<%@page import="service.impl.PaymentService"%>
<%@page import="service.interfaces.IPaymentService"%>
<%@page import="controllers.Payment.Config"%>
<%@page import="java.net.URLEncoder"%>
<%@page import="java.nio.charset.StandardCharsets"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@page import="java.util.Iterator"%>
<%@page import="java.util.Collections"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Enumeration"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
        <meta name="description" content="">
        <meta name="author" content="">
        <title>Kết quả Thanh Toán</title>
        <!-- Bootstrap core CSS -->
        <link href="/vnpay_jsp/assets/bootstrap.min.css" rel="stylesheet"/>
        <!-- Custom styles for this template -->
        <link href="/vnpay_jsp/assets/jumbotron-narrow.css" rel="stylesheet">
        <script src="/vnpay_jsp/assets/jquery-1.11.3.min.js"></script>
        <style>
            .payment-result {
                margin-top: 30px;
            }
            .form-group label {
                font-weight: bold;
            }
            .result-value {
                color: #555;
            }
        </style>
    </head>
    <body>
        <div class="container payment-result">
            <div class="row">
                <div class="col-md-12">
                    <div class="page-header">
                        <h1 class="text-center">Kết quả Thanh Toán</h1>
                    </div>
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h3 class="panel-title">Chi tiết giao dịch</h3>
                        </div>
                        <div class="panel-body">
                            <div class="list-group">
                                <div class="list-group-item">
                                    <strong>Mã giao dịch thanh toán:</strong>
                                    <span class="result-value"><%=request.getParameter("vnp_TxnRef")%></span>
                                </div>
                                <div class="list-group-item">
                                    <strong>Số tiền:</strong>
                                    <span class="result-value"><%=Integer.parseInt(request.getParameter("vnp_Amount")) / 100%></span>
                                </div>
                                <div class="list-group-item">
                                    <strong>Mô tả giao dịch:</strong>
                                    <span class="result-value"><%=request.getParameter("vnp_OrderInfo")%></span>
                                </div>
                                <div class="list-group-item">
                                    <strong>Mã lỗi thanh toán:</strong>
                                    <span class="result-value"><%=request.getParameter("vnp_ResponseCode")%></span>
                                </div>
                                <div class="list-group-item">
                                    <strong>Mã giao dịch tại CTT VNPAY-QR:</strong>
                                    <span class="result-value"><%=request.getParameter("vnp_TransactionNo")%></span>
                                </div>
                                <div class="list-group-item">
                                    <strong>Mã ngân hàng thanh toán:</strong>
                                    <span class="result-value"><%=request.getParameter("vnp_BankCode")%></span>
                                </div>
                                <div class="list-group-item">
                                    <strong>Thời gian thanh toán:</strong>
                                    <span class="result-value"><%=request.getParameter("vnp_PayDate")%></span>
                                </div>
                                <div class="list-group-item">
                                    <strong>Tình trạng giao dịch:</strong>
                                    <span class="result-value fw-bold" style="color:blue;">
                                        <%
                                            if ("00".equals(request.getParameter("vnp_TransactionStatus"))) {
                                                out.print("Thành công");
                                            } else {
                                                out.print("Không thành công");
                                            }
                                        %>
                                    </span>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
