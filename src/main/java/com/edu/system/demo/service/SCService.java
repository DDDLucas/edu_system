package com.edu.system.demo.service;


import com.edu.system.demo.dto.CourseDTO;
import com.edu.system.demo.dto.SelectedCourseDTO;

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
    public List<CourseDTO> getSelectedCourse(int stu_id);
    public List<SelectedCourseDTO> getGrade(int stu_id);
}
