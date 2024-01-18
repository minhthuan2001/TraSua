<%@page import="bean.khachhangbean"%>
<%@page import="bean.sanphambean"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="bo.sanphambo"%>
<%@page import="bean.loaibean"%>
<%@page import="bo.loaibo"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel = "icon" href = "Logo/logohotto.png" type ="image/x-icon">
<title>Tiệm Trà Sữa Hotto</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
   <link rel="stylesheet" href="style.css">
   <link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Lobster&display=swap" rel="stylesheet">
<!-- CSS -->
<style>
.center {
  margin-left: auto;
  margin-right: auto;
}
.botron{
	border-radius: 10px;
}
.font{
font-size: 18px;
color: violet;
font-family: "Lobster";

}
.listloai{
	padding: 10px;
}
.body{
background-image: url('Logo/nhat.jpg');
}
</style>
</head>
<body style="background-color: #FFFAF0;">
<!-- NAVBAR -->
<nav class="navbar "style="background-color: #e3f2fd;">	
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="sanphamController" >
      <b>	<p style="font-family: Brush Script MT;color:#EE2C2C	;font-size:50px;margin-left: 40px;"> hotto</p></b>
      </a>
    </div>
    <ul class="nav navbar-nav"style="width:80%;font-size:10px;margin-left: 60px;">
    <li style="width:200px"></li>
       <li class="active"><a href="AdminLoaiController">Quản lí loại</a></li>
      <li class="active"><a href="AdminSanPhamController">Quản lí sản phẩm</a></li>
            <li class="active"><a href="AdminNhanVienController">Quản lí Nhân viên </a></li>
      
      <li class="active"><a href="AdminKhachHangController">Quản lí Khách hàng</a></li>
      <li class="active"><a href="AdminXacNhanController">Xác nhận hóa đơn</a></li>
       <li class="active"><a href="AdminDaXacNhanController">Hóa đơn đã xác nhận</a></li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
    	<c:if test="${sessionScope.acc==null}">
      <li><a href="dangkyController"><span class="glyphicon glyphicon-user"></span> Đăng ký</a></li>
      </c:if>
      
     <li><a href="dangnhapController">
      <span class="glyphicon glyphicon-user">
      </span> 
      <%khachhangbean kh=(khachhangbean)session.getAttribute("acc");
        if(kh!=null){
        	out.print(kh.getHoTen());
        %>
        <li><a href="thongtinController">
      <span class="glyphicon glyphicon-user">
      </span>Profile
      </a></li>
      <%
        }else
        	out.print("Đăng nhập");
      %>
      </a></li>
      <c:if test="${sessionScope.acc!=null}">
      <li><a href="dangxuatController"><span class="glyphicon glyphicon-log-in"></span> Đăng xuất</a></li>
      </c:if>
    </ul>
  </div>
</nav>
<br>
<table>
<tr>
<td>
<form action="AdminKhachHangController" method="post" style="margin-left: 150px;color:#EE0000; ">
<b>Mã khách hàng :  <input name ="txtmakhachhang" type="text"> <br>
Mật khẩu: <input name ="txtmatkhau" type="text"></b><br>
<br>
<button name="butadd" type="submit" class="btn btn-warning"> Add</button>
<button name="butupdate" type="submit" class="btn btn-success"> Update</button>
</form>
</td>
</tr>
<!-- <tr>
<td width="20px" valign="top" style="margin-left: 200px;">
			<form action="AdminKhachHangController" method="post">
	   		<input type="text" name="txttim" placeholder="Tìm khách hàng"class="form-control">       
	  		<input type='submit' name='th' value='Search' class="btn-primary form-control">
  			</form>
		</td>
		</tr> -->
</table>
<h1 align="center">Danh sách khách hàng </h1><br>
<table class="table table-hover" style="color:blue;font-size: 15px;">
<thead style="color:green;font-size: 17px;"> 
	<b></b><th>Mã khách hàng </th>
	<th>Họ Tên </th>
	<th>Địa Chỉ </th>
	<th>Email </th>
	<th>Số điện thoại </th>
	<th>Tên Đăng Nhập </th>
	<th>Mật Khẩu</th>
	<th>Chọn</th>
	<th>Xóa </th> </b>
</thead>
<%
	ArrayList<khachhangbean> khach=(ArrayList<khachhangbean>)request.getAttribute("dskh");
	for(khachhangbean k:khach){
%>
	<tr>
		<td><%=k.getMaKhachHang() %> </td>
		<td><%=k.getHoTen() %> </td>
		<td><%=k.getDiaChi() %> </td>
		<td><%=k.getEmail() %> </td>
		<td><%=k.getSoDienThoai() %> </td>
		<td><%=k.getTenDangNhap() %> </td>
		<td><%=k.getMatKhau() %> </td>
		<td><a href ="AdminLoaiController?makh=<%=k.getMaKhachHang()%>&tab=chon" >
		 <button class="btn btn-primary"> Select </button> </a></td>
		<td><a href ="AdminLoaiController?makh=<%=k.getMaKhachHang()%>&tab=xoa" >
		 <button class="btn btn-danger" >  Delete </button></a></td>
	</tr>
	<%} %>
</table>

</body>
</html>