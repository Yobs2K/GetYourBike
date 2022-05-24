package com.example.labjava.dto;

public class SkateboardDTO {

    private Long id;

    private String name;

    private String shortDesc;

    private String fullDesc;

    private Double width; //Ширина деки, дюймы

    private Double length; //Длина деки, дюймы

    private Double suspensionWidth; //ширина подвески, мм

    private Long skatewheelId;

    private SkatewheelDTO skatewheel;

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

    public Long getSkatewheelId() {
        return skatewheelId;
    }

    public void setSkatewheelId(Long skatewheelId) {
        this.skatewheelId = skatewheelId;
    }

    public SkatewheelDTO getSkatewheel() {
        return skatewheel;
    }

    public void setSkatewheel(SkatewheelDTO skatewheel) {
        this.skatewheel = skatewheel;
    }

    public String getImgLink() {
        return imgLink;
    }

    public void setImgLink(String imgLink) {
        this.imgLink = imgLink;
    }
}
