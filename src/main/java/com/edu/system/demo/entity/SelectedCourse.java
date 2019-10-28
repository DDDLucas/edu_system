package com.edu.system.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author lucas
 * @site
 * @company
 * @create 2019-10-28 17:13
 */
@Entity
@Table(name = "selectedCourse")
public class SelectedCourse {

    private int id;
    private int course_id;
    private int stu_id;
    private float score;
}
