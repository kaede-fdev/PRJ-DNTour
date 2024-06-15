<%--
    Document   : login-page
    Created on : May 14, 2024, 11:00:55 AM
    Author     : VJames
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
              rel="stylesheet" >
    </head>

    <body>
        <section class="vh-100" >
            <div class="container h-100">
                <div class="row d-flex justify-content-center align-items-center h-100">
                    <div class="col-lg-12 col-xl-11">
                        <div class="card text-black" style="border:none;">
                            <div class="card-body p-md-5">
                                <div class="row justify-content-center">
                                    <div class="col-md-10 col-lg-6 col-xl-5 order-2 order-lg-1">

                                        <p class="text-center h1 fw-bold mb-5 mx-1 mx-md-4 mt-4">Đăng ký</p>

                                        <form class="mx-1 mx-md-4" action="register" method="POST">

                                            <div class="d-flex flex-row align-items-center mb-4">
                                                <i class="fas fa-user fa-lg me-3 fa-fw"></i>
                                                <div data-mdb-input-init class="form-outline flex-fill mb-0">
                                                    <input name="fullname" type="text" id="form3Example1c" class="form-control" />
                                                    <label class="form-label" for="form3Example1c">Tên của bạn</label>
                                                </div>
                                            </div>

                                            <div class="d-flex flex-row align-items-center mb-4">
                                                <i class="fas fa-envelope fa-lg me-3 fa-fw"></i>
                                                <div data-mdb-input-init class="form-outline flex-fill mb-0">
                                                    <input name="email" type="email" id="form3Example3c" class="form-control" />
                                                    <label class="form-label" for="form3Example3c">Email</label>
                                                </div>
                                            </div>

                                            <div class="d-flex flex-row align-items-center mb-4">
                                                <i class="fas fa-lock fa-lg me-3 fa-fw"></i>
                                                <div data-mdb-input-init class="form-outline flex-fill mb-0">
                                                    <input name="password" type="password" id="form3Example4c" class="form-control" />
                                                    <label class="form-label" for="form3Example4c">Mật khẩu</label>
                                                </div>
                                            </div>

                                            <div class="d-flex flex-row align-items-center mb-4">
                                                <i class="fas fa-key fa-lg me-3 fa-fw"></i>
                                                <div data-mdb-input-init class="form-outline flex-fill mb-0">
                                                    <input name="confirmPassword" type="password" id="form3Example4cd" class="form-control" />
                                                    <label class="form-label" for="form3Example4cd">Nhập lại mật khẩu</label>
                                                </div>
                                            </div>
                                            <% if (request.getAttribute("errorMessage") != null) {%>
                                            <div class="alert alert-danger" role="alert">
                                                <%= request.getAttribute("errorMessage")%>
                                            </div>
                                            <% }%>

                                            <div class="d-flex justify-content-center mx-4 mb-3 mb-lg-4 gap-4">
                                                <button  type="submit" data-mdb-button-init data-mdb-ripple-init class="btn btn-primary btn">Đăng ký</button>
                                            </div>

                                        </form>

                                    </div>
                                    <div class="col-md-10 col-lg-6 col-xl-7 d-flex align-items-center order-1 order-lg-2">

                                        <img src="https://res.cloudinary.com/dy1uuo6ql/image/upload/v1718218036/jovpaga58spxhjrvwear.jpg"
                                             class="img-fluid rounded-3" alt="Sample image">

                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
    </body>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
    ></script>
</html>
