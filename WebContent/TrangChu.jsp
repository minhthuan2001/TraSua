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
<nav class="navbar navbar-light" style="background-color: #e3f2fd;">	
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="sanphamController" >
      <b>	<p style="font-family: Brush Script MT;color:#EE2C2C	;font-size:50px;margin-left: 40px;"> hotto</p></b>
      </a>
    </div>
    <ul class="nav navbar-nav" >
    <li style="width:200px"></li>
      <li class="active"><a href="sanphamController">Trang chủ</a></li>
           <li class="active"><a href="gioithieuController">Giới thiệu</a></li>
      
      <li class="active"><a href="xuhuongController">Khuyến Mãi </a></li>
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
<marquee width="40%" direction="left" height="50px">
	<h3 style="margin-left: 100px;color:#FF3E96;font-family:Courier New, Courier;">
	<b>Hotto - Trà sữa đậm chất Nhật Bản</b></h3>
</marquee>
<div class="slider" style="font-family: cursive;">
	<div class="slider_imgs">
		<input type="radio" name="inputslider" id="img1">
		<input type="radio" name="inputslider" id="img2">
		<input type="radio" name="inputslider" id="img3">
		<input type="radio" name="inputslider" id="img4">
	
	
		<img src="Logo/nhat.jpg" alt="img1" class="imgslider1">
		<img src="Logo/trasua0.jpg" alt="img2" class="imgslider2">
		<img src="Logo/trasua1.jpg" alt="img3" class="imgslider3">
		<img src="Logo/trasua2.jpg" alt="img4" class="imgslider4">
	</div>
	<div class="lablesliders">
		<label for="img1"></label>
		<label for="img2"></label>
		<label for="img3"></label>
		<label for="img4"></label>
	</div>
</div>
<br>


<table class="center" width="80%">
	<tr >
		<td>
			<div >
				<table class="table table-hover" >
			<%
			ArrayList<loaibean> dsloai = (ArrayList<loaibean>) request.getAttribute("dsloai");
			for(loaibean loai: dsloai){ //Hien thi all loai sp
			%>
				<td class="font" >
					<a style="color: #EE2C2C;" href="sanphamController?ml=<%=loai.getMaLoai()%>">
					<img src="Logo/ts.jpg" alt="ts" style="width: 18px;">	
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

<table class="center" width="90%">
	<tr >
		 <%-- <td width="200" valign="top" style="color:green">
		 <h5>Danh sách loại</h5>
		<table class="table table-hover">
			<%
			ArrayList<loaibean> dsloai = (ArrayList<loaibean>) request.getAttribute("dsloai");
			for(loaibean loai: dsloai){ //Hien thi all loai sp
			%>
				<tr><td>
				<a href="sanphamController?ml=<%=loai.getMaLoai()%>">
					<%=loai.getTenLoai() %>
					</a>
					</td></tr>
			<%}%>
		</table>
		</td> --%>
		<td  valign="top" align="center">
		<table align="center"class="table">
			<%	
				
			response.setCharacterEncoding("utf-8");
			request.setCharacterEncoding("utf-8");
			//Lay dssach tu sachCpntroller gui ve
			ArrayList<sanphambean> ds= (ArrayList<sanphambean>) request.getAttribute("dssp");
				int n=ds.size();
					for(int i=0;i<n;i++){
						sanphambean sp =ds.get(i);
					%>
					<tr> <!-- class="col-sm-4" --> 
						<td  style="color: #CC0000; font-family: 'Courier new';font-size: 17px;">
						<img src="<%= sp.getAnh()%>"style="width: 200px;height: auto;"class="botron">  <br>
					<br>
					
					<b> <%=sp.getTenSanPham()%> </b><br>
					<b>Giá (VNĐ): <%=sp.getGiaSanPham()%></b><br>
					<a href="gioController?anh=<%=sp.getAnh() %>&msp=<%=sp.getMaSanPham()%>&tsp=<%=sp.getTenSanPham()%>&giasp=<%=sp.getGiaSanPham()%>"> <img width="100px" src="Logo/muangay.gif"> </a>
					
					</td>
					<% i++;
					if(i<n){
						sp=ds.get(i);
					%>
					<td style="color: #CC0000; font-family: 'Courier new';font-size: 17px;">
						<img src="<%= sp.getAnh()%>"style="width: 200px;height: auto;" class="botron">  <br>
					<br>
					<b> <%=sp.getTenSanPham()%> </b><br>
					<b>Giá (VNĐ): <%=sp.getGiaSanPham()%></b><br>
					<a href="gioController?anh=<%=sp.getAnh() %>&msp=<%=sp.getMaSanPham()%>&tsp=<%=sp.getTenSanPham()%>&giasp=<%=sp.getGiaSanPham()%>"> <img width="100px" src="Logo/muangay.gif"> </a>
					</td>
					<%} %>
					<% i++;
					if(i<n){
						sp=ds.get(i);
					%>
					<td style="color: #CC0000; font-family: 'Courier new';font-size: 17px;">
						<img src="<%= sp.getAnh()%>"style="width: 200px;height: auto;"class="botron">  <br>
					<br>
					<b> <%=sp.getTenSanPham()%> </b><br>
					<b>Giá (VNĐ): <%=sp.getGiaSanPham()%></b><br>
					<a href="gioController?anh=<%=sp.getAnh() %>&msp=<%=sp.getMaSanPham()%>&tsp=<%=sp.getTenSanPham()%>&giasp=<%=sp.getGiaSanPham()%>"> <img width="100px" src="Logo/muangay.gif"> </a>
					</td>
					<%} %>
					<% i++;
					if(i<n){
						sp=ds.get(i);
					%>
					<td style="color: #CC0000; font-family: 'Courier new';font-size: 17px;">
						<img src="<%= sp.getAnh()%>"style="width: 200px;height: auto;"class="botron">  <br>
					<br>
					<b> <%=sp.getTenSanPham()%> </b><br>
					<b>Giá (VNĐ): <%=sp.getGiaSanPham()%></b><br>
					<a href="gioController?anh=<%=sp.getAnh() %>&msp=<%=sp.getMaSanPham()%>&tsp=<%=sp.getTenSanPham()%>&giasp=<%=sp.getGiaSanPham()%>"> <img width="100px" src="Logo/muangay.gif"> </a>
					
					</td>
					<%} %>
					</tr>
			<%}  %>
		</table>
		</td>
		<!-- <td width="200" valign="top">
			<form action="sanphamController" method="post">
			<h4 style="color:violet;"> Tim kiếm <br></h4>
	   		<input type="text" name="txttim" placeholder="Nhap key"class="form-control">       
	  		<input type='submit' name='th' value='Search' class="btn-primary form-control">
  			</form>
		</td> -->
	</tr>
</table>
<!-- Nút đầu trang -->
<button id="myBtn" title="Lên đầu trang" style="margin-left: 1150px;width: 50px;"><img src='Logo/top.png' title='lên đầu trang' width='40px'/></button>
<script>
window.onscroll = function() {scrollFunction()};
function scrollFunction() {
 
if (document.body.scrollTop > 600 || document.documentElement.scrollTop > 600) {
document.getElementById("myBtn").style.display = "block";
} else {
document.getElementById("myBtn").style.display = "none";
}
}
 
document.getElementById('myBtn').addEventListener("click", function(){
document.body.scrollTop = 0;
document.documentElement.scrollTop = 0;
});
</script>
<!-- Nút đầu trang -->
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
                	<li><a href="#">Tiktok</a></li>
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
<p> hello ${sessionScope.acc.Email} </p>
</body>
</html>