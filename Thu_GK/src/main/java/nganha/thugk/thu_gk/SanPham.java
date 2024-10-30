package nganha.thugk.thu_gk;

public class SanPham {
  private int id;
  private String tenSP;
  private float giaSP;
  private String moTa;

  public SanPham(int id, String tenSP, float giaSP, String moTa) {
    this.id = id;
    this.tenSP = tenSP;
    this.giaSP = giaSP;
    this.moTa = moTa;
  }

  // Getters và Setters
  public int getId() { return id; }
  public void setId(int id) { this.id = id; }

  public String getTenSP() { return tenSP; }
  public void setTenSP(String tenSP) { this.tenSP = tenSP; }

  public float getGiaSP() { return giaSP; }
  public void setGiaSP(float giaSP) { this.giaSP = giaSP; }

  public String getMoTa() { return moTa; }
  public void setMoTa(String moTa) { this.moTa = moTa; }
}
