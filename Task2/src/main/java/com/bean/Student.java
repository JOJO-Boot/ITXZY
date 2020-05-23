package com.bean;

public class Student {

    private Integer id;
    private Long createAt;
    private String name;
    private String qq;
    private String type;
    private String city;
    private Long enterAt;
    private String school;
    private Integer onlineId;
    private String link;
    private String desire;
    private String bro;
    private Long updateAt;
    private String knowFrom;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Long createAt) {
        this.createAt = createAt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Long getEnterAt() {
        return enterAt;
    }

    public void setEnterAt(Long enterAt) {
        this.enterAt = enterAt;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public Integer getOnlineId() {
        return onlineId;
    }

    public void setOnlineId(Integer onlineId) {
        this.onlineId = onlineId;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getDesire() {
        return desire;
    }

    public void setDesire(String desire) {
        this.desire = desire;
    }

    public String getBro() {
        return bro;
    }

    public void setBro(String bro) {
        this.bro = bro;
    }

    public Long getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Long updateAt) {
        this.updateAt = updateAt;
    }

    public String getKnowFrom() {
        return knowFrom;
    }

    public void setKnowFrom(String knowFrom) {
        this.knowFrom = knowFrom;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", createAt=" + createAt +
                ", name='" + name + '\'' +
                ", qq='" + qq + '\'' +
                ", type='" + type + '\'' +
                ", city='" + city + '\'' +
                ", enterAt=" + enterAt +
                ", school='" + school + '\'' +
                ", onlineId=" + onlineId +
                ", link='" + link + '\'' +
                ", desire='" + desire + '\'' +
                ", bro='" + bro + '\'' +
                ", updateAt=" + updateAt +
                ", knowFrom='" + knowFrom + '\'' +
                '}';
    }
}