package controller;


import doMainModels.ChucVu;
import doMainModels.CuaHang;
import doMainModels.NhanVien;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.apache.commons.beanutils.BeanUtils;
import repositories.ChucVuRepository;
import repositories.CuaHangRepository;
import repositories.NhanVienRepository;
import view_model.QLNhanVien;

import javax.xml.crypto.Data;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@WebServlet({
        "/nhan-vien/index", //GET
        "/nhan-vien/create", //GET
        "/nhan-vien/edit", //GET
        "/nhan-vien/delete", //GET
        "/nhan-vien/store", //POST
        "/nhan-vien/update", //POST

})
public class NhanVienServlet extends HttpServlet {
    private ChucVuRepository chucVuRepository;

    private NhanVienRepository nhanVienRepository;

    private CuaHangRepository cuaHangRepository;


    public NhanVienServlet() {
        nhanVienRepository = new NhanVienRepository();
        chucVuRepository = new ChucVuRepository();
        cuaHangRepository = new CuaHangRepository();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("create")) {
            this.create(request, response);
        } else if (uri.contains("edit")) {
            this.edit(request, response);
        } else if (uri.contains("delete")) {
            this.delete(request, response);
        } else {
            this.index(request, response);
        }
    }

    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        NhanVien nv1 = this.nhanVienRepository.findByMa(ma);
        this.nhanVienRepository.delete(nv1);
        response.sendRedirect("/ASM_war_exploded/nhan-vien/index");
    }

    protected void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("danhSachNV", this.nhanVienRepository.findAll());
        request.setAttribute("danhSachCV", this.chucVuRepository.findAll());
        request.setAttribute("danhSachCH", this.cuaHangRepository.findAll());
        request.setAttribute("view", "/views/nhan_vien/index.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
    }

    protected void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("danhSachCV", this.chucVuRepository.findAll());
        request.setAttribute("danhSachCH", this.cuaHangRepository.findAll());
        request.setAttribute("view", "/views/nhan_vien/create.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
    }

    protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("danhSachCV", this.chucVuRepository.findAll());
        request.setAttribute("danhSachCH", this.cuaHangRepository.findAll());
        String ma = request.getParameter("ma");
        NhanVien nv1 = this.nhanVienRepository.findByMa(ma);
        request.setAttribute("nv", nv1);
        request.setAttribute("view", "/views/nhan_vien/edit.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("store")) {
            this.store(request, response);
        } else if (uri.contains("update")) {
            this.update(request, response);
        } else {
            response.sendRedirect("/ASM_war_exploded/nhan-vien/index");
        }
    }

    protected void store(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//        try {
//            NhanVien nv1 = new NhanVien();
//            BeanUtils.populate(nv1, request.getParameterMap());
//            this.nhanVienRepository.insert(nv1);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        response.sendRedirect("/ASM_war_exploded/nhan-vien/index");
        HttpSession session = request.getSession();
        String ma = request.getParameter("ma");
        String ten = request.getParameter("ten");
        String tenDem = request.getParameter("tenDem");
        String ho = request.getParameter("ho");
        Date ngaySinh = Date.valueOf(request.getParameter("ngaySinh")) ;
        String sdt = request.getParameter("sdt");
        String diaChi = request.getParameter("diaChi");
        String matKhau = request.getParameter("matKhau");
        String cuaHang = request.getParameter("cuaHang");
        String chucVu = request.getParameter("chucVu");
        String trangThai = request.getParameter("trangThai");
        String gioiTinh = request.getParameter("gioiTinh");
        if (ma.isEmpty()) {
            session.setAttribute("errMessNV", "Ma Empty");
            response.sendRedirect("/ASM_war_exploded/nhan-vien/create");
        } else {
            new NhanVienRepository().insert(NhanVien.builder().ma(ma).ten(ten).tenDem(tenDem).ho(ho).ngaySinh(ngaySinh).sdt(sdt).diaChi(diaChi).matKhau(matKhau).ch(CuaHang.builder().id(UUID.fromString(cuaHang)).build())
                    .cv((ChucVu.builder().id(UUID.fromString(chucVu)).build())).trangThai(Integer.parseInt(trangThai)).gioiTinh(gioiTinh).build());
            response.sendRedirect("/ASM_war_exploded/nhan-vien/index");
        }
    }

    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//
//        try {
//            String ma = request.getParameter("ma");
//            NhanVien nv1 = this.nhanVienRepository.findByMa(ma);
//            BeanUtils.populate(nv1, request.getParameterMap());
//            this.nhanVienRepository.update(nv1);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        response.sendRedirect("/ASM_war_exploded/nhan-vien/index");
//    }

        String ma = request.getParameter("ma");
        NhanVien domainNV = this.nhanVienRepository.findByMa(ma);
        String ten = request.getParameter("ten");
        String tenDem = request.getParameter("tenDem");
        String ho = request.getParameter("ho");
        Date ngaySinh = Date.valueOf(request.getParameter("ngaySinh"));
        String sdt = request.getParameter("sdt");
        String diaChi = request.getParameter("diaChi");
        String matKhau = request.getParameter("matKhau");
        String cuaHang = request.getParameter("cuaHang");
        String chucVu = request.getParameter("chucVu");
        String trangThai = request.getParameter("trangThai");
        String gioiTinh = request.getParameter("gioiTinh");

        try {
            BeanUtils.populate(domainNV, request.getParameterMap());
            this.nhanVienRepository.update(NhanVien.builder()
                    .id(domainNV.getId())
                    .ma(ma)
                    .ten(ten)
                    .tenDem(tenDem)
                    .ho(ho)
                    .ngaySinh(ngaySinh)
                    .sdt(sdt)
                    .diaChi(diaChi)
                    .matKhau(matKhau)
                    .ch(CuaHang.builder().id(UUID.fromString(cuaHang)).build())
                    .cv((ChucVu.builder().id(UUID.fromString(chucVu)).build()))
                    .trangThai(Integer.parseInt(trangThai))
                    .gioiTinh(gioiTinh)
                    .build());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        response.sendRedirect("/ASM_war_exploded/nhan-vien/index");
    }

}
