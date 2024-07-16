<%--
    Document   : payment-page
    Created on : Jun 12, 2024, 11:33:57 PM
    Author     : VJames
--%>

<%@page import="utils.Jwt"%>
<%@page import="model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
              rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
              crossorigin="anonymous">
    </head>
    <body>
        <section class="w-100 p-5">
            <div class="container" style="margin-top: 60px;">
                <h2 class="mb-4 text-center fw-bold" style="font-size: 32px;">THANH TOÁN ĐẶT CỌC TOUR DU LỊCH</h2>
                <p class="mb-4 text-center ">(Chúng tôi sẽ liên hệ với bạn ngay sau khi nhận được thông tin thanh toán!)</p>
                <div class="row">

                    <div class="col-md-6">
                        <%
                            Cookie[] cookies = request.getCookies();
                            boolean isAuthenticated = false;
                            User currentUser = null;
                            if (cookies != null) {
                                for (Cookie cookie : cookies) {
                                    if (cookie.getName().equals("isAuth") && cookie.getValue().equals("true") || cookie.getName().equals("accessToken")) {
                                        isAuthenticated = true;
                                    }
                                    if (cookie.getName().equals("accessToken")) {
                                        currentUser = Jwt.extractUserFromToken(cookie.getValue());
                                    }
                                }
                            }
                        %>
                        <form action="vnpayajax" method="post" id="frmCreateOrder">
                            <div class="mb-3">
                                <div class="form-group d-flex gap-2" style="font-size: 20px;">
                                    <label for="amount">Số tiền đặc cọc (VND)</label>
                                    <input hidden class="form-control" data-val="true" data-val-number="The field Amount must be a number." data-val-required="The Amount field is required." id="amount" max="100000000" min="1" name="amount" type="number" value="500000" />
                                    <input hidden name="tourId" value="${tour.getId()}"/>
                                    <input hidden name="userId" value="<%= isAuthenticated ? currentUser.getId() : null%>"/>
                                    <p class="fw-bold" style="color: red;">500.000 VND</p>
                                </div>
                            </div>

                            <div class="mb-3">
                                <label for="fullname" class="form-label">Họ tên</label>
                                <input type="text" class="form-control" id="fullname" name="fullname" value="<%= isAuthenticated ? currentUser.getFullname() : ""%>" required>
                            </div>
                            <div class="mb-3">
                                <label for="phone" class="form-label">Số điện thoại</label>
                                <input type="text" class="form-control" id="phone" name="phone" value="<%= isAuthenticated ? currentUser.getPhone() : ""%>" required>
                            </div>
                            <div class="mb-3">
                                <label for="email" class="form-label">Email</label>
                                <input type="email" class="form-control" id="email" name="email" value="<%= isAuthenticated ? currentUser.getEmail() : ""%>" required>
                            </div>
                            <div class="mb-3">
                                <label for="address" class="form-label">Địa chỉ</label>
                                <input type="text" class="form-control" id="address" name="address" required>
                            </div>
                            <button type="submit" class="btn btn-primary">Thanh toán</button>
                        </form>
                    </div>
                </div>
            </div>
        </section>
    </body>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
    <script type="text/javascript">
        $("#frmCreateOrder").submit(function () {
            var postData = $("#frmCreateOrder").serialize();
            var submitUrl = $("#frmCreateOrder").attr("action");
            $.ajax({
                type: "POST",
                url: submitUrl,
                data: postData,
                dataType: 'JSON',
                success: function (x) {
                    if (x.code === '00') {
                        if (window.vnpay) {
                            vnpay.open({width: 768, height: 600, url: x.data});
                        } else {
                            location.href = x.data;
                        }
                        return false;
                    } else {
                        alert(x.Message);
                    }
                }
            });
            return false;
        });
    </script>
</html>
