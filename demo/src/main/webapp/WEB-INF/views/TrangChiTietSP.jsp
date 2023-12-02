<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="shortcut icon" href="https://cdn.pnj.io/images/image-update/favicon/pnj-icon.ico" type="image/x-icon">
    <title> CÔNG TY TRANG SỨC PHẠM ĐẮC THẮNG</title>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <!--  -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.9/angular.min.js"></script>
    <!--  -->
    <script src="xemchitiet.js"></script>
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
<body   ng-app="web207" ng-controller="web207-ctrl">


<form action="/home/hien-thi" style="float: right" method="post">
    <button class="btn btn-success" type="submit">TRANG CHU</button>
</form>


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
            <a class="btn btn-success" href="/ban-hang-online/hien-thi">Ban Hang online</a>

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


<br>

<!-- thân -->

<div style="width: 80%;margin-left: 10%;height: 32cm;border: 2px solid rgb(255, 255, 255)"       >
    <div style="text-align:center ;margin-top: 0.5cm;">  <p>Trang chủ/Nhẫn/Nhẫn vàng PNJ/  ${dulieu.idSp.ten}</p></div>

    <div style="float: right; width: 40%;border: 2px solid rgb(255, 255, 255);">
        <p style="font-size: 25px;color:  #4c4c4c;">${dulieu.idSp.ten}</p>
        <p>Mã: ${dulieu.idSp.ma}-${dulieu.id}</p>
        <p style="font-size: 30px;color:  #ff0000;">${dulieu.giaBan} VND</p>
        <p>Chọn kích cỡ</p>
        <div style="font-size: 20px;">
            <input type="radio" style="border: 3px solid #797a7b;border-radius: 5px;font-size: 20px;"  name="vt1">   10
            <input type="radio" for="" style="border: 3px solid #797a7b;border-radius: 5px;font-size: 20px;"  name="vt1">15
            <input type="radio" for="" style="border: 3px solid #797a7b;border-radius: 5px;font-size: 20px;"   name="vt1">20
        </div>
        <br><br>
        <p>CÒN HÀNG:  ${dulieu.soLuongTon}</p>
        <br>
        <div style="border: 2px solid #003468;border-radius: 5px;">
            <div style="background: rgb(222, 227, 227);border-radius: 5px;">
                <p>-Ưu đãi :</p>
            </div>
            <p>+Cơ hội nhận ngay chuyến du lịch 10tr dành cho cặp đôi khi mua hóa đơn online từ 5tr. <a href="">Xem chi tiết</a> </p>
            <p>+Giảm đến 600K khi thanh toán qua <a href="">  HSBC</a></p>
        </div>
        <br>
        <form action="/home/gio-hang" method="post">
            <input name="idctsp"  value="${dulieu.id}" style="display: none">
        <button  class="btmuangay"style="width: 100%;height: 1.5cm; border-radius: 5px;font-size: 25px;color: white; text-align: center;background: #7c0101;">
           MUA NGAY
                <p style=" font-size: 10px;color: white;">Miễn phí giao hàng tận nhà hoặc của hàng</p>  <br>
        </button>
        </form>
        <br><br>
        <button style="float: right;width: 49%;height: 1cm;color: white;background: #003468;border-radius: 5px;">
            <p>67 của hàng còn hàng</p>
        </button>

        <button  style="width: 49%;height: 1cm;color: white;background: #003468;border-radius: 5px;">
            Mua Trả góp <br>
            chỉ từ 888.888đ/tháng</button>
        <br><br>
        <p style="text-align: center;color:#003468 ;font-size: 15px;">Gọi ngay HOtline  <img src="https://cdn.pnj.io/images/image-update/2023/hotline/phone_in_talk.svg" alt=""style="width: 24px;height: 24px;"> 1800545457 1800 5454 57 (8:00 AM - 21:00 PM)

            Tư vấn miễn phí • Nhận ưu đãi độc quyền</p>
        <p style="color:#003468 ;">+Giá sản phẩm thay đổi tuỳ trọng lượng vàng và đá<br>

            + Đổi sản phẩm trong 48h tại hệ thống cửa hàng PNJ <br>

            + Miễn phí giao nhanh Toàn Quốc 1-7 ngày, xem thêm Chính sách giao hàng</p>
    </div>


    <div style="float: right; width: 46%;margin-right: 1%;border: 2px solid rgb(167, 164, 164);border-radius: 5px;height: 18cm;">
        <a href="">  <img src="{{chay.image}}" alt="" style="width: 100%;height: 100%;"></a>
    </div>
    <div style=" width: 12%;border: 2px solid rgb(255, 255, 255);height: 100%;border-radius: 5px;height: 18cm;">
        <a href="">   <img src="{{chay.image}}" alt="" style="width: 100%;border: 2px solid rgb(167, 164, 164);border-radius: 5px;height: 2cm;"></a> <br><br>
        <a href="">   <img src="{{chay.image}}" alt="" style="width: 100%;border: 2px solid rgb(167, 164, 164);border-radius: 5px;height: 2cm;"></a> <br><br>
        <a href="">   <img src="{{chay.image}}" alt="" style="width: 100%;border: 2px solid rgb(167, 164, 164);border-radius: 5px;height: 2cm;"></a>
    </div>
    <br><br>
    <div style="border: 1px solid rgb(213, 213, 213);">
        <p style="font-size: 20px ;color:#003468  ;margin-left: 20px;">THÔNG SỐ MÔ TẢ</p> <hr>
        <p style="color:#003468  ;margin-left: 20px;">Trọng lượng tham khảo:  <br>
            10.74287kg <br><br>

            Loại đá chính:
            Ruby  <br><br>

            Loại đá phụ:
            Mix đá  <br><br>

            Thương hiệu:
            PNJ  <br><br>

            Giới tính:
            Nữ  <br>
            Được chế tác từ vàng 18K cùng vẻ đẹp huyền bí của viên đá Ruby, PNJ mang đến sản phẩm nhẫn sang trọng và quyến rũ dành cho phái nữ. Đá Ruby sở hữu vẻ quyến rũ, khi được cộng hưởng ánh sắc của dãy đá trắng lấp lánh, hài hòa theo từng đường nét thiết kế đã tạo nên một món trang sức đẹp mê hồn.  <br><br>

            Đặc biệt hơn, một chiếc nhẫn đính đá Ruby thuận theo phong thủy sẽ mang lại may mắn cũng như nguồn năng lượng tích cực. Và người sở hữu trang sức Ruby không chỉ có được những năng lượng tốt này mà cuộc sống sẽ ngày càng khởi sắc.</p>
        <HR></HR>
    </div>
</div>
<!-- ////////// -->

<
<div
        style="height: 87px;font-size: 40px;border: 1px solid rgb(255, 255, 255);text-align: center;background: #000000;color: white;">
    <img src="	https://cdn.pnj.io/images/logo/pnj.com.vn.png" alt="" style="width: 200px;height: 87px;">
    PH28478
</div>
</body>
</html>