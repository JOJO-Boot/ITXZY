<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>

<json:object escapeXml="false">
    <json:object name="sampleReels" >
        <json:property name="id" value="${sampleReels.id}" />
        <json:property name="name" value="${sampleReels.name}" />
        <json:property name="creatAt" value="${sampleReels.createAt}" />
        <json:property name="updateAt" value="${sampleReels.updateAt}" />
        <json:property name="updateBy" value="${sampleReels.updateBy}" />
    </json:object>
</json:object>
