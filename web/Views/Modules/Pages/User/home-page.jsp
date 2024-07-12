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
                        <a href="service" type="button" class="btn btn-light" style="font-weight: 600;">Đặt Tours có sẵn</a>
                        <a href="suggest" type="button" class="btn btn-warning" style="font-weight: 600;">Gợi ý Tours cho bạn</a>
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
                    <div class="w-100 d-flex justify-content-center mt-4">
                        <a href="hotelsearch" class="btn fw-bold btn-warning text-center">
                            Xem thêm
                        </a>
                    </div>
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
                    <div class="w-100 d-flex justify-content-center">
                        <a href="restaurantsearch" class="btn fw-bold btn-warning text-center">
                            Xem thêm
                        </a>
                    </div>

                </div>
                <!--/*new section1*/                <div class="container mx-auto my-5 ">
                                    <div>
                                        <h2 class="fw-bold">Trending destinations</h2>
                                        <p>Most popular choices for travellers from Vietnam</p>
                                    </div>
                                    <div class="row mx-5 ">
                                        <div class="col h-50">
                                            <a href="#"><img class="w-100  rounded object-fit-cover" src="img/Hue.jpg" /></a>
                                            <p class="mt-3 fw-bold fs-2">Hue <img src="img/FlagVietNam.png" /></p>
                                        </div>
                                        <div class="col h-50">
                                            <a href="#"><img class=" w-100   rounded object-fit-cover" src="img/HoiAn.jpg" /></a>
                                            <p class="mt-3 fw-bold fs-2">HoiAn <img src="img/FlagVietNam.png" /></p>
                                        </div>
                                    </div>
                                    <div class="row mx-5 h-25 ">
                                        <div class="col ">
                                            <a href="#"><img class=" rounded w-100 h-100 object-fit-cover" src="img/DaNang5.jpg" /></a>
                                            <p class="mt-3 fw-bold fs-2">Da Nang <img src="img/FlagVietNam.png" /></p>

                                        </div>
                                    </div>

                                </div>-->
                <!--/*new section2/                <div class="container mx-auto my-5 ">
                                    <div class="box-head d-flex justify-content-between align-items-center ">
                                        <div>
                                            <div class=" title-1 d-block mb-2 fs-5 fw-blod">Did you know?</div>
                                            <h2 class="text-primary">Useful travel knowledge</h2>
                                        </div>

                                        <div class="section-4__button-bottom"><a class="button  text-decoration-none mx-2 " href="#">More <i
                                                    class="mx-1 fa-solid fa-angle-right"></i></a></div>
                                    </div>
                                    <div class="d-flex mt-4">
                                        <div class="section-item">
                                            <div class="section-6__image"><a href="#"><img src="img/HoiAn.jpg"></a></div>
                                            <div class="section-6__content">
                                                <div class="section-6__tag">Kiến thức du lịch</div>
                                                <h3 class="section-6__title"><a href="#" class="text-decoration-none">KINH NGHIỆM DU LỊCH Hội An </a></h3>
                                                <div class="section-6__desc"> Phố cổ Hội An là một đô thị cổ nằm ở hạ lưu sông Thu Bồn, thuộc vùng đồng bằng ven biển tỉnh Quảng Nam,
                                                    Việt Nam, cách thành phố Đà Nẵng khoảng 30 km về phía Nam.

                                                    Hội An là một thành phố thuộc tỉnh Quảng Nam có nhiều khu phố cổ được xây từ thế kỷ 16 và vẫn còn tồn
                                                    tại gần như nguyên vẹn đến nay. Trong các tài liệu cổ của phương Tây... </div>
                                            </div>
                                        </div>
                                        <div class="section-item">
                                            <div class="section-6__image"><a href="#"><img src="img/KNDL_DANANG.jpeg"></a></div>
                                            <div class="section-6__content">
                                                <div class="section-6__tag">Kiến thức du lịch</div>
                                                <h3 class="section-6__title"><a href="#" class="text-decoration-none">KINH NGHIỆM DU LỊCH ĐÀ
                                                        NẴNG</a></h3>
                                                <div class="section-6__desc">Mỗi thời điểm, Đà Nẵng đều có vẻ đẹp riêng, đem lại cảm xúc khác nhau,
                                                    nhưng thời điểm lý tưởng nhất để ghé thăm Đà Nẵng là khoảng tháng 2 đến tháng 5. Đây là thời
                                                    điểm Đà Nẵng rất đẹp, tiết trời dễ chịu, mát mẻ, trong lành, thuận lợi cho việc tham quan và
                                                    nghỉ dưỡng. Ở thời điểm này cũng là lúc diễn ra các lễ hội... </div>
                                            </div>
                                        </div>
                                        <div class="section-item">
                                            <div class="section-6__image"><a href="#"><img src="img/Hue.jpg"></a></div>
                                            <div class="section-6__content">
                                                <div class="section-6__tag">Kiến thức du lịch</div>
                                                <h3 class="section-6__title"><a href="#" class="text-decoration-none">KINH NGHIỆM DU LỊCH  Huế</a></h3>
                                                <div class="section-6__desc"> Tĩnh lặng, mộng mơ, đậm chất thi ca là những mỹ từ để giới thiếu về Huế. Hiện nay, thành phố này là một
                                                    trong ba vùng du lịch lớn của cả nước, có bề dày lịch sử văn hóa lâu năm. Đây là nơi bảo tồn, phát triển
                                                    nhiều danh lam thắng cùng quần thể di tích lịch sử được thế giới công nhận. Huế ngày nay cũng được mệnh
                                                    danh là thành phố Festival của cả nước. ...</div>
                                            </div>
                                        </div>
                                    </div>

                                </div>-->
                <!--    */new section3*/            <div class="container mx-auto my-5">
                        <div class="section4">
                            <div class="fw-bold">
                                <h2>Browse by property type</h2>
                            </div>

                            <div class="swiper swiper-section4 w-100 mt-5  ">

                                <div class="swiper-wrapper ">


                                    <div class="swiper-slide text-left w-auto"><a href="#"><img class="w-100 rounded"
                                                src="img/Hotels.jpeg" /></a>
                                        <p class="mt-3 fw-bold fs-5">Hotels</p>
                                    </div>
                                    <div class="swiper-slide text-left w-auto"><a href="#"><img class="w-100 rounded"
                                                src="img/Villas.jpeg" /></a>
                                        <p class="mt-3 fw-bold fs-5">Village</p>
                                    </div>
                                    <div class="swiper-slide text-left w-auto"><a href="#"><img class="w-100 rounded"
                                                src="img/Resorts.jpeg" /></a>
                                        <p class="mt-3 fw-bold fs-5">Resorts</p>
                                    </div>
                                    <div class="swiper-slide text-left w-auto"><a href="#"><img class="w-100 rounded"
                                                src="img/LuxuryTents.jpeg" /></a>
                                        <p class="mt-3 fw-bold fs-5">Luxury Tents</p>
                                    </div>
                                    <div class="swiper-slide text-left w-auto"><a href="#"><img class="w-100 rounded"
                                                src="img/HomeStays.jpeg" /></a>
                                        <p class="mt-3 fw-bold fs-5">Home Stays</p>
                                    </div>
                                    <div class="swiper-slide text-left w-auto"><a href="#"><img class="w-100 rounded"
                                                src="img/Holiday Homes.jpeg" /></a>
                                        <p class="mt-3 fw-bold fs-5">Holiday Homes</p>
                                    </div>
                                    <div class="swiper-slide text-left w-auto"><a href="#"><img class="w-100 rounded"
                                                src="img/Apartments.jpeg" /></a>
                                        <p class="mt-3 fw-bold fs-5">Apartments</p>
                                    </div>
                                    <div class="swiper-slide text-left w-auto"><a href="#"><img class="w-100 rounded"
                                                src="img/Campsites.jpeg" /></a>
                                        <p class="mt-3 fw-bold fs-5">Campsites</p>
                                    </div>
                                </div>


                            </div>
                        </div>-->

            </div>


        </div>
    </section>

    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy" crossorigin="anonymous"></script>
</body>
</html>
