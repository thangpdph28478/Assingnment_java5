<%--
  Created by IntelliJ IDEA.
  User: PHAM DAC THANG
  Date: 4/4/2023
  Time: 7:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"

          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <!--  -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.9/angular.min.js"></script>
    <style>
        a {

            text-decoration:none;
        }
        .thanh1>a {
            margin: 19px;
            font-size: 18px;
            color: rgb(118, 113, 113);
            text-decoration:none;
        }

        .thanh1>a:hover {
            color: rgb(0, 0, 0);
            /* text-decoration:none;  */
            box-sizing: border-box;
            text-decoration:none;

        }
        .btmuangay>a {
            margin: 19px;
            font-size: 18px;
            color: rgb(255, 255, 255);

        }

        .btmuangay>a:hover {
            color: rgb(255, 255, 255);
            text-decoration:none;
            box-sizing: border-box;

        }
        .dssp>a {

            color: #000;
            text-decoration:none;
        }

        .dssp>a:hover {

            text-decoration: none;

            color: #000;
        }
    </style>
</head>


<body>

<DIV STYLE="text-align: center;font-size: 50px"> TRANG CHỦ ASM JAVA 5</DIV>

<br><br>




<table class="table " style="border: white 5px;width:80%;margin-left:15% ">
    <tbody>
    <tr>
        <td>

            <a href="/san-pham/hien-thi" class="btn btn-success">Trang sản phẩm</a>

        </td>
        <th>
            <a href="/mau-sac/hien-thi" class="btn btn-success">Trang màu sắc</a>

        </th>
        <th>
            <a class="btn btn-success" href="/dong-sp/hien-thi">Trang dòng sản phẩm</a>
        </th>


        <th>
            <a href="/NSX/hien-thi" class="btn btn-success">Trang nơi sản xuất</a>
        </th>

        <th>

            <a href="/khach-hang/hien-thi" class="btn btn-success">Trang khách hàng</a>
        </th>


    </tr>
    </tbody>



    <tr ></tr>
    <tbody>
    <tr>
        <td>

            <a class="btn btn-success" href="/chi-tiet-sp/hien-thi">Trang chi tiết sản phẩm</a>
        </td>
        <th>
            <a class="btn btn-success" href="/cua-hang/hien-thi">Trang cửa hàng</a>

        </th>
        <th>
            <a class="btn btn-success" href="/chuc-vu/hien-thi">Trang chức vụ</a>

        </th>
        <th>
            <a class="btn btn-success" href="/nhan-vien/hien-thi">Trang nhân viên</a>

        </th>
        <th>

            <a class="btn btn-success" href="/home/gio-hang">Giỏ hàng của khách</a>

        </th>
    </tr>
    </tbody>


    <tr ></tr>
    <tbody>
    <tr>
        <td>
            <a href="/gio-hang/hien-thi" class="btn btn-success">Trang giỏ hàng</a>

        </td>
        <th>
            <a class="btn btn-success" href="/gio-hang-chi-tiet/hien-thi">Trang giỏ hàng chi tiết</a>

        </th>
        <th>
            <a class="btn btn-success" href="/hoa-don/hien-thi">Trang hóa đơn</a>

        </th>
        <th>
            <a class="btn btn-success" href="/hoa-don-chi-tiet/hien-thi">Trang hóa dơn chi tiết</a>

        </th>
        <th>
            <a class="btn btn-success" href="/ban-hang-tai-quay/hien-thi">Bán hàng tại quầy</a>

        </th>
    </tr>
    </tbody>
</table>





<div class="container px-4 px-lg-5 mt-5">
    <div class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-6 row-cols-xl-5 justify-content-center">

        <c:forEach items="${dulieu}" var="ht" varStatus="stt">

        <div

                style="width: 22.5%; height: 9cm;float: right;border: 2px solid rgb(216, 208, 208);margin-right: 2%;  "   class="col mb-5"   ng-repeat="chay in chay">
            <div class="dssp">

                <div style="width: 100%; height: 4.5cm;background: rgb(247, 244, 244);">
                    <img src="	https://cdn.pnj.io/images/image-update/tag-product/new-icon-3-w29.svg" alt=""
                         style="width: 36px; height:35px;float: right;margin-right: 10px;">

                    <img
                            src="{{chay.image}}"
                            alt="" style="width: 100%; height:100%;">
                </div>
                <div style="width: 100%; height: 1cm;background: rgb(247, 244, 244);">
                    <img src="https://cdn.pnj.io/images/image-update/tag-product/icon-tragop-2.svg" alt=""
                         style="width: 31px; height:35px;float: right;margin-right: 10px;">
                    <img src="https://cdn.pnj.io/images/image-update/2022/10/pnjfast/PNJfast-Giaotrong3h.svg" alt=""
                         style="width: 45px; height:28px;margin-left: 10px;">
                </div>
                <div style="width: 100%; height: 3.5cm;text-align: center;">
                    <br>
                    <p>${ht.idSp.ten}</p>
                    <p>Mã: ${ht.idSp.ma}-${ht.soLuongTon}</p>

                    <p style="font-size: 16px;color: #fc0101;">${ht.giaBan} VND</p>

                    <form action="/home/xemchitietsanpham" method="post">
                         <input value="${ht.id}"  name="idcthd"  style="display: none">
                        <button  class="btn btn-secondary"  name="ten" id="ten" type="submit"   style="width: 3cm;">Xem chi tiết </button>


                    </form>
                </div>

            </div>
        </div>
        </c:forEach>
    </div></div>

<nav aria-label="Page navigation example">
    <ul class="pagination justify-content-center pagination-lg">
        <li class="page-item"><a class="page-link" href="/home/hien-thi?pageNum=0">First</a></li>

        <c:forEach begin="1" end="${total}" varStatus="status">
            <li class="page-item">
                <a href="${pageContext.request.contextPath}/home/hien-thi?pageNum=${status.index -1}"
                   class="page-link">${status.index}</a>
            </li>
        </c:forEach>

        <li class="page-item"><a class="page-link" href="/home/hien-thi?pageNum=${total-1}">Last</a></li>
    </ul>
</nav>

<script src="/src/main/webapp/WEB-INF/views/j.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
        integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.min.js"
        integrity="sha384-mQ93GR66B00ZXjt0YO5KlohRA5SY2XofN4zfuZxLkoj1gXtW8ANNCe9d5Y3eG5eD"
        crossorigin="anonymous"></script>
</body>
</html>
