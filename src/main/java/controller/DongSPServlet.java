package controller;

import doMainModels.DongSP;
import doMainModels.MauSac;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.apache.commons.beanutils.BeanUtils;
import repositories.DongSPRepository;
import util.CheckString;

import java.io.IOException;

@WebServlet({
        "/dong-sp/index", //GET
        "/dong-sp/create", //GET
        "/dong-sp/edit", //GET
        "/dong-sp/delete", //GET
        "/dong-sp/store", //POST
        "/dong-sp/update", //POST
})
public class DongSPServlet extends HttpServlet {
    private DongSPRepository dongSPRepository;
    String error ;
    String errorTen;
    String errorMa;
    public DongSPServlet(){
        dongSPRepository  = new DongSPRepository();
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
        DongSP dsp1 = this.dongSPRepository.findByMa(ma);
        this.dongSPRepository.delete(dsp1);
        response.sendRedirect("/ASM_war_exploded/dong-sp/index");
    }
    protected void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("trungMa",error);
        request.setAttribute("danhSachDSP", this.dongSPRepository.findAll());
        request.setAttribute("view", "/views/dong_sp/index.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
    }
    protected void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("trungMa",error);
        request.setAttribute("checkten", errorTen);
        request.setAttribute("checkma", errorMa);
        request.setAttribute("view","/views/dong_sp/create.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request,response);
    }
    protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        DongSP dsp1 = this.dongSPRepository.findByMa(ma);
        request.setAttribute("checkten", errorTen);
        request.setAttribute("dsp", dsp1);
        request.setAttribute("view","/views/dong_sp/edit.jsp");
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
            response.sendRedirect("/ASM_war_exploded/dong-sp/index");
        }
    }
    protected void store(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DongSP dsp1 = new DongSP();

        try {
            BeanUtils.populate(dsp1, request.getParameterMap());
        } catch (Exception e) {
            e.printStackTrace();
        }
        errorTen = CheckString.checkValues(dsp1.getTen(),"tên");
        errorMa = CheckString.checkValues(dsp1.getMa(),"mã");
        DongSP dsp = this.dongSPRepository.findByMa(dsp1.getMa());
        if (dsp!=null){
            error="Trùng mã";
            response.sendRedirect("/ASM_war_exploded/dong-sp/create");
            return;
        }else{
            error="";
        }

        if (!errorTen.isEmpty()||!errorMa.isEmpty()){
            response.sendRedirect("/ASM_war_exploded/dong-sp/create");
            return;
        }
        this.dongSPRepository.insert(dsp1);
        response.sendRedirect("/ASM_war_exploded/dong-sp/index");
    }
    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        DongSP dsp1 = this.dongSPRepository.findByMa(ma);
        try {
            BeanUtils.populate(dsp1, request.getParameterMap());
        } catch (Exception e) {
            e.printStackTrace();
        }
        errorTen = CheckString.checkValues(dsp1.getTen(),"tên");
        if (!errorTen.isEmpty()){
            response.sendRedirect("/ASM_war_exploded/dong-sp/edit?ma="+dsp1.getMa());
            return;
        }
        this.dongSPRepository.update(dsp1);

        response.sendRedirect("/ASM_war_exploded/dong-sp/index");
    }
}
