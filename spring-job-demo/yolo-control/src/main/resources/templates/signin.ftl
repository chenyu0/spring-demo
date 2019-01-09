<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" Content="text/html;Charset=UTF-8"/>
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport"/>
    <meta name="keywords" content="job">
    <title>job系统</title>
</head>
<body>
<div>
    <form action="controller/SysUserController/login" method="post">
        用户名：<input type="text" name="username"/>
        <br/>
        密码：<input type="password" name="password"/>
        <br/>
        <input type="submit" id="submit" value="Login"/>
    </form>
</div>
</body>
<script type="text/javascript">
    <#if (message['message'])??>
          alert("${message['message']}");
    </#if>
</script>

</html>