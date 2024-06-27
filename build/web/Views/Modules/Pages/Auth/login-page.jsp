<%--
    Document   : login-page
    Created on : May 14, 2024, 11:00:55 AM
    Author     : VJames
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
        <style>
            .background-blur::before {
                content: '';
                position: absolute;
                top: 0;
                left: 0;
                width: 100%;
                height: 100%;
                background-image: url('https://res.cloudinary.com/dy1uuo6ql/image/upload/v1719295201/samples/h2fcan2lsxaw6yl7l9xz.jpg');
                background-position: center;
                background-repeat: no-repeat;
                background-size: cover;
                filter: blur(10px);
                z-index: -1;
            }

            .background-blur {
                position: relative;
                z-index: 0;
            }

            @keyframes slideIn {
                from {
                    transform: translateY(20%);
                    opacity: 0;
                }
                to {
                    transform: translateY(0);
                    opacity: 1;
                }
            }

            .slide-in {
                animation: slideIn 0.5s ease-out;
            }
        </style>
    </head>

    <body>
        <section class="vh-100 background-blur">
            <div class="container py-5 h-100">
                <div class="row d-flex justify-content-center align-items-center h-100">
                    <div class="col col-xl-10">
                        <div class="card slide-in" style="border-radius: 1rem;">
                            <div class="row g-0">
                                <div class="col-md-6 col-lg-5 d-none d-md-block">
                                    <img src="https://res.cloudinary.com/dy1uuo6ql/image/upload/v1719295201/samples/h2fcan2lsxaw6yl7l9xz.jpg"
                                         alt="login form" class="img-fluid" style="border-radius: 1rem 0 0 1rem; height: 100%;" />
                                </div>
                                <div class="col-md-6 col-lg-7 d-flex align-items-center">
                                    <div class="card-body p-4 p-lg-5 text-black">

                                        <form action="login" method="post">

                                            <div class="d-flex align-items-center">

                                                <span class="h1 fw-bold mb-0" style="color: #b394bd;">DaNaTours</span>
                                            </div>

                                            <h5 class="fw-normal mb-3 pb-3" style="letter-spacing: 1px;">Đăng nhập vào tài khoản của bạn</h5>

                                            <div data-mdb-input-init class="form-outline mb-4">
                                                <input type="email" name="email" id="form2Example17" class="form-control form-control-lg" />
                                                <label class="form-label" for="form2Example17">Địa chỉ email</label>
                                            </div>

                                            <div data-mdb-input-init class="form-outline mb-4">
                                                <input type="password" name="password" id="form2Example27" class="form-control form-control-lg" />
                                                <label class="form-label" for="form2Example27">Mật khẩu</label>
                                            </div>

                                            <% if (request.getAttribute("errorMessage") != null) {%>
                                            <div class="text-danger"><%= request.getAttribute("errorMessage")%></div>
                                            <% }%>

                                            <div class="pt-1 mb-4">
                                                <button id="loginButton" data-mdb-button-init data-mdb-ripple-init class="btn btn-dark btn-lg btn-block" type="submit">Login</button>
                                            </div>

                                            <a class="small text-muted" href="#!">Forgot password?</a>
                                            <p class="mb-5 pb-lg-2" style="color: #393f81;">Bạn không có tài khoản? <a href="register" style="color: #393f81;">Đăng ký ở đây</a></p>
                                            <a href="#!" class="small text-muted">Terms of use.</a>
                                            <a href="#!" class="small text-muted">Privacy policy</a>
                                        </form>

                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
    </body>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</html>
