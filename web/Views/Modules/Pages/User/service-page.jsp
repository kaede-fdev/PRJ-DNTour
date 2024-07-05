<%--
    Document   : service-page
    Created on : Jun 12, 2024, 11:33:57 PM
    Author     : VJames
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
              rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
              crossorigin="anonymous">
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
                                <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Nhập số tiền của bạn">

                            </div>
                            <button type="submit" class="btn btn-warning fw-bold" style="margin-top: 16px;">Nhận gợi ý</button>
                        </form>
                </div>
                <!--Tours-->
                <div class="" style="padding-top: 40px">
                    <h4 class="fw-bold" style="font-size: 32px;">Khám phá các Tours hiện có của chúng tôi!</h1>
                        <div class="d-flex flex-wrap" style="gap: 25px; justify-content: space-between">
                            <!--items-->
                            <div class="" style="width: 32%; height: fit-content; border-radius: 16px; overflow: hidden; box-shadow: rgba(0, 0, 0, 0.35) 0px 5px 15px; cursor: pointer;">
                                <div style="">
                                    <img src="https://bizweb.dktcdn.net/thumb/1024x1024/100/489/447/products/1.jpg?v=1687878274650"
                                         style="width: 100%; height: 250px; border-radius: 16px; object-fit: cover;"/>
                                </div>
                                <div>
                                    <h5 class="d-inline-block  p-3" style="max-width: 100%; margin: 0; max-height: 200px">Đà Nẵng - Bà Nà - Cầu Vàng - Sơn Trà - Biển Mỹ Khê - Hội An - Đà Nẵng</h5>
                                </div>
                                <div class="d-flex justify-content-between align-items-center px-3">
                                    <p style="margin: 0;">Khởi hành: Hằng ngày</p>
                                    <p style="margin: 0;">Thời gian: 3 ngày</p>
                                </div>
                                <div class="d-flex justify-content-between align-items-center px-3">
                                    <p class="" style="font-size: 14px; text-decoration: line-through; margin: 0;">4.900.000</p>
                                </div>
                                <div class="d-flex justify-content-between align-items-center px-3">
                                    <p style="font-weight: 600; color: red; margin: 0">4.390.000 đ</p>
                                    <p style="color: red; font-weight: 600; margin: 0">-9%</p>
                                </div>

                                <div class="p-3 w-100" style="padding-top: 10px !important;">
                                    <button class="btn btn-warning w-100 fw-bold">Đặt ngay</button>
                                </div>
                            </div>

                        </div>
                </div>
            </div>
        </section>
    </body>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</html>