package bean;

public class nhanvienbean {
	private long MaNhanVien;
	private String TenNhanVien;
	private String TenDangNhap;
	private String MatKhau;
	public nhanvienbean(long l, String string, String string2, String string3, boolean b) {
		super();
		// TODO Auto-generated constructor stub
	}
	public nhanvienbean(long maNhanVien, String tenNhanVien, String tenDangNhap, String matKhau) {
		super();
		MaNhanVien = maNhanVien;
		TenNhanVien = tenNhanVien;
		TenDangNhap = tenDangNhap;
		MatKhau = matKhau;
	}
	public long getMaNhanVien() {
		return MaNhanVien;
	}
	public void setMaNhanVien(long maNhanVien) {
		MaNhanVien = maNhanVien;
	}
	public String getTenNhanVien() {
		return TenNhanVien;
	}
	public void setTenNhanVien(String tenNhanVien) {
		TenNhanVien = tenNhanVien;
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

	
}
