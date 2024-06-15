<%--
    Document   : layout
    Created on : May 14, 2024, 12:06:05 AM
    Author     : VJames
--%>

<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>${pageTitle}</title>

    </head>
    <body>
        <main>
            <jsp:include page="${pageContent}"/>
        </main>
    </body>
</html>
