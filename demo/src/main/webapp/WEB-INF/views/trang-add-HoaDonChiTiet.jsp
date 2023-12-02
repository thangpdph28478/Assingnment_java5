<%--
  Created by IntelliJ IDEA.
  User: PHAM DAC THANG
  Date: 4/4/2023
  Time: 6:14 PM
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
</head>
<body>

<br><br>

<form action="/home/hien-thi" style="float: right">
    <button class="btn btn-success" type="submit">TRANG CHU</button>
</form>
<br><br>

<%--/${dulieuxem.id}--%>
<form:form action="/hoa-don-chi-tiet/add" method="post" modelAttribute="dulieuxem">


    <table class="table " style="border: aliceblue 1px">

        <tbody>
        <tr>
            <td>MÃ HÓA ĐƠN:</td>
            <th>


                <form:select path="id.idHoadon" items="${hoadon}" itemValue="id" itemLabel="ma" id="idhd"
                             disabled="false">
                </form:select>
                </select>
            </th>
        </tr>
        </tbody>

        <tbody>

        <tr>
            <td> CHI TIẾT SẢN PHẨM:</td>
            <th>
                <form:select path="id.idChiTietSP" items="${chitietsanpham}" itemValue="id" itemLabel="CTSP"
                             id="idctsp">
                </form:select>

            </th>
        </tr>
        </tbody>
        <tbody>
        <tr>
            <td> SỐ LƯỢNG:</td>
            <th><form:input path="soluong" id="sl" type="number"></form:input></th>
        </tr>
        </tbody>


        <tbody>
        <tr>
            <td> ĐƠN GIÁ:</td>
            <th><form:input path="donGia" id="dg" type="number"></form:input></th>
        </tr>
        </tbody>


        <tbody>
        <tr>
            <td>
                    <%--                onclick="return kiemtrathem()"--%>
                <button type="submit" style="float: right" class="btn btn-success" onclick="return kiemtrathem()"
                        id="btt">ADD
                </button>
            </td>
            <th></th>
        </tr>
        </tbody>

    </table>
</form:form>


<script>

    function kiemtrathem() {
        var idhd = document.getElementById("idhd").value;
        var idctsp = document.getElementById("idctsp").value;

        var sl = document.getElementById("sl").value;
        var dg = document.getElementById("dg").value;


        let kt = confirm("BẠN CHẮC MUỐN THÊM");
        if (kt == false) {
            document.getElementById("btt").type = "reset";
            return true;
        } else {

            if (idhd.trim() === '' || idctsp.trim() === '' ||
                sl.trim() === '' || dg.trim() === ''
            ) {
                confirm("Không để trống");
                document.getElementById("btt").type = "reset";
                return true;
            } else {
                let ktt = 1;
                <c:forEach items="${tbt}" var="vt">


                if ("${vt.id.idHoadon.id}" == idhd && "${vt.id.idChiTietSP.id}" == idctsp) {
                    ktt = 0;
                }
                </c:forEach>


                if (ktt == 0) {
                    document.getElementById("btt").type = "reset";
                    confirm("Mã đã tồn tại");
                    return true;
                } else {

                    if (laSoNguyenDuong(sl) == false || laSoNguyenDuong(dg) == false) {
                        document.getElementById("btt").type = "reset";
                        confirm("Số Lượng và Đơn Giá >=0");
                        return true;


                    } else {
                        document.getElementById("btt").type = "submit";
                        confirm("Thêm thành công");

                        return true;
                    }


                }

            }
        }
    }


    function laSoNguyenDuong(kt) {

        return (kt >= 0 && kt % 1 == 0);

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
