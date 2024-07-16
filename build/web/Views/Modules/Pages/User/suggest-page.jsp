<%--
    Document   : suggest-page
    Created on : Jul 14, 2024, 2:50:02 PM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
                <div style="padding-top: 40px;">
                    <h4 class="fw-bold" style="font-size: 32px;">Tham khảo Tours gợi ý dành cho bạn:</h4>
                    <form action="suggest" method="POST">
                        <div class="form-group">
                            <label for="exampleInputEmail1">Hãy cho chúng tôi biết tổng số tiền bạn có thể chi trả cho các địa điểm ghé thăm ở Đà Nẵng!</label>
                            <input type="number" id="price" name="price" min="500000" max="100000000" class="form-control" placeholder="Nhập số tiền của bạn" required><br><br>
                        </div>
                        <button type="submit" class="btn btn-warning fw-bold" style="margin-bottom: 20px;">Nhận gợi ý</button>
                    </form>
                </div>
                <c:if test="${not empty tours}">
                    <c:forEach var="tour" items="${tours}">
                        <div class="tour-card" style="width: 32%; height: auto; border-radius: 16px; overflow: hidden; box-shadow: rgba(0, 0, 0, 0.35) 0px 5px 15px; cursor: pointer;">
                            <a href="tourdetails?id=${tour.id}" style="text-decoration: none; color: #000;">
                                <div class="tour-image-container">
                                    <img src="${tour.backgroundImage}" alt="Tour Image" class="tour-image object-fit-cover" />
                                </div>
                                <div class="tour-title">
                                    <h5 class="d-inline-block p-3" style="max-width: 100%; margin: 0; max-height: 200px">${tour.title}</h5>
                                </div>
                                <div class="tour-details d-flex justify-content-between align-items-center px-3">
                                    <p style="margin: 0;">Khởi hành: ${tour.startDay}</p>
                                    <p style="margin: 0;">Thời gian: ${tour.duration}</p>
                                </div>
                                <div class="tour-prices d-flex justify-content-between align-items-center px-3">
                                    <p style="font-weight: 600; color: red; margin: 0">
                                        Giá: <span>${tour.getTotalPrice()} đ</span>
                                    </p>
                                    <p style="font-weight: 600; color: red; margin: 0">
                                        Giá cho trẻ em: <span>${tour.getForChildTotalPrice()} đ</span>
                                    </p>
                                </div>
                            </a>
                            <div class="tour-actions p-3 w-100 d-flex justify-content-between" style="padding-top: 10px !important;">
                                <a  class=""href="tourUpdate?id=${tour.id}">
                                    <button class="btn btn-warning fw-bold">Đặt ngay</button>
                                </a>
                                <a href="tourUpdate?id=${tour.id}">
                                    <button class="btn btn-warning fw-bold">Xem chi tiết</button>
                                </a>
                            </div>
                        </div>
                    </c:forEach>
                </c:if>

            </div>
        </section>

    </body>
</html>
