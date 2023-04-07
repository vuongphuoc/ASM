package controller;


import doMainModels.KhachHang;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.apache.commons.beanutils.BeanUtils;
import repositories.KhachHangRepository;

import java.io.IOException;

@WebServlet({
        "/khach-hang/index", //GET
        "/khach-hang/create", //GET
        "/khach-hang/edit", //GET
        "/khach-hang/delete", //GET
        "/khach-hang/store", //POST
        "/khach-hang/update", //POST
})
public class KhachHangServlet extends HttpServlet {
    private KhachHangRepository khachHangRepository;

    public KhachHangServlet() {
        khachHangRepository = new KhachHangRepository();
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
        KhachHang kh1 = this.khachHangRepository.findByMa(ma);
        this.khachHangRepository.delete(kh1);
        response.sendRedirect("/ASM_war_exploded/khach-hang/index");
    }
    protected void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("danhSachKH", this.khachHangRepository.findAll());
        request.setAttribute("view", "/views/khach_hang/index.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
    }
    protected void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("view","/views/khach_hang/create.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request,response);
    }
    protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        KhachHang kh1 = this.khachHangRepository.findByMa(ma);
        request.setAttribute("kh", kh1);
        request.setAttribute("view","/views/khach_hang/edit.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("store")) {
            this.store(request, response);
        } else if (uri.contains("update")) {
            this.update(request, response);
        } else {
            response.sendRedirect("/ASM_war_exploded/khach-hang/index");
        }
    }
    protected void store(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            KhachHang kh1 = new KhachHang();
            BeanUtils.populate(kh1, request.getParameterMap());
            this.khachHangRepository.insert(kh1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("/ASM_war_exploded/khach-hang/index");
    }
    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String ma = request.getParameter("ma");
            KhachHang kh1 = this.khachHangRepository.findByMa(ma);
            BeanUtils.populate(kh1, request.getParameterMap());
            this.khachHangRepository.update(kh1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("/ASM_war_exploded/khach-hang/index");
    }
}
