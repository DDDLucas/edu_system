package com.edu.system.demo.repository;

import com.edu.system.demo.entity.Course;
import com.edu.system.demo.entity.SelectedCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * @author lucas
 * @site
 * @company
 * @create 2019-10-24 20:57
 */
@Repository
public interface SCRepository extends JpaRepository<SelectedCourse, Integer> {

    @Query(value="SELECT * FROM course WHERE id IN\n" +
            "(SELECT course_id FROM selected_course WHERE stu_id =:stu_id);",nativeQuery = true)
    Course findCourseById(int stu_id);
}
