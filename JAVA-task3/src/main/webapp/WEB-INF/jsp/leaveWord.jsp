<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>

<json:object escapeXml="false">
    <json:object name="leaveWord" >
        <json:property name="id" value="${leaveWord.id}" />
        <json:property name="nick" value="${leaveWord.nick}" />
        <json:property name="content" value="${leaveWord.content}"/>
        <json:property name="creatAt" value="${leaveWord.creatAt}"/>
    </json:object>
</json:object>

