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

    private String imgLink;

    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "skatewheel_id")
    private Skatewheel skateWheel;

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

    public Double getWidth() {
        return width;
    }

    public void setWidth(Double width) {
        this.width = width;
    }

    public Double getLength() {
        return length;
    }

    public void setLength(Double length) {
        this.length = length;
    }

    public Double getSuspensionWidth() {
        return suspensionWidth;
    }

    public void setSuspensionWidth(Double suspensionWidth) {
        this.suspensionWidth = suspensionWidth;
    }

    public Skatewheel getSkateWheel() {
        return skateWheel;
    }

    public void setSkateWheel(Skatewheel skateWheel) {
        this.skateWheel = skateWheel;
    }

    public String getImgLink() {
        return imgLink;
    }

    public void setImgLink(String imgLink) {
        this.imgLink = imgLink;
    }
}
