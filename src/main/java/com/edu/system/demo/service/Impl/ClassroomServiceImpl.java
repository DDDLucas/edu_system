package com.edu.system.demo.service.Impl;

import com.edu.system.demo.dto.ClassroomDTO;
import com.edu.system.demo.entity.Classroom;
import com.edu.system.demo.repository.ClassroomRepository;
import com.edu.system.demo.service.ClassroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author lucas
 * @site
 * @company
 * @create 2019-10-22 22:58
 */
@Service
public class ClassroomServiceImpl implements ClassroomService {

    @Autowired
    private ClassroomRepository classroomRepository;

    @Override
    public String addClassroom(String classroomCode) {
        String[] weekday = {"周一","周二","周三","周四","周五"};
        for(int i=0; i<5; i++){
            Classroom classroom = new Classroom();
            classroom.setClassroom(classroomCode);
            classroom.setWeekday(weekday[i]);
            classroomRepository.save(classroom);
        }
        return "加教室成功";
    }

    @Override
    public List<Classroom> getClassroom() {
        List<Classroom> classroomList = classroomRepository.findAll();
        return classroomList;
    }

    @Override
    public String updateClassroom(ClassroomDTO classroomDTO) {
        Classroom classroom = classroomRepository.getOne(classroomDTO.getId());
        classroom.setClassroom(classroomDTO.getClassroom());
        classroomRepository.save(classroom);
        return "教室数据修改成功";
    }

    @Override
    public String deleteClassroom(int class_id) {
        Classroom classroom = classroomRepository.getOne(class_id);
        classroomRepository.delete(classroom);
        return "删教室成功";
    }

    @Override
    public Page<Classroom> getClassroomPage(Integer pageNum, Integer pageSize) {
        List<Classroom> classroomList = classroomRepository.findAll();
        Pageable pageable = PageRequest.of(pageNum, pageSize);
        int totalElements =classroomList.size();
        int fromIndex = pageable.getPageSize()*pageable.getPageNumber();
        int toIndex = pageable.getPageSize()*(pageable.getPageNumber()+1);
        if(toIndex>totalElements) toIndex = totalElements;
        List<Classroom> indexObjects = classroomList.subList(fromIndex,toIndex);
        Page<Classroom> coursePage=new PageImpl<>(indexObjects, pageable ,totalElements);
        return coursePage;
    }

    @Override
    public String emptyClassroom() {
        List<Classroom> classroomList = classroomRepository.findAll();
        for(Classroom c:classroomList){
            c.setLesson1(null);
            c.setLesson2(null);
            c.setLesson3(null);
            c.setLesson4(null);
            c.setLesson5(null);
            c.setLesson6(null);
            c.setLesson7(null);
            c.setLesson8(null);
            c.setLesson9(null);
            c.setLesson10(null);
            c.setLesson11(null);
            c.setLesson12(null);
            c.setLesson13(null);
            c.setLesson14(null);
            classroomRepository.save(c);
        }
        return "清空教室成功";
    }


}
