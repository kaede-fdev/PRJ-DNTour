<%--
    Document   : restaurant-search-page
    Created on : Jul 7, 2024, 6:56:26 PM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css">

        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
                integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous">
        </script>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Restaurant search Page</title>
    </head>
    <style>
        /* section1 */
        .container {
            /*width: 1080px;*/
        }

        label {
            display: block;
            font-size: small;
            color: #455873;
            line-height: 18px;
        }

        .section1 {
            height: 68px;

        }

        input:focus {
            border: 0;
            outline: none;
        }

        .btn[type="submit"] {


            background-color: #007bff;
            color: #fff;
            border: none;
            border-radius: 5px;
            font-size: 14px;
            cursor: pointer;
        }

        li {
            /*font-size: 12px;*/

        }

        button[type="submit"]:hover {
            background-color: #0056b3;
        }

        .destination-option {
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        .destination-option:hover {
            background-color: #f5f5f5;
        }
        .d-block {
            display: block;
        }

        /* section1 */
        .section1 .btn{
            margin-left: 35px;

        }
        /*pt*/
        .pt {
            font-size: 12px;
        }

        .pt .homePage:hover {
            color: blanchedalmond;
        }

        .pt i {
            font-size: 8px;
        }
        .section1 .extends{
            background-color: #ffffff;
        }
        /*pt*/
        /*section2*/




        .custom-wrapper {
            width: 80%;
            margin: auto;
            position: relative;
        }

        .header .projtitle {
            font-size: 12px;
            color: #007bff;
            display: flex;
            justify-content: center;


        }

        /* Styles for the price input container */
        .price-input-container {
            width: 100%;
        }

        .price-input {
            display: flex;
            width: 50%;

            color: #555;

        }

        .price-field {
            align-items: center;
            margin-right: 70px;
            width: 0%;
        }

        .price-field input {

            font-size: 10px;
            border: none;
            outline: none;

        }


        /* Remove Arrows/Spinners */
        input::-webkit-outer-spin-button,
        input::-webkit-inner-spin-button {
            -webkit-appearance: none;
            margin: 0;
        }

        .slider-container {
            width: 100%;
        }

        .slider-container {
            height: 6px;
            position: relative;
            background: #e4e4e4;
            border-radius: 5px;
        }

        .slider-container .price-slider {
            height: 100%;
            left: 25%;
            right: 15%;
            position: absolute;
            border-radius: 5px;
            /*                        background: #007bff;*/
        }

        .range-input {
            position: relative;
        }

        .range-input input {
            position: absolute;
            width: 100%;
            height: 5px;
            background: none;
            top: -5px;
            pointer-events: none;
            cursor: pointer;
            -webkit-appearance: none;
        }

        /* Styles for the range thumb in WebKit browsers */
        input[type="range"]::-webkit-slider-thumb {
            height: 18px;
            width: 18px;
            border-radius: 70%;
            background: #007bff;
            pointer-events: auto;
            -webkit-appearance: none;
        }

        .tick-header {
            color: #007bff;
        }

        .filter-container p {
            font-size: 14px;
        }
        .section2 .description{
            font-size: 12px;
        }
        .section2 select{
            font-size: 14px;
        }
        .section2 option{
            font-size: 12px;
        }



        .min-price, .max-price {
            font-weight: bold;
            font-size: 14px;
            color: #333; /* Adjust color as per your design */

        }
        .star {
            font-size: 11px;
            color: #f39c12; /* Adjust star color */
        }
        .close-btn {
            font-size: 20px;
            position: absolute;
            top: 10px;
            right: 10px;
            cursor: pointer;
            z-index: 1100;
        }
        .extends {
            background-color: white;
            z-index: 1000; /* Ensure dropdown is above other content */
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        .destination-option {
            cursor: pointer;
        }
        .destination-option:hover {
            background-color: #f0f0f0;
        }
        .section2 .item{
            /*            height:190px;*/
        }


        /*section2*/
    </style>

    <body>
        <div class="">
            <div class="section1">
                <div class="   mx-auto container">
                    <div class="  my-5 border rounded-3 w-100  ">
                        <form action="restaurantsearch" method="POST"  class=" d-flex justify-content-between h-100  my-2 ">
                            <div class="d-flex w-25 align-items-center p-2">
                                <div class="ms-2 mb-1">
                                    <i class="fas fa-map-marker-alt fa-2x fs-4"></i>
                                </div>
                                <div class="mx-1 h-75 my-3 w-100 text-left align-items-end flex-column position-relative">
                                    <label class="ms-2 border-end">Please enter a destination</label>
                                    <div class="border-end d-flex ms-2 align-items-center">
                                        <input class="border-0 w-75 fw-bold" type="text" id="cityInput" name="city" placeholder="City" value="${cityName}"  >
                                        <i class="fas fa-times-circle fs-2 ms-1 " id="clear-icon" style="cursor: pointer; display: none;"></i>
                                    </div>
                                    <div class="position-absolute ms-2 my-3 top-75 d-none border rounded-3 w-100 extends" id="extends">
                                        <div>
                                            <label class="mx-2 my-2">Popular Destinations</label>
                                        </div>
                                        <div>
                                            <ul class="list-unstyled">
                                                <div class="d-flex destination-option py-2 align-items-center">
                                                    <i class="fas fa-map-marker-alt fa-xs fs-6 mx-1 me-2"></i>
                                                    <li role="option" class="fw-bold">Hue</li>
                                                </div>
                                                <div class="d-flex py-2 destination-option  align-items-center">
                                                    <i class="fas fa-map-marker-alt fa-xs  fs-6 mx-1 me-2"></i>
                                                    <li role="option" class="fw-bold">Da Nang</li>
                                                </div>
                                                <div class="d-flex destination-option py-2  align-items-center">
                                                    <i class="fas fa-map-marker-alt fa-xs fs-6 mx-1 me-2"></i>
                                                    <li role="option" class="fw-bold">Hoi An</li>
                                                </div>
                                            </ul>
                                        </div>
                                    </div>
                                </div>
                            </div>





                            <div class="d-flex  w-25 align-items-center ms-3 ">
                                <div class="w-100 border-end  ">
                                    <label for="start-date ">Start Date:</label>
                                    <input class="w-75 border-0 fw-bold" type="date" id="start-date" name="start-date"
                                           value="${currentDate}" placeholder="${currentDate}" required>
                                </div>

                            </div>



                            <div class="d-flex w-25 align-items-center" style="display: none !important">
                                <div class="  w-100 text-left   border-end  ">

                                    <label class=" mx-3 mt-1">Guests and rooms</label>
                                    <input class="border-0   mx-3 fw-bold  " type="text" readonly    placeholder="City"
                                           class="" value="2 Guests , 1 Room">

                                </div>

                            </div>

                            <div class=" w-25    "> <button class=" h-50   btn w-75 my-3 " type="submit" name="action" value="case-1" >Search</button>
                            </div>


                        </form>
                    </div>
                </div>
            </div>
            <div class="d-flex container mx-auto my-5 pt ">
                <div class=""><a href="#" class="text-decoration-none text-dark d-flex align-items-center">
                        <div class="homePage ">Home page</div><i class="fa-solid fa-chevron-right mx-2 "></i>
                    </a></div>

                <div class=""><a href="#" class="text-primary text-decoration-none "> Hotel</a></div>

            </div>
            <div class="section2 mx-auto container my-4 d-flex align-items-center">
                <div class="w-100 my-2 d-flex ">
                    <div class="w-25  me-2">
                        <div class="border rounded-2">
                            <form action="restaurantsearch" method="POST" >
                                <div class="border-bottom p-2"><strong>Chọn lọc theo:</strong>
                                </div>
                                <div class="main border-bottom">
                                    <div class="custom-wrapper">
                                        <div class="header py-2">
                                            <h2 class="projtitle fw-bold">
                                                Giá tiền có thể chi trả
                                            </h2>
                                        </div>

                                        <div class="price-input-container">
                                            <div class="price-input d-flex my-2">
                                                <div class="price-field">
                                                    <input type="number" class="min-input"   name="min-input" value="0" readonly>
                                                </div>
                                                <div class="price-field">
                                                    <input type="number" class="max-input"   name="max-input" value="100" readonly>
                                                </div>
                                            </div>
                                            <div class="slider-container">
                                                <div class="price-slider"></div>
                                            </div>
                                        </div>

                                        <!-- Slider -->
                                        <div class="range-input py-2">
                                            <input type="range" class="min-range" min="0" max="100" value="0" step="1">
                                            <input type="range" class="max-range" min="0" max="100" value="100" step="1">
                                        </div>
                                    </div>
                                </div>

                                <div class="">
                                    <div class="align-items-center text-center  tick-header">
                                        <div class="fw-bold fs-6 p-2  ">Các bộ lọc phổ biến</div>
                                    </div>
                                    <div class="filter-container mx-3">
                                        <div>
                                            <p class="m-0 mx-2">Kiểu nhà hàng</p>
                                        </div>
                                        <div class="filter-item d-flex my-2">
                                            <input type="checkbox" name="chinese" value=" chinese" class="mx-2">
                                            <label for="chinese">Trung Quốc</label>
                                        </div>
                                        <div class="filter-item d-flex my-2">
                                            <input type="checkbox"  name="asian" value="asian" class="mx-2">
                                            <label for="asian">Á</label>
                                        </div>
                                        <div class="filter-item d-flex my-2">
                                            <input type="checkbox"  name="viet" value=" viet" class="mx-2">
                                            <label for="viet"> Việt</label>
                                        </div>
                                        <div class="filter-item d-flex my-2">
                                            <input type="checkbox"  name="american" value="american" class="mx-2">
                                            <label for="american">Mỹ</label>
                                        </div>
                                        <div class="filter-item d-flex my-2">
                                            <input type="checkbox"  name="arfica" value="arfica" class="mx-2">
                                            <label for="arfica">Âu</label>
                                        </div>
                                        <div class="filter-item d-flex my-2">
                                            <input type="checkbox"  name="italia" value="italia" class="mx-2">
                                            <label for="italia">Ý</label>
                                        </div>
                                    </div>
                                    <input type="hidden" id="cityInput" name="city" value="${cityName}">
                                    <input type="hidden" id="start-date" name="start-date" value="${currentDate}">

                                </div>
                                <button class="btn w-100 p-2  mx-auto mt-1 fs-6" type="submit" name="action" value="case-2">Filter</button>

                            </form>

                        </div>

                    </div>
                    <div class="  w-75 mx-5">
                        <!--                        <div class="d-flex align-items-center mb-3">
                                                    <div class="mr-5"> <i class="fa-solid fa-arrow-up-wide-short"></i> Sort by:</div>
                                                    <div class="ms-3">
                                                        <select id="sortOptions" class="form-control">
                                                            <option value="priceMinToMax" >Price: Min to Max</option>
                                                            <option value="priceMaxToMin">Price: Max to Min</option>
                                                            <option value="ratingRecommended">Rating & Recommended</option>
                                                        </select>
                                                    </div>
                                                </div>-->
                        <div>
                            <c:forEach var="restaurant" items="${sessionScope.restaurants}">
                                <div class="item border rounded-2 row my-5">
                                    <div class="col mr-3 p-0">
                                        <c:choose>
                                            <c:when test="${not empty sessionScope.restaurantImagesMap[restaurant.id]}">
                                                <img src="${sessionScope.restaurantImagesMap[restaurant.id][1].url}" alt="Restaurant Image" class="w-100 h-100  rounded-2 object-fit-cover">
                                            </c:when>
                                            <c:otherwise>
                                                <img src="${restaurant.openUrl}" alt="Default Image" class="rounded-2 object-fit-cover">
                                            </c:otherwise>
                                        </c:choose>
                                    </div>
                                    <div class="col ml-2">
                                        <h5 class="fw-bold text-primary my-2">
                                            <a href="${restaurant.openUrl}" class="text-decoration-none">${restaurant.name}</a>
                                        </h5>
                                        <div class="d-flex my-2 position-relative">
                                            <button class="btn btn-link my-2 p-0 text-decoration-none" onclick="toggleMap('map-${restaurant.id}')">
                                                <div class="fs-6">Xem bản đồ</div>
                                            </button>
                                            <div id="map-${restaurant.id}" class="position-absolute d-none map-container">
                                                <div class="close-btn" onclick="closeMap('map-${restaurant.id}')">
                                                    <i class="fa fa-times-circle fa-lg"></i>
                                                </div>
                                                ${restaurant.mapEmbed}
                                            </div>
                                        </div>
                                        <div class="col my-2">
                                            Nhà hàng chuyên
                                            ${restaurant.styles}
                                        </div>
                                    </div>
                                    <div class="w-25 mt-3  ">
                                        <div class="col min-price my-2">${restaurant.minPrice}$ ~ ${restaurant.maxPrice}$</div>
                                        <button class="col btn w-100 p-3 mt-4" type="submit">Xem chi tiết</button>
                                    </div>
                                </div>
                            </c:forEach>

                        </div>
                    </div>

                </div>
            </div>




        </div>


    </body>
    <script>
        // JavaScript to handle showing and hiding map on button click
        function toggleMap(mapDivId) {
            var mapDiv = document.getElementById(mapDivId);
            mapDiv.classList.toggle("d-none");
        }

        // JavaScript to close the map when clicking the "x-mark"
        function closeMap(mapDivId) {
            var mapDiv = document.getElementById(mapDivId);
            mapDiv.classList.add("d-none");
        }
    </script>

    <script>
        document.addEventListener("DOMContentLoaded", function () {
            const cityInput = document.getElementById('cityInput');
            const extendsDiv = document.getElementById('extends');

            // Function to show or hide the extends dropdown
            function toggleExtendsDropdown() {
                extendsDiv.classList.toggle('d-none');
            }

            // Show extends dropdown when cityInput is clicked
            cityInput.addEventListener('click', function (event) {
                toggleExtendsDropdown();
                event.stopPropagation(); // Prevents the click event from reaching document click listener
            });

            // Hide extends dropdown when clicked outside of it
            document.addEventListener('click', function (event) {
                const isClickInside = cityInput.contains(event.target) || extendsDiv.contains(event.target);
                if (!isClickInside) {
                    extendsDiv.classList.add('d-none');
                }
            });

            // Optional: Handle selecting an option from the dropdown
            const destinationOptions = document.querySelectorAll('.destination-option');
            destinationOptions.forEach(option => {
                option.addEventListener('click', function () {
                    const selectedCity = option.querySelector('li').textContent;
                    cityInput.value = selectedCity;
                    extendsDiv.classList.add('d-none');
                });
            });

            // Optional: Clear input field
            const clearIcon = document.getElementById('clear-icon');
            clearIcon.addEventListener('click', function () {
                cityInput.value = '';
                clearIcon.style.display = 'none';
            });

            // Show clear icon when input has value
            cityInput.addEventListener('input', function () {
                if (cityInput.value.trim().length > 0) {
                    clearIcon.style.display = 'inline';
                } else {
                    clearIcon.style.display = 'none';
                }
            });
        });
    </script>

    <!--    <script src="/../src/java/js/RangeSlider.js"></script>-->
    <script>
        const rangeSlider = document.querySelector(".slider-container .price-slider");
        const rangeInputs = document.querySelectorAll(".range-input input");
        const priceGap = 4;
        const priceInputs = document.querySelectorAll(".price-input input");

        for (let i = 0; i < priceInputs.length; i++) {
            priceInputs[i].addEventListener("input", e => {
                let minPrice = parseInt(priceInputs[0].value);
                let maxPrice = parseInt(priceInputs[1].value);

                if (minPrice < 1) {
                    alert("Minimum price cannot be less than $1");
                    priceInputs[0].value = 1;
                    minPrice = 1;
                }

                if (maxPrice > 100) {
                    alert("Maximum price cannot be greater than $100");
                    priceInputs[1].value = 100;
                    maxPrice = 100;
                }

                if (minPrice > maxPrice - priceGap) {
                    priceInputs[0].value = maxPrice - priceGap;
                    minPrice = maxPrice - priceGap;

                    if (minPrice < 1) {
                        priceInputs[0].value = 1;
                        minPrice = 1;
                    }
                }

                if (maxPrice - minPrice >= priceGap && maxPrice <= rangeInputs[1].max) {
                    if (e.target.className === "min-input") {
                        rangeInputs[0].value = minPrice;
                        let value = rangeInputs[0].max;
                        rangeSlider.style.left = `${(minPrice / value) * 100}%`;
                    } else {
                        rangeInputs[1].value = maxPrice;
                        let value = rangeInputs[1].max;
                        rangeSlider.style.right = `${100 - (maxPrice / value) * 100}%`;
                    }
                }
            });

            rangeInputs[i].addEventListener("input", e => {
                let minVal = parseInt(rangeInputs[0].value);
                let maxVal = parseInt(rangeInputs[1].value);

                if (maxVal - minVal < priceGap) {
                    if (e.target.className === "min-range") {
                        rangeInputs[0].value = maxVal - priceGap;
                    } else {
                        rangeInputs[1].value = minVal + priceGap;
                    }
                } else {
                    priceInputs[0].value = minVal;
                    priceInputs[1].value = maxVal;
                    rangeSlider.style.left = `${(minVal / rangeInputs[0].max) * 100}%`;
                    rangeSlider.style.right = `${100 - (maxVal / rangeInputs[1].max) * 100}%`;
                }
            });
        }
    </script>

</html>
