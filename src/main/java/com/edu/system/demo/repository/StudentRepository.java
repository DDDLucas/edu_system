package com.edu.system.demo.repository;

import com.edu.system.demo.entity.Student;
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
public interface StudentRepository extends JpaRepository<Student, Integer> {

    @Query(value = "SELECT * FROM student WHERE name LIKE %:name%", nativeQuery = true)
    List<Student> searchbyName(String name);

    @Query(value = "SELECT * FROM student WHERE id=:id", nativeQuery = true)
    List<Student> searchbyId(Integer id);

    @Query(value = "SELECT * FROM student WHERE id=:id and name LIKE %:name%", nativeQuery = true)
    List<Student> searchbyIdandName(Integer id, String name);
}
