package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.nhanvienbean;

public class nhanviendao {
	public nhanvienbean ktdn(String TenDangNhap, String MatKhau) throws Exception{
		ketnoidao kn= new ketnoidao();
		kn.ketnoi();
		String sql = "select * from NhanVien where TenDangNhap=? and MatKhau=?";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setString(1, TenDangNhap);
		cmd.setString(2, MatKhau);
		ResultSet rs= cmd.executeQuery();
		nhanvienbean nv=null;
		if(rs.next()) {
			long MaNhanVien = rs.getLong("MaNhanVien");
			String TenNhanVien=rs.getString("TenNhanVien");
			
			nv = new nhanvienbean(MaNhanVien, TenNhanVien, TenDangNhap, MatKhau);
			return nv;//
		}
		return nv;

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
					rs.getString(4));
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
			
			
			//chay cau lenh khong co ket qua tra ve
			cmd.executeUpdate();		
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public ArrayList<nhanvienbean> getnv() throws Exception{
		ArrayList<nhanvienbean> ds= new ArrayList<nhanvienbean>();
		//B1: ket noi csdl
		ketnoidao kn = new ketnoidao();
		kn.ketnoi();
		//B2: tao cau lenh sql
		String sql = "select * from NhanVien";
		//B3: tao cau lenh
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		//B4:Thuc hien cau lenh
		ResultSet rs = cmd.executeQuery();
		//B5: Duyet rs de luu vao ds
		while (rs.next()) {
			long MaNhanVien=rs.getLong("MaNhanVien");
			String TenNhanVien=rs.getString("TenNhanVien");
			String TenDangNhap=rs.getString("TenDangNhap");
			String MatKhau=rs.getString("MatKhau");
			
			ds.add(new nhanvienbean( MaNhanVien, TenNhanVien, TenDangNhap, MatKhau));
		}
		// B6: dong rs va ket noi
		rs.close(); kn.cn.close();
		return(ds);
	}
	public int Them(String TenNhanVien,String TenDangNhap,String MatKhau) throws Exception {
		//B1: ket noi csdl
		ketnoidao kn = new ketnoidao();
		kn.ketnoi();
		//B2: tao cau lenh sql
		String sql="insert into KhachHang(TenNhanVien,TenDangNhap,MatKhau)values (?,?,?)";
		//B3: tao cau lenh
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setString(1, TenNhanVien);
		cmd.setString(5, TenDangNhap);
		cmd.setString(6, MatKhau);
		
		int kq=cmd.executeUpdate(); //thuc hien cau lenh sql
		// B6: dong rs va ket noi
		cmd.close(); kn.cn.close();
		
		return kq;
		
	}
	public int Xoa(String MaNhanVien) throws Exception{
		//B1: ket noi csdl
				ketnoidao kn = new ketnoidao();
				kn.ketnoi();
				//B2: tao cau lenh sql
				String sql="delete from NhanVien where MaNhanVien=?";
				//B3: tao cau lenh
				PreparedStatement cmd = kn.cn.prepareStatement(sql);
				cmd.setString(1, MaNhanVien);
				int kq=cmd.executeUpdate(); //thuc hien cau lenh sql
				// B6: dong rs va ket noi
				cmd.close(); kn.cn.close();
				
				return kq;		
	}
	public int Sua(long MaNhanVien,String MatKhau) throws Exception{
		//B1: ket noi csdl
		ketnoidao kn = new ketnoidao();
		kn.ketnoi();
		//B2: tao cau lenh sql
		String sql="UPDATE NhanVien SET MatKhau=? WHERE MaNhanVien=?";
		//B3: tao cau lenh
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setString(1, MatKhau);
		cmd.setLong(2, MaNhanVien);


		int kq=cmd.executeUpdate(); //thuc hien cau lenh sql
		// B6: dong rs va ket noi
		cmd.close(); kn.cn.close();
		
		return kq;	
	}
}
