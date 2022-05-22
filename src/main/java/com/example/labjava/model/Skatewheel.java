package com.example.labjava.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Skatewheel {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String shortDesc;

    private String fullDesc;

    private Double wheelSize; //Диаметр колёс, мм

    private String wheelHardness; //Жёсткость колёс, а-ля 95A
}
