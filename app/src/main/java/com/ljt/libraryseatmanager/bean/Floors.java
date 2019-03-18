package com.ljt.libraryseatmanager.bean;

import java.util.List;

public class Floors {
    String name ;
    List<Areas> areas;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Areas> getAreas() {
        return areas;
    }

    public void setAreas(List<Areas> areas) {
        this.areas = areas;
    }
}
