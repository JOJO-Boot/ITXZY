<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>手机注册页面</title>
</head>
<body>

<h2>在这里注册</h2>
<hr style="height:1px;border:none;border-top:1px solid #555555;" />
<br></br>

<form action="registerByPhone"  method="post">
    用户名:<input type="text" name="username" placeholder="请输入小于16位的用户名" maxlength="16"><br>
    手机号:<input type="text" name="phone" placeholder="请输入11位手机号" maxlength="11"><br>
    验证码:<input type="text" name="code" placeholder="请输入6位验证码" maxlength="6"><br>
    小密码:<input type="text" name="password"><br>
    <input type="submit" value="注册">
</form>
<br></br>
<br></br>
<a href="toSendCode"><input type="button" value="验证码"></a>
<a href="toRegister"><input type="button" value="普通注册"></a>
<a href="toRegisterByEmail"><input type="button" value="使用邮箱注册"></a>
<a href="toLogin"> <input type="button" value="已有账户？点我登录"> </a>
${mes}
</body>
</html>
