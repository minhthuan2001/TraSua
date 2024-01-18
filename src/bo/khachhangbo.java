package bo;

import java.util.ArrayList;

import bean.khachhangbean;
import dao.khachhangdao;

public class khachhangbo {
	public ArrayList<khachhangbean> ds = new ArrayList<khachhangbean>();
	khachhangdao khdao = new khachhangdao();
	public khachhangbean ktdn(String TenDangNhap, String MatKhau)throws Exception {
		return khdao.ktdn(TenDangNhap, MatKhau);
	}
	public ArrayList<khachhangbean> getkh() throws Exception{
		return khdao.getkh();
	}
	public int Them(String HoTen,String DiaChi,String SoDienThoai,String EMail,String TenDangNhap,String MatKhau) throws Exception {
		return khdao.Them(HoTen, DiaChi, SoDienThoai, EMail, TenDangNhap, MatKhau);
	}
	public int Xoa(String MaKhachHang) throws Exception{
		return khdao.Xoa(MaKhachHang);
	}
	public int Sua(long MaKhachHang,String MatKhauMoi) throws Exception{
		return khdao.Sua(MaKhachHang,MatKhauMoi);
	}
	public ArrayList<khachhangbean> TimMa(long MaKhachHang) throws Exception {
		ArrayList<khachhangbean> tam= new ArrayList<khachhangbean>();
		for(khachhangbean kh : ds)
			if(kh.getMaKhachHang()==MaKhachHang)
				tam.add(kh);
		return tam;
	}
	//Viết hàm: Tim(String key):
	//trả về all sách có tên sách hoặc tác giả giống như key
	public ArrayList<khachhangbean> Tim(String key) throws Exception {
		ArrayList<khachhangbean> tam= new ArrayList<khachhangbean>();
		for(khachhangbean kh: ds)
			if(kh.getHoTen().toLowerCase().contains(key.toLowerCase()))
				tam.add(kh);
		return tam;
	}
	
}

