package com.example.labjava.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Bicycle {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String shortDesc;

    @Column(length = 4000)
    private String fullDesc;

    private String frameType;

    private Double weight;

    private Double wheelSize;

    private String style;

    private String imgLink;

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

    public String getFrameType() {
        return frameType;
    }

    public void setFrameType(String frameType) {
        this.frameType = frameType;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double frameSize) {
        this.weight = frameSize;
    }

    public Double getWheelSize() {
        return wheelSize;
    }

    public void setWheelSize(Double wheelSize) {
        this.wheelSize = wheelSize;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getImgLink() {
        return imgLink;
    }

    public void setImgLink(String imgLink) {
        this.imgLink = imgLink;
    }
}
