package com.edu.system.demo.service.Impl;

import com.edu.system.demo.dto.StudentDTO;
import com.edu.system.demo.dto.TeacherDTO;
import com.edu.system.demo.entity.Student;
import com.edu.system.demo.entity.Teacher;
import com.edu.system.demo.repository.TeacherRepository;
import com.edu.system.demo.service.TeacherService;
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
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;


    @Override
    public String addTeacher(TeacherDTO teacherDTO) {
        Teacher teacher =new Teacher();
        teacher.setId(teacherDTO.getId());
        teacher.setName(teacherDTO.getName());
        teacher.setPassword(teacherDTO.getPassword());
        teacher.setInstitute(teacherDTO.getInstitute());
        teacherRepository.save(teacher);
        return "添加成功";
    }

    @Override
    public List<Teacher> getTeacher() {
        List<Teacher> teacherList=teacherRepository.findAll();
        return teacherList;

    }

    @Override
    public String updateTeacher(TeacherDTO teacherDTO) {
        Teacher teacher = teacherRepository.getOne(teacherDTO.getId());
        teacher.setName(teacherDTO.getName());
        teacher.setPassword(teacherDTO.getPassword());
        teacher.setInstitute(teacherDTO.getInstitute());
        teacherRepository.save(teacher);
        return null;
    }

    @Override
    public String deleteTeacher(int tea_id) {
        Teacher teacher = teacherRepository.getOne(tea_id);
        teacherRepository.delete(teacher);
        return null;
    }

    @Override
    public void searchTeacher() {

    }

}