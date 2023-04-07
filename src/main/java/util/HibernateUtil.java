package util;

import doMainModels.*;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.util.List;
import java.util.Properties;

public class HibernateUtil {
    private static final SessionFactory FACTORY;

    static {
        Configuration conf = new Configuration();

        Properties properties = new Properties();
        properties.put(Environment.DIALECT, "org.hibernate.dialect.SQLServerDialect");
        properties.put(Environment.DRIVER, "com.microsoft.sqlserver.jdbc.SQLServerDriver");
        properties.put(Environment.URL, "jdbc:sqlserver://localhost:1433;databaseName=FINALASS_FPOLYSHOP_FA22_SOF205__SOF2041");
        properties.put(Environment.USER, "sa");
        properties.put(Environment.PASS, "123456");
        properties.put(Environment.SHOW_SQL, "true");
//        properties.put(Environment.HBM2DDL_AUTO, "create"); // bỏ tự động tạo table: none

        conf.setProperties(properties);
        conf.addAnnotatedClass(ChiTietSP.class);
        conf.addAnnotatedClass(SanPham.class);
        conf.addAnnotatedClass(MauSac.class);
        conf.addAnnotatedClass(Nsx.class);
        conf.addAnnotatedClass(DongSP.class);
        conf.addAnnotatedClass(ChucVu.class);
        conf.addAnnotatedClass(CuaHang.class);
        conf.addAnnotatedClass(KhachHang.class);
        conf.addAnnotatedClass(NhanVien.class);
//        conf.addAnnotatedClass(HoaDon.class);
//        conf.addAnnotatedClass(GioHang.class);
//        conf.addAnnotatedClass(GioHangChiTiet.class);
//        conf.addAnnotatedClass(HoaDonChiTiet.class);

        ServiceRegistry registry = new StandardServiceRegistryBuilder()
                .applySettings(conf.getProperties()).build();
        FACTORY = conf.buildSessionFactory(registry);

    }

    public static SessionFactory getFACTORY() {
        return FACTORY;
    }

    public static void main(String[] args) {
//        System.out.println(getFACTORY());
        Session hSession = getFACTORY().openSession();
        String hql  = "select cvObj from ChucVu cvObj where cvObj.ma =?1";
        TypedQuery<ChucVu> query = hSession.createQuery(hql,ChucVu.class);
        query.setParameter(1,"ch1");
        ChucVu cv = query.getSingleResult();
        System.out.println(cv.getTen());

        List<NhanVien> dsNV = cv.getListNV();
        NhanVien nv = dsNV.get(0);
        System.out.println(nv.getHo()+ " " +nv.getTenDem()+ " " +nv.getTen());

    }
}
