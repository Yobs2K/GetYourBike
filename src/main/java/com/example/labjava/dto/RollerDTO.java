package com.example.labjava.dto;

public class RollerDTO {

    private Long id;

    private String name;

    private String shortDesc;

    private String fullDesc;

    private String size; //размер обуви

    private Double wheelSize; //Диаметр колёс, мм

    private Integer wheelNum; //кол-во колёс

    private String age; //Возраст, либо диапазон, либо словом (детские, взрослые, подростковые итд)

    private String sex;

    private String color;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortDesc() {
        return shortDesc;
    }

    public void setShortDesc(String shortDesc) {
        this.shortDesc = shortDesc;
    }

    public String getFullDesc() {
        return fullDesc;
    }

    public void setFullDesc(String fullDesc) {
        this.fullDesc = fullDesc;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Double getWheelSize() {
        return wheelSize;
    }

    public void setWheelSize(Double wheelSize) {
        this.wheelSize = wheelSize;
    }

    public Integer getWheelNum() {
        return wheelNum;
    }

    public void setWheelNum(Integer wheelNum) {
        this.wheelNum = wheelNum;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
