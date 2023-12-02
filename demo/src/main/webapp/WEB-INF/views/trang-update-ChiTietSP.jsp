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

<form:form action="/chi-tiet-sp/update/${dulieuxem.id}" method="post" modelAttribute="dulieuxem">


    <table class="table " style="border: aliceblue 1px">
        <tbody>
        <tr>
            <td> SAN PHAM:</td>
            <th>
                <form:select path="idSp" items="${sanpham}" itemValue="id" itemLabel="ten" id="idkh">
                </form:select>

            </th>
        </tr>
        </tbody>

        <tbody>
        <tr>
            <td> NOI SAN XUAT:</td>
            <th>
                <form:select path="idNsx" items="${noisanxuat}" itemValue="id" itemLabel="ten" id="idkh">
                </form:select>

            </th>
        </tr>
        </tbody>

        <tbody>
        <tr>
            <td> MAU SAC:</td>
            <th>
                <form:select path="idMauSac" items="${mausac}" itemValue="id" itemLabel="ten" id="idkh">
                </form:select>

            </th>
        </tr>
        </tbody>



        <tbody>
        <tr>
            <td> DONG SAN PHAM:</td>
            <th>
                <form:select path="idDongSp" items="${dongsanpham}" itemValue="id" itemLabel="ten" id="idnv">
                </form:select>
            </th>
        </tr>
        </tbody>

        <tbody>
        <tr>
            <td> NAM BAO HANH:</td>
            <th><form:input path="namBaoHang" id="ma"></form:input></th>
        </tr>
        </tbody>

        <tbody>
        <tr>
            <td> MO TA:</td>
            <th><form:input path="moTa" id="ngaytao" ></form:input></th>
        </tr>
        </tbody>

        <tbody>
        <tr>
            <td> SO LUONG TON:</td>
            <th><form:input path="soLuongTon" id="ngaythanhtoan" ></form:input></th>
        </tr>
        </tbody>

        <tbody>
        <tr>
            <td> GIA NHAP:</td>
            <th><form:input path="giaNhap" id="ngayship" ></form:input></th>
        </tr>
        </tbody>

        <tbody>
        <tr>
            <td> GIA BAN:</td>
            <th><form:input path="giaBan" id="ngaynhan" ></form:input></th>
        </tr>
        </tbody>




        <tbody>

        <tr>
            <td>

                <button type="submit" style="float: right" class="btn btn-success" onclick="return kiemtrathem()"
                        id="btt">UPDATE
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
