<%@ page language="java" contentType="text/html; charset=utf8"
         pageEncoding="utf8" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"><html>
<html lang="en">
<head>
    <!-- Meta -->
    <meta charset="utf-8">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no">

    <title>HMC. <spring:message code="checkout.checkoutProcess"/></title>

    <!-- Bootstrap Core CSS -->
    <link rel="stylesheet" href="../resources/css/bootstrap.min.css" type="text/css" media="screen"/>

    <!-- Customizable CSS -->
    <link rel="stylesheet" href="../resources/css/main.css" type="text/css" media="screen"/>
    <link rel="stylesheet" href="../resources/css/green.css" type="text/css" media="screen"/>
    <link rel="stylesheet" href="../resources/css/owl.carousel.css" type="text/css" media="screen"/>
    <link rel="stylesheet" href="../resources/css/owl.transitions.css" type="text/css" media="screen"/>
    <link rel="stylesheet" href="../resources/css/animate.min.css" type="text/css" media="screen"/>

    <!-- Fonts -->
    <link href='http://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700,800' rel='stylesheet' type='text/css'>

    <!-- Icons/Glyphs -->
    <link rel="stylesheet" href="../resources/css/font-awesome.min.css" type="text/css" media="screen"/>

    <!-- Favicon -->
    <link rel="shortcut icon" href="../resources/images/favicon.ico">

    <script>
        (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
            (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
                m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
        })(window,document,'script','https://www.google-analytics.com/analytics.js','ga');

        ga('create', 'UA-75911811-4', 'auto');
        ga('send', 'pageview');

    </script>

</head>
<body>

<div class="wrapper">
<!-- ============================================================= TOP NAVIGATION ============================================================= -->
<div class="wrapper">
    <%@include file="../insertions/header.jsp" %>
    <div id="top-mega-nav">
        <div class="container">
            <nav>
                <ul class="inline">
                    <%@include file="../insertions/shopByDepartment.jsp" %>
                    <li class="breadcrumb-nav-holder">
                        <ul>
                            <li class="breadcrumb-item gray">
                                <a href="/"><spring:message code="common.home"/></a>
                            </li>
                            <%--<li class="breadcrumb-item gray">--%>
                                <%--<a onclick="goToHmc()"><spring:message code="common.hmc"/></a>--%>
                            <%--</li>--%>
                            <li class="breadcrumb-item gray">
                                <a href="/hmc/cart"><spring:message code="cart.shoppingCart"/></a>
                            </li>
                            <li class="breadcrumb-item current">
                                <a onclick="window.location.reload(true);">
                                    <h1 class="h2 department-h1"><spring:message code="checkout.checkoutProcess"/></h1>
                                </a>
                            </li>
                        </ul>
                    </li>
                    <!-- /.breadcrumb-nav-holder -->
                </ul>
            </nav>
        </div>
        <!-- /.container -->
    </div>
    <!-- /#top-mega-nav -->
    <!-- ========================================= BREADCRUMB : END ========================================= --></div>
<!-- ========================================= CONTENT ========================================= -->

<section id="checkout-page">
    <div class="container">
        <div class="col-xs-12 no-margin">

            <c:if test="${!empty sessionScope.basket}">
                <form:form method="post" action="checkout" id="form" commandName="order">
                    <form:input type="hidden" path="orderId"/>
                    <div class="billing-address">
                        <h2 class="border h1"><spring:message code="checkout.billingAddress"/></h2>

                        <div class="row field-row">
                            <div class="col-xs-12 col-sm-6">
                                <label><spring:message code="checkout.firstName"/>*</label>
                                <form:input path="firstName" class="le-input" required="true"  name="firstName" type="text"/><br>
                            </div>
                            <div class="col-xs-12 col-sm-6">
                                <label><spring:message code="checkout.lastName"/>*</label>
                                <form:input path="lastName" class="le-input" required="true" name="lastName" type="text"/><br>
                            </div>
                        </div>
                        <!-- /.field-row -->

                        <div class="row field-row">
                            <div class="col-xs-12">
                                <label><spring:message code="checkout.companyName"/></label>
                                <form:input path="company" class="le-input" name="company" type="text"/><br>
                            </div>
                        </div>
                        <!-- /.field-row -->

                        <div class="row field-row">
                            <div class="col-xs-12">
                                <label><spring:message code="checkout.address"/>*</label>
                                <form:input path="address" class="le-input" name="address" required="true" type="text"/><br>
                            </div>
                        </div>
                        <!-- /.field-row -->

                        <div class="row field-row">
                            <div class="col-xs-12 col-sm-4">
                                <label><spring:message code="checkout.postcode"/>*</label>
                                <form:input path="postcode" class="le-input" name="postcode" required="true" type="number"/><br>
                            </div>
                            <div class="col-xs-12 col-sm-4">
                                <label id="label-email"><spring:message code="checkout.email"/>*<span style='color:crimson' class="hidden"> <spring:message code="checkout.invalidEmail"/></span></label>
                                <form:input path="email" class="le-input" required="true" name="email" type="email"/>
                            </div>

                            <div class="col-xs-12 col-sm-4">
                                <label><spring:message code="checkout.phoneNumber"/>*</label>
                                <form:input path="phone" class="le-input" name="phone" required="true" type="text"/>
                            </div>
                        </div>
                        <!-- /.field-row -->
                    </div>
                    <!-- /.billing-address -->

                    <section id="your-order">
                        <h2 class="border h1"><spring:message code="checkout.yourOrder"/></h2>
                        <c:forEach items="${sessionScope.basket.items}" var="machine">
                            <div class="row no-margin order-item">
                                <div class="col-xs-12 col-sm-1 no-margin">
                                    <a class="qty">
                                        <span id="count${machine.product.productId}"></span> x
                                    </a>
                                </div>

                                <div class="col-xs-12 col-sm-9 ">
                                    <div class="title">
                                        <a href="/hmc${machine.product.productId}">
                                                ${machine.product.type} ${machine.product.model}
                                        </a>
                                    </div>
                                    <div class="brand">${machine.product.manufacturer}</div>
                                </div>

                                <%--<div class="col-xs-12 col-sm-2 no-margin" <c:if test="${pageContext.request.userPrincipal.name == null}">style="display: none"</c:if>>--%>
                                    <%--<div class="price">$${machine.product.price}</div>--%>
                                <%--</div>--%>
                            </div>
                            <!-- /.order-item -->
                        </c:forEach>

                        <c:forEach items="${checkoutListRobots}" var="machine">
                            <div class="row no-margin order-item">
                                <div class="col-xs-12 col-sm-1 no-margin">
                                    <a class="qty">
                                        <span id="count${machine.productId}"></span> x
                                    </a>
                                </div>

                                <div class="col-xs-12 col-sm-9 ">
                                    <div class="title">
                                        <a href="/hmc${machine.productId}">
                                                ${machine.type} ${machine.model}
                                        </a>
                                    </div>
                                    <div class="brand">${machine.manufacturer}</div>
                                </div>

                                <%--<div class="col-xs-12 col-sm-2 no-margin" <c:if test="${pageContext.request.userPrincipal.name == null}">style="display: none"</c:if>>--%>
                                    <%--<div class="price">$${machine.price}</div>--%>
                                <%--</div>--%>
                            </div>
                            <!-- /.order-item -->
                        </c:forEach>
                        <%--<div class="row no-margin order-item" <c:if test="${pageContext.request.userPrincipal.name == null}">style="display: none"</c:if>>--%>
                            <%--<div class="col-xs-6 col-xs-offset-4 col-sm-3 col-sm-offset-7 no-margin">--%>
                                <%--<spring:message code="checkout.orderTotal"/>--%>
                            <%--</div>--%>

                            <%--&lt;%&ndash;<div class="col-xs-2 col-sm-2 col-sm-2 no-margin">&ndash;%&gt;--%>
                                <%--&lt;%&ndash;<div class="value">$${sessionScope.basket.total}</div>&ndash;%&gt;--%>
                            <%--&lt;%&ndash;</div>&ndash;%&gt;--%>
                        <%--</div>--%>

                    </section>
                    <!-- /#your-order -->

                    <form:input type="hidden" name="orderList" path="orderList"/>
                    <form:input type="hidden" class="total-field" name="total" path="total"/>

                    <div class="place-order-button">
                        <button class="le-button huge" type="submit"><spring:message code="checkout.placeOrder"/></button>
                    </div>
                    <!-- /.place-order-button -->
                </form:form>
            </c:if>

        </div>
        <!-- /.col -->
    </div>
    <!-- /.container -->
</section>
<!-- /#checkout-page -->
<!-- ========================================= CONTENT : END ========================================= -->
<!-- ============================================================= FOOTER ============================================================= -->
<!-- ================================================= FOOTER ========================================== -->
<%@include file="../insertions/footer.jsp" %>
<!-- ============================================================= FOOTER : END ============================================================= -->

<script src="../resources/js/jquery-1.10.2.min.js"></script>
<script src="../resources/js/jquery-migrate-1.2.1.js"></script>
<script src="../resources/js/bootstrap.min.js"></script>
<script src="http://maps.google.com/maps/api/js?sensor=false&amp;language=en"></script>
<script src="../resources/js/gmap3.min.js"></script>
<script src="../resources/js/bootstrap-hover-dropdown.min.js"></script>
<script src="../resources/js/owl.carousel.min.js"></script>
<script src="../resources/js/css_browser_selector.min.js"></script>
<script src="../resources/js/echo.min.js"></script>
<script src="../resources/js/jquery.easing-1.3.min.js"></script>
<script src="../resources/js/bootstrap-slider.min.js"></script>
<script src="../resources/js/jquery.raty.min.js"></script>
<script src="../resources/js/jquery.prettyPhoto.min.js"></script>
<script src="../resources/js/jquery.customSelect.min.js"></script>
<script src="../resources/js/wow.min.js"></script>
<script src="../resources/js/scripts.js"></script>
<script src="http://w.sharethis.com/button/buttons.js"></script>
<script src="../resources/js/comparison,wishlist,cart,common.jsp"></script>
<script type="text/javascript">
//    $(document).ready(function () {
//        var arr = localStorage.cartItemStr.split(';');
//        $.each(arr, function (index, value) {
//            var item = value.split(',');
//            $("#count" + item[0]).html(item[2]);
//        });
//        $("input[name='orderList']").val(localStorage.cartItemStr);
//        $("input[name='total']").val(localStorage.cartTotal);
//        $('#form').submit(function(){
//            var send = true;
//            var inputs = ['firstName','lastName','address','postcode','email','phone'];
//            $.each(inputs, function (index, value) {
//                var input = $("input[name='"+value+"']");
//                if(!input.val()) {
//                    input.addClass('red');
//                    send = false;
//                } else {
//                    input.removeClass('red');
//                    input.val(input.val().trim());
//                    if(value=='email') {
//                        var re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
//                        var span = $("#label-email span");
//                        if(!re.test(input.val())){
//                            input.addClass('red');
//                            span.removeClass('hidden');
//                            send = false;
//                        } else {
//                            span.addClass('hidden');
//                        }
//                    }
//                }
//            });
//            $("html, body").animate({ scrollTop: 30 }, "fast");
//            return send;
//        });
//    });

</script>
<script type="text/javascript">
    $(document).ready(function(){
//        var fullArr = localStorage.cartItemStr.split(';');
//        if (fullArr != null && fullArr != "") {
//            var orderTotal = 0;
//            $(fullArr).each(function (index, value) {
//                var machine = value.split(',');
//                var productId = machine[0];
//                var price = machine[1];
//                var count = machine[2];
//                $('#count' + productId).text(count);
//                $('#total' + productId).text((parseInt(count) * parseInt(price)).toString());
//                orderTotal += parseInt(price) * parseInt(count);
//            });
//            $("#order-total").text(orderTotal.toString());
//        }
        $('.total-field').attr("value", localStorage.cartTotal.toString());
    });
</script>
</body>
</html>