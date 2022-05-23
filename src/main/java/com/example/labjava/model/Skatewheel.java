package com.example.labjava.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;

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

    public Double getWheelSize() {
        return wheelSize;
    }

    public void setWheelSize(Double wheelSize) {
        this.wheelSize = wheelSize;
    }

    public String getWheelHardness() {
        return wheelHardness;
    }

    public void setWheelHardness(String wheelHardness) {
        this.wheelHardness = wheelHardness;
    }
}
