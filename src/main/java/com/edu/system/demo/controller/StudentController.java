package com.edu.system.demo.controller;

import com.edu.system.demo.dto.CourseDTO;
import com.edu.system.demo.dto.SelectedCourseDTO;
import com.edu.system.demo.service.Impl.*;
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

@Api(value = "StudentController", tags = "学生模块接口")
@RestController
public class StudentController {

    @Resource
    private StudentServiceImpl studentServiceImpl;

    @Resource
    private SCServiceImpl scServiceImpl;

    @ApiOperation(value = "学生登陆")
    @GetMapping("/studentSignIn")
    public String studentSignIn(int id, String password){ return studentServiceImpl.studentSignIn(id, password); }

    @ApiOperation(value = "添加课程")
    @PostMapping("/selectCourse")
    public String selectCourse(@RequestBody SelectedCourseDTO selectedCourseDTO){ return scServiceImpl.selectCourse(selectedCourseDTO); }

    @ApiOperation(value = "获得已添加课程")
    @GetMapping("/getSelectedCourse")
    public List<CourseDTO> getSelectedCourse(int stu_id){ return scServiceImpl.getSelectedCourse(stu_id); }

    @ApiOperation(value = "删除已添加课程")
    @DeleteMapping("/deleteSelectedCourse")
    public String deleteSelectedCourse(int sc_id){ return scServiceImpl.deleteSelectedCourse(sc_id); }

    @ApiOperation(value = "查看课程成绩")
    @GetMapping("/getGrade")
    public List<SelectedCourseDTO> getGrade(int stu_id){ return scServiceImpl.getGrade(stu_id); }


}
