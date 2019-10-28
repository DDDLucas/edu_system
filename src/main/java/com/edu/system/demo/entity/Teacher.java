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
@Table(name="teacher")
public class Teacher {

    @Id
    @GeneratedValue
//    @ApiModelProperty(value = "老师id")
    private int id;

    @Column(length = 80)
//    @ApiModelProperty(value = "老师姓名")
    private String name;

    @Column(length = 80)
//    @ApiModelProperty(value = "老师密码")
    private String password;

    @Column(length = 80)
//    @ApiModelProperty(value = "学院")
    private String institute;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getInstitute() {
        return institute;
    }

    public void setInstitute(String institute) {
        this.institute = institute;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", institute='" + institute + '\'' +
                '}';
    }
}
