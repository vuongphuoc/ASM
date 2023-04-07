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
<h3 style="text-align: center;"> Danh Sách Màu Sắc</h3>
<div class="row">
    <div class="col-6">
        <a href="create" class="btn btn-success">Thêm mới</a>
    </div>
</div>
<c:if test="${ f:length(danhSachMS) == 0 }">
    <h3 class="alert alert-warning">Không có dữ liệu</h3>
</c:if>
<c:if test="${ f:length(danhSachMS) != 0 }">
    <table class="table table-striped mt-3">
        <thead class="table-primary">
        <tr>
            <th>Mã</th>
            <th>Tên</th>

            <th colspan="2">Thao tác</th>
        </tr>
        </thead>
        <tbody>

        <c:forEach items="${ danhSachMS }" var="ms">
            <tr>
                <td>${ ms.ma }</td>
                <td>${ ms.ten }</td>

                <td>
                    <a href="/ASM_war_exploded/mau-sac/edit?ma=${ms.ma}" class="btn btn-primary">Cập nhật</a>
                </td>
                <td>
                    <a href="/ASM_war_exploded/mau-sac/delete?ma=${ms.ma}" class="btn btn-danger">Xóa</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</c:if>
