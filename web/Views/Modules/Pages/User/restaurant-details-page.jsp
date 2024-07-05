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
                    <h1 class="w-full text-center fw-bold">${restaurant.getName()}</h1>
                    <p class="text-center">${restaurant.getStyles()}</p>
                    <div class="d-flex flex-row gap-2 justify-content-center">
                        <p class="fw-bold">Địa chỉ: <span>${restaurant.address}</span></p>
                    </div>
                    <div class="d-flex justify-content-center pt-4">
                        <h4>Từ <span style="color: red;">${restaurant.getFormattedMinPrice()} đ</span> Đến <span style="color: red;">${restaurant.getFormattedMaxPrice()} đ</span></h4>
                    </div>
                    <div class="d-flex justify-content-center pt-4">
                        <a href="${restaurant.openUrl}" class="btn btn-warning fw-bold">Chi tiết tại Tripadvisor</a>
                    </div>

                    <!-- Gallery -->
                    <div class="row" style="padding-top: 60px;">
                        <div>
                            <h4 class="text-center">Hình ảnh về nhà hàng</h4>
                        </div>
                        <c:forEach var="image" items="${restaurantImages}">
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
                        ${restaurant.getMapEmbed()}
                    </div>
                </div>
            </div>
        </section>
    </body>
</html>
