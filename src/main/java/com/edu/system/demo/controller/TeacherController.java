package com.edu.system.demo.controller;

import com.edu.system.demo.entity.Course;
import com.edu.system.demo.entity.SelectedCourse;
import com.edu.system.demo.service.Impl.CourseServiceImpl;
import com.edu.system.demo.service.Impl.SCServiceImpl;
import com.edu.system.demo.service.Impl.TeacherServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author lucas
 * @site
 * @company
 * @create 2019-10-30 16:49
 */
@RestController
@Api(value="TeacherController", tags = "教师模块接口")
public class TeacherController {

    @Resource
    public TeacherServiceImpl teacherServiceImpl;

    @Resource
    public CourseServiceImpl courseServiceImpl;

    @Resource
    public SCServiceImpl scServiceImpl;

    @ApiOperation(value = "教师登陆")
    @GetMapping("/teacherSignIn")
    public String teacherSignIn(int tea_id,String password){ return teacherServiceImpl.teacherSignIn(tea_id,password);}

    @ApiOperation(value = "查看课程")
    @GetMapping("/getTCourses")
    public List<Course> getTCourses(int tea_id){ return courseServiceImpl.getTCourses(tea_id);}

    @ApiOperation(value = "查看课程下学生")
    @GetMapping("/getCourseStudent")
    public List<SelectedCourse> getCourseStudent(int cou_id){ return scServiceImpl.getCourseStudent(cou_id);}

    @ApiOperation(value = "更新学生成绩")
    @GetMapping("/updateScore")
    public String updateScore(int sc_id,float score){ return scServiceImpl.updateScore(sc_id,score);}


}
