package nganha.thigk.thigk2_64131410;

public class HocSinh {
    private int id;
    private String tenHS;
    private String lop;
    private String nganh;

    // Constructor
    public HocSinh(int id, String tenHS, String lop, String nganh) {
      this.id = id;
      this.tenHS = tenHS;
      this.lop = lop;
      this.nganh = nganh;
    }

    // Getters và Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getTenHS() { return tenHS; }
    public void setTenHS(String tenHS) { this.tenHS = tenHS; }

    public String getLop() { return lop; }
    public void setLop(String lop) { this.lop = lop; }

    public String getNganh() { return nganh; }
    public void setNganh(String nganh) { this.nganh = nganh; }
}
