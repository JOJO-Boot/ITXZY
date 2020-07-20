package com.pojo;

public class Email {
    private String region;//城市
    private String accessKeyId ;//跟短信的数值一样
    private String accessKeySecret;//同上
    private String accountName;  //控制台创建的发信地址
    private String fromAlias;  //发信人昵称
    private String tagName;  //控制台创建的标签
    private String subject; //邮件主题
    private String htmlBody; //邮件正文

    public String getAccessKeyId() {
        return accessKeyId;
    }

    public void setAccessKeyId(String accessKeyId) {
        this.accessKeyId = accessKeyId;
    }

    public String getAccessKeySecret() {
        return accessKeySecret;
    }

    public void setAccessKeySecret(String accessKeySecret) {
        this.accessKeySecret = accessKeySecret;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getFromAlias() {
        return fromAlias;
    }

    public void setFromAlias(String fromAlias) {
        this.fromAlias = fromAlias;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getHtmlBody() {
        return htmlBody;
    }

    public void setHtmlBody(String htmlBody) {
        this.htmlBody = htmlBody;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }
}