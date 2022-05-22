package com.example.labjava.model;

import javax.persistence.*;

@Entity
public class Skateboard {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String shortDesc;

    private String fullDesc;

    private Double width; //Ширина деки, дюймы

    private Double length; //Длина деки, дюймы

    private Double suspensionWidth; //ширина подвески, мм

    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "skatewheel_id")
    private Skatewheel skateWheel;


}
