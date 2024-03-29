package com.edu.system.demo.service;

import com.edu.system.demo.dto.CourseDTO;
import com.edu.system.demo.entity.Course;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @author lucas
 * @site
 * @company
 * @create 2019-10-22 22:57
 */
public interface CourseService {

    String addCourse(CourseDTO courseDTO);
    List<CourseDTO> getCourse();
    String updateCourse(CourseDTO courseDTO);
    String deleteCourse(int cou_id);
    Page<CourseDTO> searchCourse(Integer pageNum, Integer pageSize, String course_name);
    List<Course> getTCourses(int tea_id);

    Page<CourseDTO> getCoursePage(Integer pageNum, Integer pageSize, String specialty);

    String emptyCourseClassroom();

    String distributecourse();
}
