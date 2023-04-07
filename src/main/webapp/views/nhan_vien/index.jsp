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
<h3 style="text-align: center;"> Danh Sách Nhân Viên</h3>
<div class="row">
    <div class="col-6">
        <a href="create" class="btn btn-success">Thêm mới</a>
    </div>
</div>
<c:if test="${ f:length(danhSachNV) == 0 }">
    <h3 class="alert alert-warning">Không có dữ liệu</h3>
</c:if>
<c:if test="${ f:length(danhSachNV) != 0 }">

    <table class="table table-striped mt-3">
        <thead class="table-primary">
        <tr>
            <th>Mã</th>
            <th>Tên</th>
            <th>Tên đệm</th>
            <th>Họ</th>
            <th>Giới tính</th>
            <th>Ngày sinh</th>
            <th>Địa chỉ</th>
            <th>Sđt</th>
            <th>Mật khẩu</th>
            <th>IdCH</th>
            <th>IdCV</th>
            <th>Trạng thái</th>

            <th colspan="2">Thao tác</th>
        </tr>
        </thead>
        <tbody>

        <c:forEach items="${ danhSachNV }" var="nv">

            <tr>
                <td>${ nv.ma }</td>
                <td>${ nv.ten }</td>
                <td>${ nv.tenDem }</td>
                <td>${ nv.ho }</td>
                <td>${ nv.gioiTinh }</td>
                <td>${ nv.ngaySinh }</td>
                <td>${ nv.diaChi }</td>
                <td>${ nv.sdt }</td>
                <td>${ nv.matKhau }</td>
                <td>${nv.ch.ten}</td>
                <td>${nv.cv.ten}</td>
                <td>${ nv.trangThai == 0 ?"Đang làm":"Đã nghỉ" }</td>
                <td>
                    <a href="edit?ma=${nv.ma}" class="btn btn-primary">Cập nhật</a>
                </td>
                <td>
                    <a href="delete?ma=${nv.ma}" class="btn btn-danger">Xóa</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</c:if>

