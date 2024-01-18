package bean;

public class sanphambean {
	private String MaSanPham;
	private String TenSanPham;
	private long GiaSanPham;
	private String Anh;
	private String MaLoai;
	public sanphambean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public sanphambean(String maSanPham, String tenSanPham, long giaSanPham,  String maLoai,String anh) {
		super();
		MaSanPham = maSanPham;
		TenSanPham = tenSanPham;
		GiaSanPham = giaSanPham;
		Anh = anh;
		MaLoai = maLoai;
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
	public String getAnh() {
		return Anh;
	}
	public void setAnh(String anh) {
		Anh = anh;
	}
	public String getMaLoai() {
		return MaLoai;
	}
	public void setMaLoai(String maLoai) {
		MaLoai = maLoai;
	}
	
	
	
	
}
