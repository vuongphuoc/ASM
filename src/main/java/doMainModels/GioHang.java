package doMainModels;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.UUID;

@Entity
@Table(name = "GioHang")
public class GioHang {
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "IdKH")
    private String idKH;
    @Column(name = "IdNV")
    private String idNV;
    @Column(name = "Ma")
    private String ma;
    @Column(name = "NgayTao")
    private Date ngayTao;
    @Column(name = "NgayThanhToan")
    private Date ngayThanhToan;
    @Column(name = "TenNguoiNhan")
    private String tenNguoiNhan;
    @Column(name = "Sdt")
    private String sdt;

    @Column(name = "TinhTrang")
    private Integer tinhTrang;

    public GioHang() {
    }

    public GioHang(UUID id, String idKH, String idNV, String ma, Date ngayTao, Date ngayThanhToan, String tenNguoiNhan, String sdt, Integer tinhTrang) {
        this.id = id;
        this.idKH = idKH;
        this.idNV = idNV;
        this.ma = ma;
        this.ngayTao = ngayTao;
        this.ngayThanhToan = ngayThanhToan;
        this.tenNguoiNhan = tenNguoiNhan;
        this.sdt = sdt;
        this.tinhTrang = tinhTrang;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getIdKH() {
        return idKH;
    }

    public void setIdKH(String idKH) {
        this.idKH = idKH;
    }

    public String getIdNV() {
        return idNV;
    }

    public void setIdNV(String idNV) {
        this.idNV = idNV;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public Date getNgayThanhToan() {
        return ngayThanhToan;
    }

    public void setNgayThanhToan(Date ngayThanhToan) {
        this.ngayThanhToan = ngayThanhToan;
    }

    public String getTenNguoiNhan() {
        return tenNguoiNhan;
    }

    public void setTenNguoiNhan(String tenNguoiNhan) {
        this.tenNguoiNhan = tenNguoiNhan;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public Integer getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(Integer tinhTrang) {
        this.tinhTrang = tinhTrang;
    }
}
