package com.edu.system.demo.service.Impl;

import com.edu.system.demo.dto.CourseDTO;
import com.edu.system.demo.entity.Classroom;
import com.edu.system.demo.entity.Course;
import com.edu.system.demo.entity.SelectedCourse;
import com.edu.system.demo.repository.ClassroomRepository;
import com.edu.system.demo.repository.CourseRepository;
import com.edu.system.demo.repository.SCRepository;
import com.edu.system.demo.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    @Autowired
    private ClassroomRepository classroomRepository;
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

    @Override
    public String emptyCourseClassroom() {
        List<Course> courseList = courseRepository.findAll();
        for(Course c: courseList){
            c.setClass_id(null);
            courseRepository.save(c);
        }
        return "成功清空课程绑定的教室";
    }

    @Override
    public String distributecourse() {

        List<Classroom> classroomList = classroomRepository.findAll();
        List<Course> courseList = courseRepository.sortCoursebySp_ty_cr();

        int classroomSize = classroomList.size();
        List listforall = new ArrayList();
        List listfor3 =  new ArrayList(); //为三学分课程遍历准备
        for(int i=0; i<classroomSize; i++) {
            listforall.add(i);
            listfor3.add(i);
        }
        String startsp = courseList.get(0).getSpecialty();
        //因为不同专业可以安排同一时间不同教室，如周一第一节101 102 分别上政治和英语课；

        List scheduleforall = new ArrayList();
        List schedulefor3 =  new ArrayList();
        for(int j=0; j<30; j++) {
            scheduleforall.add(j);
            if(j<15){
                schedulefor3.add(j);
            }
        }
        //同一专业,3学分一周只有15个教室可选（为了不碰撞）, 2、1学分算上3学分教室共30个教室

        for(Course c: courseList){  // c依次按专业,必/选修,学分排序
            System.out.println("======"+c.getId()+" ====" +c.getSpecialty());
            String tmpsp= c.getSpecialty();
            //这个课是新专业
            if(!tmpsp.equals(startsp)){
                scheduleforall.clear();
                schedulefor3.clear();
                for(int j=0; j<30; j++) {
                    scheduleforall.add(j);
                    if(j<15){
                        schedulefor3.add(j);
                    }
                }
                startsp = tmpsp;
            }
            if(c.getType().equals("必修")){
                if(c.getCredit() == 3){   //三学分一定是必修课程
                    int n = (int) (Math.random()*schedulefor3.size());
                    int r = (int) schedulefor3.get(n);   //是否校验  若这个list因为删除而为空
                    int shang = r / 3;  //第几天
                    int yu = r % 3;  //第几节课

                    if( yu == 1 ){
                        int rm1 = shang*6+3;
                        int rm2 = shang*6+4;
                        scheduleforall.remove(new Integer(rm1));
                        scheduleforall.remove(new Integer(rm2));
                    }else{
                        int rm = r*2+1;
                        scheduleforall.remove(new Integer(rm));
                    }



                    schedulefor3.remove(new Integer(r));
                    List tmplist = new ArrayList();  //随机选择一个当天的教室集合
                    for(int i=shang; i<classroomSize -1; i=i+5){
                        if(listfor3.contains(i)){
                            tmplist.add(i);
                        }
                    }
                    int tmpn = (int) (Math.random()*tmplist.size());
                    int rindex;
                    try{
                        rindex = (int) tmplist.get(tmpn);
                    }catch (Exception e){
                        return "教室不足，排课失败";
                    }
                    tmplist.remove(tmpn);
                    Classroom sc =classroomList.get(rindex);
                    if( yu == 0){
                        while(sc.getLesson3()!=null){
                            tmpn = (int) (Math.random()*tmplist.size());
                            try{
                                rindex = (int) tmplist.get(tmpn);
                            }catch (Exception e){
                                return "教室不足，排课失败";
                            }
                            tmplist.remove(tmpn);
                            sc =classroomList.get(rindex);
                        }
                        sc.setLesson3(String.valueOf(c.getId()));
                        sc.setLesson4(String.valueOf(c.getId()));
                        sc.setLesson5(String.valueOf(c.getId()));
                    }else if( yu ==1){
                        while(sc.getLesson8()!=null){
                            tmpn = (int) (Math.random()*tmplist.size());
                            try{
                                rindex = (int) tmplist.get(tmpn);
                            }catch (Exception e){
                                return "教室不足，排课失败";
                            }
                            tmplist.remove(tmpn);
                            sc =classroomList.get(rindex);
                        }
                        sc.setLesson8(String.valueOf(c.getId()));
                        sc.setLesson9(String.valueOf(c.getId()));
                        sc.setLesson10(String.valueOf(c.getId()));
                    }else{
                        while(sc.getLesson12()!=null){
                            tmpn = (int) (Math.random()*tmplist.size());
                            try{
                                rindex = (int) tmplist.get(tmpn);
                            }catch (Exception e){
                                return "教室不足，排课失败";
                            }
                            tmplist.remove(tmpn);
                            sc =classroomList.get(rindex);
                        }
                        sc.setLesson12(String.valueOf(c.getId()));
                        sc.setLesson13(String.valueOf(c.getId()));
                        sc.setLesson14(String.valueOf(c.getId()));
                    }
                    //此教室可上大课时间已满,三学分找教室时不再遍历它
                    if(sc.getLesson3()!=null && sc.getLesson8()!=null && sc.getLesson12()!=null ){
                        listfor3.remove(new Integer(rindex));
                    }
                    classroomRepository.save(sc);
                    c.setClass_id(String.valueOf(sc.getId()));
                    courseRepository.save(c);
                }else{  //2,1学分必修
                    int n = (int) (Math.random()*scheduleforall.size());
                    int r = (int) scheduleforall.get(n);
                    scheduleforall.remove(new Integer(r));
                    int shang = r /6 ;//星期数
                    int yu = r % 6; //第几节课
                    List tmplist = new ArrayList();  //随机选择一个当天的教室集合
                    for(int i=shang; i<classroomSize -1; i=i+5){
                        if(listforall.contains(i)){
                            tmplist.add(i);
                        }
                    }
                    int tmpn = (int) (Math.random()*tmplist.size());
                    int rindex;
                    try{
                        rindex = (int) tmplist.get(tmpn);
                    }catch (Exception e){
                        return "教室不足，排课失败";
                    }
                    tmplist.remove(tmpn);
                    Classroom sc =classroomList.get(rindex);
                    if( yu == 0){
                        while(sc.getLesson1()!=null){
                            tmpn = (int) (Math.random()*tmplist.size());
                            try{
                                rindex = (int) tmplist.get(tmpn);
                            }catch (Exception e){
                                return "教室不足，排课失败";
                            }
                            tmplist.remove(tmpn);
                            sc =classroomList.get(rindex);
                        }
                        sc.setLesson1(String.valueOf(c.getId()));
                        sc.setLesson2(String.valueOf(c.getId()));
                    }
                    if( yu == 1){
                        while(sc.getLesson3()!=null){
                            tmpn = (int) (Math.random()*tmplist.size());
                            try{
                                rindex = (int) tmplist.get(tmpn);
                            }catch (Exception e){
                                return "教室不足，排课失败";
                            }
                            tmplist.remove(tmpn);
                            sc =classroomList.get(rindex);
                        }
                        sc.setLesson3(String.valueOf(c.getId()));
                        sc.setLesson4(String.valueOf(c.getId()));
                    }
                    if( yu == 2){
                        while(sc.getLesson6()!=null){
                            tmpn = (int) (Math.random()*tmplist.size());
                            try{
                                rindex = (int) tmplist.get(tmpn);
                            }catch (Exception e){
                                return "教室不足，排课失败";
                            }
                            tmplist.remove(tmpn);
                            sc =classroomList.get(rindex);
                        }
                        sc.setLesson6(String.valueOf(c.getId()));
                        sc.setLesson7(String.valueOf(c.getId()));
                    }
                    if( yu == 3){
                        while(sc.getLesson8()!=null){
                            tmpn = (int) (Math.random()*tmplist.size());
                            try{
                                rindex = (int) tmplist.get(tmpn);
                            }catch (Exception e){
                                return "教室不足，排课失败";
                            }
                            tmplist.remove(tmpn);
                            sc =classroomList.get(rindex);
                        }
                        sc.setLesson8(String.valueOf(c.getId()));
                        sc.setLesson9(String.valueOf(c.getId()));
                    }
                    if( yu == 4){
                        while(sc.getLesson10()!=null){
                            tmpn = (int) (Math.random()*tmplist.size());
                            try{
                                rindex = (int) tmplist.get(tmpn);
                            }catch (Exception e){
                                return "教室不足，排课失败";
                            }
                            tmplist.remove(tmpn);
                            sc =classroomList.get(rindex);
                        }
                        sc.setLesson10(String.valueOf(c.getId()));
                        sc.setLesson11(String.valueOf(c.getId()));
                    }
                    if( yu == 5){
                        while(sc.getLesson12()!=null){
                            tmpn = (int) (Math.random()*tmplist.size());
                            try{
                                rindex = (int) tmplist.get(tmpn);
                            }catch (Exception e){
                                return "教室不足，排课失败";
                            }
                            tmplist.remove(tmpn);
                            sc =classroomList.get(rindex);
                        }
                        sc.setLesson12(String.valueOf(c.getId()));
                        sc.setLesson13(String.valueOf(c.getId()));
                    }
                    //当天此教室是否已满
                    if(sc.getLesson1()!=null && sc.getLesson3()!=null && sc.getLesson6()!=null && sc.getLesson8()!=null && sc.getLesson10()!=null && sc.getLesson12()!=null ){
                        listforall.remove(new Integer(rindex));
                    }
                    classroomRepository.save(sc);
                    c.setClass_id(String.valueOf(sc.getId()));
                    courseRepository.save(c);
                }
            }else{  //选修
                int n = (int) (Math.random()*listforall.size());
                int index = (int) listforall.get(n);
                Classroom sc = classroomList.get(index);
                if(sc.getLesson1()==null ){
                    sc.setLesson1(String.valueOf(c.getId()));
                    sc.setLesson2(String.valueOf(c.getId()));
                }else if(sc.getLesson3()==null )	{
                    sc.setLesson3(String.valueOf(c.getId()));
                    sc.setLesson4(String.valueOf(c.getId()));
                }else if( sc.getLesson6()==null )	{
                    sc.setLesson6(String.valueOf(c.getId()));
                    sc.setLesson7(String.valueOf(c.getId()));
                }else if( sc.getLesson8()==null ){
                    sc.setLesson8(String.valueOf(c.getId()));
                    sc.setLesson9(String.valueOf(c.getId()));
                }else if( sc.getLesson10()==null ){
                    sc.setLesson10(String.valueOf(c.getId()));
                    sc.setLesson11(String.valueOf(c.getId()));
                }else if( sc.getLesson12()==null ){
                    sc.setLesson12(String.valueOf(c.getId()));
                    sc.setLesson13(String.valueOf(c.getId()));
                    listforall.remove(new Integer(index));
                }
                classroomRepository.save(sc);
                c.setClass_id(String.valueOf(sc.getId()));
                courseRepository.save(c);
            }//else选修
        }//for




        return "排课成功";
    }
}
