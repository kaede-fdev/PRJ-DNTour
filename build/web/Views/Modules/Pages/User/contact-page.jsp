<%--
    Document   : contact-page
    Created on : Jun 12, 2024, 11:34:16 PM
    Author     : VJames
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>HandbookDaNang</title>
    </head>
    <style>
        input,
        textarea {
            border: 1px solid #e1e1e1;
            width: 100%;
            margin-bottom: 15px;
            outline: none;

        }

        .qa .list {
            max-height: 300px;
            /* Adjust as needed */
            overflow-y: auto;
        }

        .qa .item p {
            display: none;
        }

        .qa .item p.visible {
            display: block;
        }

        .scrollbar {
            scrollbar-width: thin;
            scrollbar-color: #888 #f1f1f1;
        }

        /* For WebKit browsers */
        .scrollbar::-webkit-scrollbar {
            width: 8px;
        }

        .scrollbar::-webkit-scrollbar-track {
            background: #f1f1f1;
            border-radius: 10px;
            /* Optional: for rounded corners */
        }

        .scrollbar::-webkit-scrollbar-thumb {
            background-color: #888;
            border-radius: 10px;
            /* Optional: for rounded corners */
            border: 2px solid #f1f1f1;
        }

        .scrollbar::-webkit-scrollbar-button {
            display: none;
        }

        .list p {
            font-size: 13px;
        }

        .list b {
            font-size: 14px;
        }

        .list b:hover {
            color: #0979FD;
            cursor: pointer;
        }
        input[type="number"]::-webkit-outer-spin-button,
        input[type="number"]::-webkit-inner-spin-button {
            -webkit-appearance: none;
            margin: 0;
        }

        /* Hide the arrows in Firefox */
        input[type="number"] {
            -moz-appearance: textfield;
        }
    </style>

    <body style="background: #f2f3f3;">
        <div class="d-flex container mx-auto my-5 section1">
            <div class=""><a href="#" class="text-decoration-none text-dark d-flex align-items-center">
                    <div class="homePage">Home page</div><i class="fa-solid fa-chevron-right mx-2  "></i>
                </a></div>

            <div class=""><a href="#" class="text-primary text-decoration-none"> Lien He</a></div>

        </div>


        <div class="mx-auto container d-flex">
            <div class="col me-5">
                <div class=" mb-3 p-3 rounded-3 border" style="    background-color: #fff">
                    <h4 class="fw-bold mb-3">
                        Liên hệ với chúng tôi
                    </h4>
                    <div id="pagelogin">
                        <form method="post" action="" id="contact" accept-charset="UTF-8">


                            <div class="d-flex flex-column">
                                <input class="my-2 fs-6 rounded-1 p-2" placeholder="Họ và tên" type="text"
                                       class="form-control" required="" value="" name="contact[Name]">
                                <input class="my-2 fs-6 rounded-1 p-2" placeholder="Email" type="email"
                                       pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$" required="" id="email1"
                                       class="form-control" value="" name="contact[email]">
                                <input class="my-2 fs-6 rounded-1 p-2" type="number" placeholder="Điện thoại"
                                       name="contact[phone]" class="form-control" required="">
                                <textarea class="my-2 fs-6 rounded-1 p-2" placeholder="Nội dung" name="contact[body]"
                                          id="comment" class="" rows="3" required=""></textarea>
                                <button class="my-2 w-25 fs-6 rounded-1 border-0 p-2 text-white" type="submit"
                                        class="btn-lienhe rounded-4" style="background-color: #0979FD ">Gửi thông tin</button>
                            </div>
                        </form>
                    </div>
                </div>
                <div class=" mb-3 p-3 rounded-3 border order-lg-2" style="    background-color: #fff">
                    <h4 class="bold mb-4 bold">
                        Công ty cổ phần dịch vụ OH!Travel
                    </h4>
                    <div class=" mb-2">
                        <div class="d-flex  ">
                            <i class="fa-solid fa-location-dot me-2 fs-4"></i>
                            <div class="">
                                <b class="d-block mb-1">Địa chỉ:</b>
                                <p style="color:#687176">Tầng 6, Tòa Ladeco, 266 Đội Cấn, Quận Ba Đình, TP Hà Nội</p>

                            </div>

                        </div>




                    </div>
                    <div class=" mb-2">
                        <div class="d-flex  ">
                            <i class="fa-solid fa-location-dot me-2 fs-4"></i>
                            <div class="">
                                <b class="d-block mb-1">Email:</b>
                                <p style="color:#687176">support@sapo.vn</p>

                            </div>

                        </div>




                    </div>

                    <div class=" mb-2">
                        <div class="d-flex  ">
                            <i class="fa-solid fa-location-dot me-2 fs-4"></i>
                            <div class="">
                                <b class="d-block mb-1 ">Hotline:</b>
                                <p style="color:#687176">1900 6750</p>

                            </div>

                        </div>




                    </div>
                </div>
            </div>
            <div class="col ">
                <div class="text-center">
                    <img class=" mx-auto" src="https://bizweb.dktcdn.net/100/489/447/themes/912592/assets/contact.png?1718160816633"
                         alt="" />
                </div>

                <b class="text-center d-block mb-3 my-4" style="font-size: 13px;">Để được hỗ trợ nhanh hơn, vui lòng gửi yêu cầu của bạn qua biểu mẫu</b>
                <div class="qa bg-white p-3 rounded-2 border position-relative " style="background-color: #fff; height: 350px;">
                    <b class="title d-block mb-3">Câu hỏi & Giải đáp</b>
                    <div class="list scrollbar position-absolute">
                        <div class="item border-bottom mb-2">
                            <b class="d-block mb-2 pr-4 position-relative">Cách làm thủ tục trực tuyến</b>
                            <p>Chỉ dành cho thành viên OH!Travel, tính năng làm thủ tục chuyến bay trực tuyến có trên trang
                                web và ứng dụng OH!Travel sẽ giúp bạn làm thủ tục dễ dàng trước cả khi bạn đến sân
                                bay.<br><br>
                                Giờ đây bạn không còn phải vất vả giữa nhiều trang web và ứng dụng khác nhau của hãng hàng
                                không nữa. Chỉ cần đăng nhập vào tài khoản OH!Travel, làm thủ tục và xem thẻ lên máy bay dễ
                                dàng ngay tại Traveloka - trải nghiệm làm thủ tục trực tuyến chưa bao giờ dễ dàng đến
                                thế!<br><br>
                                Ngay khi chuyến bay của bạn có thể làm thủ tục, OH!Travel sẽ gửi thông báo đến bạn.</p>
                        </div>
                        <div class="item border-bottom mb-2">
                            <b class="d-block mb-2 pr-4 position-relative">Cách huỷ vé và hoàn tiền cho đặt chỗ máy bay</b>
                            <p>1. Đăng nhập vào extranet<br>
                                2. Nhấn Chỗ nghỉ và nhấp vào Chính sách<br>
                                3. Nhấn vào Tạo chính sách hủy phòng mới<br>
                                4. Chọn xem Quý vị có muốn đưa ra khoảng thời gian được hủy miễn phí hay không, và nếu có
                                thì bao lâu trước khi đến khách được hủy miễn phí<br>
                                5. Nêu rõ khách sẽ bị thu phí bao nhiêu nếu hủy sau khi hết thời gian hủy miễn phí (hoặc nếu
                                không có thời gian hủy miễn phí) hoặc vắng mặt<br>
                                6. Nhấp vào Lưu</p>
                        </div>
                        <div class="item border-bottom mb-2">
                            <b class="d-block mb-2 pr-4 position-relative">Cách yêu cầu xuất hóa đơn GTGT khi đặt tại
                                OH!Travel</b>
                            <p>Bạn liên hệ với bộ phận hỗ trợ OH!Travel tại đây để yêu cầu xuất hóa đơn cho booking vé của
                                bạn.</p>
                        </div>
                        <div class="item border-bottom mb-2">
                            <b class="d-block mb-2 pr-4 position-relative">Xác nhận và xác thực thanh toán</b>
                            <p>Thông báo sẽ được gửi tới sms và email của quý khách ngay khi xử lý xong</p>
                        </div>
                        <div class="item border-bottom mb-2">
                            <b class="d-block mb-2 pr-4 position-relative">Làm cách nào để kiểm tra trạng thái hoàn tiền của
                                tôi</b>
                            <p>Thông báo sẽ được gửi tới sms và email của quý khách ngay khi xử lý xong</p>
                        </div>
                        <div class="item border-bottom mb-2">
                            <b class="d-block mb-2 pr-4 position-relative">Cách sửa hoặc đổi tên hành khách bay</b>
                            <p>Bạn liên hệ với bộ phận hỗ trợ OH!Travel tại đây để yêu cầu đổi tên cho booking của bạn.</p>
                        </div>
                        <div class="item border-bottom mb-2">
                            <b class="d-block mb-2 pr-4 position-relative">Cách đổi lịch vé máy bay của tôi</b>
                            <p>Bạn liên hệ với bộ phận hỗ trợ OH!Travel tại đây để yêu cầu đổi lịch cho booking của bạn.</p>
                        </div>
                    </div>
                </div>

            </div>




        </div>
        <div class="row container text-center mx-auto mt-2 ">
            <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3835.8560693164695!2d108.25831637592069!3d15.968891042114658!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x3142116949840599%3A0x365b35580f52e8d5!2sFPT%20University%20Danang!5e0!3m2!1sen!2s!4v1720608030584!5m2!1sen!2s" width="600" height="450" style="border:0;" allowfullscreen="" loading="lazy" referrerpolicy="no-referrer-when-downgrade"></iframe>
        </div>
    </body>

    <script src="js/swiper.js"></script>
    <script>
        document.addEventListener("DOMContentLoaded", function () {
            const items = document.querySelectorAll('.qa .item b');

            items.forEach(item => {
                item.addEventListener('click', function () {
                    const p = this.nextElementSibling;
                    if (p.classList.contains('visible')) {
                        p.classList.remove('visible');
                    } else {
                        // Hide any other visible paragraphs
                        document.querySelectorAll('.qa .item p').forEach(paragraph => {
                            paragraph.classList.remove('visible');
                        });
                        p.classList.add('visible');
                    }
                });
            });
        });
    </script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</html>
