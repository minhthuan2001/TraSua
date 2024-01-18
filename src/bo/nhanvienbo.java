package bo;

import java.util.ArrayList;

import bean.nhanvienbean;
import dao.nhanviendao;

public class nhanvienbo {
	nhanviendao nvdao = new nhanviendao();
	ArrayList<nhanvienbean> ds;
	public nhanvienbean ktdn(String TenDangNhap, String MatKhau) throws Exception{
		return nvdao.ktdn(TenDangNhap, MatKhau);
	}
	public ArrayList<nhanvienbean> getnv() throws Exception{
		return nvdao.getnv();
	}
	public int Them(String TenNhanVien,String TenDangNhap,String MatKhau) throws Exception {
		return nvdao.Them(TenNhanVien, TenDangNhap, MatKhau);
	}
	public int Xoa(String MaNhanVien) throws Exception{
		return nvdao.Xoa(MaNhanVien);
	}
	public int Sua(long MaNhanVien,String MatKhauMoi) throws Exception{
		return nvdao.Sua(MaNhanVien,MatKhauMoi);
	}
	public ArrayList<nhanvienbean> TimMa(long MaNhanVien) throws Exception {
		ArrayList<nhanvienbean> tam= new ArrayList<nhanvienbean>();
		for(nhanvienbean nv : ds)
			if(nv.getMaNhanVien()==MaNhanVien)
				tam.add(nv);
		return tam;
	}
	//Viết hàm: Tim(String key):
	//trả về all sách có tên sách hoặc tác giả giống như key
	public ArrayList<nhanvienbean> Tim(String key) throws Exception {
		ArrayList<nhanvienbean> tam= new ArrayList<nhanvienbean>();
		for(nhanvienbean nv: ds)
			if(nv.getTenNhanVien().toLowerCase().contains(key.toLowerCase()))
				tam.add(nv);
		return tam;
	}
}
