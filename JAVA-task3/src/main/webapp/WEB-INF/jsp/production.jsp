<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>

<json:object escapeXml="false">
    <json:object name="production" >
        <json:property name="id" value="${production.id}" />
        <json:property name="sampleReelsId" value="${production.sampleReelsId}" />
        <json:property name="sampleReelsName" value="${production.sampleReelsName}"/>
        <json:property name="themeId" value="${production.themeId}"/>
        <json:property name="themeName" value="${production.themeName}"/>
        <json:property name="name" value="${production.name}"/>
        <json:property name="content" value="${production.content}"/>
        <json:property name="createAt" value="${production.createAt}"/>
        <json:property name="updateAt" value="${production.updateAt}"/>
        <json:property name="updateBy" value="${production.updateBy}"/>
    </json:object>
</json:object>
