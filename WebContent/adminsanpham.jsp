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
   <link rel="stylesheet" href="cssfile.css">
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
<form action="AdminSanPhamController" method="post" style="margin-left: 150px;color:#EE0000; ">
<b>
Mã sản phẩm :  <input name ="txtmasanpham" type="text"> <br>
Tên sản phẩm: <input name ="txttensanpham" type="text">  <br>
Giá sản phẩm: <input name ="txtgiasanpham" type="number"> <br>
Mã loại sản phẩm: <input name ="txtmaloaisanpham" type="text"> <br>
Ảnh sản phẩm: <input name="txtanhsanpham" type="text"> <br>
</b> 
<br>
<button name="butaddsp" type="submit" class="btn btn-warning"> Add</button>
<button name="butupdatesp" type="submit" class="btn btn-success"> Update</button>
</form>

<h1 align="center">Danh sách các sản phẩm </h1><br>
<table class="table table-hover"style="color:blue; font-size: 15px;">
 <thead style="color:green; font-size: 17px;"> 
	<b></b><th>Ảnh sản phẩm </th>
	<th> Mã sản phẩm </th>
	<th>Tên sản phẩm</th>
	<th>Giá Sản Phẩm</th>
	<th>Mã loại sản phẩm</th>
	<th>Chọn</th>
	<th>Xóa </th> </b>
</thead>
 <%
	ArrayList<sanphambean> ds=(ArrayList<sanphambean>)request.getAttribute("dssp");
	for(sanphambean sp:ds){
%>
	<tr style="color:blue;">
		
		<td><img src="<%= sp.getAnh()%>"style="width: 150px;height: auto;" class="botron"></td>
		<td><%=sp.getMaSanPham() %> </td>
		<td><%=sp.getTenSanPham() %> </td>
		<td><%=sp.getGiaSanPham()%> </td>
		<td><%=sp.getMaLoai() %> </td>
		
		<td><a href ="AdminSanPhamController?msp=<%=sp.getMaSanPham()%>&tab=chon" >
		 <button class="btn btn-primary"> Select </button> </a></td>
		<td><a href ="AdminSanPhamController?msp=<%=sp.getMaSanPham()%>&tab=xoa" >
		 <button class="btn btn-danger" >  Delete </button></a></td> 
	</tr>
	<%} %>
</table> 

</body>
</html>