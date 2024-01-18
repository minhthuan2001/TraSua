package bean;

public class khachhangbean {
	private long MaKhachHang;
	private String HoTen;
	private String DiaChi;
	private String SoDienThoai;
	private String Email;
	private String TenDangNhap;
	private String MatKhau;
	private boolean LaQuanLi;
	public khachhangbean(long l, String string, String string2, String string3, String string4, String string5, String string6) {
		super();
		// TODO Auto-generated constructor stub
	}
	public khachhangbean(long maKhachHang, String hoTen, String diaChi, String soDienThoai, String email,
			String tenDangNhap, String matKhau, boolean laQuanLi) {
		super();
		MaKhachHang = maKhachHang;
		HoTen = hoTen;
		DiaChi = diaChi;
		SoDienThoai = soDienThoai;
		Email = email;
		TenDangNhap = tenDangNhap;
		MatKhau = matKhau;
		LaQuanLi = laQuanLi;
	}
	public long getMaKhachHang() {
		return MaKhachHang;
	}
	public void setMaKhachHang(long maKhachHang) {
		MaKhachHang = maKhachHang;
	}
	public String getHoTen() {
		return HoTen;
	}
	public void setHoTen(String hoTen) {
		HoTen = hoTen;
	}
	public String getDiaChi() {
		return DiaChi;
	}
	public void setDiaChi(String diaChi) {
		DiaChi = diaChi;
	}
	public String getSoDienThoai() {
		return SoDienThoai;
	}
	public void setSoDienThoai(String soDienThoai) {
		SoDienThoai = soDienThoai;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getTenDangNhap() {
		return TenDangNhap;
	}
	public void setTenDangNhap(String tenDangNhap) {
		TenDangNhap = tenDangNhap;
	}
	public String getMatKhau() {
		return MatKhau;
	}
	public void setMatKhau(String matKhau) {
		MatKhau = matKhau;
	}
	public boolean isLaQuanLi() {
		return LaQuanLi;
	}
	public void setLaQuanLi(boolean laQuanLi) {
		LaQuanLi = laQuanLi;
	}
	
	
}
