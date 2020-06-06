<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>

<json:object escapeXml="false">
    <json:object name="role" >
        <json:property name="id" value="${role.id}" />
        <json:property name="name" value="${role.name}" />
        <json:property name="jurisdiction" value="${role.jurisdiction}" />
        <json:property name="createAt" value="${role.createAt}" />
        <json:property name="updateAt" value="${role.updateAt}" />
        <json:property name="updateBy" value="${role.updateBy}" />
        <json:property name="lastLogAt" value="${role.lastLogAt}" />
    </json:object>
</json:object>
