package bo;

import dao.hoadondao;

public class hoadonbo {
	hoadondao hddao = new hoadondao();
	public int Them(long MaKhachHang) throws Exception {
		return hddao.Them(MaKhachHang);
	}
	public long getMaxHD() throws Exception{
		return hddao.getMaxHD();
	}
}
