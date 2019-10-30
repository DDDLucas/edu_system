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

    public String addTeacher(TeacherDTO teachertDTO);
    public List<Teacher> getTeacher();
    public String updateTeacher(TeacherDTO teachertDTO);
    public String deleteTeacher(int tea_id);
    public void searchTeacher();
    public String teacherSignIn(int tea_id, String password);
}
