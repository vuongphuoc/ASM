package controller;


import doMainModels.CuaHang;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.apache.commons.beanutils.BeanUtils;
import repositories.CuaHangRepository;

import java.io.IOException;

@WebServlet({
        "/cua-hang/index", //GET
        "/cua-hang/create", //GET
        "/cua-hang/edit", //GET
        "/cua-hang/delete", //GET
        "/cua-hang/store", //POST
        "/cua-hang/update", //POST
})
public class CuaHangServlet extends HttpServlet {
    private CuaHangRepository cuaHangRepository;

    public CuaHangServlet(){
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
            index(request,response);
        }
    }
    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        CuaHang ch1 = this.cuaHangRepository.findByMa(ma);
        this.cuaHangRepository.delete(ch1);
        response.sendRedirect("/ASM_war_exploded/cua-hang/index");
    }
    protected void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("danhSachCH", this.cuaHangRepository.findAll());
        request.setAttribute("view", "/views/cua_hang/index.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
    }
    protected void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("view","/views/cua_hang/create.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request,response);
    }
    protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        CuaHang ch1 = this.cuaHangRepository.findByMa(ma);
        request.setAttribute("ch", ch1);
        request.setAttribute("view","/views/cua_hang/edit.jsp");
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
            response.sendRedirect("/ASM_war_exploded/cua-hang/index");
        }
    }
    protected void store(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            CuaHang ch1 = new CuaHang();
            BeanUtils.populate(ch1, request.getParameterMap());
            this.cuaHangRepository.insert(ch1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("/ASM_war_exploded/cua-hang/index");
    }
    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String ma = request.getParameter("ma");
            CuaHang ch1 = this.cuaHangRepository.findByMa(ma);
            BeanUtils.populate(ch1, request.getParameterMap());
            this.cuaHangRepository.update(ch1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("/ASM_war_exploded/cua-hang/index");
    }
}
