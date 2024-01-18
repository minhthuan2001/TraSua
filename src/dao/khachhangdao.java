package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.khachhangbean;

public class khachhangdao {
	public khachhangbean ktdn(String TenDangNhap, String MatKhau) throws Exception{
		ketnoidao kn= new ketnoidao();
		kn.ketnoi();
		String sql = "select * from KhachHang where TenDangNhap=? and MatKhau=?";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setString(1, TenDangNhap);
		cmd.setString(2, MatKhau);
		ResultSet rs= cmd.executeQuery();
		khachhangbean kh=null;
		if(rs.next()) {
			long MaKhachHang = rs.getLong("MaKhachHang");
			String HoTen=rs.getString("HoTen");
			String DiaChi=rs.getString("DiaChi");
			String SoDienThoai= rs.getString("SoDienThoai");
			String Email= rs.getString("Email");
			boolean LaQuanLi= rs.getBoolean("LaQuanLi");
			kh = new khachhangbean(MaKhachHang, HoTen, DiaChi, SoDienThoai, Email, TenDangNhap, MatKhau,LaQuanLi);
			return kh;//
		}
		return kh;

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
	public ArrayList<khachhangbean> getkh() throws Exception{
		ArrayList<khachhangbean> ds= new ArrayList<khachhangbean>();
		//B1: ket noi csdl
		ketnoidao kn = new ketnoidao();
		kn.ketnoi();
		//B2: tao cau lenh sql
		String sql = "select * from KhachHang";
		//B3: tao cau lenh
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		//B4:Thuc hien cau lenh
		ResultSet rs = cmd.executeQuery();
		//B5: Duyet rs de luu vao ds
		while (rs.next()) {
			long MaKhachHang=rs.getLong("MaKhachHang");
			String HoTen=rs.getString("HoTen");
			String DiaChi=rs.getString("DiaChi");
			String SoDienThoai=rs.getString("SoDienThoai");
			String Email=rs.getString("Email");
			String TenDangNhap=rs.getString("TenDangNhap");
			String MatKhau=rs.getString("MatKhau");
			boolean LaQuanLi=rs.getBoolean("LaQuanLi");
			ds.add(new khachhangbean( MaKhachHang, HoTen, DiaChi, SoDienThoai, Email, TenDangNhap, MatKhau, LaQuanLi));
		}
		// B6: dong rs va ket noi
		rs.close(); kn.cn.close();
		return(ds);
	}
	public int Them(String HoTen, String DiaChi,String SoDienThoai,String Email,String TenDangNhap,String MatKhau) throws Exception {
		//B1: ket noi csdl
		ketnoidao kn = new ketnoidao();
		kn.ketnoi();
		//B2: tao cau lenh sql
		String sql="insert into KhachHang(HoTen,DiaChi,SoDienThoai,Email,TenDangNhap,MatKhau)values (?,?,?,?,?,?)";
		//B3: tao cau lenh
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setString(1, HoTen);
		cmd.setString(2, DiaChi);
		cmd.setString(3, SoDienThoai);
		cmd.setString(4, Email);
		cmd.setString(5, TenDangNhap);
		cmd.setString(6, MatKhau);
		
		int kq=cmd.executeUpdate(); //thuc hien cau lenh sql
		// B6: dong rs va ket noi
		cmd.close(); kn.cn.close();
		
		return kq;
		
	}
	public int Xoa(String MaKhachHang) throws Exception{
		//B1: ket noi csdl
				ketnoidao kn = new ketnoidao();
				kn.ketnoi();
				//B2: tao cau lenh sql
				String sql="delete from KhachHang where MaKhachHang=?";
				//B3: tao cau lenh
				PreparedStatement cmd = kn.cn.prepareStatement(sql);
				cmd.setString(1, MaKhachHang);
				int kq=cmd.executeUpdate(); //thuc hien cau lenh sql
				// B6: dong rs va ket noi
				cmd.close(); kn.cn.close();
				
				return kq;		
	}
	public int Sua(long MaKhachHang,String MatKhau) throws Exception{
		//B1: ket noi csdl
		ketnoidao kn = new ketnoidao();
		kn.ketnoi();
		//B2: tao cau lenh sql
		String sql="UPDATE KhachHang SET MatKhau=? WHERE MaKhachHang=?";
		//B3: tao cau lenh
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setString(1, MatKhau);
		cmd.setLong(2, MaKhachHang);


		int kq=cmd.executeUpdate(); //thuc hien cau lenh sql
		// B6: dong rs va ket noi
		cmd.close(); kn.cn.close();
		
		return kq;	
	}
}
