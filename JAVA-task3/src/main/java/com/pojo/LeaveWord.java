package com.pojo;

public class LeaveWord {
    private Long id;

    private String nick;

    private String content;

    private Long creatAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getCreatAt() {
        return creatAt;
    }

    public void setCreatAt(Long creatAt) {
        this.creatAt = creatAt;
    }

    @Override
    public String toString() {
        return "LeaveWord{" +
                "id=" + id +
                ", nick='" + nick + '\'' +
                ", content='" + content + '\'' +
                ", creatAt=" + creatAt +
                '}';
    }
}
