package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import bean.khachhangbean;

public class logindao {
	public khachhangbean login(String user, String pass) {
		String sql ="select * from KhachHang where TenDangNhap =? and MatKhau =?";
	try {
		ketnoidao kn= new ketnoidao();
		kn.ketnoi();
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setString(1, user);
		cmd.setString(2, pass);
		ResultSet rs= cmd.executeQuery();
		while(rs.next()) {
			return new khachhangbean(rs.getLong(1),
					rs.getString(2),
					rs.getString(3),
					rs.getString(4),
					rs.getString(5),
					rs.getString(6),
					rs.getString(7),
					rs.getBoolean(8));
		}
	} catch (Exception e) {
	}	
		return null;
	}
	public khachhangbean kiemtratk(String user ) {
		String sql ="select * from KhachHang where TenDangNhap =?";
	try {
		ketnoidao kn= new ketnoidao();
		kn.ketnoi();
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setString(1, user);
		ResultSet rs= cmd.executeQuery();
		while(rs.next()) {
			return new khachhangbean(rs.getLong(1),
					rs.getString(2),
					rs.getString(3),
					rs.getString(4),
					rs.getString(5),
					rs.getString(6),
					rs.getString(7),
					rs.getBoolean(8));
		}
	} catch (Exception e) {
	}	
		return null;
	}
	public void dangky(String hoten, String diachi,String sodt ,String email,String user, String pass) {
		String sql = "insert into KhachHang values (?,?,?,?,?,?,0)";
		try {
			ketnoidao kn= new ketnoidao();
			kn.ketnoi();
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			cmd.setString(1, hoten);
			cmd.setString(2, diachi);
			cmd.setString(3, sodt);
			cmd.setString(4, email);
			cmd.setString(5, user);
			cmd.setString(6, pass);
			//chay cau lenh khong co ket qua tra ve
			cmd.executeUpdate();		
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
