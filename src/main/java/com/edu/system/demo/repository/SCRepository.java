package com.edu.system.demo.repository;

import com.edu.system.demo.dto.SelectedCourseDTO;
import com.edu.system.demo.entity.Course;
import com.edu.system.demo.entity.SelectedCourse;
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
public interface SCRepository extends JpaRepository<SelectedCourse, Integer> {

    @Query(value="SELECT c.id,c.name,c.teacher_id,c.stu_num,c.type,c.specialty,c.institute,c.class_id,c.credit,c.max_num,sc.id as sc_id FROM selected_course sc,course c WHERE sc.course_id=c.id AND sc.stu_id =stu_id",nativeQuery = true)
    public List<Object> findCourseById(int stu_id);

    @Query(value="SELECT sc.id,course.name,sc.score FROM selected_course sc, course WHERE sc.course_id = course.id AND stu_id =:stu_id",nativeQuery = true)
    public List<Object> findGradeById(int stu_id);


    @Query(value="select * from selected_course where course_id=:cou_id",nativeQuery = true)
    public List<SelectedCourse> findGradebyCourse(int cou_id);


}
