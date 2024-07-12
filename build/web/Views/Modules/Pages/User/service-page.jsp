<%--
    Document   : service-page
    Created on : Jun 12, 2024, 11:33:57 PM
    Author     : VJames
--%>

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
        <section class="w-100">
            <div class="container">
                <!--Tours-->
                <div class="" style="padding-top: 40px">
                    <h4 class="fw-bold" style="font-size: 32px;">Khám phá các Tours hiện có của chúng tôi!</h1>
                        <div class="d-flex flex-wrap" style="gap: 25px; justify-content: space-between">
                            <c:forEach var="tour" items="${tours}">
                                <div class="" style="width: 32%; height: fit-content; border-radius: 16px; overflow: hidden; box-shadow: rgba(0, 0, 0, 0.35) 0px 5px 15px; cursor: pointer;">
                                    <a href="tourdetails?id=${tour.getId()}" style="text-decoration: none; color: #000;">
                                        <div style="">
                                            <img src="${tour.getBackgroundImage()}"
                                                 style="width: 100%; height: 250px; border-radius: 16px; object-fit: cover;"/>
                                        </div>
                                        <div>
                                            <h5 class="d-inline-block  p-3" style="max-width: 100%; margin: 0; max-height: 200px;
                                                text-overflow: ellipsis;
                                                width: 100%;
                                                white-space: nowrap;
                                                overflow: hidden;">${tour.getTitle()}</h5>
                                        </div>
                                        <div class="d-flex justify-content-between align-items-center px-3">
                                            <p style="margin: 0;">Khởi hành: ${tour.getStartDay()}</p>
                                            <p style="margin: 0;">Thời gian: ${tour.getDuration()}</p>
                                        </div>

                                        <div class="d-flex justify-content-between align-items-center px-3">
                                            <p style="font-weight: 600; color: red; margin: 0">
                                                Giá:
                                                <span> ${tour.getFormattedMaxPrice()} đ</span>
                                            </p>
                                            <p style="font-weight: 600; color: red; margin: 0">
                                                Giá cho trẻ em:
                                                <span> ${tour.getFormattedMinPrice()} đ</span>
                                            </p>
                                        </div>
                                    </a>

                                    <div class="p-3 w-100" style="padding-top: 10px !important;">
                                        <a href="payment?tourId=${tour.getId()}" class="btn btn-warning w-100 fw-bold">Đặt ngay</a>
                                    </div>
                                </div>
                            </c:forEach>
                        </div>
                </div>
            </div>
        </section>
    </body>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</html>