package com.pojo;

public class Theme {

    private Long id;

    private Long sampleReelsId;

    private String sampleReelsName;

    private String name;

    private Long createAt;

    private Long updateAt;

    private String updateBy;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSampleReelsId() {
        return sampleReelsId;
    }

    public void setSampleReelsId(Long sampleReelsId) {
        this.sampleReelsId = sampleReelsId;
    }

    public String getSampleReelsName() {
        return sampleReelsName;
    }

    public void setSampleReelsName(String sampleReelsName) {
        this.sampleReelsName = sampleReelsName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    @Override
    public String toString() {
        return "Theme{" +
                "id=" + id +
                ", sampleReelsId=" + sampleReelsId +
                ", sampleReelsName='" + sampleReelsName + '\'' +
                ", name='" + name + '\'' +
                ", createAt=" + createAt +
                ", updateAt=" + updateAt +
                ", updateBy='" + updateBy + '\'' +
                '}';
    }
}
