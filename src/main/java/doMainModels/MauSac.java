package doMainModels;

import jakarta.persistence.*;
import lombok.Builder;
import org.hibernate.annotations.Type;

import java.util.UUID;

@Entity
@Table(name = "MauSac")
public class MauSac {
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

    public MauSac() {
    }

    public MauSac(UUID id, String ma, String ten) {
        this.id = id;
        this.ma = ma;
        this.ten = ten;
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
}
