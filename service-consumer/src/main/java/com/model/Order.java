package com.model;

import java.io.Serializable;

/**
 * @Description
 * @author: yangyingyang
 * @date: 2021/1/21.
 */
public class Order implements Serializable {

    private String id;

    private String username;

    private String phone;

    private Integer age;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
