<%@page import="bean.xacnhanbean"%>
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
      <b>	<p style="font-family: Brush Script MT;color:#EE2C2C;font-size:50px;margin-left: 20px;"> hotto</p></b>
      </a>
    </div>
    <ul class="nav navbar-nav" style="width:80%;font-size:10px;margin-left: 60px;">
    <li style="width:100px;"></li>
       <li class="active"><a href="AdminLoaiController">Quản lí loại</a></li>
      <li class="active"><a href="AdminSanPhamController">Quản lí sản phẩm</a></li>
            <li class="active"><a href="AdminNhanVienController">Quản lí Nhân viên </a></li>
      
       <li class="active"><a href="AdminKhachHangController">Quản lí Khách hàng</a></li>
      <li class="active"><a href="AdminXacNhanController">Xác nhận hóa đơn</a></li>
       <li class="active"><a href="AdminDaXacNhanController">Hóa đơn đã xác nhận</a></li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
    	<c:if test="${sessionScope.acc==null}">
      <li><a href="dangnhapController"><span class="glyphicon glyphicon-user"></span> Đăng ký</a></li>
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
<!-- NAVBAR -->
<br>
<h1 align="center">Danh sách hóa đơn đã xác nhận </h1><br> <hr>

<table class = "table table-hover">
<thead style="{color: Blue}">
<tr style="color:#3DCCCC;text-align:center;">
<th>Mã CTHĐ </th>
<th>Họ Tên </th>
<th>Tên Sản Phẩm </th>
<th>Giá(VNĐ)</th>
<th>Số lượng mua </th>
<th>Thành tiền</th>
<th >Đã mua</th>
</tr>
</thead>

<%
	ArrayList<xacnhanbean> ds = (ArrayList<xacnhanbean>)request.getAttribute("dshoadon");
	for(xacnhanbean xn:ds){
%>	
	<tr style="color: blue;">
	<td><%=xn.getMaChiTietHoaDon() %> </td>
		<td><%=xn.getHoTen() %> </td>
		<td><%=xn.getTenSanPham()%> </td>
		<td><%=xn.getGiaSanPham() %> </td>
		<td><%=xn.getSoLuongMua() %> </td>
		<td><%=xn.getThanhTien() %> </td>
		<td style="color: red;"><%=xn.isDaMua() %> </td>		
	</tr>
	
	<%} %>
	
<%--  <c:forEach var="xn" items="${dshoadon}">
<tr >
	<td>${xn.getHoTen()}</td>
	<td>${xn.getTenSanPham()}</td>
	<td>${xn.getGiaSanPham()}</td>
	<td>${xn.getSoLuongMua()}</td>
	<td>${xn.getThanhTien()}</td>
	<td><a href="AdminXacNhanController?mact=${xn.getMaChiTietHoaDon()}">
		<button class="btn btn-success" name="bt1">Xác nhận</button> </a></td>
	
	
</tr>
		
</c:forEach> --%>

</table>

</body>
</html>