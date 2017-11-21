package com.example.lin.testapplication.entity;

/**
 * Created by 101912 on 2017/7/27.
 */

public class Person {

    private int _id;
    private String name;
    private String age;

    public void setId(int id) {
        this._id = id;
    }

    public int getId() {
        return _id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getAge() {
        return age;
    }
}
