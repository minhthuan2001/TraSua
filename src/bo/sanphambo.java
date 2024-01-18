	package bo;

import java.util.ArrayList;

import bean.sanphambean;
import dao.sanphamdao;



public class sanphambo {
	sanphamdao spdao = new sanphamdao();
	ArrayList<sanphambean> ds;
	//Viet ham getsach: lấy về all sách
	public ArrayList<sanphambean> getsanpham() throws Exception {
		ds = spdao.getsanpham();
		return ds;
	}
	// Viết hàm: TimMa(String maloai): 
	//trả về tất cả sách của loại có mã: mã loại
	public ArrayList<sanphambean> TimMa(String maloai) throws Exception {
		ArrayList<sanphambean> tam= new ArrayList<sanphambean>();
		for(sanphambean sp : ds)
			if(sp.getMaLoai().equals(maloai))
				tam.add(sp);
		return tam;
	}
	//Viết hàm: Tim(String key):
	//trả về all sách có tên sách hoặc tác giả giống như key
	public ArrayList<sanphambean> Tim(String key) throws Exception {
		ArrayList<sanphambean> tam= new ArrayList<sanphambean>();
		for(sanphambean sp: ds)
			if(sp.getTenSanPham().toLowerCase().contains(key.toLowerCase()))
				tam.add(sp);
		return tam;
	}
	public int Them(String MaSanPham,String TenSanPham, long GiaSanPham,String MaLoaiSanPham,String Anh) throws Exception {
		for(sanphambean sp: ds) {
			if(sp.getMaLoai().equals(MaLoaiSanPham))
				return 0;
		}
		return spdao.Them(MaSanPham, TenSanPham, GiaSanPham, MaLoaiSanPham, Anh);
	}
	public int Xoa(String MaSanPham) throws Exception{
		return spdao.Xoa(MaSanPham);
	}
	public int Sua(String MaSanPham,String TenSanPhamMoi) throws Exception{
		return spdao.Sua(MaSanPham, TenSanPhamMoi);
	}
}
