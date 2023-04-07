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
<h3 style="text-align: center;"> Danh Sách Chi Tiết Sản Phẩm</h3>
<div class="row">
    <div class="col-6">
        <a href="create" class="btn btn-success">Thêm mới</a>
    </div>
</div>
<c:if test="${ f:length(danhSachCTSP) == 0 }">
    <h3 class="alert alert-warning">Không có dữ liệu</h3>
</c:if>
<c:if test="${ f:length(danhSachCTSP) != 0 }">
    <table class="table table-striped mt-3">
        <thead class="table-primary">
        <tr>
            <th>IDSP</th>
            <th>IDNSX</th>
            <th>ID Màu Sắc</th>
            <th>Id Dòng Sản Phẩm</th>
            <th>Năm BH </th>
            <th>Mô tả</th>
            <th>Số lượng tồn</th>
            <th>Giá nhập </th>
            <th>Giá bán</th>

            <th colspan="2">Thao tác</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${ danhSachCTSP }" var="ctsp">
            <tr>
                <td>${ ctsp.sp.ten }</td>
                <td>${ ctsp.nsx.ten }</td>
                <td>${ ctsp.ms.ten }</td>
                <td>${ ctsp.dsp.ten }</td>
                <td>${ ctsp.namBH }</td>
                <td>${ ctsp.moTa }</td>
                <td>${ ctsp.soLuongTon }</td>
                <td>${ ctsp.giaNhap }</td>
                <td>${ ctsp.giaBan }</td>
                <td>
                    <a class="btn btn-primary"
                       href="/ASM_war_exploded/chi-tiet-sp/edit?id=${ ctsp.id }">
                        Cập nhật
                    </a>
                </td>
                <td>
                    <a class="btn btn-danger"
                       href="/ASM_war_exploded/chi-tiet-sp/delete?id=${ ctsp.id }">
                        Xóa
                    </a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</c:if>
