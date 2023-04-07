package filters;

import doMainModels.NhanVien;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


import java.io.IOException;
import java.util.logging.LogRecord;

@WebFilter({
        "/nhan-vien/*",
        "/khach-hang/*",
        "/mau-sac/*",
        "/san-pham/*",
        "/dong-sp/*",
        "/nsx/*",
        "/chi-tiet-sp/*",
        "/chuc-vu/*",
        "/cua-hang/*",

})
public class AuthenFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse res = (HttpServletResponse) servletResponse;
        HttpSession session = req.getSession();
        NhanVien nv = (NhanVien) session.getAttribute("nv");
        if (nv == null) {
            res.sendRedirect("/ASM_war_exploded/login");
        } else {
            filterChain.doFilter(req, res);
        }
    }
}
