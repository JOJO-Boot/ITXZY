<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<json:object escapeXml="false">

    <json:property name="code" value="${code}"/>
    <json:property name="message" value="${message}"/>
    <json:array name="data">
        <c:forEach items="${list}" var="student">
            <json:object>
                <json:property name="id" value="${student.id}"/>
                <json:property name="createAt" value="${student.createAt}"/>
                <json:property name="name" value="${student.name}"/>
                <json:property name="qq" value="${student.qq}"/>
                <json:property name="type" value="${student.type}"/>
                <json:property name="city" value="${student.city}"/>
                <json:property name="enterAt" value="${student.enterAt}"/>
                <json:property name="school" value="${student.school}"/>
                <json:property name="onlineId" value="${student.onlineId}"/>
                <json:property name="link" value="${student.link}"/>
                <json:property name="desire" value="${student.desire}"/>
            </json:object>
        </c:forEach>
    </json:array>

</json:object>

