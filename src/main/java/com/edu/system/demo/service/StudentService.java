package com.edu.system.demo.service;

import com.edu.system.demo.dto.StudentDTO;
import com.edu.system.demo.entity.Student;

import java.util.List;

/**
 * @author lucas
 * @site
 * @company
 * @create 2019-10-22 22:57
 */
public interface StudentService {

    public String addStudent(StudentDTO studentDTO);
    public List<Student> getStudent();
    public String updateStudent(StudentDTO studentDTO);
    public String deleteStudent(int stu_id);
    public void searchStudent();

    public String studentSignIn(int id, String password);
}
