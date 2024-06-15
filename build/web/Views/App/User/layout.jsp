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
        <header>
            <jsp:include page="/Views/Modules/Layouts/User/header.jsp"/>
        </header>
        <!--        <nav>
        <jsp:include page="/Views/Modules/Layouts/User/navigation.jsp"/>
    </nav>-->
        <main>
            <div id="user-main-container" class="container">
                <jsp:include page="${pageContent}"/>
            </div>
        </main>
        <!--        <footer>
        <jsp:include page="/Views/Modules/Layouts/User/footer.jsp"/>
    </footer>-->
    </body>
</html>
