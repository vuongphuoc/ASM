<%--
  Created by IntelliJ IDEA.
  User: vuong
  Date: 4/4/2023
  Time: 3:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" session="true" %>
<%--<div class="alert alert-danger">${ errorMessage }</div>--%>
<%--<form method="post" action="/ASM_war_exploded/login">--%>
<%--    <div class="mt-3">--%>
<%--        <label>Mã</label>--%>
<%--        <input type="text" name="ma" class="form-control" />--%>
<%--    </div>--%>
<%--    <div class="mt-3">--%>
<%--        <label>Mật khẩu</label>--%>
<%--        <input type="password" name="matKhau" class="form-control" />--%>
<%--    </div>--%>
<%--    <div class="mt-3">--%>
<%--        <button class="btn btn-primary">Đăng nhập</button>--%>
<%--    </div>--%>
<%--</form>--%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="f" uri="jakarta.tags.functions" %>
<!doctype html>
<html lang="en">
<head>
    <title>Title</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<form method="post" action="/ASM_war_exploded/login">
    <br>
    <center>
        <h1>Đăng Nhập</h1>
    </center>
    <br>
    <div class="row">
        <div class="col-3">
        </div>
        <div class="col-3">
            <label>Mã</label>
            <input type="text" name="ma" class="form-control" />
        </div>
        <div class="col-3">
            <label>Mật khẩu</label>
            <input type="password" name="matKhau" class="form-control" />
        </div>
        <div class="col-3">
        </div>
    </div>
    <br>
    <div class="row">
        <div class="col-3">
        </div>
        <div class="col-6">
            <c:if test="${f:contains(errorMessage,'Sai tài khoản hoặc mật khẩu') == true }">
                <div class="alert alert-danger">${ errorMessage }</div>
            </c:if>
        </div>
        <div class="col-3">
        </div>
    </div>
    <div class="row">
        <div class="col-3">
        </div>
        <div class="col-6">
            <button class="btn btn-primary">Đăng nhập</button>

        </div>
        <div class="col-3">
        </div>
    </div>

</form>
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


