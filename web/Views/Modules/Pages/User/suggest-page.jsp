<%--
    Document   : suggest-page
    Created on : Jul 6, 2024, 10:04:55 PM
    Author     : VJames
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <section class="w-100">
            <div class="container">
                <!--ToursSuggestion-->
                <div class="" style="padding-top: 40px">
                    <h4 class="fw-bold" style="font-size: 32px;">Tham khảo Tours gợi ý dành cho bạn: </h1>
                        <form>
                            <div class="form-group">
                                <label for="exampleInputEmail1">Hãy cho chúng tôi biết tổng số tiền bạn có thể chi trả cho các địa điểm ghé thăm ở Đà Nẵng!</label>
                                <input type="number" min="500000" max="100000000" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Nhập số tiền của bạn">

                            </div>
                            <button type="submit" class="btn btn-warning fw-bold" style="margin-top: 16px;">Nhận gợi ý</button>
                        </form>
                </div>
            </div>
        </section>
    </body>
</html>
