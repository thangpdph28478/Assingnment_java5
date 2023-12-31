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


<a class="btn btn-success" href="/home/dat-hang" onclick="return myFunction4()">DAT HANG</a>


<br><br>
<table class="table table-bordered border-primary">
    <thead>
    <tr>
        <th scope="col">#</th>
        <th scope="col">GIO HANG</th>
        <th scope="col">KHACH HANG</th>
        <th scope="col">SAN PHAM</th>
        <th scope="col">SỐ LƯỢNG</th>
        <th scope="col">DON GIA</th>
        <th scope="col">DON GIA KHI GIAM</th>




        <th scope="col">UPDATE</th>
        <th scope="col">DELETE</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${dulieu}" var="ht" varStatus="stt">
        <tr>
            <td>${stt.index}</td>
            <th>${ht.id.idGioHang.ma} </th>
            <th>${ht.id.idGioHang.idKhachHang.ho} ${ht.id.idGioHang.idKhachHang.tenDem} ${ht.id.idGioHang.idKhachHang.ten} </th>
            <th>${ht.id.idChiTietSP.idSp.ma}-${ht.id.idChiTietSP.idSp.ten} </th>
            <form action="/home/updatectgh" method="post">
            <th><input value="${ht.soluong}" name="slcud" type="number"></th>
            <td>${ht.donGia}</td>
            <td>${ht.donGiaKhiGiam}</td>



            <td>



                   <input name="idctsp" value="${ht.id.idChiTietSP.id}" style="display: none">
<button type="submit"   class="btn btn-success">UPDATE</button>
                </form>

            </td>

            <td>
                <form action="/home/delete" method="post">

                    <input name="idctsp" value="${ht.id.idChiTietSP.id}" style="display: none">
                    <button type="submit"   class="btn btn-success">DELETE</button>
                </form >






        </tr>
    </c:forEach>
    </tbody>
</table>

<%--<nav aria-label="Page navigation example">--%>
<%--    <ul class="pagination justify-content-center pagination-lg">--%>
<%--        <li class="page-item"><a class="page-link" href="/gio-hang-chi-tiet/hien-thi?pageNum=0">First</a></li>--%>

<%--        <c:forEach begin="1" end="${total}" varStatus="status">--%>
<%--            <li class="page-item">--%>
<%--                <a href="${pageContext.request.contextPath}/gio-hang-chi-tiet/hien-thi?pageNum=${status.index -1}"--%>
<%--                   class="page-link">${status.index}</a>--%>
<%--            </li>--%>
<%--        </c:forEach>--%>

<%--        <li class="page-item"><a class="page-link" href="/gio-hang-chi-tiet/hien-thi?pageNum=${total-1}">Last</a></li>--%>
<%--    </ul>--%>
<%--</nav>--%>

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
