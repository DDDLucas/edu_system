package com.edu.system.demo.service.Impl;

import com.edu.system.demo.dto.SelectedCourseDTO;
import com.edu.system.demo.entity.Administer;
import com.edu.system.demo.entity.Course;
import com.edu.system.demo.entity.SelectedCourse;
import com.edu.system.demo.repository.AdminRepository;
import com.edu.system.demo.repository.SCRepository;
import com.edu.system.demo.service.AdminService;
import com.edu.system.demo.service.SCService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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


    @Override
    public String selectCourse(SelectedCourseDTO selectedCourseDTO) {
        SelectedCourse sc = new SelectedCourse();
        sc.setId(selectedCourseDTO.getId());
        sc.setCourse_id(selectedCourseDTO.getCourse_id());
        sc.setStu_id(selectedCourseDTO.getStu_id());
        scRepository.save(sc);
        return "添课成功";
    }

    @Override
    public String deleteSelectedCourse(int sc_id) {
        SelectedCourse sc = scRepository.getOne(sc_id);
        scRepository.delete(sc);
        return "删课成功";
    }

    @Override
    public List<Course> getSelectedCourse(int stu_id) {
        List<Course> courseList = (List<Course>) scRepository.findCourseById(stu_id);
        return courseList;
    }


}
