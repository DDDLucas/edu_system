package com.edu.system.demo.controller;

import com.edu.system.demo.dto.StudentDTO;
import com.edu.system.demo.entity.Student;
import com.edu.system.demo.service.Impl.StudentServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
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

    @ApiOperation(value = "添加学生")
    @PostMapping("/addStudent")
    public String addStudent(StudentDTO stu){ return studentServiceImpl.addStudent(stu); }

    @ApiOperation(value = "获取所有学生列表")
    @GetMapping("/getStudent")
    public List<Student> getStudent(){ return studentServiceImpl.getStudent(); }

    @ApiOperation(value = "更新学生信息")
    @PutMapping("/updateStudent")
    public String updateStudent(StudentDTO stu){ return studentServiceImpl.updateStudent(stu); }

    @ApiOperation(value = "删除学生")
    @DeleteMapping("/deleteStudent")
    public String deleteStudent(int stu_id){ return studentServiceImpl.deleteStudent(stu_id); }




//    /*
//    返回template指定页面
//     */
//    @RequestMapping("/hello")
//    public String index(){
//        return "hello";
//    }
}
