<%@ page language="java" contentType="text/html; charset=utf8" pageEncoding="utf8" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<%--<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">--%>
<!doctype html>
<html>
<html lang="en">
<head>
  <!-- Meta -->
  <meta charset="utf-8">
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no">

  <title><spring:message code="common.hmcTitle"/></title>

  <!-- Bootstrap Core CSS -->
  <link rel="stylesheet" href="../../resources/css/bootstrap.min.css" type="text/css" media="screen"/>

  <!-- Customizable CSS -->
  <link rel="stylesheet" href="../../resources/css/main.css" type="text/css" media="screen"/>
  <link rel="stylesheet" href="../../resources/css/green.css" type="text/css" media="screen"/>
  <link rel="stylesheet" href="../../resources/css/owl.carousel.css" type="text/css" media="screen"/>
  <link rel="stylesheet" href="../../resources/css/owl.transitions.css" type="text/css" media="screen"/>
  <link rel="stylesheet" href="../../resources/css/animate.min.css" type="text/css" media="screen"/>

  <!-- Fonts -->
  <link href='http://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700,800' rel='stylesheet' type='text/css'>

  <!-- Icons/Glyphs -->
  <link rel="stylesheet" href="../../resources/css/font-awesome.min.css" type="text/css" media="screen"/>

  <!-- Favicon -->
  <link rel="shortcut icon" href="../../resources/images/favicon.ico">

  <script>
    (function (i, s, o, g, r, a, m) {
      i['GoogleAnalyticsObject'] = r;
      i[r] = i[r] || function () {
        (i[r].q = i[r].q || []).push(arguments)
      }, i[r].l = 1 * new Date();
      a = s.createElement(o),
              m = s.getElementsByTagName(o)[0];
      a.async = 1;
      a.src = g;
      m.parentNode.insertBefore(a, m)
    })(window, document, 'script', 'https://www.google-analytics.com/analytics.js', 'ga');

    ga('create', 'UA-75911811-4', 'auto');
    ga('send', 'pageview');

  </script>
</head>
<body>

<div class="wrapper">
  <%@include file="insertions/header.jsp" %>

  <div id="top-mega-nav">
    <div class="container">
      <nav>
        <ul class="inline">
          <%@include file="insertions/shopByDepartment.jsp" %>

          <li class="breadcrumb-nav-holder">
            <ul>
              <li class="breadcrumb-item gray">
                <a href="/"><spring:message code="common.home"/></a>
              </li>
              <li class="breadcrumb-item current">
                <a onclick="window.location.reload(true);">
                  <h1 class="h2 department-h1"><spring:message code="common.robots"/></h1>
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

  <section id="category-grid">
    <div class="container">

      <div id="top"></div>

      <!-- ========================================= SIDEBAR ========================================= -->
      <div class="col-xs-12 col-sm-3 no-margin sidebar narrow">
        <!-- ========================================= PRODUCT FILTER ========================================= -->
        <div class="widget">
          <h2 style="font-size: 28px; line-height: 52px; color: #3d3d3d"><spring:message code="productFilters"/></h2>

          <div class="body bordered" id="filterForm">
            <form:form action="/robot/filter" method="get">
              <div class="category-filter">
                <!-- manufacturer -->
                <h2>Manufacturer</h2>
                <c:if test="${!empty machineManufacturer}">
                  <ul>
                    <c:forEach items="${machineManufacturer}" var="manufacturer">
                      <li>
                        <input class="le-checkbox" name="manufacturer" type="checkbox" value="${manufacturer.nameManufacturer}"
                                  <c:if test="${manufacturer.nameManufacturer == mainFilter.manufacturer}">checked</c:if>>
                        <label>${manufacturer.nameManufacturer}</label>
                      </li>
                    </c:forEach>
                  </ul>
                </c:if>
                <hr>

                <!--year-->
                <h2>Year</h2>
                <ul>
                  <%--<c:forEach items="${machineList}" var="machine">--%>
                    <li>
                      <input type="text" name="yearFrom" size="5" placeholder="from" value="${mainFilter.yearFrom}">
                      <input type="text" name="yearTo" size="5" placeholder="to" value="${mainFilter.yearTo}">
                    </li>
                  <%--</c:forEach>--%>
                </ul>
                <hr>
                <h2>Axes</h2>
                <%--<c:if test="${!empty axesArr}">--%>
                  <ul>
                      <li>
                        <select class="le-select" name="axes">
                          <option disabled selected>Axes is not selected:</option>
                          <c:forEach items="${axesArr}" var="axes">
                            <c:if test="${!empty axes}">
                              <option value="${axes}" <c:if test="${mainFilter.axes == axes}">
                                selected
                              </c:if>>${axes} Axes</option>
                            </c:if>
                          </c:forEach>
                        </select>
                      </li>
                  </ul>
                <%--</c:if>--%>
                <hr>
                <h2>Load</h2>
                  <ul>
                    <li>
                      <select class="le-select" name="load">
                        <option disabled selected>Load is not selected:</option>
                        <c:forEach items="${loadArr}" var="load">
                          <c:choose>
                            <c:when test="${load.loadValue.split(',')[0] == '>'}">
                              <option value="${load.loadValue}" <c:if test="${mainFilter.load == load}"> selected </c:if>>
                              ${load.loadValue.split(',')[0]} ${load.loadValue.split(',')[1]} kg</option>
                            </c:when>
                            <c:when test="${load.loadValue.split(',')[0] == '<'}">
                              <option value="${load.loadValue}" <c:if test="${mainFilter.load == load}"> selected </c:if>>
                              ${load.loadValue.split(',')[0]} ${load.loadValue.split(',')[1]} kg</option>
                            </c:when>
                            <c:when test="${load.loadValue.split(',')[0] != null}">
                              <option value="${load.loadValue}" <c:if test="${mainFilter.load == load}"> selected </c:if>>
                              = ${load.loadValue.split(',')[0]}...${load.loadValue.split(',')[1]} kg</option>
                            </c:when>
                          </c:choose>
                        </c:forEach>
                      </select>
                    </li>
                  </ul>
                <hr>
                <h2>Reach</h2>
                <ul>
                  <li>
                    <select class="le-select" name="reach">
                      <option disabled selected>Reach is not selected:</option>
                      <c:forEach items="${reachArr}" var="reach">
                        <c:choose>
                          <c:when test="${reach.reachValue.split(',')[0] == '>'}">
                            <option value="${reach.reachValue}" <c:if test="${mainFilter.reach == reach}"> selected </c:if>>
                                ${reach.reachValue.split(',')[0]} ${reach.reachValue.split(',')[1]} mm</option>
                          </c:when>
                          <c:when test="${reach.reachValue.split(',')[0] == '<'}">
                            <option value="${reach.reachValue}" <c:if test="${mainFilter.reach == reach}"> selected </c:if>>
                                ${reach.reachValue.split(',')[0]} ${reach.reachValue.split(',')[1]} mm</option>
                          </c:when>
                          <c:when test="${reach.reachValue.split(',')[0] != null}">
                            <option value="${reach.reachValue}" <c:if test="${mainFilter.reach == reach}"> selected </c:if>>
                              = ${reach.reachValue.split(',')[0]}...${reach.reachValue.split(',')[1]} mm</option>
                          </c:when>
                        </c:choose>
                      </c:forEach>
                    </select>
                  </li>
                </ul>
                <hr>
                <h2>Location</h2>
                <c:if test="${!empty machineLocation}">
                  <ul>
                    <c:forEach items="${machineLocation}" var="location">
                      <li>
                        <input class="le-checkbox" name="location" type="checkbox" value="${location.countryName}"
                                  <c:if test="${location.countryName == mainFilter.location}">checked</c:if>>
                        <label>${location.countryName}</label>
                      </li>
                    </c:forEach>
                  </ul>
                </c:if>
                <hr>
              </div>
              <div class="place-order-button">
                <input class="le-button-huge" type="submit" value="Filter">
                  <%--<a id="filterSubmit" onclick="submitFilter()">--%>
                  <%--<spring:message code="hmc.filter"/></a>--%>
              </div>
            </form:form>
          </div>

          <div class="reset-filter">
            <a href="/robots"><spring:message code="hmc.resetFilter"/></a>
          </div>
          <br><br>
        </div>
        <!-- ========================================= PRODUCT FILTER : END ========================================= -->
      </div>
      <!-- ========================================= SIDEBAR : END ========================================= -->

      <!-- ========================================= CONTENT ========================================= -->

      <div class="col-xs-12 col-sm-9 no-margin wide sidebar">
        <section class="carousel-holder">

          <div class="title-nav">
            <h2><spring:message code="common.robots"/></h2>
            <div class="nav-holder"></div>
          </div>

          <div class="grid-list-products">

            <div class="control-bar">
              <%--<div id="popularity-sort" class="le-select" >--%>
              <%--<select data-placeholder="sort by popularity">--%>
              <%--<option value="1"><spring:message code="hmc.withoutSorting"/></option>--%>
              <%--<c:if test="${pageContext.request.userPrincipal.name != null}">--%>
              <%--<option value="2"><spring:message code="hmc.priceHighToLow"/></option>--%>
              <%--</c:if>--%>
              <%--<c:if test="${pageContext.request.userPrincipal.name != null}">--%>
              <%--<option value="3"><spring:message code="hmc.priceLowToHigh"/></option>--%>
              <%--</c:if>--%>
              <%--</select>--%>
              <%--</div>--%>

            <div id="item-count" class="le-select">
              <select id="selectPerPage">
                <c:set var="perPageNums">3;9;18;36;72</c:set>
                <c:forTokens items="${perPageNums}" delims=";" var="perPage">
                  <option value="${perPage}" <c:if test="${perPage == itemsPerPage}">selected</c:if>>${perPage}
                    <spring:message code="hmc.perPage"/></option>
                </c:forTokens>
              </select>
            </div>

            <div class="grid-list-buttons">
              <ul>
                <li class="grid-list-button-item active">
                  <a data-toggle="tab" href="#grid-view" onclick="sessionStorage.view = 'grid'">
                    <i class="fa fa-th-large"></i> <spring:message code="hmc.grid"/>
                  </a>
                </li>
                <li class="grid-list-button-item">
                  <a data-toggle="tab" href="#list-view" onclick="sessionStorage.view = 'list'">
                    <i class="fa fa-th-list"></i> <spring:message code="hmc.list"/>
                  </a>
                </li>
              </ul>
            </div>
          </div>
          <!-- /.control-bar -->

          <div class="tab-content">

            <div id="grid-view" class="products-grid fade tab-pane in active">
              <div class="product-grid-holder">
                <c:if test="${!empty robotsList}">
                  <div class="row no-margin">
                    <c:forEach items="${robotsList}" var="robot" varStatus="loop">
                      <div class="item${loop.index + 1} col-xs-12 col-sm-4 no-margin product-item-holder hover">
                        <div class="product-item">
                          <div class="image">
                            <img alt="${robot.type} - ${robot.productId}" src="../resources/images/blank.gif"
                                 data-echo="../resources/images/products/${robot.photo1}"/>
                            <span class="photo${robot.productId} hidden">${robot.photo1}</span>
                          </div>
                          <div class="body">
                            <div class="title">
                              <a href="/robot${robot.productId}">
                                  ${robot.type}<br><span
                                      class="model${robot.productId}">${robot.model}</span>
                              </a>
                            </div>
                            <div class="brand">
                              <span class="brand${robot.productId}">${robot.brand}</span>, ${robot.year}<br>
                                <spring:message code="machine.machineCondition"/>: ${robot.condition}<br>
                                <spring:message code="machine.location"/>: ${robot.location}<br>
                                <%--<spring:message code="machine.motion"/> X&timesY&timesZ: ${machine.xMotion}&times${machine.yMotion}&times${machine.zMotion}<spring:message code="machine.mm"/><br>--%>
                                <%--<spring:message code="machine.tableSize"/> X&timesY: ${machine.xTableSize}&times${machine.yTableSize}<spring:message code="machine.mm"/>--%>
                            </div>
                          </div>
                          <div class="prices" <c:if test="${pageContext.request.userPrincipal.name == null}">
                            style="display: none"</c:if>>
                            <div class="price-current pull-right">$<span
                                    class="price${robot.productId}">${robot.price}</span>
                            </div>
                            <br>
                          </div>
                          <div class="hover-area">
                            <div class="add-cart-button">
                              <a class="cart${robot.productId} le-button"
                                 onclick="window.location.href = '/addToCart/${robot.productId}/robots'"><spring:message
                                      code="common.addToCart"/></a>
                              <%--<a class="cart${robot.productId} le-button in-cart hidden"--%>
                                 <%--onclick="removeFromCart('${robot.productId}')"><spring:message--%>
                                      <%--code="common.inCart"/></a>--%>
                            </div>
                            <div class="wish-compare">
                                  <%--<span class="wishList${robot.productId} btn-add-to-wishlist"--%>
                                        <%--onclick="addToWishList('${robot.productId}')"><spring:message--%>
                                          <%--code="common.addToWishList"/></span>--%>
                                  <%--<span class="wishList${robot.productId} btn-add-to-wishlist btn-green hidden"--%>
                                        <%--onclick="removeFromWishList('${robot.productId}')"><spring:message--%>
                                          <%--code="common.removeFromWishList"/></span>--%>
                              <%--<br>--%>
                                  <span class="compare${robot.productId} btn-add-to-compare"
                                        onclick="window.location.href = '/addToCompare/${robot.productId}/robots'"><spring:message
                                          code="common.addToComparison"/></span>
                                  <%--<span class="compare${robot.productId} btn-add-to-compare btn-green hidden"--%>
                                        <%--onclick="removeFromComparison('${robot.productId}')"><spring:message--%>
                                          <%--code="common.removeFromComparison"/></span>--%>
                            </div>
                          </div>
                        </div>
                      </div>
                    </c:forEach>
                  </div>
                </c:if>
              </div>
            </div>

            <div id="list-view" class="products-grid fade tab-pane">
              <div class="products-list">
                <c:if test="${!empty robotsList}">
                  <c:forEach items="${robotsList}" var="robot" varStatus="loop">
                    <div class="item${loop.index + 1} product-item product-item-holder">
                      <div class="row">
                        <div class="no-margin col-xs-12 col-sm-4 image-holder">
                          <div class="image">
                            <img alt="${robot.model}" src="../resources/images/blank.gif"
                                 data-echo="../resources/images/products/${robot.photo1}"/>
                            <span class="photo${robot.productId} hidden">${robot.photo1}</span>
                          </div>
                        </div>
                        <!-- /.image-holder -->
                        <div class="no-margin col-xs-12 col-sm-5 body-holder">
                          <div class="body">
                            <div class="title">
                              <a href="/hmc${robot.productId}">
                                  ${robot.type}<br><span
                                      class="model${robot.productId}">${robot.model}</span>
                              </a>
                            </div>
                            <%--<div class="brand">--%>
                              <%--<span class="brand${robot.productId}">${robot.brand}</span>, ${robot.producingCountry}<br>--%>
                            <%--</div>--%>
                            <div class="excerpt">
                                <p>
                                <spring:message
                                code="machine.machineCondition"/>: ${robot.condition}<br>
                                <spring:message
                                code="machine.location"/>: ${robot.location}<br>
                                <spring:message code="machine.motion"/>
                                Reach: ${robot.reach}
                                  <%--&times${machine.yMotion}&times${machine.zMotion}--%>
                                <%--<spring:message code="machine.mm"/><br>--%>
                                <%--<spring:message code="machine.tableSize"/>--%>
                                <%--X&timesY: ${machine.xTableSize}&times${machine.yTableSize}--%>
                                <%--<spring:message code="machine.mm"/>--%>
                                </p>
                            </div>
                          </div>
                        </div>
                        <!-- /.body-holder -->
                        <div class="no-margin col-xs-12 col-sm-3 price-area">
                          <div class="right-clmn">
                            <div class="price-current"
                                 <c:if test="${pageContext.request.userPrincipal.name == null}">style="display: none"</c:if>>
                              $<span class="price${robot.productId}">${robot.price}</span>
                            </div>
                            <div class="add-cart-button">
                              <a class="cart${robot.productId} le-button"
                                 onclick="window.location.href = '/addToCart/${robot.productId}/robots'"><spring:message
                                      code="common.addToCart"/></a>
                              <%--<a class="cart${robot.productId} le-button in-cart hidden"--%>
                                 <%--onclick="removeFromCart('${robot.productId}')"><spring:message--%>
                                      <%--code="common.inCart"/></a>--%>
                            </div>
                            <div class="wish-compare">
                                  <%--<span class="wishList${robot.productId} btn-add-to-wishlist"--%>
                                        <%--onclick=""><spring:message--%>
                                          <%--code="common.addToWishList"/></span>--%>
                                  <%--<span class="wishList${robot.productId} btn-add-to-wishlist btn-green hidden"--%>
                                        <%--onclick="removeFromWishList('${robot.productId}')"><spring:message--%>
                                          <%--code="common.removeFromWishList"/></span>--%>
                              <br>
                                  <span class="compare${robot.productId} btn-add-to-compare" data-toggle="popover"
                                        onclick="window.location.href = '/addToCompare/${robot.productId}/robots'"><spring:message
                                          code="common.addToComparison"/></span>
                                  <%--<span class="compare${robot.productId} btn-add-to-compare btn-green hidden"--%>
                                        <%--data-toggle="popover"--%>
                                        <%--onclick="removeFromComparison('${robot.productId}')"><spring:message--%>
                                          <%--code="common.removeFromComparison"/></span>--%>
                            </div>
                          </div>
                        </div>
                      </div>
                    </div>
                  </c:forEach>
                </c:if>
              </div>
            </div>

            <c:if test="${empty robotsList}">
              <div class="container-fluid">
                <div class="col-lg-10 center-block items-holder">
                  <div class="inner-xs">
                    <div class="page-header">
                      <h2 class="page-title">
                        <spring:message code="hmc.noMachines"/>
                      </h2>
                    </div>
                  </div>
                </div>
              </div>
            </c:if>

            <c:if test="${!empty robotsList}">
              <c:set var="itemsPerPage" value="${itemsPerPage}"/>
              <c:set var="itemsNum" value="${itemsNum}"/>
              <div class="pagination-holder">
                <div class="row">

                  <div class="col-xs-6 text-left">
                    <ul class="pagination">
                      <c:forEach begin="1" end="${pagesNum}" var="i">
                        <li id="page${i}" onclick="showPageAndGoUp(${i});">${i}</li>
                      </c:forEach>
                    </ul>
                  </div>

                  <div class="col-xs-6">
                    <div class="result-counter">
                      <spring:message code="hmc.showing"/> <span id="showFromTo"></span> <spring:message
                            code="hmc.of"/> <span id="of"></span> <spring:message code="hmc.results"/>
                    </div>
                  </div>

                </div>
                <!-- /.row -->
              </div>
              <!-- /.pagination-holder -->
            </c:if>
          </div>
          <!-- /.tab-content -->
        </div>
        <!-- /.grid-list-products -->
      </section>
      <!-- /#hmc -->
    </div>
    <!-- /.col -->
    <!-- ========================================= CONTENT : END ========================================= -->
  </div>
  <!-- /.container -->
</section>
  <!-- /#category-grid -->
  <%@include file="insertions/footer.jsp" %>
</div>
<!-- JavaScripts placed at the end of the document so the pages load faster -->
<script src="../../resources/js/jquery-1.10.2.min.js"></script>
<script src="../../resources/js/jquery-migrate-1.2.1.js"></script>
<script src="../../resources/js/bootstrap.min.js"></script>
<script src="http://maps.google.com/maps/api/js?sensor=false&amp;language=en"></script>
<script src="../../resources/js/gmap3.min.js"></script>
<script src="../../resources/js/bootstrap-hover-dropdown.min.js"></script>
<script src="../../resources/js/owl.carousel.min.js"></script>
<script src="../../resources/js/css_browser_selector.min.js"></script>
<script src="../../resources/js/echo.min.js"></script>
<script src="../../resources/js/jquery.easing-1.3.min.js"></script>
<script src="../../resources/js/bootstrap-slider.min.js"></script>
<script src="../../resources/js/jquery.raty.min.js"></script>
<script src="../../resources/js/jquery.prettyPhoto.min.js"></script>
<script src="../../resources/js/jquery.customSelect.min.js"></script>
<script src="../../resources/js/wow.min.js"></script>
<script src="../../resources/js/scripts.js"></script>
<script src="http://w.sharethis.com/button/buttons.js"></script>
<script src="../../resources/js/comparison,wishlist,cart,common.jsp"></script>
<%--<script type="text/javascript">--%>
  <%--var checkboxesNames = ['brand','model'];--%>

  <%--var slidersNames = ['productionYear','price','xMotion','yMotion','zMotion','xTableSize','yTableSize'];--%>

  <%--var specificSlidersNames = ['productionYear','price'];--%>

  <%--// step for slider--%>
  <%--var specificSliders = {--%>
    <%--'productionYear' : 1,--%>
    <%--'price' : 500--%>
  <%--};--%>

  <%--var commonStep = 100;--%>
<%--</script>--%>
<script src="../../resources/js/filters.jsp"></script>
<%--<script type="text/javascript">--%>
  <%--// global variables, will be used in file 'filters'--%>
  <%--var slidersDefaultRange = {--%>
    <%--'productionYear': ['${yearMinMax[0]}', '${yearMinMax[1]}'],--%>
    <%--'price': ['${priceMinMax[0]}', '${priceMinMax[1]}'],--%>
    <%--'xMotion': ['${xMotionMinMax[0]}', '${xMotionMinMax[1]}'],--%>
    <%--'yMotion': ['${yMotionMinMax[0]}', '${yMotionMinMax[1]}'],--%>
    <%--'zMotion': ['${zMotionMinMax[0]}', '${zMotionMinMax[1]}'],--%>
    <%--'xTableSize': ['${xTableSizeMinMax[0]}', '${xTableSizeMinMax[1]}'],--%>
    <%--'yTableSize': ['${yTableSizeMinMax[0]}', '${yTableSizeMinMax[1]}']--%>
  <%--};--%>

  <%--var itemsNum = '${itemsNum}';--%>

  <%--$(document).ready(function () {--%>
    <%--if (sessionStorage.view == null || sessionStorage.view == "") {--%>
      <%--sessionStorage.view = 'grid';--%>
    <%--} else if (sessionStorage.view == 'list') {--%>
      <%--$('.grid-list-button-item:nth-child(2) a').tab('show')--%>
    <%--}--%>

    <%--if (sessionStorage.page == null || sessionStorage.page == "") {--%>
      <%--sessionStorage.page = '1';--%>
    <%--}--%>

    <%--if (sessionStorage.perPageUrl == null || sessionStorage.perPageUrl == "") {--%>
      <%--sessionStorage.perPageUrl = 'perPage=${itemsPerPage}';--%>
    <%--}--%>

    <%--$('#selectPerPage').change(function () {--%>
      <%--sessionStorage.perPageUrl = 'perPage=' + $(this).val().toString();--%>
      <%--goToRobots();--%>
    <%--});--%>
  <%--});--%>
<%--//</script>--%>
<script src="../../resources/js/pagination.jsp"></script>
</body>
</html>