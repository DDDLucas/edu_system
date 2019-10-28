package com.edu.system.demo.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author lucas
 * @site
 * @company
 * @create 2019-10-28 7:36
 */
@Entity
@Table(name = "administer")
public class Administer  {

    @Id
    @GeneratedValue
    private int id;

    @Column(length = 80)
    private String usr_name;

    @Column(length = 80)
    private String password;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsr_name() {
        return usr_name;
    }

    public void setUsr_name(String usr_name) {
        this.usr_name = usr_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
