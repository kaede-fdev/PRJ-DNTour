<%--
    Document   : header
    Created on : May 14, 2024, 12:11:05 AM
    Author     : VJames
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
              rel="stylesheet" >
    </head>
    <body>
        <header class="p-3 bg-dark text-white">
            <div class="container">
                <div class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">
                    <a href="/ITour/" class="d-flex align-items-center mb-2 mb-lg-0 text-white text-decoration-none">
                        <p class="text-center" style="font-size: 32px; color: white; font-weight: bold; margin: 0">DNTours</p>
                    </a>
                    <ul class="nav  col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0" style="margin-left: 30px;">
                        <%
                            String requestURI = request.getRequestURI();
                            String[] parts = requestURI.split("/");
                            String lastPart = parts[parts.length - 1];
                            String pageName = lastPart.split("\\.")[0];
                            System.out.println("AT PAGE " + pageName);
                        %>
                        <li>
                            <a href="home" class="nav-link pb-2 <%= pageName.equals("home") ? "text-white" : "text-secondary"%>">Trang chủ</a>
                        </li>
                        <li>
                            <a href="service" class="nav-link pb-2 <%= pageName.equals("service") ? "text-white" : "text-secondary"%>">Dịch vụ</a>
                        </li>
                        <li>
                            <a href="introduce" class="nav-link pb-2 <%= pageName.equals("introduce") ? "text-white" : "text-secondary"%>">Giới thiệu</a>
                        </li>
                        <li>
                            <a href="news" class="nav-link pb-2 <%= pageName.equals("news") ? "text-white" : "text-secondary"%>">Tin tức</a>
                        </li>
                        <li>
                            <a href="contact" class="nav-link pb-2 <%= pageName.equals("contact") ? "text-white" : "text-secondary"%>">Liên hệ</a>
                        </li>
                    </ul>
                    <form class="col-12 col-lg-auto mb-3 mb-lg-0 me-lg-3">
                        <input type="search" class="form-control form-control-dark"
                               placeholder="Search..."
                               arial-label="Search"
                               />
                    </form>
                    <div>
                        <a href="login" class="text-decoration-none">
                            <button type="button" class="btn btn-outline-light me-2">Login</button>
                        </a>
                        <a href="register" class="text-decoration-none">
                            <button type="button" class="btn btn-warning">Register</button>
                        </a>
                    </div>

                </div>
            </div>
        </header>
    </body>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
    ></script>
</html>
