package controller;

import doMainModels.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.apache.commons.beanutils.BeanUtils;
import repositories.*;

import java.io.IOException;
import java.sql.Date;
import java.util.UUID;

@WebServlet({
        "/chi-tiet-sp/index", //GET
        "/chi-tiet-sp/create", //GET
        "/chi-tiet-sp/edit", //GET
        "/chi-tiet-sp/delete", //GET
        "/chi-tiet-sp/store", //POST
        "/chi-tiet-sp/update", //POST
})
public class ChiTietSPServlet extends HttpServlet {
    private ChiTietSPRepository chietSPRepository;
    private SanPhamRepository sanPhamRepository;
    private NsxRepository nsxRepository;
    private MauSacRepository mauSacRepository;
    private DongSPRepository dongSPRepository;

    public ChiTietSPServlet() {
        chietSPRepository = new ChiTietSPRepository();
        sanPhamRepository = new SanPhamRepository();
        nsxRepository = new NsxRepository();
        dongSPRepository = new DongSPRepository();
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
        String id = request.getParameter("id") ;
        ChiTietSP ctsp1 = this.chietSPRepository.findByID(id);
        this.chietSPRepository.delete(ctsp1);
        response.sendRedirect("/ASM_war_exploded/chi-tiet-sp/index");
    }

    protected void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("danhSachCTSP", this.chietSPRepository.findAll());
        request.setAttribute("view", "/views/chi_tiet_sp/index.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
    }

    protected void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("danhSachSP", this.sanPhamRepository.findAll());
        request.setAttribute("danhSachDSP", this.dongSPRepository.findAll());
        request.setAttribute("danhSachMS", this.mauSacRepository.findAll());
        request.setAttribute("danhSachNSX", this.nsxRepository.findAll());
        request.setAttribute("view", "/views/chi_tiet_sp/create.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
    }

    protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("danhSachSP", this.sanPhamRepository.findAll());
        request.setAttribute("danhSachDSP", this.dongSPRepository.findAll());
        request.setAttribute("danhSachMS", this.mauSacRepository.findAll());
        request.setAttribute("danhSachNSX", this.nsxRepository.findAll());
        String id = request.getParameter("id") ;
        ChiTietSP ctsp1 = this.chietSPRepository.findByID(id);
        request.setAttribute("ctsp", ctsp1);
        request.setAttribute("view","/views/chi_tiet_sp/edit.jsp");
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
            response.sendRedirect("/ASM_war_exploded/chi-tiet-sp/index");
        }
    }

    protected void store(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ChiTietSP  ctsp1 = new ChiTietSP();
        try {
            BeanUtils.populate(ctsp1, request.getParameterMap());
//            this.chietSPRepository.insert(ctsp1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String idsanPham = request.getParameter("idsanPham");
        String idMauSac = request.getParameter("idMauSac");
        String idNsx = request.getParameter("idNsx");
        String idDongSP = request.getParameter("idDongSP");
        UUID idSP1 = UUID.fromString(idsanPham);
        UUID idMS1 = UUID.fromString(idMauSac);
        UUID idNSX1 = UUID.fromString(idNsx);
        UUID idDSP1 = UUID.fromString(idDongSP);
        SanPham sanPham = sanPhamRepository.findById(idSP1);
        MauSac mauSac = mauSacRepository.findById(idMS1);
        Nsx nsx = nsxRepository.findById(idNSX1);
        DongSP dongSP = dongSPRepository.findById(idDSP1);
        ctsp1.setSp(sanPham);
        ctsp1.setMs(mauSac);
        ctsp1.setNsx(nsx);
        ctsp1.setDsp(dongSP);
        chietSPRepository.insert(ctsp1);
        response.sendRedirect("/ASM_war_exploded/chi-tiet-sp/index");

    }

    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id") ;
        ChiTietSP ctsp1 = this.chietSPRepository.findByID(id);
        try {
            BeanUtils.populate(ctsp1, request.getParameterMap());
            this.chietSPRepository.update(ctsp1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String idsanPham = request.getParameter("idsanPham");
        String idMauSac = request.getParameter("idMauSac");
        String idNsx = request.getParameter("idNsx");
        String idDongSP = request.getParameter("idDongSP");
        UUID idSP1 = UUID.fromString(idsanPham);
        UUID idMS1 = UUID.fromString(idMauSac);
        UUID idNSX1 = UUID.fromString(idNsx);
        UUID idDSP1 = UUID.fromString(idDongSP);
        SanPham sanPham = sanPhamRepository.findById(idSP1);
        MauSac mauSac = mauSacRepository.findById(idMS1);
        Nsx nsx = nsxRepository.findById(idNSX1);
        DongSP dongSP = dongSPRepository.findById(idDSP1);
        ctsp1.setSp(sanPham);
        ctsp1.setMs(mauSac);
        ctsp1.setNsx(nsx);
        ctsp1.setDsp(dongSP);
        chietSPRepository.update(ctsp1);
        response.sendRedirect("/ASM_war_exploded/chi-tiet-sp/index");
    }
}

