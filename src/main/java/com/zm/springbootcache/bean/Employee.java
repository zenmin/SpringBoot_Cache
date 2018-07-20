package com.zm.springbootcache.bean;

import java.io.Serializable;

public class Employee implements Serializable {
    private Integer id;

    private String name;

    private String gender;

    private Integer age;

    private Integer dId;

    private String empStatus;

    public Employee(Integer id, String name, String gender, Integer age, Integer dId, String empStatus) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.dId = dId;
        this.empStatus = empStatus;
    }

    public Employee() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getdId() {
        return dId;
    }

    public void setdId(Integer dId) {
        this.dId = dId;
    }

    public String getEmpStatus() {
        return empStatus;
    }

    public void setEmpStatus(String empStatus) {
        this.empStatus = empStatus == null ? null : empStatus.trim();
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", dId=" + dId +
                ", empStatus='" + empStatus + '\'' +
                '}';
    }
}