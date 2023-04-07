package controller;


import doMainModels.MauSac;
import doMainModels.Nsx;
import doMainModels.SanPham;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.apache.commons.beanutils.BeanUtils;
import repositories.NsxRepository;
import util.CheckString;

import java.io.IOException;

@WebServlet({
        "/nsx/index", //GET
        "/nsx/create", //GET
        "/nsx/edit", //GET
        "/nsx/delete", //GET
        "/nsx/store", //POST
        "/nsx/update", //POST
})
public class NsxServlet extends HttpServlet {
    private NsxRepository nsxRepository;
    String error ;
    String errorTen;
    String errorMa;
    public NsxServlet(){
        nsxRepository = new NsxRepository();
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
        Nsx nsx1 = this.nsxRepository.findByMa(ma);
        this.nsxRepository.delete(nsx1);
        response.sendRedirect("/ASM_war_exploded/nsx/index");
    }
    protected void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("trungMa",error);
        request.setAttribute("danhSachNSX", this.nsxRepository.findAll());
        request.setAttribute("view", "/views/nsx/index.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
    }
    protected void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("trungMa",error);
        request.setAttribute("checkten", errorTen);
        request.setAttribute("checkma", errorMa);
        request.setAttribute("view","/views/nsx/create.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request,response);
    }
    protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        Nsx nsx1 = this.nsxRepository.findByMa(ma);
        request.setAttribute("checkten", errorTen);
        request.setAttribute("nsx", nsx1);
        request.setAttribute("view","/views/nsx/edit.jsp");
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
            response.sendRedirect("/ASM_war_exploded/nsx/index");
        }
    }
    protected void store(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Nsx nsx1 = new Nsx();

        try {
            BeanUtils.populate(nsx1, request.getParameterMap());
        } catch (Exception e) {
            e.printStackTrace();
        }
        errorTen = CheckString.checkValues(nsx1.getTen(),"tên");
        errorMa = CheckString.checkValues(nsx1.getMa(),"mã");
        Nsx nsx = this.nsxRepository.findByMa(nsx1.getMa());
        if (nsx!=null){
            error="Trùng mã";
            response.sendRedirect("/ASM_war_exploded/nsx/create");
            return;
        }else{
            error="";
        }
        if (!errorTen.isEmpty()||!errorMa.isEmpty()){
            response.sendRedirect("/ASM_war_exploded/nsx/create");
            return;
        }
        this.nsxRepository.insert(nsx1);

        response.sendRedirect("/ASM_war_exploded/nsx/index");
    }
    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        Nsx nsx1 = this.nsxRepository.findByMa(ma);
        try {

            BeanUtils.populate(nsx1, request.getParameterMap());
        } catch (Exception e) {
            e.printStackTrace();
        }
        errorTen = CheckString.checkValues(nsx1.getTen(),"tên");
        if (!errorTen.isEmpty()){
            response.sendRedirect("/ASM_war_exploded/nsx/edit?ma="+nsx1.getMa());
            return;
        }
        this.nsxRepository.update(nsx1);

        response.sendRedirect("/ASM_war_exploded/nsx/index");
    }
}
