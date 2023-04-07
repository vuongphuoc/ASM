package doMainModels;

import jakarta.persistence.*;
import lombok.Builder;
import org.hibernate.annotations.Type;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "SanPham")
public class SanPham {
//    @Id
//    @Column(name = "Id")
//    @GeneratedValue(strategy = GenerationType.UUID)
//    private UUID id;
@Id
@Column(name = "Id")
@GeneratedValue(strategy = GenerationType.UUID)
private UUID id;

    @Column(name = "Ma")
    private String ma;

    @Column(name = "Ten")
    private String ten;
    @OneToMany(
            mappedBy = "sp",
            fetch = FetchType.LAZY
    )
    private List<ChiTietSP> ListCTSP;
    public SanPham() {
    }

    public SanPham(UUID id, String ma, String ten, List<ChiTietSP> listCTSP) {
        this.id = id;
        this.ma = ma;
        this.ten = ten;
        ListCTSP = listCTSP;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public List<ChiTietSP> getListCTSP() {
        return ListCTSP;
    }

    public void setListCTSP(List<ChiTietSP> listCTSP) {
        ListCTSP = listCTSP;
    }
}
