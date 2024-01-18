package bo;

import java.util.ArrayList;

import bean.giohangbean;

public class giohangbo {
	public ArrayList<giohangbean> ds = new ArrayList<giohangbean>();
	public void Them(String Anh,String MaSanPham, String TenSanPham, long GiaSanPham,
			long SoLuongMua) throws Exception{
			//Kiem tra hang da co chua, neu co thi tang soluongmua
			for(giohangbean h: ds)
				if(h.getMaSanPham().equals(MaSanPham)) {
					h.setSoLuongMua(h.getSoLuongMua()+ SoLuongMua);
					return;
				}
			
			giohangbean g= new giohangbean(Anh, MaSanPham, TenSanPham, GiaSanPham, SoLuongMua);
			ds.add(g);
		}
	//xoa hang ra khoi ds
	public void XoaHang(String MaSanPham) {
		for(giohangbean h: ds)
			if(h.getMaSanPham().equals(MaSanPham)) {
				ds.remove(h); return;
			}
	}
	public void Sua(String MaSanPham, long SoLuongMoi) {
		int n=ds.size(); //lay so sach trong ds
		for(int i=0;i<ds.size();i++) {
			giohangbean h=ds.get(i);// lay sach thu i
			if(h.getMaSanPham().endsWith(MaSanPham)) {
				h.setSoLuongMua(SoLuongMoi); //sua so luong
				ds.set(i, h); //luu lai vao ds
				return;
			}
		}
	}
	public long Tong(){
		long s=0;
		for(giohangbean h: ds)
			s=s+h.getThanhTien();
		return s;
	}
	public void XoaTatCa() {
	    ds.clear();
	}
	public void Xoa(String tsp) {
	    for (int i = 0; i < ds.size(); i++) {
	        if (ds.get(i).getTenSanPham().equals(tsp)) {
	            ds.remove(ds.get(i));
	            return;
	        }
	    }
	}

}
