package doMainModels;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;


@Entity
@Table(name = "ChiTietSP")
public class ChiTietSP {
    @Id
    @GenericGenerator(name = "generator", strategy = "guid", parameters = {})
    @GeneratedValue(generator = "generator")
    @Column(name = "Id",columnDefinition="uniqueidentifier")
    private String id;
    @ManyToOne()
    @JoinColumn(name = "IdSP",referencedColumnName = "Id")
    private SanPham sp;
    @ManyToOne()
    @JoinColumn(name = "IdNsx",referencedColumnName = "Id")
    private Nsx nsx;
    @ManyToOne()
    @JoinColumn(name = "IdMauSac",referencedColumnName = "Id")
    private MauSac ms;
    @ManyToOne()
    @JoinColumn(name = "IdDongSP",referencedColumnName = "Id")
    private DongSP dsp;
    @Column(name = "NamBH")
    private Integer namBH;

    @Column(name = "MoTa")
    private String moTa;

    @Column(name = "SoLuongTon")
    private Integer soLuongTon;

    @Column(name = "GiaNhap")
    private Double giaNhap;
    @Column(name = "GiaBan")
    private Double giaBan;

    public ChiTietSP() {
    }

    public ChiTietSP(String id, SanPham sp, Nsx nsx, MauSac ms, DongSP dsp, Integer namBH, String moTa, Integer soLuongTon, Double giaNhap, Double giaBan) {
        this.id = id;
        this.sp = sp;
        this.nsx = nsx;
        this.ms = ms;
        this.dsp = dsp;
        this.namBH = namBH;
        this.moTa = moTa;
        this.soLuongTon = soLuongTon;
        this.giaNhap = giaNhap;
        this.giaBan = giaBan;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public SanPham getSp() {
        return sp;
    }

    public void setSp(SanPham sp) {
        this.sp = sp;
    }

    public Nsx getNsx() {
        return nsx;
    }

    public void setNsx(Nsx nsx) {
        this.nsx = nsx;
    }

    public MauSac getMs() {
        return ms;
    }

    public void setMs(MauSac ms) {
        this.ms = ms;
    }

    public DongSP getDsp() {
        return dsp;
    }

    public void setDsp(DongSP dsp) {
        this.dsp = dsp;
    }

    public Integer getNamBH() {
        return namBH;
    }

    public void setNamBH(Integer namBH) {
        this.namBH = namBH;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public Integer getSoLuongTon() {
        return soLuongTon;
    }

    public void setSoLuongTon(Integer soLuongTon) {
        this.soLuongTon = soLuongTon;
    }

    public Double getGiaNhap() {
        return giaNhap;
    }

    public void setGiaNhap(Double giaNhap) {
        this.giaNhap = giaNhap;
    }

    public Double getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(Double giaBan) {
        this.giaBan = giaBan;
    }
}
