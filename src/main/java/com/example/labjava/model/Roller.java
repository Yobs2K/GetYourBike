package com.example.labjava.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Roller {

    @Id
    @GeneratedValue
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

}
