<%--
  Created by IntelliJ IDEA.
  User: vuong
  Date: 3/28/2023
  Time: 10:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="f" uri="jakarta.tags.functions" %>
<h3 style="text-align: center;"> Danh Sách Khách Hàng</h3>
<div class="row">
    <div class="col-6">
        <a href="/ASM_war_exploded/khach-hang/create" class="btn btn-success">Thêm mới</a>
    </div>
</div>
<c:if test="${ f:length(danhSachKH) == 0 }">
    <h3 class="alert alert-warning">Không có dữ liệu</h3>
</c:if>
<c:if test="${ f:length(danhSachKH) != 0 }">
    <table class="table table-striped mt-3">
        <thead class="table-primary">
        <tr>
                <%--                    <th>ID</th>--%>
            <th>Mã</th>
            <th>Tên</th>
            <th>Tên đệm</th>
            <th>Họ </th>
            <th>Ngày Sinh</th>
            <th>Số điện thoại</th>
            <th>Địa chỉ</th>
            <th>Thành phố</th>
            <th>Quốc gia</th>
            <th>Mật khẩu</th>
            <th colspan="2">Thao tác</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${ danhSachKH }" var="kh">
            <tr>
                <td>${ kh.ma }</td>
                <td>${ kh.ten }</td>
                <td>${ kh.tenDem }</td>
                <td>${ kh.ho }</td>
                <td>${ kh.ngaySinh }</td>
                <td>${ kh.sdt }</td>
                <td>${ kh.diaChi }</td>
                <td>${ kh.thanhPho}</td>
                <td>${ kh.quocGia}</td>
                <td>${ kh.matKhau}</td>
                <td>
                    <a class="btn btn-primary"
                       href="/ASM_war_exploded/khach-hang/edit?ma=${ kh.ma }">
                        Cập nhật
                    </a>
                </td>
                <td>
                    <a class="btn btn-danger"
                       href="/ASM_war_exploded/khach-hang/delete?ma=${ kh.ma }">
                        Xóa
                    </a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</c:if>