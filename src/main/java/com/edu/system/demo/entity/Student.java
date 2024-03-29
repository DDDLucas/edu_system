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
@Table(name="student")
public class Student {

    @Id
    @GeneratedValue
//    @ApiModelProperty(value = "学生id")
    private int id;

    @Column(length = 80)
//    @ApiModelProperty(value = "学生姓名")
    private String name;

    @Column(length = 80)
//    @ApiModelProperty(value = "学生密码")
    private String password;

    @Column(length = 80)
//    @ApiModelProperty(value = "专业")
    private String specialty;

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

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", specialty='" + specialty + '\'' +
                ", institute='" + institute + '\'' +
                '}';
    }
}
