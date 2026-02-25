<%-- 
    Document   : home
    Created on : Feb 25, 2026, 3:58:34 PM
    Author     : khanhnd
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Home</h1>
        
          <a href="<c:url value='/login?action=login' />">login</a>
    </body>
</html>
