<%--
  Created by IntelliJ IDEA.
  User: vuong
  Date: 3/28/2023
  Time: 9:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
  <title>Layout</title>
  <!-- Required meta tags -->
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css">
  <!-- Bootstrap CSS -->
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
        integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<div class="container-fluid">
  <header>
          <img style="height: 80px" src="/ASM_war_exploded/images/logo.png" alt=""/>
    <nav class="navbar navbar-expand-lg bg-light">
      <div class="container-fluid">
        <a class="navbar-brand" href="/ASM_war_exploded/views/layout.jsp"><i class="fa-solid fa-house"></i> Trang chủ</a>
        <a class="navbar-brand" href="/ASM_war_exploded/views/login.jsp" onclick="return confirm('Bạn có muốn đăng xuất không')"><i class="fa-solid fa-right-to-bracket"></i> Logout</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
      </div>
    </nav>

  </header>


<div class="row mt-3" style="min-height: 450px;">
  <div class="bg-warning col-3 text-center">
    <br>
    <br>
    <div class="navbar-nav">
      <a class="nav-link active" aria-current="page" href="/ASM_war_exploded/san-pham/index">Sản Phẩm</a>
      <a class="nav-link" href="/ASM_war_exploded/khach-hang/index">Khách Hàng</a>
      <a class="nav-link" href="/ASM_war_exploded/nhan-vien/index">Nhân Viên</a>
      <a class="nav-link" href="/ASM_war_exploded/nsx/index">NSX</a>
      <a class="nav-link" href="/ASM_war_exploded/mau-sac/index">Màu Sắc</a>
      <a class="nav-link" href="/ASM_war_exploded/dong-sp/index">Dòng SP</a>
      <a class="nav-link" href="/ASM_war_exploded/chuc-vu/index">Chức vụ</a>
      <a class="nav-link" href="/ASM_war_exploded/cua-hang/index">Cửa Hàng</a>
      <a class="nav-link" href="/ASM_war_exploded/chi-tiet-sp/index">Chi Tiết Sản Phẩm</a>
    </div>
  </div>
  <div class="bg-light col-9">
    <jsp:include page="${ view }" />

  </div>
</div>
<div>
  <br>
  <footer class=" text-center text-lg-start py-3 fp" style="background-color: #192041;color: white">
    <section class="">
      <div class="container text-center text-md-start mt-5">
        <div class="row mt-3">
          <div class="col-md-4 col-lg-4 col-xl-4 mx-auto mb-4">
            <h6 class="text-uppercase fw-bold mb-4">
              <img src="/ASM_war_exploded/images/logo2.png" height="90px"/>
            </h6>
          </div>

          <div class="col-md-8 col-lg-8 col-xl-8 mx-auto mb-8">
            <h6>THÔNG TIN LIÊN HỆ</h6>
            <p>VVP</p>
            <p>Điện thoại: +8433345045</p>
            <p>Email: phuocvvph23075@fpt.edu.vn</p>
          </div>
        </div>
      </div>
    </section>

    <div
            class="text-center py-4"
            style="background-color: rgba(0, 0, 0, 0.05)"
    >
      © 2023 Copyright: >phuocvvph23075@fpt.edu.vn</a
            >
    </div>
  </footer>
  </div>
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
