package com.edu.system.demo.entity;


import javax.persistence.*;

/**
 * @author lucas
 * @site
 * @company
 * @create 2019-10-22 22:55
 */
//@ApiModel
@Entity
@Table(name="course")
public class Course {

    @Id
    @GeneratedValue
//    @ApiModelProperty(value = "课程id")
    private int id;

    @Column(length = 80)
//    @ApiModelProperty(value = "课程名")
    private String name;

//    @ApiModelProperty(value = "老师id")
    private int teacher_id;

//    @ApiModelProperty(value = "选课人数")
    private int stu_num;

    @Column(length = 80)
//    @ApiModelProperty(value = "属性（必/选）")
    private String type;

    @Column(length = 80)
//    @ApiModelProperty(value = "专业")
    private String specialty;

    @Column(length = 80)
//    @ApiModelProperty(value = "学院")
    private String institute;

    @Column(length = 80)
//    @ApiModelProperty(value = "上课教室id")
    private String class_id;

//    @ApiModelProperty(value = "学分")
    private int credit;

//    @ApiModelProperty(value = "最大人数")
    private int max_num;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(int teacher_id) {
        this.teacher_id = teacher_id;
    }

    public int getStu_num() {
        return stu_num;
    }

    public void setStu_num(int stu_num) {
        this.stu_num = stu_num;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public String getInstitute() {
        return institute;
    }

    public void setInstitute(String institute) {
        this.institute = institute;
    }

    public String getClass_id() {
        return class_id;
    }

    public void setClass_id(String class_id) {
        this.class_id = class_id;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public int getMax_num() {
        return max_num;
    }

    public void setMax_num(int max_num) {
        this.max_num = max_num;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", teacher_id=" + teacher_id +
                ", stu_num=" + stu_num +
                ", type='" + type + '\'' +
                ", specialty='" + specialty + '\'' +
                ", institute='" + institute + '\'' +
                ", class_id='" + class_id + '\'' +
                ", credit=" + credit +
                ", max_num=" + max_num +
                '}';
    }
}
