package com.springboot.pojo;

import java.io.Serializable;

public class Tbstudent implements Serializable {

    private static final long serialVersionUID = -8592106287695486547L;
    private Integer id;

    private Long createat;

    private String name;

    private String qq;

    private String type;

    private String city;

    private Long enterat;

    private String school;

    private Integer onlineid;

    private String link;

    private String desire;

    private String bro;

    private Long updateat;

    private String knowfrom;



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getCreateat() {
        return createat;
    }

    public void setCreateat(Long createat) {
        this.createat = createat;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq == null ? null : qq.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public Long getEnterat() {
        return enterat;
    }

    public void setEnterat(Long enterat) {
        this.enterat = enterat;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school == null ? null : school.trim();
    }

    public Integer getOnlineid() {
        return onlineid;
    }

    public void setOnlineid(Integer onlineid) {
        this.onlineid = onlineid;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link == null ? null : link.trim();
    }

    public String getDesire() {
        return desire;
    }

    public void setDesire(String desire) {
        this.desire = desire == null ? null : desire.trim();
    }

    public String getBro() {
        return bro;
    }

    public void setBro(String bro) {
        this.bro = bro == null ? null : bro.trim();
    }

    public Long getUpdateat() {
        return updateat;
    }

    public void setUpdateat(Long updateat) {
        this.updateat = updateat;
    }

    public String getKnowfrom() {
        return knowfrom;
    }

    public void setKnowfrom(String knowfrom) {
        this.knowfrom = knowfrom == null ? null : knowfrom.trim();
    }

    @Override
    public String toString() {
        return "Tbstudent{" +
                "id=" + id +
                ", createat=" + createat +
                ", name='" + name + '\'' +
                ", qq='" + qq + '\'' +
                ", type='" + type + '\'' +
                ", city='" + city + '\'' +
                ", enterat=" + enterat +
                ", school='" + school + '\'' +
                ", onlineid=" + onlineid +
                ", link='" + link + '\'' +
                ", desire='" + desire + '\'' +
                ", bro='" + bro + '\'' +
                ", updateat=" + updateat +
                ", knowfrom='" + knowfrom + '\'' +
                '}';
    }
}