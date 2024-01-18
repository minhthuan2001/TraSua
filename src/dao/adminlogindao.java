package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import bean.nhanvienbean;

public class adminlogindao {
	public nhanvienbean login(String user, String pass) {
		String sql ="select * from NhanVien where TenDangNhap =? and MatKhau =?";
	try {
		ketnoidao kn= new ketnoidao();
		kn.ketnoi();
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setString(1, user);
		cmd.setString(2, pass);
		ResultSet rs= cmd.executeQuery();
		while(rs.next()) {
			return new nhanvienbean(rs.getLong(1),
					rs.getString(2),
					rs.getString(3),
					rs.getString(4),
					rs.getBoolean(5));
		}
	} catch (Exception e) {
	}	
		return null;
	}
	public nhanvienbean kiemtratk(String user ) {
		String sql ="select * from NhanVien where TenDangNhap =?";
	try {
		ketnoidao kn= new ketnoidao();
		kn.ketnoi();
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setString(1, user);
		ResultSet rs= cmd.executeQuery();
		while(rs.next()) {
			return new nhanvienbean(rs.getLong(1),
					rs.getString(2),
					rs.getString(3),
					rs.getString(4),
					rs.getBoolean(5));
		}
	} catch (Exception e) {
	}	
		return null;
	}
	public void dangky(String TenNhanVien,String TenDangNhap, String MatKhau,boolean LaQuanLi) {
		String sql = "insert into NhanVien values (?,?,?,?)";
		try {
			ketnoidao kn= new ketnoidao();
			kn.ketnoi();
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			cmd.setString(1, TenNhanVien);
			cmd.setString(2, TenDangNhap);
			cmd.setString(3, MatKhau);
			cmd.setBoolean(4, LaQuanLi);;
			
			//chay cau lenh khong co ket qua tra ve
			cmd.executeUpdate();		
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
