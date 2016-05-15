package com.iyihua.timeitem.models.item;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by iyihua on 2016/5/15.
 */
public class Item {
    private String date;
    private String time;
    private String content;
    private String category;
    private String project;
    private String location;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Item() {
    }

    public Item(String date, String time, String content, String category, String project, String location) {
        this.date = date;
        this.time = time;
        this.content = content;
        this.category = category;
        this.project = project;
        this.location = location;
    }

    public static List<Item> initTestDataList() {
        List<Item> list = new ArrayList<Item>();
        for (int i=0; i<10; i++) {
            list.add(new Item("date"+i,"time"+i,"content"+i,"category"+i,"project"+i,"location"+i));
        }
        return list;
    }
}
