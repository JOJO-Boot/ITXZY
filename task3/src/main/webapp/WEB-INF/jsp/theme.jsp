<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>

<json:object escapeXml="false">
    <json:object name="theme" >
        <json:property name="id" value="${theme.id}" />
        <json:property name="sampleReelsId" value="${theme.sampleReelsId}" />
        <json:property name="sampleReelsName" value="${theme.sampleReelsName}" />
        <json:property name="name" value="${theme.name}" />
        <json:property name="createAt" value="${theme.createAt}" />
        <json:property name="updateAt" value="${theme.updateAt}" />
        <json:property name="updateBy" value="${theme.updateBy}" />
    </json:object>
</json:object>
