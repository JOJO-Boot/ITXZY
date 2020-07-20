<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>邮件注册页面</title>
</head>
<body>
<strong><p>邮箱注册</p></strong>
<form action="registerByEmail" method=POST >
<%--    请输入用户名:<br>--%>
<%--    <input type="text" name="username" id="username" placeholder="请输入小于16位的用户名" maxlength="16">--%>
<%--    ${NameError}--%>
<%--    <br>--%>
<%--    请输入密码:<br>--%>
<%--    <input type="text" name="password" id="pass" placeholder="请输入小于16位的密码"  maxlength="16">--%>
<%--    ${PassError}--%>
<%--    <br>--%>
<%--    请再次确认密码:<br>--%>
<%--    <input type="text" name="againPassword" id="againPass" placeholder="请再次输入密码" maxlength="16" >--%>
<%--    ${TwoPassError}--%>
<%--    <br>--%>
    邮箱:<br>
    <input type="text" name="email" id="email2" placeholder="请输入您的邮箱">
    ${EmailError}
    <br>
    请输入收到的验证码:<br>
    <input type="text" name="yzm" id="yzm" placeholder="请输入6位验证码" maxlength="6">
    <input type="button" name="" id="verCodeBtn" value="获取验证码" onclick="settime(this);"/>
    ${YzmError}
    <br>
    <br>
    <input type="submit" value="注册">
</form>
<br>

<script src="http://www.lanrenzhijia.com/ajaxjs/jquery.min.js"></script>
<script>
    //验证码
    var counts = 120;
    function settime(val) {
        if(counts == 0) {
            val.removeAttribute("disabled");
            val.value = "获取验证码";
            counts = 120;
            return false;
        } else {
            val.setAttribute("disabled", true);
            val.value = "重新发送（" + counts + "）";
            counts--;
        }
        setTimeout(function() {
            settime(val);
        }, 1000);
    }

    //获取验证码
    $(function(){
        $("#verCodeBtn").click(function() {
            var userinfo = {
                "UserEmailNum": $("input[name='email']").val()
            }

            $.ajax({
                url: "/sendEmailYzm",
                data: userinfo,
                type: "post",
            });
        });
    })
</script>

</hr>
<a href="toRegisterByPhone">如果你想使用手机注册，请点击此处</a>
<br>
<a href="login">已有账号？点此直接登录</a>
</body>
</html>
