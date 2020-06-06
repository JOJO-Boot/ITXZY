package com.pojo;

public class Manager {
    private Long id;

    private String name;

    private String password;

    private Long lastLogAt;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getLastLogAt() {
        return lastLogAt;
    }

    public void setLastLogAt(Long lastLogAt) {
        this.lastLogAt = lastLogAt;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", lastLogAt=" + lastLogAt +
                '}';
    }
}
