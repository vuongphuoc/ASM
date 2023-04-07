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
    <title>Cập nhật Nhân Viên</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<div class="col-8 offset-2">
    <form method="POST"
          action="/ASM_war_exploded/nhan-vien/update?ma=${nv.ma}">
        <center><h1>Cập nhật Nhân Viên</h1></center>
        <div class="row mt-3">
            <div class="col-6">
                <label>Mã</label>
                <input type="text" name="ma" class="form-control" value="${nv.ma}" disabled />
            </div>
            <div class="col-6">
                <label>Tên</label>
                <input type="text" name="ten" class="form-control"value="${nv.ten}" />
            </div>
        </div>
        <div class="row mt-3">
            <div class="col-6">
                <label>Tên đệm</label>
                <input type="text" name="tenDem" class="form-control"value="${nv.tenDem}" />
            </div>
            <div class="col-6">
                <label>Họ</label>
                <input type="text" name="ho" class="form-control"value="${nv.ho}" />
            </div>
        </div>
        <div class="row mt-3">
            <div class="col-6">
                <label>Giới tính</label> </br>
                <input type="radio" name="gioiTinh" value="true"
                ${nv.gioiTinh == true ? "checked" : "" }/>Nam
                <input type="radio" name="gioiTinh"
                       value="false" ${nv.gioiTinh == false ? "checked" : "" }/>Nữ
            </div>
            <div class="col-6">
                <label>Ngày Sinh</label>
                <input type="date" name="ngaySinh" class="form-control" value="${nv.ngaySinh}"/>
            </div>
        </div>
        <div class="row mt-3">
            <div class="col-6">
                <label>Địa chỉ</label>
                <input type="text" name="diaChi" class="form-control" value="${nv.diaChi}"/>
            </div>
            <div class="col-6">
                <label>Sdt</label>
                <input type="tel" name="sdt" class="form-control"value="${nv.sdt}" />
            </div>
        </div>

        <div class="row mt-3">
            <div class="col-6">
                <label>IDCH</label> </br>
                <select name="cuaHang" class="form-control" >
                    <c:forEach items="${ danhSachCH }" var="ch1" >
                        <option ${nv.ch.id == ch1.id ? "selected" :""} value="${ch1.id}">${ch1.ten}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="col-6">
                <label>IDCV</label> </br>
                <select name="chucVu" class="form-control">
                    <c:forEach items="${ danhSachCV }" var="cv1" >
                        <option ${nv.cv.id == cv1.id ? "selected" :""} value="${cv1.id}">${cv1.ten}</option>
                    </c:forEach>
                </select>
            </div>


            <div class="col-6">
                <label>Mật khẩu</label>
                <input type="password" name="matKhau" class="form-control"value="${nv.matKhau}" />
            </div>
            <div class="col-6">
                <label>Trạng Thái</label>
                <select name="trangThai" class="form-control" required />
                <option value="0" ${nv.trangThai == "0"?"selected":""}>Đang làm</option>
                <option value="1" ${nv.trangThai == "1"?"selected":""}>Đã nghỉ</option>
                </select>
            </div>
        </div>
        <div class="row mt-3">
            <div class="col-6">
                <button class="btn btn-primary">Cập nhật Nhân Viên</button>
            </div>
            <div class="col-6"></div>
        </div>
    </form>
</div>
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
