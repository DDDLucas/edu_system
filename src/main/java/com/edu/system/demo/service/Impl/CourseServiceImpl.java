package com.edu.system.demo.service.Impl;

import com.edu.system.demo.dto.CourseDTO;
import com.edu.system.demo.dto.StudentDTO;
import com.edu.system.demo.entity.Course;
import com.edu.system.demo.entity.SelectedCourse;
import com.edu.system.demo.entity.Student;
import com.edu.system.demo.repository.CourseRepository;
import com.edu.system.demo.repository.SCRepository;
import com.edu.system.demo.repository.StudentRepository;
import com.edu.system.demo.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lucas
 * @site
 * @company
 * @create 2019-10-22 22:58
 */
@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private SCRepository scRepository;
    @Override
    public String addCourse(CourseDTO courseDTO) {
        Course course = new Course();
        course.setId(courseDTO.getId());
        course.setName(courseDTO.getName());
        course.setTeacher_id(courseDTO.getTeacher_id());
        course.setStu_num(courseDTO.getStu_num());
        course.setType(courseDTO.getType());
        course.setSpecialty(courseDTO.getSpecialty());
        course.setInstitute(courseDTO.getInstitute());
        course.setClass_id(courseDTO.getClass_id());
        course.setCredit(courseDTO.getCredit());
        course.setMax_num(courseDTO.getMax_num());
        courseRepository.save(course);
        return "课程添加成功";
    }

    @Override
    public List<Course> getCourse() {
        List<Course> courseList = courseRepository.findAll();
        return courseList;
    }

    @Override
    public String updateCourse(CourseDTO courseDTO) {
        Course course = courseRepository.getOne(courseDTO.getId());
        course.setName(courseDTO.getName());
        course.setTeacher_id(courseDTO.getTeacher_id());
        course.setStu_num(courseDTO.getStu_num());
        course.setType(courseDTO.getType());
        course.setSpecialty(courseDTO.getSpecialty());
        course.setInstitute(courseDTO.getInstitute());
        course.setClass_id(courseDTO.getClass_id());
        course.setCredit(courseDTO.getCredit());
        course.setMax_num(courseDTO.getMax_num());
        courseRepository.save(course);
        return "课程修改成功";
    }

    @Override
    public String deleteCourse(int cou_id) {
        Course course = courseRepository.getOne(cou_id);
        List<SelectedCourse> scList = scRepository.findGradebyCourse(cou_id);
        scRepository.deleteAll(scList);
        courseRepository.delete(course);
        return "删除成功";
    }

    @Override
    public void searchCourse() {

    }

    @Override
    public List<Course> getTCourses(int tea_id) {
        List<Course> courseList = courseRepository.getCoursesByTeacher_id(tea_id);
        return courseList;
    }

    @Override
    public Page<Course> getCoursePage(Integer pageNum, Integer pageSize, String specialty) {
        List<Course> courseList;
        if(specialty == null){
            courseList = courseRepository.findAll();
        }else{
            courseList =courseRepository.sortCoursebySpecialty(specialty);
        }

        Pageable pageable = PageRequest.of(pageNum, pageSize);
        int totalElements =courseList.size();
        int fromIndex = pageable.getPageSize()*pageable.getPageNumber();
        int toIndex = pageable.getPageSize()*(pageable.getPageNumber()+1);
        if(toIndex>totalElements) toIndex = totalElements;
        List<Course> indexObjects = courseList.subList(fromIndex,toIndex);
        Page<Course> coursePage=new PageImpl<>(indexObjects, pageable ,totalElements);
        return coursePage;
    }
}
