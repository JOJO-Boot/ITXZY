<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册页面</title>
</head>
<body>

<h2>在这里注册</h2>
<hr style="height:1px;border:none;border-top:1px solid #555555;" />
<br></br>

<form action="register"  method="post">
    用户:<input type="text" name="username">
    密码:<input type="text" name="password">
    <input type="submit" value="注册">
</form>
<br></br>
<br></br>
<a href="toRegisterByPhone"><input type="button" value="使用手机号注册"></a>
<a href="toRegisterByEmail"><input type="button" value="使用邮箱注册"></a>
<a href="toLogin"> <input type="button" value="已有账户？点我登录"> </a>
${mes}
</body>
</html>
