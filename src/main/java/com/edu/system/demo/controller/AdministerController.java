package com.edu.system.demo.controller;

import com.edu.system.demo.dto.CourseDTO;
import com.edu.system.demo.dto.StudentDTO;
import com.edu.system.demo.dto.TeacherDTO;
import com.edu.system.demo.entity.Course;
import com.edu.system.demo.entity.Student;
import com.edu.system.demo.entity.Teacher;
import com.edu.system.demo.service.Impl.AdminServiceImpl;
import com.edu.system.demo.service.Impl.CourseServiceImpl;
import com.edu.system.demo.service.Impl.StudentServiceImpl;
import com.edu.system.demo.service.Impl.TeacherServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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

    @ApiOperation(value = "管理员登陆")
    @PostMapping("/adminSignIn")
    public String adminSignIn(String usr_name, String password){ return adminServiceImpl.adminSignIn(usr_name, password); }


    @ApiOperation(value = "添加学生")
    @PostMapping("/addStudent")
    public String addStudent(@RequestBody StudentDTO stu){
        System.out.println("传入数据： "+stu.toString());
        System.out.println("传入数据name： "+stu.getName());
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

    @ApiOperation(value = "更新课程信息")
    @PutMapping("/updateCourse")
    public String updateCourse(@RequestBody CourseDTO cou){ return courseServiceImpl.updateCourse(cou); }

    @ApiOperation(value = "删除课程")
    @DeleteMapping("/deleteCourse")
    public String deleteCourse(int cou_id){ return courseServiceImpl.deleteCourse(cou_id); }



}
