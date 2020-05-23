<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>

<json:object escapeXml="false">
    <json:object name="student" >
        <json:property name="id" value="${student.id}" />
        <json:property name="createAt" value="${student.createAt}" />
        <json:property name="name" value="${student.name}" />
        <json:property name="qq" value="${student.qq}" />
        <json:property name="type" value="${student.type}" />
        <json:property name="city" value="${student.city}" />
        <json:property name="enterAt" value="${student.enterAt}" />
        <json:property name="school" value="${student.school}" />
        <json:property name="onlineId" value="${student.onlineId}" />
        <json:property name="link" value="${student.link}" />
        <json:property name="desire" value="${student.desire}" />
        <json:property name="bro" value="${student.bro}" />
        <json:property name="updateAt" value="${student.updateAt}" />
        <json:property name="knowFrom" value="${student.knowFrom}" />
    </json:object>
</json:object>









