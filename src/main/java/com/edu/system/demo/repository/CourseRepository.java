package com.edu.system.demo.repository;

import com.edu.system.demo.dto.CourseDTO;
import com.edu.system.demo.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author lucas
 * @site
 * @company
 * @create 2019-10-24 20:57
 */
@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {

    @Query(value="select * from course where teacher_id=:tea_id ",nativeQuery = true)
    public List<Course> getCoursesByTeacher_id(int tea_id);
}
