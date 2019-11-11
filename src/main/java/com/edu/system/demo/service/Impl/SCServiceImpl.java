package com.edu.system.demo.service.Impl;

import com.edu.system.demo.dto.CourseDTO;
import com.edu.system.demo.dto.SelectedCourseDTO;
import com.edu.system.demo.entity.Course;
import com.edu.system.demo.entity.SelectedCourse;
import com.edu.system.demo.repository.CourseRepository;
import com.edu.system.demo.repository.SCRepository;
import com.edu.system.demo.service.SCService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


/**
 * @author lucas
 * @site
 * @company
 * @create 2019-10-22 22:58
 */
@Service
public class SCServiceImpl implements SCService {

    @Autowired
    private SCRepository scRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public String selectCourse(SelectedCourseDTO selectedCourseDTO) {
        Course course = courseRepository.getOne(selectedCourseDTO.getCourse_id());
        if(course.getStu_num() < course.getMax_num()){
            course.setStu_num(course.getStu_num()+1);
            courseRepository.save(course);
            SelectedCourse sc = new SelectedCourse();
            sc.setId(selectedCourseDTO.getId());
            sc.setCourse_id(selectedCourseDTO.getCourse_id());
            sc.setStu_id(selectedCourseDTO.getStu_id());
            scRepository.save(sc);

            return "添课成功";
        }else{
            return "添课失败：选课人数已满";
        }


    }

    @Override
    public String deleteSelectedCourse(int sc_id) {
        SelectedCourse sc = scRepository.getOne(sc_id);
        Course course = courseRepository.getOne(sc.getCourse_id());
        course.setStu_num(course.getStu_num()-1);
        courseRepository.save(course);
        scRepository.delete(sc);
        return "删课成功";
    }

    @Override
    public List<CourseDTO> getSelectedCourse(int stu_id) {
        List<Object> objectList = scRepository.findCourseById(stu_id);
        List<CourseDTO> courseList =new ArrayList<>();
        for(Object o : objectList){
            Object[] obj= (Object[]) o;
            CourseDTO course=new CourseDTO();
            course.setId((Integer) obj[0]);
            course.setName((String) obj[1]);
            course.setTeacher_id((Integer) obj[2]);
            course.setStu_num((Integer) obj[3]);
            course.setType((String) obj[4]);
            course.setSpecialty((String) obj[5]);
            course.setInstitute((String) obj[6]);
            course.setClass_id((String) obj[7]);
            course.setCredit((Integer) obj[8]);
            course.setMax_num((Integer) obj[9]);
            course.setSc_id((Integer) obj[10]);
            courseList.add(course);
        }
        return courseList;
    }

    @Override
    public List<SelectedCourseDTO> getGrade(int stu_id) {
        List<Object> objectList = scRepository.findGradeById(stu_id);
        List<SelectedCourseDTO> scList =new ArrayList<>();
        for(Object o : objectList){
            Object[] obj= (Object[]) o;
            SelectedCourseDTO sc=new SelectedCourseDTO();
            sc.setId((Integer) obj[0]);
            sc.setCourse_name((String) obj[1]);
            sc.setScore((Float) obj[2]);
            scList.add(sc);
        }
        return scList;
    }

    @Override
    public List<SelectedCourse> getCourseStudent(int cou_id) {
        List<SelectedCourse> selectedCourseList = scRepository.findGradebyCourse(cou_id);
        return selectedCourseList;
    }

    @Override
    public String updateScore(int sc_id, float score) {
        SelectedCourse sc = scRepository.getOne(sc_id);
        sc.setScore(score);
        scRepository.save(sc);
        return "修改成功";
    }


}
