package com.edu.system.demo.repository;

import com.edu.system.demo.entity.Classroom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author lucas
 * @site
 * @company
 * @create 2019-11-04 22:41
 */
@Repository
public interface ClassroomRepository extends JpaRepository<Classroom, Integer> {
}
