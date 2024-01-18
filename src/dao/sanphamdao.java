package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.sanphambean;

public class sanphamdao {
	public ArrayList<sanphambean> getsanpham() throws Exception{
		ArrayList<sanphambean> ds = new ArrayList<sanphambean>();
		//B1: ket noi csdl
		ketnoidao kn = new ketnoidao();
		kn.ketnoi();
		//B2: tao cau lenh sql
		String sql = "select * from SanPham";
		//B3: tao cau lenh	
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		//B4:Thuc hien cau lenh
		ResultSet rs = cmd.executeQuery();
		//B5: Duyet rs de luu vao ds
		while (rs.next()) {
			String MaSanPham=rs.getString("MaSanPham");
			String TenSanPham=rs.getString("TenSanPham");
			long GiaSanPham =rs.getLong("GiaSanPham");
			String Anh=rs.getString("Anh");
			String MaLoai=rs.getString("MaLoai");
			ds.add(new sanphambean(MaSanPham, TenSanPham, GiaSanPham, MaLoai,Anh));
		}
		rs.close();kn.cn.close();
		return(ds);
	}
	public int Them(String MaSanPham, String TenSanPham,long GiaSanPham, String MaLoaiSanPham,String Anh) throws Exception {
		//B1: ket noi csdl
		ketnoidao kn = new ketnoidao();
		kn.ketnoi();	
		//B2: tao cau lenh sql
		String sql="insert into SanPham(MaSanPham,TenSanPham,GiaSanPham,MaLoai,Anh)values (?,?,?,?,?)";
		//B3: tao cau lenh
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setString(1, MaSanPham);
		cmd.setString(2, TenSanPham);
		cmd.setLong(3, GiaSanPham);
		cmd.setString(4, MaLoaiSanPham);
		cmd.setString(5, Anh);
		int kq=cmd.executeUpdate(); //thuc hien cau lenh sql
		// B6: dong rs va ket noi
		cmd.close(); kn.cn.close();
		
		return kq;
		
	}
	public int Xoa(String MaSanPham) throws Exception{
		//B1: ket noi csdl
				ketnoidao kn = new ketnoidao();
				kn.ketnoi();
				//B2: tao cau lenh sql
				String sql="delete from SanPham where MaSanPham=?";
				//B3: tao cau lenh
				PreparedStatement cmd = kn.cn.prepareStatement(sql);
				cmd.setString(1, MaSanPham);
				int kq=cmd.executeUpdate(); //thuc hien cau lenh sql
				// B6: dong rs va ket noi
				cmd.close(); kn.cn.close();
				
				return kq;		
	}
	public int Sua(String MaSanPham,String TenSanPhamMoi) throws Exception{
		//B1: ket noi csdl
		ketnoidao kn = new ketnoidao();
		kn.ketnoi();
		//B2: tao cau lenh sql
		String sql="update LoaiSanPham set TenSanPham =? where MaSanPham=?";
		//B3: tao cau lenh
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setString(1, TenSanPhamMoi);
		cmd.setString(2, MaSanPham);
		int kq=cmd.executeUpdate(); //thuc hien cau lenh sql
		// B6: dong rs va ket noi
		cmd.close(); kn.cn.close();
		
		return kq;	
	}
}
