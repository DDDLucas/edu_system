package com.edu.system.demo.controller;

import com.edu.system.demo.dto.ClassroomDTO;
import com.edu.system.demo.dto.CourseDTO;
import com.edu.system.demo.dto.StudentDTO;
import com.edu.system.demo.dto.TeacherDTO;
import com.edu.system.demo.entity.Classroom;
import com.edu.system.demo.entity.Course;
import com.edu.system.demo.entity.Student;
import com.edu.system.demo.entity.Teacher;
import com.edu.system.demo.repository.ClassroomRepository;
import com.edu.system.demo.service.Impl.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author lucas
 * @site
 * @company
 * @create 2019-10-22 22:58
 */

@Api(value = "AdministerController", tags = "管理员管理模块接口")
@RestController
public class AdministerController {

    @Resource
    private StudentServiceImpl studentServiceImpl;

    @Resource
    private TeacherServiceImpl teacherServiceImpl;

    @Resource
    private CourseServiceImpl courseServiceImpl;

    @Resource
    private AdminServiceImpl adminServiceImpl;

    @Resource
    private ClassroomServiceImpl classroomServiceImpl;

    @ApiOperation(value = "管理员登陆")
    @GetMapping("/adminSignIn")
    public String adminSignIn(String usr_name, String password){ return adminServiceImpl.adminSignIn(usr_name, password); }


    @ApiOperation(value = "添加学生")
    @PostMapping("/addStudent")
    public String addStudent(@RequestBody StudentDTO stu){
        return studentServiceImpl.addStudent(stu); }

    @ApiOperation(value = "获取所有学生列表")
    @GetMapping("/getStudent")
    public List<Student> getStudent(){ return studentServiceImpl.getStudent(); }

    @ApiOperation(value = "更新学生信息")
    @PutMapping("/updateStudent")
    public String updateStudent(@RequestBody StudentDTO stu){ return studentServiceImpl.updateStudent(stu); }

    @ApiOperation(value = "删除学生")
    @DeleteMapping("/deleteStudent")
    public String deleteStudent(int stu_id){ return studentServiceImpl.deleteStudent(stu_id); }


    @ApiOperation(value = "添加老师")
    @PostMapping("/addTeacher")
    public String addTeacher(@RequestBody TeacherDTO teacher){ return teacherServiceImpl.addTeacher(teacher); }

    @ApiOperation(value = "获取所有老师列表")
    @GetMapping("/getTeacher")
    public List<Teacher> getTeacher(){ return teacherServiceImpl.getTeacher(); }

    @ApiOperation(value = "更新老师信息")
    @PutMapping("/updateTeacher")
    public String updateTeacher(@RequestBody TeacherDTO teacher){ return teacherServiceImpl.updateTeacher(teacher); }

    @ApiOperation(value = "删除老师")
    @DeleteMapping("/deleteTeacher")
    public String deleteTeacher(int tea_id){ return teacherServiceImpl.deleteTeacher(tea_id); }


    @ApiOperation(value = "添加课程")
    @PostMapping("/addCourse")
    public String addCourse(@RequestBody CourseDTO cou){ return courseServiceImpl.addCourse(cou); }

    @ApiOperation(value = "获取所有课程列表")
    @GetMapping("/getCourse")
    public List<Course> getCourse(){ return courseServiceImpl.getCourse(); }

    @ApiOperation(value = "获取所有课程列表分页")
    @GetMapping("/getCoursePage")
    public Page<Course> getCoursePage(Integer pageNum, Integer pageSize, String specialty){ return courseServiceImpl.getCoursePage(pageNum, pageSize, specialty); }


    @ApiOperation(value = "更新课程信息")
    @PutMapping("/updateCourse")
    public String updateCourse(@RequestBody CourseDTO cou){ return courseServiceImpl.updateCourse(cou); }

    @ApiOperation(value = "删除课程")
    @DeleteMapping("/deleteCourse")
    public String deleteCourse(int cou_id){ return courseServiceImpl.deleteCourse(cou_id); }

    @ApiOperation(value = "清空课程绑定的教室")
    @GetMapping("/emptyCourseClassroom")
    public String emptyCourseClassroom(){ return courseServiceImpl.emptyCourseClassroom(); }



    @ApiOperation(value = "添加教室")
    @GetMapping("/addClassroom")
    public String addClassroom(String classroomCode){ return classroomServiceImpl.addClassroom(classroomCode); }


    @ApiOperation(value = "获取所有教室列表")
    @GetMapping("/getClassroom")
    public List<Classroom> getClassroom(){ return classroomServiceImpl.getClassroom(); }

    @ApiOperation(value = "获取所有教室列表分页")
    @GetMapping("/getClassroomPage")
    public Page<Classroom> getClassroomPage(Integer pageNum, Integer pageSize){ return classroomServiceImpl.getClassroomPage(pageNum, pageSize); }

    @ApiOperation(value = "更新教室信息")
    @PutMapping("/updateClassroom")
    public String updateClassroom(@RequestBody ClassroomDTO classroomDTO){ return classroomServiceImpl.updateClassroom(classroomDTO); }

    @ApiOperation(value = "删除教室")
    @DeleteMapping("/deleteClassroom")
    public String deleteClassroom(int class_id){ return classroomServiceImpl.deleteClassroom(class_id); }

    @ApiOperation(value = "清空教室")
    @GetMapping("/emptyClassroom")
    public String emptyClassroom(){ return classroomServiceImpl.emptyClassroom(); }

    @ApiOperation(value = "排课")
    @GetMapping("/distributecourse")
    public String distributecourse(){ return courseServiceImpl.distributecourse(); }

}
