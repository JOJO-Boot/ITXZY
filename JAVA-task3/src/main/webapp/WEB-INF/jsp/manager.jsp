<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>

<json:object escapeXml="false">
    <json:object name="manager" >
        <json:property name="id" value="${manager.id}" />
        <json:property name="name" value="${manager.name}" />
        <json:property name="password" value="${manager.password}"/>
        <json:property name="lastLogAt" value="${manager.lastLogAt}"/>
    </json:object>
</json:object>

