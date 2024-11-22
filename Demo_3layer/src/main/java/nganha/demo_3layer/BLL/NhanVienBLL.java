package nganha.demo_3layer.BLL;

import nganha.demo_3layer.DAL.NhanVienDAL;
import nganha.demo_3layer.Model_DTO.NhanVien;

public class NhanVienBLL {
  NhanVienDAL nhanVienDAL;
  public boolean ThemMoi(NhanVien nv){
    //cac xu ly o day
    boolean kq = nhanVienDAL.AddNew(nv);
    return kq;
  }
  boolean checkLogin(String tenDN, String matKhau){
    //kiem tra tinh dung dan
    //vd: tenDN vs matKhau co dung khong
    //Neu dung thi goi cho DAL lam. Neu sai thi thong bao sai len
    return nhanVienDAL.Login(tenDN, matKhau);
  }
}
