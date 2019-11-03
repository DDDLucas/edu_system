package com.edu.system.demo.dto;

import lombok.Data;



/**
 * @author lucas
 * @site
 * @company
 * @create 2019-10-22 23:02
 */
@Data
public class CourseDTO {

    private int id;
    private String name;
    private int teacher_id;
    private int stu_num;
    private String type;
    private String speciality;
    private String institute;
    private String class_time;
    private String classroom;
    private int credit;
    private int max_num;
    private int sc_id;

}
