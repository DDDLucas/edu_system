package com.edu.system.demo.repository;

import com.edu.system.demo.entity.Teacher;
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
public interface TeacherRepository extends JpaRepository<Teacher, Integer> {

    @Query(value = "SELECT * FROM teacher WHERE name LIKE %:name%", nativeQuery = true)
    List<Teacher> searchbyName(String name);

    @Query(value = "SELECT * FROM teacher WHERE id=:id", nativeQuery = true)
    List<Teacher> searchbyId(Integer id);

    @Query(value = "SELECT * FROM teacher WHERE id=:id and name LIKE %:name%", nativeQuery = true)
    List<Teacher> searchbyIdandName(Integer id, String name);
}
