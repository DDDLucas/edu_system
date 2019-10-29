package com.edu.system.demo.service;


import com.edu.system.demo.dto.SelectedCourseDTO;
import com.edu.system.demo.dto.StudentDTO;
import com.edu.system.demo.entity.Course;
import com.edu.system.demo.entity.SelectedCourse;
import com.edu.system.demo.entity.Student;

import java.util.List;

/**
 * @author lucas
 * @site
 * @company
 * @create 2019-10-22 22:57
 */
public interface SCService {

    public String selectCourse(SelectedCourseDTO selectedCourseDTO);
    public String deleteSelectedCourse(int sc_id);
    public List<Course> getSelectedCourse(int stu_id);


}
