package bo;

import java.util.ArrayList;

import bean.xacnhanbean;
import dao.ctdao;

public class ctbo {
	public ArrayList<xacnhanbean> ds = new ArrayList<xacnhanbean>();
	ctdao ct =new ctdao();
	public int Them(String MaSanPham, long SoLuongMua, long MaHoaDon) throws Exception {
		return ct.Them(MaSanPham, SoLuongMua, MaHoaDon);
	}
	public int CapNhat(long MaChiTietHoaDon) throws Exception{
		return ct.CapNhat(MaChiTietHoaDon);
		
	}
	public ArrayList<xacnhanbean> gethoadonchuaxacnhan() throws Exception{
		return ct.gethoadonchuaxacnhan();
	}
	public ArrayList<xacnhanbean> gethoadondaxacnhan() throws Exception{
		return ct.gethoadondaxacnhan();
}
}
