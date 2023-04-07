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
@Table(name = "ChucVu")
public class ChucVu {

    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "Ma")
    private String ma;

    @Column(name = "Ten")
    private String ten;

    @OneToMany(
            mappedBy = "cv",
            fetch = FetchType.EAGER
    )
    private List<NhanVien> listNV;

    public ChucVu() {
    }

    public ChucVu(UUID id, String ma, String ten, List<NhanVien> listNV) {
        this.id = id;
        this.ma = ma;
        this.ten = ten;
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
//    public List<NhanVien> getListNV() {
//        return listNV;
//    }
//
//    public void setListNV(List<NhanVien> listNV) {
//        this.listNV = listNV;
//    }
}
