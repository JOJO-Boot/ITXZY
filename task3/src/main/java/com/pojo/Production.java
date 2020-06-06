package com.pojo;

public class Production {

    private Long id;

    private Long sampleReelsId;

    private String sampleReelsName;

    private Long themeId;

    private String themeName;

    private String name;

    private String content;

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

    public Long getThemeId() {
        return themeId;
    }

    public void setThemeId(Long themeId) {
        this.themeId = themeId;
    }

    public String getThemeName() {
        return themeName;
    }

    public void setThemeName(String themeName) {
        this.themeName = themeName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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
        return "Production{" +
                "id=" + id +
                ", sampleReelsId=" + sampleReelsId +
                ", sampleReelsName='" + sampleReelsName + '\'' +
                ", themeId=" + themeId +
                ", themeName='" + themeName + '\'' +
                ", name='" + name + '\'' +
                ", content='" + content + '\'' +
                ", createAt=" + createAt +
                ", updateAt=" + updateAt +
                ", updateBy='" + updateBy + '\'' +
                '}';
    }
}
