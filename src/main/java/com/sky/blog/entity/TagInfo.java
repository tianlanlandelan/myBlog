package com.sky.blog.entity;

/**
 * Created by yangkaile on 2018/1/14.
 */
public class TagInfo {
    private int id;
    private String name;

    public TagInfo() {
    }

    public TagInfo(String name) {
        this.name = name;
    }

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
}
