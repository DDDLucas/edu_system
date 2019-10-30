package com.edu.system.demo.service;

import com.edu.system.demo.dto.CourseDTO;
import com.edu.system.demo.entity.Course;

import java.util.List;

/**
 * @author lucas
 * @site
 * @company
 * @create 2019-10-22 22:57
 */
public interface CourseService {

    public String addCourse(CourseDTO courseDTO);
    public List<Course> getCourse();
    public String updateCourse(CourseDTO courseDTO);
    public String deleteCourse(int cou_id);
    public void searchCourse();
    public List<Course> getTCourses(int tea_id);
}
