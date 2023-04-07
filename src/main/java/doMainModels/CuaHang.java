package doMainModels;

import jakarta.persistence.*;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import java.util.List;
import java.util.UUID;
@Getter
@Setter
@Builder
@Entity
@Table(name = "CuaHang")
public class CuaHang {


    @Id
    @Column(name="Id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;


    @Column(name = "Ma")
    private String ma;

    @Column(name = "Ten")
    private String ten;
    @Column(name = "DiaChi")
    private String diaChi;

    @Column(name = "ThanhPho")
    private String thanhPho;

    @Column(name = "QuocGia")
    private String quocGia;
    
    
    @OneToMany(
            mappedBy = "ch",
            fetch = FetchType.EAGER
    )
    private List<NhanVien> listNV;
    public CuaHang() {
    }

    public CuaHang(UUID id, String ma, String ten, String diaChi, String thanhPho, String quocGia, List<NhanVien> listNV) {
        this.id = id;
        this.ma = ma;
        this.ten = ten;
        this.diaChi = diaChi;
        this.thanhPho = thanhPho;
        this.quocGia = quocGia;
        this.listNV = listNV;
    }

//    public UUID getId() {
//        return id;
//    }
//
//    public void setId(UUID id) {
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
//    public String getDiaChi() {
//        return diaChi;
//    }
//
//    public void setDiaChi(String diaChi) {
//        this.diaChi = diaChi;
//    }
//
//    public String getThanhPho() {
//        return thanhPho;
//    }
//
//    public void setThanhPho(String thanhPho) {
//        this.thanhPho = thanhPho;
//    }
//
//    public String getQuocGia() {
//        return quocGia;
//    }
//
//    public void setQuocGia(String quocGia) {
//        this.quocGia = quocGia;
//    }
//
//    public List<NhanVien> getListNV() {
//        return listNV;
//    }
//
//    public void setListNV(List<NhanVien> listNV) {
//        this.listNV = listNV;
//    }
}
