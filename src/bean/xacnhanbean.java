package bean;

import java.util.Date;

public class xacnhanbean {
	private long MaKhachHang;
	private String HoTen;
	private String TenSanPham;
	private long GiaSanPham;
	private Date NgayMua;
	private long SoLuongMua;
	private boolean DaMua;
	private long ThanhTien;
	private long MaChiTietHoaDon;
	public xacnhanbean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public xacnhanbean(long maKhachHang, String hoTen, String tenSanPham, long giaSanPham, Date ngayMua,
			long soLuongMua, boolean daMua, long thanhTien, long maChiTietHoaDon) {
		super();
		MaKhachHang = maKhachHang;
		HoTen = hoTen;
		TenSanPham = tenSanPham;
		GiaSanPham = giaSanPham;
		NgayMua = ngayMua;
		SoLuongMua = soLuongMua;
		DaMua = daMua;
		ThanhTien = thanhTien;
		MaChiTietHoaDon = maChiTietHoaDon;
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
	public Date getNgayMua() {
		return NgayMua;
	}
	public void setNgayMua(Date ngayMua) {
		NgayMua = ngayMua;
	}
	public long getSoLuongMua() {
		return SoLuongMua;
	}
	public void setSoLuongMua(long soLuongMua) {
		SoLuongMua = soLuongMua;
	}
	public boolean isDaMua() {
		return DaMua;
	}
	public void setDaMua(boolean daMua) {
		DaMua = daMua;
	}
	public long getThanhTien() {
		return ThanhTien;
	}
	public void setThanhTien(long thanhTien) {
		ThanhTien = thanhTien;
	}
	public long getMaChiTietHoaDon() {
		return MaChiTietHoaDon;
	}
	public void setMaChiTietHoaDon(long maChiTietHoaDon) {
		MaChiTietHoaDon = maChiTietHoaDon;
	}
	
}
