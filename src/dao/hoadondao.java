package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

public class hoadondao {
	public int Them(long MaKhachHang) throws Exception {
		//B1: ket noi csdl
				ketnoidao kn = new ketnoidao();
				kn.ketnoi();
				//B2: tao cau lenh sql
				String sql="insert into HoaDon (MaKhachHang,NgayMua,DaMua)values (?,?,?)";
				//B3: tao cau lenh
				PreparedStatement cmd = kn.cn.prepareStatement(sql);
				//Truyen 3 tham so vao cau lenh sql
				cmd.setLong(1, MaKhachHang);
				//Lay ngay gio hien tai
				Date n1 = new Date();
				//dinh dang lai ngay thang nam
				SimpleDateFormat dd= new SimpleDateFormat("yyyy-MM-dd");
				//Doi ngay util sang chuoi theo dinh dang
				String tam = dd.format(n1); //2023-07-27
				Date n2 =dd.parse(tam); //Doi chuoi ra ngay util
				//Doi ngay util sang ngay sql va dua vao tham so
				cmd.setDate(2,new java.sql.Date(n2.getTime()));
				cmd.setBoolean(3, false);
				int kq=cmd.executeUpdate(); //thuc hien cau lenh sql
				// B6: dong rs va ket noi
				cmd.close(); kn.cn.close();
				
				return kq;
	}
	
	public long getMaxHD() throws Exception{
		//B1: ket noi csdl
		ketnoidao kn = new ketnoidao();
		kn.ketnoi();
		//B2: tao cau lenh sql
		String sql = "select MAX(MaHoaDon) as MaxHD from HoaDon";
		//B3: tao cau lenh
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		//B4:Thuc hien cau lenh
		ResultSet rs = cmd.executeQuery();
		long max=0;
		if (rs.next()) {
			//lay ve gia tri cua cot dau tien trong rs (result sql)
			max =rs.getLong(1);
		}	
		cmd.close(); kn.cn.close();
		return max;
	}
}
