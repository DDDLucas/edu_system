package com.edu.system.demo.service;

import com.edu.system.demo.dto.TeacherDTO;
import com.edu.system.demo.entity.Teacher;

import java.util.List;

/**
 * @author lucas
 * @site
 * @company
 * @create 2019-10-22 22:57
 */
public interface TeacherService {

    String addTeacher(TeacherDTO teachertDTO);
    List<Teacher> getTeacher();
    String updateTeacher(TeacherDTO teachertDTO);
    String deleteTeacher(int tea_id);
    List<Teacher> searchTeacher(Integer id, String name);
    String teacherSignIn(int tea_id, String password);
}
