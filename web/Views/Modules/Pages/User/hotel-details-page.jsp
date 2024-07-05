<%--
    Document   : hotel-details
    Created on : Jul 3, 2024, 1:08:16 AM
    Author     : VJames
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.3.0/font/bootstrap-icons.css">
        <style>
            p {
                margin-bottom: 0;
            }
            .content>div>figure {
                padding: 20px 0px;
                display: flex;
                justify-content: center;
            }
            .map > iframe {
                width: 100% !important;
                height: 500px !important;
                border-radius: 8px;
            }

        </style>
    </head>
    <body>
        <section class="w-100">
            <div class="container">
                <div style="padding-top: 80px;">
                    <h1 class="w-full text-center fw-bold">${hotel.getName()}</h1>
                    <div class="d-flex flex-row gap-2 justify-content-center">
                        <p> Loại khách sạn: <span class="fw-bold">${hotel.getStars()} sao</span></p>
                    </div>
                    <div class="d-flex flex-row gap-2 justify-content-center">
                        <p class="fw-bold">Địa chỉ: <span>${hotel.getAddress()}</span></p>
                    </div>
                    <div class="d-flex flex-row gap-2 justify-content-center" style="padding-top: 20px;">
                        <h4 class="fw-bold">Giá từ: <span style="color: red;">${hotel.getFormattedMinPrice()} đ</span></h4>
                    </div>
                    <div class="d-flex justify-content-center pt-4">
                        <a href="${hotel.openUrl}" class="btn btn-warning fw-bold">Ghé xem trang web</a>

                    </div>

                    <div class="" style="padding-top: 60px;">
                        <h4 class="text-center">Mô tả bổ sung</h4>
                        <p class="text-center">
                            ${hotel.getDescription()}
                        </p>
                    </div>

                    <!-- Gallery -->
                    <div class="row" style="padding-top: 60px;">
                        <div>
                            <h4 class="text-center">Hình ảnh về khách sạn</h4>
                        </div>
                        <c:forEach var="image" items="${hotelImages}">
                            <div class="col-lg-4 col-md-12 mb-4 mb-lg-0">
                                <img
                                    src="${image.getUrl()}"
                                    class="w-100 shadow-1-strong rounded mb-4"
                                    alt="Restaurant Image"
                                    style="height: 240px; object-fit: cover;"
                                    />
                            </div>
                        </c:forEach>
                    </div>
                    <!-- Gallery -->
                    <div class="map">
                        ${hotel.getMapEmbed()}
                    </div>
                </div>
            </div>
        </section>
    </body>
</html>
