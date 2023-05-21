<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="java.util.Map" %>
<%

Map<String, String> errores = (Map<String, String>) request.getAttribute("errorsMap");

%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Formulario de usuarios</title>
</head>
<body>
<h3>Formulario de usuarios</h3>

<%
    if (errores != null && errores.size() > 0) {
%>
<ul>
    <% for (String error : errores.values()) {%>
    <!-- %= es una expresión de JSP que imprime el valor de la expresión -->
    <li><%=error%></li>
    <%}%>
</ul>
<%}%>
<!-- pageContext.request.contextPath es una variable de JSP que contiene el contexto de la aplicación -->
<!-- es decir, el prefijo de la URL de la aplicación -->
<form action="${pageContext.request.contextPath}/hello-servlet" method="post">

    <div>
        <label for="username">Usuario</label>
        <!-- param es una variable de JSP que contiene los parámetros de la petición -->
        <!-- El parámetro username es enviado por el servlet HelloServlet -->
        <div><input type="text" name="username" id="username" value="${param.username}"></div>
        <%
            if(errores != null && errores.containsKey("username")) {
        %>
        <div style="color: red"><%=errores.get("username")%></div>
        <%}%>
    </div>
    <div>
        <label for="password">Password</label>
        <div><input type="password" name="password" id="password"></div>
        <%
            if(errores != null && errores.containsKey("password")) {
        %>
        <div style="color: red"><%=errores.get("password")%></div>
        <%}%>

    </div>
    <div>
        <label for="email">Email</label>
        <div><input type="text" name="email" id="email" value="${param.email}"></div>
        <%
            if(errores != null && errores.containsKey("email")) {
        %>
        <div style="color: red"><%=errores.get("email")%></div>
        <%}%>

    </div>
    <div>
        <label for="pais">País</label>
        <div>
            <select name="pais" id="pais">
                <option value="">-- seleccionar --</option>
                <option value="ES" ${param.equals("ES")? "selected": ""}>España</option>
                <option value="MX" ${param.equals("MX")? "selected": ""}>México</option>
                <option value="CL" ${param.equals("CL")? "selected": ""}>Chile</option>
                <option value="AR" ${param.equals("AR")? "selected": ""}>Argentina</option>
                <option value="PE" ${param.equals("PE")? "selected": ""}>Perú</option>
                <option value="CO" ${param.equals("CO")? "selected": ""}>Colombia</option>
                <option value="VE" ${param.equals("VE")? "selected": ""}>Venezuela</option>
            </select>
        </div>
    </div>

    <div>
        <label for="lenguajes">Lenguajes de programación</label>
        <div>
            <select name="lenguajes" id="lenguajes" multiple>
                <option value="java" ${paramValues.lenguajes.stream().anyMatch(v-> v.equals("java")).get()?"selected":""}>Java SE</option>
                <option value="jakartaEE" ${paramValues.lenguajes.stream().anyMatch(v-> v.equals("jakartaEE")).get()?"selected":""}>Jakarta EE9</option>
                <option value="spring" ${paramValues.lenguajes.stream().anyMatch(v-> v.equals("spring")).get()?"selected":""}>Spring Boot</option>
                <option value="js" ${paramValues.lenguajes.stream().anyMatch(v-> v.equals("js")).get()?"selected":""}>JavaScript</option>
                <option value="angular" ${paramValues.lenguajes.stream().anyMatch(v-> v.equals("angular")).get()?"selected":""}>Angular</option>
                <option value="react" ${paramValues.lenguajes.stream().anyMatch(v-> v.equals("react")).get()?"selected":""}>React</option>
            </select>
        </div>
    </div>

    <div>
        <label>Roles</label>
        <div>
            <input type="checkbox" name="roles" value="ROLE_ADMIN">
            <label>Administrador</label>
        </div>
        <div>
            <input type="checkbox" name="roles" value="ROLE_USER" checked>
            <label>Usuario</label>
        </div>
        <div>
            <input type="checkbox" name="roles" value="ROLE_MODERATOR">
            <label>Moderador</label>
        </div>
    </div>
    <div>
        <label>Idiomas</label>
        <div>
            <input type="radio" name="idioma" value="es">
            <label>Español</label>
        </div>
        <div>
            <input type="radio" name="idioma" value="en">
            <label>Inglés</label>
        </div>
        <div>
            <input type="radio" name="idioma" value="fr">
            <label>Frances</label>
        </div>
    </div>
    <div>
        <label for="habilitar">Habilitar</label>
        <div>
            <input type="checkbox" name="habilitar" id="habilitar" checked>
        </div>
    </div>
    <div>
        <div>
            <input type="submit" value="Enviar">
        </div>
    </div>
    <input type="hidden" name="secreto" value="12345">
</form>

<!-- Las cabeceras HTTP se pueden ver en el navegador en la pestaña Network. Estas cabeceras se envían en la petición -->
<a href="${pageContext.request.contextPath}/cabeceras-http-request">Ir a la página de cabeceras Request</a>
<br>
<a href="${pageContext.request.contextPath}/cabeceras-http-request">Ir a la página de cabeceras Response</a>
</body>
</html>