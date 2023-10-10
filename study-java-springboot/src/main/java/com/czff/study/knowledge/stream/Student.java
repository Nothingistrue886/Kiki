package com.czff.mydemo.knowledge.stream;

public class Student {

    private String name;
    private Integer sorceNumber;

    public Student() {
    }

    public Student(String name) {
        this.name = name;
    }

    public Student(String name, Integer sorceNumber) {
        this.name = name;
        this.sorceNumber = sorceNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSorceNumber() {
        return sorceNumber;
    }

    public void setSorceNumber(Integer sorceNumber) {
        this.sorceNumber = sorceNumber;
    }
}
