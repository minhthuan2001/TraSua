<%@page import="bean.giohangbean"%>
<%@page import="bo.giohangbo"%>
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
<link rel="preconnect" href="https://fonts.gstatic.com" >
<link href="https://fonts.googleapis.com/css2?family=Lobster&display=swap" rel="stylesheet">
<!-- CSS -->
<style>
.center {
  margin-left: auto;
  margin-right: auto;
}
.left{
margin-left: 700px;
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
.dieuchinh{
float:left;
padding: 0 auto;
margin: 0 auto;
}
.table table-hover{
margin: 0 auto;}


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
    <ul class="nav navbar-nav">
    <li style="width:200px"></li>
      <li class="active"><a href="sanphamController">Trang chủ</a></li>
      <li class="active"><a href="sanphamController">Giới thiệu</a></li>
      <li class="active"><a href="xuhuongController">Khuyến Mãi</a></li>
      <li class="active">
        	<a href="htgioController">
        	<%
        		int tong=0;
        		if(session.getAttribute("gh")!=null){
        			giohangbo ghang = (giohangbo) session.getAttribute("gh");
        			for(giohangbean g: ghang.ds){
        				tong+= g.getSoLuongMua();
        			}
        		}
        		out.print("Giỏ hàng ("+tong+")");
        	%>
        	</a>
        </li>
        <c:if test="${sessionScope.acc!=null}">
      <li class="active"><a href="AdminXacNhanController">Quản lí</a></li>
      </c:if>
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
<!-- NAVBAR -->
<marquee width="40%" direction="left" height="50px">
	<h3 style="margin-left: 100px;color:#FF3E96;font-family:Courier New, Courier;">
	<b>Hotto - Trà sữa đậm chất Nhật Bản</b></h3>
</marquee>
<table class="center" width="80%">
	<tr class="listloai">
		<td>
			<div >
				<table class="table table-hover" >
			<%
			ArrayList<loaibean> dsloai = (ArrayList<loaibean>) request.getAttribute("dsloai");
			for(loaibean loai: dsloai){ //Hien thi all loai sp
			%>
				<td class="font">
					<a href="sanphamController?ml=<%=loai.getMaLoai()%>">
					<%=loai.getTenLoai() %>
					</a>
					</td>
					
			<%}%>
			<td width="200" valign="top">
			<form action="sanphamController" method="post">
	   		<input type="text" name="txttim" placeholder="Tìm sản phẩm"class="form-control">       
	  		<input type='submit' name='th' value='Search' class="btn-primary form-control">
  			</form>
		</td>
		
		</table>
			</div>
		</td>
	</tr>
</table>

<table width="1000" class="center">
<tr>
   
   <td valign="top" width="1000">
    <table class="table table-hover" align="center">
    <thead style="color: red;font-size: 17px;">
    <th>Hình sản phẩm</th>
    <th>Tên sản phẩm</th>
    <th>Giá sản phẩm</th>
    <th>Số lượng</th>
    <th>Thành tiền (VNĐ)</th>
    <th>Sửa số lượng</th>
    <th>Xóa sản phẩm</th>
    </thead>
      <%//Neu session("gh") !=null thi
      if(session.getAttribute("gh")!=null){
         giohangbo gh=null;
      	//Luu session("gh") ra bien gh
      	gh=(giohangbo)session.getAttribute("gh");
      	//Duyet cac hang trong gh.ds
      	for(giohangbean h: gh.ds){%>
      		<tr class="mid" style="color:#e12828;font-size: 16px;">
      		
      		<td><img src="<%= h.getAnh()%>"style="width: 150px;height: auto;" class="botron"></td>

      		<td><%=h.getTenSanPham() %> </td>
      		<td><%=h.getGiaSanPham() %> </td>
      		<td><%=h.getSoLuongMua() %> </td>
      		<td><%=h.getThanhTien() %> </td>
      		<td>
      		 <form action="suaController?msp=<%=h.getMaSanPham() %>" method="post">
      		 <input type="number" name="txtsl" style="width:40px">
      		 <input type="submit" name="bu1" value="Sửa" class="btn-link">
      		 </form> 
      		 </td>
      		<td><a href="xoaController?msp=<%=h.getMaSanPham() %>"> Xóa </a>  </td>
      		</tr>
      	<%} %>	
      	<tr><td colspan="5" align="right"style="color:green;font-size: 18px;">
      
      	<b>Tổng tiền (VNĐ): <%=gh.Tong() %></b></td></tr>
      		
      	<% }%>
    </table>
    
    <div class="left">
    <table align="left">
    <tr>
     <td>
     <form action="xoaallController" method="post">
      <input type="submit" name="b1" value="Xóa tất cả"
     		class="btn btn-danger">
     </form>
     </td>
    <td>
     <form action="xacnhanController" method="post">
     <input type="submit" name="b1" value="Xác nhận đặt mua"
     		class="btn btn-primary">
     </form> 
     </td>
     </tr>
     </table>
     </div>
    </td>
</table>
<!-- Footer -->
<div class="container-fluild">
    <section style="height:80px;"></section>
	<div class="row" style="text-align:center;">
	</div>
    <!----------- Footer ------------>
    <footer class="footer-bs">
        <div class="row">
        	<div class="col-md-3 footer-brand animated fadeInLeft">
            	<b>	<p style="font-family: Brush Script MT;color:violet	;font-size:120px;margin-left: 10px;"> hotto</p></b>
                <p>© 2023 ,by Minh Thuận</p>
            </div>
        	<div class="col-md-4 footer-nav animated fadeInUp">
            	<h4>Menu —</h4>
            	<div class="col-md-6">
                    <ul class="pages">
                        <li><a href="sanphamController">Trang Chủ</a></li>
                        <li><a href="xuhuongController">Xu Hướng</a></li>
                        <li><a href="htgioController">Giỏ Hàng</a></li>
                        <li><a href="dangnhapController">Đăng Nhập</a></li>
                        <li><a href="dangnhapController">Đăng Ký</a></li>
                    </ul>
                </div>
            	<div class="col-md-6">
                    <ul class="list">
                        <li><a href="#">About Us</a></li>
                        <li><a href="#">Contacts</a></li>
                        <li><a href="#">Terms & Condition</a></li>
                        <li><a href="#">Privacy Policy</a></li>
                    </ul>
                </div>
            </div>
        	<div class="col-md-2 footer-social animated fadeInDown">
            	<h4>Follow Us</h4>
            	<ul>
                	<li><a href="#">Facebook</a></li>
                	<li><a href="#">Twitter</a></li>
                	<li><a href="#">Instagram</a></li>
                	<li><a href="#">RSS</a></li>
                </ul>
            </div>
        	<div class="col-md-3 footer-ns animated fadeInRight">
            	<h4>Newsletter</h4>
                <p></p>
                <p>
                    <div class="input-group">
                      <input type="text" class="form-control" placeholder="Search for...">
                      <span class="input-group-btn">
                        <button class="btn btn-default" type="button"><span class="glyphicon glyphicon-envelope"></span></button>
                      </span>
                    </div><!-- /input-group -->
                 </p>
            </div>
        </div>
    </footer>
</div>
<!-- Footer -->
</body>
</html>