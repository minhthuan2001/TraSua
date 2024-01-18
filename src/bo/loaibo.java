package bo;

import java.util.ArrayList;

import bean.loaibean;
import dao.loaidao;

	public class loaibo {
		//ArrayList<loaibean> ds;
		public ArrayList<loaibean> ds = new ArrayList<loaibean>();
		loaidao ldao = new loaidao(); // lay du lieu tu dao
		public ArrayList<loaibean> getloai() throws Exception{
			return ldao.getloai();
		}
		public String Tim(String MaLoai) throws Exception {
			for(loaibean l: ds) {
				if(l.getMaLoai().equals(MaLoai))
					return l.getTenLoai();
			}
			return null;
		}
		public int Them(String MaLoai,String TenLoai) throws Exception {
			for(loaibean l: ds) {
				if(l.getMaLoai().equals(MaLoai))
					return 0;
			}
			return ldao.Them(MaLoai, TenLoai);
		}
		public int Xoa(String MaLoai) throws Exception{
			return ldao.Xoa(MaLoai);
		}
		public int Sua(String MaLoai,String TenLoaiMoi) throws Exception{
			return ldao.Sua(MaLoai, TenLoaiMoi);
		}
	}
