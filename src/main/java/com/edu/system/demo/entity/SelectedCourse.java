package com.edu.system.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author lucas
 * @site
 * @company
 * @create 2019-10-28 17:13
 */
@Entity
@Table(name = "selected_course")
public class SelectedCourse {

    @Id
    @GeneratedValue
    private int id;

    private int course_id;

    private int stu_id;

    private float score;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public int getStu_id() {
        return stu_id;
    }

    public void setStu_id(int stu_id) {
        this.stu_id = stu_id;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "SelectedCourse{" +
                "id=" + id +
                ", course_id=" + course_id +
                ", stu_id=" + stu_id +
                ", score=" + score +
                '}';
    }
}
