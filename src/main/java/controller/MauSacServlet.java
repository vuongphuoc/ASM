package controller;


import doMainModels.MauSac;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.apache.commons.beanutils.BeanUtils;
import repositories.MauSacRepository;
import util.CheckString;


import java.io.IOException;

@WebServlet({
        "/mau-sac/index", //GET
        "/mau-sac/create", //GET
        "/mau-sac/edit", //GET
        "/mau-sac/delete", //GET
        "/mau-sac/store", //POST
        "/mau-sac/update", //POST
})
public class MauSacServlet extends HttpServlet {
    private MauSacRepository mauSacRepository;
    String error ;
    String errorTen;
    String errorMa;

    public MauSacServlet() {
        mauSacRepository = new MauSacRepository();
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
        MauSac ms1 = this.mauSacRepository.findByMa(ma);
        this.mauSacRepository.delete(ms1);
        response.sendRedirect("/ASM_war_exploded/mau-sac/index");
    }
    protected void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("trungMa",error);
        request.setAttribute("danhSachMS", this.mauSacRepository.findAll());
        request.setAttribute("view", "/views/mau_sac/index.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
    }
    protected void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("trungMa",error);
        request.setAttribute("checkten", errorTen);
        request.setAttribute("checkma", errorMa);
        request.setAttribute("view","/views/mau_sac/create.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request,response);
    }
    protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        MauSac ms1 = this.mauSacRepository.findByMa(ma);
        request.setAttribute("checkten", errorTen);
        request.setAttribute("ms", ms1);
        request.setAttribute("view","/views/mau_sac/edit.jsp");
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
            response.sendRedirect("/ASM_war_exploded/mau-sac/index");
        }
    }
    protected void store(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MauSac ms1 = new MauSac();
        try {
            BeanUtils.populate(ms1, request.getParameterMap());
        } catch (Exception e) {
            e.printStackTrace();
        }
        errorTen = CheckString.checkValues(ms1.getTen(),"tên");
        errorMa = CheckString.checkValues(ms1.getMa(),"mã");
        MauSac ms = this.mauSacRepository.findByMa(ms1.getMa());
        if (ms!=null){
            error="Trùng mã";
            response.sendRedirect("/ASM_war_exploded/mau-sac/create");
            return;
        }else{
            error="";
        }

        if (!errorTen.isEmpty()||!errorMa.isEmpty()){
            response.sendRedirect("/ASM_war_exploded/mau-sac/create");
            return;
        }
        this.mauSacRepository.insert(ms1);

        response.sendRedirect("/ASM_war_exploded/mau-sac/index");
    }
    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        MauSac ms1 = this.mauSacRepository.findByMa(ma);
        try {
            BeanUtils.populate(ms1, request.getParameterMap());

        } catch (Exception e) {
            e.printStackTrace();
        }
        errorTen = CheckString.checkValues(ms1.getTen(),"tên");
        if (!errorTen.isEmpty()){
            response.sendRedirect("/ASM_war_exploded/mau-sac/edit?ma="+ms1.getMa());
            return;
        }
        this.mauSacRepository.update(ms1);
        response.sendRedirect("/ASM_war_exploded/mau-sac/index");
    }
}
