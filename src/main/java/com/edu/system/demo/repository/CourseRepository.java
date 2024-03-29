package com.edu.system.demo.repository;

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
    List<Course> getCoursesByTeacher_id(int tea_id);

    @Query(value="SELECT * FROM course ORDER BY \n" +
            "CASE WHEN specialty =:specialty THEN 0 ELSE 1 END ,\n" +
            "specialty ASC ",nativeQuery = true)
    List<Course> sortCoursebySpecialty(String specialty);

    @Query(value = "SELECT * FROM course ORDER BY specialty,TYPE,credit DESC",nativeQuery = true)
    List<Course> sortCoursebySp_ty_cr();

    @Query(value="SELECT * FROM course WHERE NAME LIKE %:course_name%", nativeQuery = true)
    List<Course> findByCourseName(String course_name);

}
