package com.edu.system.demo.entity;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

/**
 * @author lucas
 * @site
 * @company
 * @create 2019-11-04 22:22
 */
@Entity
@Table(name = "classroom")
public class Classroom {
    @Id
    @GeneratedValue
    private Integer id;

    @Column(length = 80)
//    @ApiModelProperty(value = "上课教室")
    private String classroom;

//    @ApiModelProperty(value = "上课星期")
    private String weekday;

    //上课节数
    @Column(length = 80)
    private String lesson1;
    @Column(length = 80)
    private String lesson2;
    @Column(length = 80)
    private String lesson3;
    @Column(length = 80)
    private String lesson4;
    @Column(length = 80)
    private String lesson5;
    @Column(length = 80)
    private String lesson6;
    @Column(length = 80)
    private String lesson7;
    @Column(length = 80)
    private String lesson8;
    @Column(length = 80)
    private String lesson9;
    @Column(length = 80)
    private String lesson10;
    @Column(length = 80)
    private String lesson11;
    @Column(length = 80)
    private String lesson12;
    @Column(length = 80)
    private String lesson13;
    @Column(length = 80)
    private String lesson14;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClassroom() {
        return classroom;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }

    public String getWeekday() {
        return weekday;
    }

    public void setWeekday(String weekday) {
        this.weekday = weekday;
    }

    public String getLesson1() {
        return lesson1;
    }

    public void setLesson1(String lesson1) {
        this.lesson1 = lesson1;
    }

    public String getLesson2() {
        return lesson2;
    }

    public void setLesson2(String lesson2) {
        this.lesson2 = lesson2;
    }

    public String getLesson3() {
        return lesson3;
    }

    public void setLesson3(String lesson3) {
        this.lesson3 = lesson3;
    }

    public String getLesson4() {
        return lesson4;
    }

    public void setLesson4(String lesson4) {
        this.lesson4 = lesson4;
    }

    public String getLesson5() {
        return lesson5;
    }

    public void setLesson5(String lesson5) {
        this.lesson5 = lesson5;
    }

    public String getLesson6() {
        return lesson6;
    }

    public void setLesson6(String lesson6) {
        this.lesson6 = lesson6;
    }

    public String getLesson7() {
        return lesson7;
    }

    public void setLesson7(String lesson7) {
        this.lesson7 = lesson7;
    }

    public String getLesson8() {
        return lesson8;
    }

    public void setLesson8(String lesson8) {
        this.lesson8 = lesson8;
    }

    public String getLesson9() {
        return lesson9;
    }

    public void setLesson9(String lesson9) {
        this.lesson9 = lesson9;
    }

    public String getLesson10() {
        return lesson10;
    }

    public void setLesson10(String lesson10) {
        this.lesson10 = lesson10;
    }

    public String getLesson11() {
        return lesson11;
    }

    public void setLesson11(String lesson11) {
        this.lesson11 = lesson11;
    }

    public String getLesson12() {
        return lesson12;
    }

    public void setLesson12(String lesson12) {
        this.lesson12 = lesson12;
    }

    public String getLesson13() {
        return lesson13;
    }

    public void setLesson13(String lesson13) {
        this.lesson13 = lesson13;
    }

    public String getLesson14() {
        return lesson14;
    }

    public void setLesson14(String lesson14) {
        this.lesson14 = lesson14;
    }

    @Override
    public String toString() {
        return "Classroom{" +
                "id=" + id +
                ", classroom='" + classroom + '\'' +
                ", weekday='" + weekday + '\'' +
                ", lesson1='" + lesson1 + '\'' +
                ", lesson2='" + lesson2 + '\'' +
                ", lesson3='" + lesson3 + '\'' +
                ", lesson4='" + lesson4 + '\'' +
                ", lesson5='" + lesson5 + '\'' +
                ", lesson6='" + lesson6 + '\'' +
                ", lesson7='" + lesson7 + '\'' +
                ", lesson8='" + lesson8 + '\'' +
                ", lesson9='" + lesson9 + '\'' +
                ", lesson10='" + lesson10 + '\'' +
                ", lesson11='" + lesson11 + '\'' +
                ", lesson12='" + lesson12 + '\'' +
                ", lesson13='" + lesson13 + '\'' +
                ", lesson14='" + lesson14 + '\'' +
                '}';
    }
}
