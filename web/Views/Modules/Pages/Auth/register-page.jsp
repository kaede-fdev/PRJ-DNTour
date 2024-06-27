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
        <style>
            .background-blur::before {
                content: '';
                position: absolute;
                top: 0;
                left: 0;
                width: 100%;
                height: 100%;
                background-image: url('https://res.cloudinary.com/dy1uuo6ql/image/upload/v1719293671/samples/uxvmia0zarexx8rv82ew.jpg');
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
                    transform: translateY(-20%);
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
                        <div class="card slide-in" style="border-radius: 1rem; z-index: 100">
                            <div class="row g-0">
                                <div class="col-md-6 col-lg-7 d-flex align-items-center">
                                    <div class="card-body p-4 p-lg-5 text-black">

                                        <form action="register" method="post">

                                            <div class="d-flex align-items-center mb-3 pb-1">
                                                <span class="h1 fw-bold mb-0" style="color: #06b2bf; font-family: "Playball", cursive; ">DaNaTours</span>
                                            </div>

                                            <h5 class="fw-normal mb-3 pb-3" style="letter-spacing: 1px;">Tạo tài khoản mới!</h5>

                                            <div data-mdb-input-init class="form-outline mb-2">
                                                <label class="form-label" for="fullname">Họ và Tên</label>
                                                <input type="text" id="username" name="fullname" class="form-control form-control-lg" />
                                            </div>

                                            <div data-mdb-input-init class="form-outline mb-2">
                                                <label class="form-label" for="email">Địa chỉ email</label>
                                                <input type="email" id="email" name="email" class="form-control form-control-lg" />
                                            </div>

                                            <div data-mdb-input-init class="form-outline mb-2">
                                                <label class="form-label" for="password">Mật khẩu</label>
                                                <input type="password" id="password" name="password" class="form-control form-control-lg" />
                                            </div>

                                            <div data-mdb-input-init class="form-outline mb-2">
                                                <label class="form-label" for="confirm_password">Xác nhận mật khẩu</label>
                                                <input type="password" id="confirm_password" name="confirmPassword" class="form-control form-control-lg" />
                                            </div>

                                            <% if (request.getAttribute("errorMessage") != null) {%>
                                            <div class="text-danger"><%= request.getAttribute("errorMessage")%></div>
                                            <% }%>

                                            <div class="pt-1 mt-4 mb-4 d-flex flex-column gap-2">
                                                <button data-mdb-button-init data-mdb-ripple-init class="btn btn-dark btn-lg btn-block" type="submit" style="width: fit-content;">Đăng ký tài khoản</button>
                                                <a href="login" class="small text-black">Trang Đăng nhập</a>

                                            </div>

                                            <a href="#!" class="small text-muted">Terms of use.</a>
                                            <a href="#!" class="small text-muted">Privacy policy</a>
                                        </form>

                                    </div>
                                </div>
                                <div class="col-md-6 col-lg-5 d-none d-md-block">
                                    <img src="https://res.cloudinary.com/dy1uuo6ql/image/upload/v1719293671/samples/uxvmia0zarexx8rv82ew.jpg"
                                         alt="register form" class="img-fluid" style="border-radius: 0 1rem 1rem 0; object-fit: cover; height: 100%;" />
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
