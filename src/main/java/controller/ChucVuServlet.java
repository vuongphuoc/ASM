package controller;


import doMainModels.ChucVu;
import doMainModels.MauSac;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.apache.commons.beanutils.BeanUtils;
import repositories.ChucVuRepository;
import util.CheckString;

import java.io.IOException;
import java.util.UUID;

@WebServlet({
        "/chuc-vu/index", //GET
        "/chuc-vu/create", //GET
        "/chuc-vu/edit", //GET
        "/chuc-vu/delete", //GET
        "/chuc-vu/store", //POST
        "/chuc-vu/update", //POST
})
public class ChucVuServlet extends HttpServlet {
    private ChucVuRepository chucVuRepository;
    String error ;
    String errorTen;
    String errorMa;
    public ChucVuServlet(){
        chucVuRepository = new ChucVuRepository();
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
        ChucVu cv1 = this.chucVuRepository.findByMa(ma);
        this.chucVuRepository.delete(cv1);
        response.sendRedirect("/ASM_war_exploded/chuc-vu/index");
    }
    protected void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("trungMa",error);
        request.setAttribute("danhSachCV", this.chucVuRepository.findAll());
        request.setAttribute("view", "/views/chuc_vu/index.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
    }
    protected void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("trungMa",error);
        request.setAttribute("checkten", errorTen);
        request.setAttribute("checkma", errorMa);
        request.setAttribute("view","/views/chuc_vu/create.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request,response);
    }
    protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        ChucVu cv1 = this.chucVuRepository.findByMa(ma);
        request.setAttribute("checkten", errorTen);
        request.setAttribute("cv", cv1);
        request.setAttribute("view","/views/chuc_vu/edit.jsp");
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
            response.sendRedirect("/ASM_war_exploded/chuc-vu/index");
        }
    }
    protected void store(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ChucVu cv1 = new ChucVu();
        try {
            BeanUtils.populate(cv1, request.getParameterMap());
        } catch (Exception e) {
            e.printStackTrace();
        }
        errorTen = CheckString.checkValues(cv1.getTen(),"tên");
        errorMa = CheckString.checkValues(cv1.getMa(),"mã");
        ChucVu cv = this.chucVuRepository.findByMa(cv1.getMa());
        if (cv!=null){
            error="Trùng mã";
            response.sendRedirect("/ASM_war_exploded/chuc-vu/create");
            return;
        }else{
            error="";
        }

        if (!errorTen.isEmpty()||!errorMa.isEmpty()){
            response.sendRedirect("/ASM_war_exploded/chuc-vu/create");
            return;
        }
        this.chucVuRepository.insert(cv1);

        response.sendRedirect("/ASM_war_exploded/chuc-vu/index");
    }
    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        ChucVu cv1 = this.chucVuRepository.findByMa(ma);
        try {
            BeanUtils.populate(cv1, request.getParameterMap());
        } catch (Exception e) {
            e.printStackTrace();
        }
        errorTen = CheckString.checkValues(cv1.getTen(),"tên");
        if (!errorTen.isEmpty()){
            response.sendRedirect("/ASM_war_exploded/chuc-vu/edit?ma="+cv1.getMa());
            return;
        }
        this.chucVuRepository.update(cv1);

        response.sendRedirect("/ASM_war_exploded/chuc-vu/index");
    }
}
