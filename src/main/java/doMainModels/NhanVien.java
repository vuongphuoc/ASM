package doMainModels;

import jakarta.persistence.*;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.sql.Date;
import java.util.Calendar;

import java.util.UUID;
@Getter
@Setter
@Builder
@Entity
@Table(name = "NhanVien")
public class NhanVien {
//    @Id
//    @Column(name = "Id")
//    @GeneratedValue(strategy = GenerationType.UUID)
//

    @Id
    @GenericGenerator(name = "generator", strategy = "guid", parameters = {})
    @GeneratedValue(generator = "generator")
    @Column(name = "Id",columnDefinition="uniqueidentifier")
    private String id;

    @Column(name = "Ma")
    private String ma;

    @Column(name = "Ten")
    private String ten;

    @Column(name = "TenDem")
    private String tenDem;

    @Column(name = "Ho")
    private String ho;

    @Column(name = "GioiTinh")
    private String gioiTinh;

    @Column(name = "NgaySinh")
    private Date ngaySinh;

    @Column(name = "DiaChi")
    private String diaChi;
    @Column(name = "Sdt")
    private String sdt;
    @Column(name = "MatKhau")
    private String matKhau;
    @ManyToOne()
    @JoinColumn(name="IdCH", referencedColumnName = "Id",
            nullable = false)
    private CuaHang ch;
    @ManyToOne()
    @JoinColumn(name ="IdCV", referencedColumnName = "Id",
            nullable = false)
    private ChucVu cv;
    @Column(name = "IdGuiBC")
    private UUID idGuiBC;
    @Column(name = "TrangThai")
    private Integer trangThai;

    public NhanVien() {
    }

    public NhanVien(String id, String ma, String ten, String tenDem, String ho, String gioiTinh, java.sql.Date ngaySinh, String diaChi, String sdt, String matKhau, CuaHang ch, ChucVu cv, UUID idGuiBC, Integer trangThai) {
        this.id = id;
        this.ma = ma;
        this.ten = ten;
        this.tenDem = tenDem;
        this.ho = ho;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.diaChi = diaChi;
        this.sdt = sdt;
        this.matKhau = matKhau;
        this.ch = ch;
        this.cv = cv;
        this.idGuiBC = idGuiBC;
        this.trangThai = trangThai;

    }

//    public String getId() {
//        return id;
//    }
//
//    public void setId(String id) {
//        this.id = id;
//    }
//
//    public String getMa() {
//        return ma;
//    }
//
//    public void setMa(String ma) {
//        this.ma = ma;
//    }
//
//    public String getTen() {
//        return ten;
//    }
//
//    public void setTen(String ten) {
//        this.ten = ten;
//    }
//
//    public String getTenDem() {
//        return tenDem;
//    }
//
//    public void setTenDem(String tenDem) {
//        this.tenDem = tenDem;
//    }
//
//    public String getHo() {
//        return ho;
//    }
//
//    public void setHo(String ho) {
//        this.ho = ho;
//    }
//
//    public String getGioiTinh() {
//        return gioiTinh;
//    }
//
//    public void setGioiTinh(String gioiTinh) {
//        this.gioiTinh = gioiTinh;
//    }
//
//    public Date getNgaySinh() {
//        return ngaySinh;
//    }
//
//    public void setNgaySinh(Date ngaySinh) {
//        this.ngaySinh = ngaySinh;
//    }
//
//    public String getDiaChi() {
//        return diaChi;
//    }
//
//    public void setDiaChi(String diaChi) {
//        this.diaChi = diaChi;
//    }
//
//    public String getSdt() {
//        return sdt;
//    }
//
//    public void setSdt(String sdt) {
//        this.sdt = sdt;
//    }
//
//    public String getMatKhau() {
//        return matKhau;
//    }
//
//    public void setMatKhau(String matKhau) {
//        this.matKhau = matKhau;
//    }
//
//    public CuaHang getCh() {
//        return ch;
//    }
//
//    public void setCh(CuaHang ch) {
//        this.ch = ch;
//    }
//
//    public ChucVu getCv() {
//        return cv;
//    }
//
//    public void setCv(ChucVu cv) {
//        this.cv = cv;
//    }
//
//    public UUID getIdGuiBC() {
//        return idGuiBC;
//    }
//
//    public void setIdGuiBC(UUID idGuiBC) {
//        this.idGuiBC = idGuiBC;
//    }
//
//    public Integer getTrangThai() {
//        return trangThai;
//    }
//
//    public void setTrangThai(Integer trangThai) {
//        this.trangThai = trangThai;
//    }
}
