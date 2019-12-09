package com.edu.system.demo.service;

import com.edu.system.demo.dto.ClassroomDTO;
import com.edu.system.demo.entity.Classroom;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @author lucas
 * @site
 * @company
 * @create 2019-10-22 22:57
 */
public interface ClassroomService {

    String addClassroom(String classroomCode);
    List<Classroom> getClassroom();
    String updateClassroom(ClassroomDTO ClassroomDTO);
    String deleteClassroom(int class_id);

    Page<Classroom> getClassroomPage(Integer pageNum, Integer pageSize);

    String emptyClassroom();

    Classroom getClassroomSingle();
}
