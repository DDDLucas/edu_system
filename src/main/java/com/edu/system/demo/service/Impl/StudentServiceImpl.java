package com.edu.system.demo.service.Impl;

import com.edu.system.demo.dto.StudentDTO;
import com.edu.system.demo.entity.Student;
import com.edu.system.demo.repository.StudentRepository;
import com.edu.system.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lucas
 * @site
 * @company
 * @create 2019-10-22 22:58
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;


    @Override
    public String addStudent(StudentDTO studentDTO) {
        Student stu =new Student();
        stu.setId(studentDTO.getId());
        stu.setName(studentDTO.getName());
        stu.setPassword(studentDTO.getPassword());
        stu.setSpecialty(studentDTO.getSpecialty());
        stu.setInstitute(studentDTO.getInstitute());
        studentRepository.save(stu);
        return "添加学生成功";
    }

    @Override
    public List<Student> getStudent() {
        List<Student> studentList=studentRepository.findAll();
        return studentList;

    }

    @Override
    public String updateStudent(StudentDTO studentDTO) {
        Student stu = studentRepository.getOne(studentDTO.getId());
        stu.setName(studentDTO.getName());
        stu.setPassword(studentDTO.getPassword());
        stu.setSpecialty(studentDTO.getSpecialty());
        stu.setInstitute(studentDTO.getInstitute());
        studentRepository.save(stu);
        return "修改成功";
    }

    @Override
    public String deleteStudent(int stu_id) {
        Student stu = studentRepository.getOne(stu_id);
        studentRepository.delete(stu);
        return "删除成功";
    }

    @Override
    public List<Student> searchStudent(Integer id, String name) {
        List<Student> studentList;
        if(id == null && name==null){
            studentList = studentRepository.findAll();
        }else if(id == null && name!=null){
            studentList = studentRepository.searchbyName(name);
        }else if(id != null && name==null){
            studentList = studentRepository.searchbyId(id);
        }else{

            studentList = studentRepository.searchbyIdandName(id, name);
        }
        return studentList;
    }

    @Override
    public String studentSignIn(int id, String password) {
        try {
            Student student = studentRepository.getOne(id);
            if(!student.getPassword().equals(password)){
                return "密码错误";
            }else {
                return "登陆成功";
            }
        }catch (Exception e){
            return "账号不存在";
        }
    }
}
