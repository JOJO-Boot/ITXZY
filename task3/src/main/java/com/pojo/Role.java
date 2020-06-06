package com.pojo;

public class Role {

    private Long id;

    private String name;

    private String jurisdiction;

    private Long createAt;

    private Long updateAt;

    private String updateBy;

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

    public String getJurisdiction() {
        return jurisdiction;
    }

    public void setJurisdiction(String jurisdiction) {
        this.jurisdiction = jurisdiction;
    }

    public Long getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Long createAt) {
        this.createAt = createAt;
    }

    public Long getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Long updateAt) {
        this.updateAt = updateAt;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public Long getLastLogAt() {
        return lastLogAt;
    }

    public void setLastLogAt(Long lastLogAt) {
        this.lastLogAt = lastLogAt;
    }

    @Override
    public String   toString() {
        return "Role{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", jurisdiction='" + jurisdiction + '\'' +
                ", createAt=" + createAt +
                ", updateAt=" + updateAt +
                ", updateBy='" + updateBy + '\'' +
                ", lastLogAt=" + lastLogAt +
                '}';
    }
}
