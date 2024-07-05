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
    <style>
        body::-webkit-scrollbar {
            width: 5px;
        }

        body::-webkit-scrollbar-track {
            background: #B2b2b2;
        }

        body::-webkit-scrollbar-thumb {
            background-color: #212529;
            border-radius: 4px;
        }
    </style>
    <body>
        <header>
            <jsp:include page="/Views/Modules/Layouts/User/header.jsp"/>
        </header>
        <!--        <nav>
        <jsp:include page="/Views/Modules/Layouts/User/navigation.jsp"/>
    </nav>-->
        <main style="padding-top: 64px;">
            <div class="">
                <jsp:include page="${pageContent}"/>
            </div>
        </main>

        <jsp:include page="/Views/Modules/Layouts/User/footer.jsp"/>
    </body>
</html>
