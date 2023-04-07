package controller;

import doMainModels.MauSac;
import doMainModels.SanPham;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.apache.commons.beanutils.BeanUtils;
import repositories.SanPhamRepository;
import util.CheckString;

import java.io.IOException;

@WebServlet({
        "/san-pham/index", //GET
        "/san-pham/create", //GET
        "/san-pham/edit", //GET
        "/san-pham/delete", //GET
        "/san-pham/store", //POST
        "/san-pham/update", //POST
})
public class SanPhamServlet extends HttpServlet {

    private SanPhamRepository  sanPhamRepository;
    String error ;
    String errorTen;
    String errorMa;
    public SanPhamServlet() {
        sanPhamRepository = new SanPhamRepository();
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
        SanPham sp1 = this.sanPhamRepository.findByMa(ma);
        this.sanPhamRepository.delete(sp1);
        response.sendRedirect("/ASM_war_exploded/san-pham/index");
    }
    protected void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("trungMa",error);
        request.setAttribute("danhSachSP", this.sanPhamRepository.findAll());
        request.setAttribute("view", "/views/san_pham/index.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
    }
    protected void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("trungMa",error);
        request.setAttribute("checkten", errorTen);
        request.setAttribute("checkma", errorMa);
        request.setAttribute("view","/views/san_pham/create.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request,response);
    }
    protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        SanPham sp1 = this.sanPhamRepository.findByMa(ma);
        request.setAttribute("checkten", errorTen);
        request.setAttribute("sp", sp1);
        request.setAttribute("view","/views/san_pham/edit.jsp");
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
            response.sendRedirect("/ASM_war_exploded/san-pham/index");
        }
    }
    protected void store(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SanPham sp1 = new SanPham();
        try {
            BeanUtils.populate(sp1, request.getParameterMap());
        } catch (Exception e) {
            e.printStackTrace();
        }
        errorTen = CheckString.checkValues(sp1.getTen(),"tên");
        errorMa = CheckString.checkValues(sp1.getMa(),"mã");
        SanPham sp = this.sanPhamRepository.findByMa(sp1.getMa());
        if (sp!=null){
            error="Trùng mã";
            response.sendRedirect("/ASM_war_exploded/san-pham/create");
            return;
        }else{
            error="";
        }

        if (!errorTen.isEmpty()||!errorMa.isEmpty()){
            response.sendRedirect("/ASM_war_exploded/san-pham/create");
            return;
        }
        this.sanPhamRepository.insert(sp1);

        response.sendRedirect("/ASM_war_exploded/san-pham/index");
    }
    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        SanPham sp1 = this.sanPhamRepository.findByMa(ma);
        try {
            BeanUtils.populate(sp1, request.getParameterMap());
        } catch (Exception e) {
            e.printStackTrace();
        }
        errorTen = CheckString.checkValues(sp1.getTen(),"tên");
        if (!errorTen.isEmpty()){
            response.sendRedirect("/ASM_war_exploded/san-pham/edit?ma="+sp1.getMa());
            return;
        }
        this.sanPhamRepository.update(sp1);

        response.sendRedirect("/ASM_war_exploded/san-pham/index");
    }
}
