package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import bean.xacnhanbean;

public class ctdao {
	public int Them(String MaSanPham, long SoLuongMua, long MaHoaDon) throws Exception {
		//B1: ket noi csdl
		ketnoidao kn = new ketnoidao();
		kn.ketnoi();
		//B2: tao cau lenh sql
		String sql="insert into ChiTietHoaDon (MaSanPham,SoLuongMua,MaHoaDon,DaMua) values (?,?,?,?)";
		//B3: tao cau lenh
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		//Truyen 4 tham so vao cau lenh sql
		cmd.setString(1, MaSanPham);
		cmd.setLong(2, SoLuongMua);
		cmd.setLong(3, MaHoaDon);
		cmd.setBoolean(4, false);
		int kq=cmd.executeUpdate(); //thuc hien cau lenh sql
		// B6: dong rs va ket noi
		cmd.close(); kn.cn.close();
		return kq;
	}
	public int CapNhat(long MaChiTietHoaDon) throws Exception{
		ketnoidao kn = new ketnoidao();
		kn.ketnoi();
		String sql = "update ChiTietHoaDon set DaMua = 1 where MaChiTietHoaDon = ?";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setLong(1,MaChiTietHoaDon);
		int kq=cmd.executeUpdate();
		cmd.close();
		kn.cn.close();
		return kq;
	}
	public  ArrayList<xacnhanbean> gethoadonchuaxacnhan() throws Exception{
			ArrayList<xacnhanbean> ds = new ArrayList<xacnhanbean>();
			//B1: ket noi csdl
			ketnoidao kn = new ketnoidao();
			kn.ketnoi();
			//B2: tao cau lenh sql
			String sql = "select * from VXacNhan";
			//B3: tao cau lenh
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			//B4:Thuc hien cau lenh
			ResultSet rs = cmd.executeQuery();
			//B5: Duyet rs de luu vao ds
			while (rs.next()) {
				long MaKhachHang=rs.getLong("MaKhachHang"); 
				String HoTen=rs.getString("HoTen");
				String TenSanPham =rs.getString("TenSanPham");
				long GiaSanPham=rs.getLong("GiaSanPham");
				Date NgayMua=rs.getDate("NgayMua");
				long SoLuongMua=rs.getLong("SoLuongMua");
				boolean DaMua = rs.getBoolean("DaMua");
				long ThanhTien=rs.getLong("ThanhTien");
				long MaChiTietHoaDon=rs.getLong("MaChiTietHoaDon");
				ds.add(new xacnhanbean(MaKhachHang, HoTen, TenSanPham, GiaSanPham, NgayMua, SoLuongMua, DaMua, ThanhTien, MaChiTietHoaDon));
			}
			rs.close();kn.cn.close();
			return(ds);
		}
	public  ArrayList<xacnhanbean> gethoadondaxacnhan() throws Exception{
		ArrayList<xacnhanbean> ds = new ArrayList<xacnhanbean>();
		//B1: ket noi csdl
		ketnoidao kn = new ketnoidao();
		kn.ketnoi();
		//B2: tao cau lenh sql
		String sql = "select * from VDaXacNhan";
		//B3: tao cau lenh
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		//B4:Thuc hien cau lenh
		ResultSet rs = cmd.executeQuery();
		//B5: Duyet rs de luu vao ds
		while (rs.next()) {
			long MaKhachHang=rs.getLong("MaKhachHang"); 
			String HoTen=rs.getString("HoTen");
			String TenSanPham =rs.getString("TenSanPham");
			long GiaSanPham=rs.getLong("GiaSanPham");
			Date NgayMua=rs.getDate("NgayMua");
			long SoLuongMua=rs.getLong("SoLuongMua");
			boolean DaMua = rs.getBoolean("DaMua");
			long ThanhTien=rs.getLong("ThanhTien");
			long MaChiTietHoaDon=rs.getLong("MaChiTietHoaDon");
			ds.add(new xacnhanbean(MaKhachHang, HoTen, TenSanPham, GiaSanPham, NgayMua, SoLuongMua, DaMua, ThanhTien, MaChiTietHoaDon));
		}
		rs.close();kn.cn.close();
		return(ds);
	}
}
