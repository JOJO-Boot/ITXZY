<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>

<json:object escapeXml="false">
    <json:object name="intro" >
        <json:property name="id" value="${intro.id}" />
        <json:property name="name" value="${intro.name}"/>
        <json:property name="createAt" value="${intro.createAt}"/>
        <json:property name="updateAt" value="${intro.updateAt}"/>
        <json:property name="updateBy" value="${intro.updateBy}"/>
    </json:object>
</json:object>


