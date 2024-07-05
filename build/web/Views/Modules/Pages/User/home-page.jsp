<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
              rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
              crossorigin="anonymous">
        <meta charset="UTF-8">
        <style>
            .carousel-item img {
                width: 100vw; /* Full viewport width */
                height: 620px; /* Full viewport height */
                object-fit: cover;
            }
            .carousel-inner, .carousel-item {
                width: 100%; /* Full container width */
                height: 620px; /* Full viewport height */
            }
        </style>
    </head>
    <body>
        <section style="position: relative;">
            <div class="d-flex align-items-center justify-content-center w-100">
                <!--banner-->
                <div id="carouselExampleAutoplaying" class="carousel slide carousel-fade w-100" data-bs-ride="carousel">
                    <div class="carousel-inner">
                        <div class="carousel-item active">
                            <img src="https://res.cloudinary.com/dy1uuo6ql/image/upload/v1719512411/samples/buvruzf5lvkpk28lyp7q.jpg" class="d-block w-100" alt="...">
                        </div>
                        <div class="carousel-item ">
                            <img src="https://res.cloudinary.com/dy1uuo6ql/image/upload/v1719513189/samples/valoi3rq4iikgodla6ip.png" class="d-block w-100" alt="...">
                        </div>
                        <div class="carousel-item ">
                            <img src="https://res.cloudinary.com/dy1uuo6ql/image/upload/v1719513068/samples/s5shw2qmnqtuntluxbyu.jpg" class="d-block w-100" alt="...">
                        </div>
                        <div class="carousel-item ">
                            <img src="https://res.cloudinary.com/dy1uuo6ql/image/upload/v1719512758/samples/xlvigf6gjkbsg9fzjtdw.jpg" class="d-block w-100" alt="...">
                        </div>
                        <div class="carousel-item ">
                            <img src="https://res.cloudinary.com/dy1uuo6ql/image/upload/v1719512913/samples/qwfxcfxzeet6ig9vx9yc.webp" class="d-block w-100" alt="...">
                        </div>
                    </div>

                </div>
            </div>
            <div class="" style="position: absolute; top: 0; left: 0; width: 100%; height: 100%; z-index: 10;">
                <div class="container d-flex flex-column align-items-center justify-content-center p-4" style="width: 100%; height: 100%">
                    <h1 style="
                        color: #fff;
                        font-size: 45px;
                        font-weight: 800;
                        text-shadow: 0px 4px 3px rgba(0,0,0,0.4),
                        0px 8px 13px rgba(0,0,0,0.1),
                        0px 18px 23px rgba(0,0,0,0.1);"
                        >HÃY THỬ TRẢI NGHIỆM KHÁM PHÁ DU LỊCH MIỀN TRUNG VIỆT NAM CÙNG DANATOURS!</h1>
                    <div class="d-flex gap-4 align-items-start" style="width: 100%">
                        <button type="button" class="btn btn-light" style="font-weight: 600;">Đặt Tours có sẵn</button>
                        <button type="button" class="btn btn-warning" style="font-weight: 600;">Gợi ý Tours thông minh</button>
                    </div>
                </div>
            </div>
        </section>

        <section class="w-100">
            <div class="container d-flex flex-column gap-2" style="padding: 40px 15px;">
                <h4 style="font-size: 32px; font-weight: 700;">Các Tours du lịch hiện hành:</h4>
                <div class="d-flex flex-wrap" style="gap: 25px; justify-content: space-between">
                    <!--items-->
                    <c:forEach var="tour" items="${tours}">
                        <div class="" style="width: 32%; height: fit-content; border-radius: 16px; overflow: hidden; box-shadow: rgba(0, 0, 0, 0.35) 0px 5px 15px; cursor: pointer;">
                            <a href="tourdetails?id=${tour.getId()}" style="text-decoration: none; color: #000;">
                                <div style="">
                                    <img src="${tour.getBackgroundImage()}"
                                         style="width: 100%; height: 250px; border-radius: 16px; object-fit: cover;"/>
                                </div>
                                <div>
                                    <h5 class="d-inline-block  p-3" style="max-width: 100%; margin: 0; max-height: 200px">${tour.getTitle()}</h5>
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
                                <button class="btn btn-warning w-100 fw-bold">Đặt ngay</button>
                            </div>
                        </div>
                    </c:forEach>

                </div>

            </div>
        </section>

        <section class="w-100" style="background: #fff;">
            <div class="container d-flex flex-column gap-2" style="padding: 40px 15px;">
                <h4 style="font-size: 32px; font-weight: 700;">Phòng khách sạn được quan tâm:</h4>
                <div class="d-flex flex-wrap" style="gap: 16px;">
                    <!--items-->
                    <c:forEach var="hotel" items="${hotels}">
                        <div c  lass="" style="width: 24%; height: fit-content; border-radius: 16px; overflow: hidden; box-shadow: rgba(0, 0, 0, 0.35) 0px 5px 15px; cursor: pointer;">
                            <div style="">
                                <img src="${hotel.getBackgroundImageUrl()}"
                                     style="width: 100%; height: 170px; border-radius: 16px; object-fit: cover;"/>
                            </div>
                            <div>
                                <h5 class="d-inline-block  p-3 fw-bold" style="max-width: 100%; margin: 0; max-height: 200px; height: 80px;">${hotel.getName()}</h5>
                                <p class="d-inline-block  px-3" style="max-width: 100%; margin: 0; max-height: 200px; height: 50px;">

                                    ${hotel.getAddress()}</p>

                            </div>

                            <div class="p-3 d-flex align-items-center justify-content-between">
                                <p class="d-inline-block " style="max-width: 100%; margin: 0; max-height: 200px; color: red; font-weight: 700;">Min: ${hotel.getFormattedMinPrice()} VND</p>
                                <a href="hoteldetails?id=${hotel.getId()}"><button class="btn btn-warning fw-bold">Chi tiết</button></a>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </section>
        <section class="w-100" style="background: #fff">
            <div class="container d-flex flex-column gap-2" style="padding: 40px 15px;">
                <h4 style="font-size: 32px; font-weight: 700;">Thông tin về các nhà hàng nổi bật:</h4>
                <div class="d-flex flex-wrap" style="gap: 25px; justify-content: space-between">
                    <!--items-->
                    <c:forEach var="restaurant" items="${restaurants}">
                        <div class="" style="width: 32%; height: fit-content; border-radius: 16px; overflow: hidden; box-shadow: rgba(0, 0, 0, 0.35) 0px 5px 15px; cursor: pointer;">
                            <div style="">
                                <img src="${restaurant.getBackgroundImageUrl()}"
                                     style="width: 100%; height: 250px; border-radius: 16px; object-fit: cover;"/>
                            </div>
                            <div>
                                <h5 class="d-inline-block  p-3 fw-bold" style="max-width: 100%; margin: 0; max-height: 200px">${restaurant.getName()}</h5>
                            </div>
                            <div class="d-flex justify-content-between align-items-center px-3">
                                <p style="margin: 0;">${restaurant.getStyles()}</p>
                            </div>
                            <div class="d-flex justify-content-between align-items-center px-3">
                                <p> Giá từ
                                    <span style="font-weight: 600; color: red; margin: 0">${restaurant.getFormattedMinPrice()} đ</span>
                                </p>
                                <p> Cao nhất
                                    <span style="font-weight: 600; color: red; margin: 0">${restaurant.getFormattedMaxPrice()}  đ</span>
                                </p>
                            </div>

                            <div class="p-3 w-100" style="padding-top: 0 !important;">
                                <a href="restaurantdetails?id=${restaurant.getId()}" class="btn btn-warning w-100 fw-bold">Chi tiết</a>
                            </div>
                        </div>
                    </c:forEach>

                </div>
            </div>
        </section>

        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy" crossorigin="anonymous"></script>
    </body>
</html>
