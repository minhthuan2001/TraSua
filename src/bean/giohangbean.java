package bean;

public class giohangbean {
	private String Anh;
	private String MaSanPham;
	private String TenSanPham;
	private long GiaSanPham;
	private long SoLuongMua;
	private long ThanhTien;
	//private String anh;
	public giohangbean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public giohangbean(String anh, String maSanPham, String tenSanPham, long giaSanPham, long soLuongMua) {
		super();
		Anh = anh;
		MaSanPham = maSanPham;
		TenSanPham = tenSanPham;
		GiaSanPham = giaSanPham;
		SoLuongMua = soLuongMua;
		ThanhTien = soLuongMua*giaSanPham;
	}
	public String getAnh() {
		return Anh;
	}
	public void setAnh(String anh) {
		Anh = anh;
	}
	public String getMaSanPham() {
		return MaSanPham;
	}
	public void setMaSanPham(String maSanPham) {
		MaSanPham = maSanPham;
	}
	public String getTenSanPham() {
		return TenSanPham;
	}
	public void setTenSanPham(String tenSanPham) {
		TenSanPham = tenSanPham;
	}
	public long getGiaSanPham() {
		return GiaSanPham;
	}
	public void setGiaSanPham(long giaSanPham) {
		GiaSanPham = giaSanPham;
	}
	public long getSoLuongMua() {
		return SoLuongMua;
	}
	public void setSoLuongMua(long soLuongMua) {
		SoLuongMua = soLuongMua;
	}
	public long getThanhTien() {
		return SoLuongMua*GiaSanPham;
	}
	public void setThanhTien(long thanhTien) {
		ThanhTien = thanhTien;
	}
	
}
