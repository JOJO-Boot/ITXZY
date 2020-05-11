package com.itxzy.bean;

public class Student {

    private Integer id;
    private Long create_at;
    private String name;
    private String qq;
    private String type;
    private String city;
    private Long enter_at;
    private String school;
    private Integer online_id;
    private String link;
    private String desire;
    private String bro;
    private Long update_at;
    private String know_from;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getCreate_at() {
        return create_at;
    }

    public void setCreate_at(Long create_at) {
        this.create_at = create_at;
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

    public Long getEnter_at() {
        return enter_at;
    }

    public void setEnter_at(Long enter_at) {
        this.enter_at = enter_at;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public Integer getOnline_id() {
        return online_id;
    }

    public void setOnline_id(Integer online_id) {
        this.online_id = online_id;
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

    public Long getUpdate_at() {
        return update_at;
    }

    public void setUpdate_at(Long update_at) {
        this.update_at = update_at;
    }

    public String getKnow_from() {
        return know_from;
    }

    public void setKnow_from(String know_from) {
        this.know_from = know_from;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", create_at=" + create_at +
                ", name='" + name + '\'' +
                ", qq='" + qq + '\'' +
                ", type='" + type + '\'' +
                ", city='" + city + '\'' +
                ", enter_at=" + enter_at +
                ", school='" + school + '\'' +
                ", online_id=" + online_id +
                ", link='" + link + '\'' +
                ", desire='" + desire + '\'' +
                ", bro='" + bro + '\'' +
                ", update_at=" + update_at +
                ", know_from='" + know_from + '\'' +
                '}';
    }
}
