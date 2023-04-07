<%--
  Created by IntelliJ IDEA.
  User: vuong
  Date: 3/28/2023
  Time: 10:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="f" uri="jakarta.tags.functions" %>
<!doctype html>
<html lang="en">
<head>
    <title>Chi Tiết Sản Phẩm</title>
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
          action="/ASM_war_exploded/chi-tiet-sp/update?id=${ctsp.id}">
        <center><h1>Cập Nhật Chi Tiết Sản Phẩm</h1></center>
        <div class="row mt-3">
            <div class="col-6">
                <label>IDSP</label>
                <select name="idsanPham" class="form-control">
                    <c:forEach items="${ danhSachSP }" var="sp">
                        <option ${ctsp.sp.id == sp.id ? "selected" :""} value="${sp.id}">${sp.ten}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="col-6">
                <label>IDNSX</label>
                <select name="idNsx" class="form-control">
                    <c:forEach items="${ danhSachNSX }" var="nsx">
                        <option ${ctsp.nsx.id == nsx.id ? "selected" :""} value="${nsx.id}">${nsx.ten}</option>
                    </c:forEach>
                </select>
            </div>
        </div>
            <div class="row mt-3">
                <div class="col-6">
                    <label>ID Màu Sắc</label>
                    <select name="idMauSac" class="form-control">
                        <c:forEach items="${ danhSachMS }" var="ms">
                            <option ${ctsp.ms.id == ms.id ? "selected" :""} value="${ms.id}">${ms.ten}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="col-6">
                    <label>Id Dòng Sản Phẩm</label>
                    <select name="idDongSP" class="form-control">
                        <c:forEach items="${ danhSachDSP }" var="dsp">
                            <option ${ctsp.dsp.id == dsp.id ? "selected" :""} value="${dsp.id}">${dsp.ten}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>
            <div class="row mt-3">
                <div class="col-6">
                    <label>Năm BH</label>
                    <input type="text" name="namBH" class="form-control" value="${ctsp.namBH}"/>
                </div>
                <div class="col-6">
                    <label>Mô tả</label>
                    <input type="text" name="moTa" class="form-control" value="${ctsp.moTa}" required></input>
                </div>
            </div>
            <div class="row mt-3">
                <div class="col-6">
                    <label>Số Lượng Tồn</label>
                    <input type="text" name="soLuongTon" class="form-control" value="${ctsp.soLuongTon}"/>
                </div>
                <div class="col-6">
                    <label>Giá nhập</label>
                    <input type="text" name="giaNhap" class="form-control" value="${ctsp.giaNhap}"/>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <center><label>Giá Bán</label></center>
                    <input type="text" name="giaBan" class="form-control" value="${ctsp.giaBan}"/>
                </div>
            </div>
            <div class="row mt-3">
                <div class="col-6">
                    <button class="btn btn-primary">Cập Nhật</button>
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
