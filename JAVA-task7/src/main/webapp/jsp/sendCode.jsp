<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>发送验证码</title>
</head>
<body>

<h2>发送验证码</h2>
<hr style="height:1px;border:none;border-top:1px solid #555555;" />
<br></br>

<form action="sendCode"  method="post">
    手机号:<input type="text" name="phone"><br>
    验证码:<input type="text" name="code">
    <input type="submit" value="发送验证码">
</form>
<br></br>
<br></br>
<a href="toRegister"><input type="button" value="普通注册"></a>
<a href="toRegisterByEmail"><input type="button" value="使用邮箱注册"></a>
<a href="toLogin"> <input type="button" value="已有账户？点我登录"> </a>
${mes}
</body>
</html>
