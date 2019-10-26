package com.edu.system.demo.repository;

import com.edu.system.demo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author lucas
 * @site
 * @company
 * @create 2019-10-24 20:57
 */
@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

}
