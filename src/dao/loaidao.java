package dao;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import bean.loaibean;

public class loaidao {
	public ArrayList<loaibean> getloai() throws Exception{
		ArrayList<loaibean> ds= new ArrayList<loaibean>();
		//B1: ket noi csdl
		ketnoidao kn = new ketnoidao();
		kn.ketnoi();
		//B2: tao cau lenh sql
		String sql = "select * from LoaiSanPham";
		//B3: tao cau lenh
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		//B4:Thuc hien cau lenh
		ResultSet rs = cmd.executeQuery();
		//B5: Duyet rs de luu vao ds
		while (rs.next()) {
			String MaLoai=rs.getString("MaLoai");
			String TenLoai=rs.getString("TenLoai");
			ds.add(new loaibean(MaLoai, TenLoai));
		}
		// B6: dong rs va ket noi
		rs.close(); kn.cn.close();
		return(ds);
	}
	public int Them(String MaLoai, String TenLoai) throws Exception {
		//B1: ket noi csdl
		ketnoidao kn = new ketnoidao();
		kn.ketnoi();
		//B2: tao cau lenh sql
		String sql="insert into LoaiSanPham(MaLoai,TenLoai)values (?,?)";
		//B3: tao cau lenh
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setString(1, MaLoai);
		cmd.setString(2, TenLoai);
		int kq=cmd.executeUpdate(); //thuc hien cau lenh sql
		// B6: dong rs va ket noi
		cmd.close(); kn.cn.close();
		
		return kq;
		
	}
	public int Xoa(String MaLoai) throws Exception{
		//B1: ket noi csdl
				ketnoidao kn = new ketnoidao();
				kn.ketnoi();
				//B2: tao cau lenh sql
				String sql="delete from LoaiSanPham where MaLoai=?";
				//B3: tao cau lenh
				PreparedStatement cmd = kn.cn.prepareStatement(sql);
				cmd.setString(1, MaLoai);
				int kq=cmd.executeUpdate(); //thuc hien cau lenh sql
				// B6: dong rs va ket noi
				cmd.close(); kn.cn.close();
				
				return kq;		
	}
	public int Sua(String MaLoai,String TenLoaiMoi) throws Exception{
		//B1: ket noi csdl
		ketnoidao kn = new ketnoidao();
		kn.ketnoi();
		//B2: tao cau lenh sql
		String sql="update LoaiSanPham set TenLoai =? where MaLoai=?";
		//B3: tao cau lenh
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setString(1, TenLoaiMoi);
		cmd.setString(2, MaLoai);
		int kq=cmd.executeUpdate(); //thuc hien cau lenh sql
		// B6: dong rs va ket noi
		cmd.close(); kn.cn.close();
		
		return kq;	
	}
}
