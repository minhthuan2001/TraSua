package bean;

public class loaibean {
	private String MaLoai;
	private String TenLoai;
	// private phải dùng get, set
	// phát sinh hàm get, hàm set
	public loaibean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public loaibean(String maLoai, String tenLoai) {
		super();
		MaLoai = maLoai;
		TenLoai = tenLoai;
	}
	public String getMaLoai() {
		return MaLoai;
	}
	public void setMaLoai(String maLoai) {
		MaLoai = maLoai;
	}
	public String getTenLoai() {
		return TenLoai;
	}
	public void setTenLoai(String tenLoai) {
		TenLoai = tenLoai;
	}
	
}
