<%--
    Document   : tour-details
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

        </style>
    </head>
    <body>
        <section class="w-100">
            <div class="container">
                <div style="padding-top: 80px;">
                    <c:if test="${not empty tours}">
                        <form action="tourUpdate" method="POST">
                            <h1 class="w-full text-center fw-bold">${tours.getTitle()}</h1>
                            <div class="d-flex flex-wrap justify-content-center p-4" style="gap: 20px; background: #fff; border-radius: 20px; color: #000;">
                                <div class="d-flex align-items-center justify-content-center gap-2">
                                    <i class="bi bi-calendar-check-fill"></i>
                                    <p class="fw-bold">Thời gian:  ${tours.getDuration()}</p>
                                </div>
                                <div class="d-flex align-items-center justify-content-center gap-2">
                                    <svg xmlns="http://www.w3.org/2000/svg" width="18" height="18" fill="currentColor" class="bi bi-car-front-fill" viewBox="0 0 16 16">
                                    <path d="M2.52 3.515A2.5 2.5 0 0 1 4.82 2h6.362c1 0 1.904.596 2.298 1.515l.792 1.848c.075.175.21.319.38.404.5.25.855.715.965 1.262l.335 1.679q.05.242.049.49v.413c0 .814-.39 1.543-1 1.997V13.5a.5.5 0 0 1-.5.5h-2a.5.5 0 0 1-.5-.5v-1.338c-1.292.048-2.745.088-4 .088s-2.708-.04-4-.088V13.5a.5.5 0 0 1-.5.5h-2a.5.5 0 0 1-.5-.5v-1.892c-.61-.454-1-1.183-1-1.997v-.413a2.5 2.5 0 0 1 .049-.49l.335-1.68c.11-.546.465-1.012.964-1.261a.8.8 0 0 0 .381-.404l.792-1.848ZM3 10a1 1 0 1 0 0-2 1 1 0 0 0 0 2m10 0a1 1 0 1 0 0-2 1 1 0 0 0 0 2M6 8a1 1 0 0 0 0 2h4a1 1 0 1 0 0-2zM2.906 5.189a.51.51 0 0 0 .497.731c.91-.073 3.35-.17 4.597-.17s3.688.097 4.597.17a.51.51 0 0 0 .497-.731l-.956-1.913A.5.5 0 0 0 11.691 3H4.309a.5.5 0 0 0-.447.276L2.906 5.19Z"/>
                                    </svg>
                                    <p class="fw-bold">Phương tiện: ${tours.getVehicle()}</p>
                                </div>
                                <div class="d-flex align-items-center justify-content-center gap-2">
                                    <svg xmlns="http://www.w3.org/2000/svg" width="18" height="18" fill="currentColor" class="bi bi-buildings-fill" viewBox="0 0 16 16">
                                    <path d="M15 .5a.5.5 0 0 0-.724-.447l-8 4A.5.5 0 0 0 6 4.5v3.14L.342 9.526A.5.5 0 0 0 0 10v5.5a.5.5 0 0 0 .5.5h9a.5.5 0 0 0 .5-.5V14h1v1.5a.5.5 0 0 0 .5.5h3a.5.5 0 0 0 .5-.5zM2 11h1v1H2zm2 0h1v1H4zm-1 2v1H2v-1zm1 0h1v1H4zm9-10v1h-1V3zM8 5h1v1H8zm1 2v1H8V7zM8 9h1v1H8zm2 0h1v1h-1zm-1 2v1H8v-1zm1 0h1v1h-1zm3-2v1h-1V9zm-1 2h1v1h-1zm-2-4h1v1h-1zm3 0v1h-1V7zm-2-2v1h-1V5zm1 0h1v1h-1z"/>
                                    </svg>
                                    <select class="form-select" aria-label="Default select example" name="hotelPrice">
                                        <option selected value="${HotelbyId.minPrice}">
                                            ${HotelbyId.name} ~ Giá thấp nhất: ${HotelbyId.minPrice}đ
                                        </option>
                                        <c:forEach var="hotel" items="${sessionScope.hotels}">
                                            <option value="${hotel.minPrice}">
                                                ${hotel.name} ~ Giá thấp nhất: ${hotel.minPrice}đ
                                            </option>
                                        </c:forEach>
                                    </select>

                                </div>
                                <div class="d-flex align-items-center justify-content-center gap-2">


                                    <svg xmlns="http://www.w3.org/2000/svg" width="18" height="18" fill="currentColor" class="bi bi-buildings-fill" viewBox="0 0 16 16">
                                    <path d="M15 .5a.5.5 0 0 0-.724-.447l-8 4A.5.5 0 0 0 6 4.5v3.14L.342 9.526A.5.5 0 0 0 0 10v5.5a.5.5 0 0 0 .5.5h9a.5.5 0 0 0 .5-.5V14h1v1.5a.5.5 0 0 0 .5.5h3a.5.5 0 0 0 .5-.5zM2 11h1v1H2zm2 0h1v1H4zm-1 2v1H2v-1zm1 0h1v1H4zm9-10v1h-1V3zM8 5h1v1H8zm1 2v1H8V7zM8 9h1v1H8zm2 0h1v1h-1zm-1 2v1H8v-1zm1 0h1v1h-1zm3-2v1h-1V9zm-1 2h1v1h-1zm-2-4h1v1h-1zm3 0v1h-1V7zm-2-2v1h-1V5zm1 0h1v1h-1z"/>
                                    </svg>
                                    <select class="form-select" aria-label="Default select example" name="restaurantPrice">
                                        <option selected value="${restaurantsById.minPrice}">
                                            ${restaurantsById.name} ~ Giá thấp nhất: ${restaurantsById.minPrice}đ
                                        </option>
                                        <c:forEach var="restaurant" items="${sessionScope.restaurants}">
                                            <option value="${restaurant.minPrice}">
                                                ${restaurant.name} ~ Giá thấp nhất: ${restaurant.minPrice}đ
                                            </option>
                                        </c:forEach>
                                    </select>
                                </div>
                                <div class="d-flex align-items-center justify-content-center gap-2">
                                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-crosshair2" viewBox="0 0 16 16">
                                    <path d="M8 0a.5.5 0 0 1 .5.5v.518A7 7 0 0 1 14.982 7.5h.518a.5.5 0 0 1 0 1h-.518A7 7 0 0 1 8.5 14.982v.518a.5.5 0 0 1-1 0v-.518A7 7 0 0 1 1.018 8.5H.5a.5.5 0 0 1 0-1h.518A7 7 0 0 1 7.5 1.018V.5A.5.5 0 0 1 8 0m-.5 2.02A6 6 0 0 0 2.02 7.5h1.005A5 5 0 0 1 7.5 3.025zm1 1.005A5 5 0 0 1 12.975 7.5h1.005A6 6 0 0 0 8.5 2.02zM12.975 8.5A5 5 0 0 1 8.5 12.975v1.005a6 6 0 0 0 5.48-5.48zM7.5 12.975A5 5 0 0 1 3.025 8.5H2.02a6 6 0 0 0 5.48 5.48zM10 8a2 2 0 1 0-4 0 2 2 0 0 0 4 0"/>
                                    </svg>
                                    <p class="fw-bold">Điểm xuất phát: Đà Nẵng</p>
                                </div>
                                <div class="d-flex align-items-center justify-content-center gap-2">
                                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-geo-alt-fill" viewBox="0 0 16 16">
                                    <path d="M8 16s6-5.686 6-10A6 6 0 0 0 2 6c0 4.314 6 10 6 10m0-7a3 3 0 1 1 0-6 3 3 0 0 1 0 6"/>
                                    </svg>
                                    <p class="fw-bold">Điểm đến: Đà Nẵng</p>
                                </div>
                                <div class="d-flex align-items-center justify-content-center gap-2">
                                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-airplane-fill" viewBox="0 0 16 16">
                                    <path d="M6.428 1.151C6.708.591 7.213 0 8 0s1.292.592 1.572 1.151C9.861 1.73 10 2.431 10 3v3.691l5.17 2.585a1.5 1.5 0 0 1 .83 1.342V12a.5.5 0 0 1-.582.493l-5.507-.918-.375 2.253 1.318 1.318A.5.5 0 0 1 10.5 16h-5a.5.5 0 0 1-.354-.854l1.319-1.318-.376-2.253-5.507.918A.5.5 0 0 1 0 12v-1.382a1.5 1.5 0 0 1 .83-1.342L6 6.691V3c0-.568.14-1.271.428-1.849"/>
                                    </svg>
                                    <p class="fw-bold">Đưa đón sân bay</p>
                                </div>
                                <div class="d-flex align-items-center justify-content-center gap-2">
                                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-airplane-fill" viewBox="0 0 16 16">
                                    <path d="M6.428 1.151C6.708.591 7.213 0 8 0s1.292.592 1.572 1.151C9.861 1.73 10 2.431 10 3v3.691l5.17 2.585a1.5 1.5 0 0 1 .83 1.342V12a.5.5 0 0 1-.582.493l-5.507-.918-.375 2.253 1.318 1.318A.5.5 0 0 1 10.5 16h-5a.5.5 0 0 1-.354-.854l1.319-1.318-.376-2.253-5.507.918A.5.5 0 0 1 0 12v-1.382a1.5 1.5 0 0 1 .83-1.342L6 6.691V3c0-.568.14-1.271.428-1.849"/>
                                    </svg>
                                    <p class="fw-bold">Hỗ trợ tư vấn 24/7</p>
                                </div>
                            </div>

                            <div class="d-flex flex-row justify-content-between align-items-center" style="background: #212529; padding: 16px; color: #fff; border-radius: 8px;">
                                <div class="d-flex gap-4">
                                    <div>
                                        <p class="fw-bold">Khởi hành: <span style="color: #ffc107;">${tours.getCreateAt()}</span></p>
                                    </div>
                                    <div class="">
                                        <p class="fw-bold">Giá Tour  <span style="color: #ffc107;">${tourPrice}đ</span></p>
                                    </div>
                                    <!--                                    <div class="">
                                                                            <p class="fw-bold">Giá cho trẻ em <span style="color: #ffc107;">${tours.getForChildTotalPrice()}đ</span></p>
                                                                        </div>-->

                                </div>
                                <button type="submit" class="btn btn-warning fw-bold">
                                    Cập nhật giá
                                </button>
                            </div>

                        </form>
                        <div style="padding: 24px 0px;">
                            <h4 class="text-center fw-bold" style="padding-bottom: 16px;">CÁC ĐỊA ĐIỂM TRONG TOURS</h4>
                            <div id="carouselExampleIndicators" class="carousel slide carousel-fade" data-bs-ride="carousel">
                                <div class="carousel-indicators">
                                    <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
                                    <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="1" aria-label="Slide 2"></button>
                                    <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="2" aria-label="Slide 3"></button>
                                </div>
                                <div class="carousel-inner">
                                    <div class="carousel-item active">
                                        <img src="https://danangbest.com/uploads/thumb/1686996052ho-tam-suoi-than-tai.webp" style="width: 100%; height: 250px; object-fit: cover; border-radius: 12px;" class="d-block w-100" alt="...">
                                    </div>
                                    <div class="carousel-item ">
                                        <img src="${tours.getBackgroundImage()}" style="width: 100%; height: 250px; object-fit: cover; border-radius: 12px;" class="d-block w-100" alt="...">
                                    </div>

                                    <div class="carousel-item">
                                        <img src="https://danangbest.com/uploads/thumb/1686996052ho-tam-suoi-than-tai.webp" style="width: 100%; height: 250px; object-fit: cover; border-radius: 12px;" class="d-block w-100" alt="...">
                                    </div>
                                </div>
                                <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="prev">
                                    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                                    <span class="visually-hidden">Previous</span>
                                </button>
                                <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="next">
                                    <span class="carousel-control-next-icon" aria-hidden="true"></span>
                                    <span class="visually-hidden">Next</span>
                                </button>
                            </div>
                        </div>

                        <div>
                            <h4 class="text-center fw-bold" style="padding-bottom: 16px;">VỀ TOUR CỦA CHÚNG TÔI</h4>
                            <div class="content">
                                ${tours.getDescription() }
                            </div>
                        </div>
                    </c:if>



                    <div>
                        <h4 class="text-center fw-bold" style="padding-bottom: 16px;">CÁC TOUR KHÁC MÀ BẠN CÓ THỂ THAM KHẢO!</h4>
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
            </div>
        </section>
    </body>
</html>
