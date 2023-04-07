<%--
  Created by IntelliJ IDEA.
  User: vuong
  Date: 3/28/2023
  Time: 10:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="f" uri="jakarta.tags.functions" %>
<!doctype html>
<html lang="en">
<head>
    <title>Index NSX</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<%--<div class="col-8 offset-2 mt-5 table-responsive">--%>
<h3 style="text-align: center;"> Danh Sách NSX</h3>
<div class="row">
    <div class="col-6">
        <a href="create" class="btn btn-success">Thêm mới</a>
    </div>
</div>
<c:if test="${ f:length(danhSachNSX) == 0 }">
    <h3 class="alert alert-warning">Không có dữ liệu</h3>
</c:if>
<c:if test="${ f:length(danhSachNSX) != 0 }">
    <table class="table table-striped mt-3">
        <thead class="table-primary">
        <tr>
            <th>Mã</th>
            <th>Tên</th>

            <th colspan="2">Thao tác</th>
        </tr>
        </thead>
        <tbody>

        <c:forEach items="${ danhSachNSX }" var="nsx">
            <tr>
                <td>${ nsx.ma }</td>
                <td>${ nsx.ten }</td>

                <td>
                    <a href="/ASM_war_exploded/nsx/edit?ma=${nsx.ma}" class="btn btn-primary">Cập nhật</a>
                </td>
                <td>
                    <a href="/ASM_war_exploded/nsx/delete?ma=${nsx.ma}" class="btn btn-danger">Xóa</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</c:if>
<%--</div>--%>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
</body>
</html>
