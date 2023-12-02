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


<form:form action="/NSX/add" method="post" modelAttribute="dulieuxem">


    <table class="table " style="border: aliceblue 1px">
        <tbody>
        <tr>
            <td> Mã:</td>
            <th>
                <form:input path="ma" id="mat"></form:input>

            </th>
        </tr>
        </tbody>

        <tbody>
        <tr>
            <td> Tên:</td>
            <th><form:input path="ten" id="tent"></form:input></th>
        </tr>
        </tbody>



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


<script>

    function kiemtrathem() {
        var ma = document.getElementById("mat").value;
        var ten = document.getElementById("tent").value;

        var tendem = document.getElementById("tendemt").value;
        var ho = document.getElementById("hot").value;

        var ngaysinh = document.getElementById("ngaysinht").value;
        var sdt = document.getElementById("sdtt").value;

        var diachi = document.getElementById("diachit").value;

        var matkhau = document.getElementById("matkhaut").value;

        var cuahang1 = document.getElementById("idcht").value;
        var chucvu1 = document.getElementById("idcvt").value;


        let kt = confirm("BẠN CHẮC MUỐN THÊM");
        if (kt == false) {
            document.getElementById("btt").type = "reset";
            return true;
        } else {

            if (ma.trim() === '' || ten.trim() === '' ||
                tendem.trim() === '' || ho.trim() === '' ||
                ngaysinh.trim() === '' || sdt.trim() === '' ||
                diachi.trim() === '' || matkhau.trim() === ''
                || cuahang1.trim() === '' || chucvu1.trim() === ''
            ) {
                confirm("Không để trống");
                document.getElementById("btt").type = "reset";
                return true;
            } else {
                let ktt = 1;
                <%--                <c:forEach items="${tbt}" var="vt">--%>


                <%--                if ("${vt.ma}" == ma) {--%>
                <%--                    ktt = 0;--%>
                <%--                }--%>
                <%--                </c:forEach>--%>


                if (ktt == 0) {
                    document.getElementById("btt").type = "reset";
                    confirm("Mã đã tồn tại");
                    return true;
                } else {

                    if (laSoNguyenDuong(sdt) == false) {
                        document.getElementById("btt").type = "reset";
                        confirm("SDT chi ghi 0-9");
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
