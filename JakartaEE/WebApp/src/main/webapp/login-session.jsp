<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Login con Session</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/login-session-servlet" method="post">
      <input type="text" name="username" placeholder="username">
      <input type="password" name="password" placeholder="password">
      <input type="submit" value="Login-session">
    </form>

</body>
</html>
