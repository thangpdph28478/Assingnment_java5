<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html lang="en">
<head>
    <title>Title</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">


</head>
<body>

<br><br>

<form action="/home/hien-thi" style="float: right">
    <button class="btn btn-success" type="submit">TRANG CHU</button>
</form>


<br>

<form:form action="/hoa-don/add" method="post" modelAttribute="dulieuxem">


    <table class="table " style="border: aliceblue 1px">
        <tbody>
        <tr>
            <td> KHÁCH HÀNG:</td>
            <th>
                <form:select path="idKhachHang" items="${khachhang}" itemValue="id" itemLabel="TTKH" id="idkh">
                </form:select>

            </th>
        </tr>
        </tbody>

        <tbody>
        <tr>
            <td> NhÂN VIÊN:</td>
            <th>
                <form:select path="idNhanVien" items="${nhanvien}" itemValue="id" itemLabel="TTNV" id="idnv">
                </form:select>
            </th>
        </tr>
        </tbody>

        <tbody>
        <tr>
            <td> MÃ:</td>
            <th><form:input path="ma" id="ma"></form:input></th>
        </tr>
        </tbody>

        <tbody>
        <tr>
            <td> NGÀY TẠO:</td>
            <th><form:input path="ngayTao" id="ngaytao" type="date"></form:input></th>
        </tr>
        </tbody>

        <tbody>
        <tr>
            <td> NGÀY THANH TOÁN:</td>
            <th><form:input path="ngayThanhToan" id="ngaythanhtoan" type="date"></form:input></th>
        </tr>
        </tbody>

        <tbody>
        <tr>
            <td> NGÀY SHIP:</td>
            <th><form:input path="ngaySip" id="ngayship" type="date"></form:input></th>
        </tr>
        </tbody>

        <tbody>
        <tr>
            <td> NGÀY NhẬN:</td>
            <th><form:input path="ngayNhan" id="ngaynhan" type="date"></form:input></th>
        </tr>
        </tbody>

        <tbody>
        <tr>
            <td> TÌNH TRẠNG:</td>
            <th>
                <form:radiobutton path="tinhTrang" value="1" label="ĐÃ THANH TOÁN"></form:radiobutton>

                <br><br>
                <form:radiobutton path="tinhTrang" value="0" label="CHỜ THANH TOÁN"></form:radiobutton>

            </th>
        </tr>
        </tbody>

        <tbody>
        <tr>
            <td> TÊN NGƯỜI NHẬN:</td>
            <th><form:input path="tenNguoiNhan" id="tennguoinhan"></form:input></th>
        </tr>
        </tbody>


        <tbody>
        <tr>
            <td> ĐỊA CHỈ:</td>
            <th><form:input path="diaChi" id="diachi"></form:input></th>
        </tr>
        </tbody>

        <tbody>
        <tr>
            <td> SDT:</td>
            <th><form:input path="sdt" id="sdt" type="number"></form:input></th>
        </tr>
        </tbody>


        <tbody>

        <tr>
            <td>

                <button type="submit" style="float: right" class="btn btn-success" onclick="return kiemtrathem()"
                        id="btt">ADD
                </button>
            </td>
            <th></th>
        </tr>
        </tbody>

    </table>
</form:form>


<br><br>

<p id="kt" name="kt"></p>


<script>
    function myFunction1() {
        let text = "Bạn chắc chắn muốn xóa\n Nếu có liên kết sẽ xóa luôn dối tượng bảng khóa ngoại";
        let kt = confirm(text);
        if (kt == true) {
            confirm("Xóa thành công");
            return true;
        } else {
            return false;
        }
    }

    function myFunction2() {
        let text = "Bạn chắc chắn muốn XEM";
        let kt = confirm(text);
        if (kt == true) {
            return true
        } else {
            return false;
        }
    }

    function myFunction3() {
        let text = "Bạn chắc chắn muốn SỬA";
        let kt = confirm(text);
        if (kt == true) {
            return true
        } else {
            return false;
        }
    }

    function myFunction4() {
        let text = "Bạn chắc chắn muốn THÊM";
        let kt = confirm(text);
        if (kt == true) {
            return true
        } else {
            return false;
        }
    }
</script>


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
