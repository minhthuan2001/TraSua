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
     <li class="active"><a href="gioithieuController">Giới thiệu</a></li>
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
<div class="slider">
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
<H2 style="color:#DF0029;margin-left: 30px;
  margin-right: 30px;">Giới thiệu về trà sữa Hotto !</H2>
<br>

<table style="margin: 5px 40px 5px 20px;align-content:flex-start;color:#DF0029;font-size: 19px; width: 800px;">
<tr>
<td>Hotto Takoyaki tọa lạc trên đường Hai Bà Trưng thành phố Huế là một trong những quán ăn vặt luôn đông đúc các bạn trẻ lui tới. Đồ ăn ở quán chủ yếu là những món ăn nổi tiếng của Nhật như bánh takoyaki, bánh bạch tuộc, bánh tráng bơ, tóp rang lá chanh, … và các loại đồ uống handmade như trà milk foam, đác rim rứa. Đặc biệt hơn trong thực đơn là món tàu hũ Singapore với lớp tàu hũ sánh mịn ăn kèm trân châu thơm ngon. </td>
 </tr>
 <tr>
 <td>
 <br>
	<img src="Logo/gt1.jpg" alt="gt1" style="width: 100%;"> <br>
</td>
 </tr>
 <tr>
 <td> <br>
 <img src="Logo/gt2.jpg" alt="gt2" style="width: 100%;"> <br>
 </td>
 </tr>
 <tr>
 <td>
 <br>
	<img src="Logo/gt3.jpg" alt="gt3"style="width: 100%;"> <br>
</td>
 </tr>
 <tr>
<td>Quán mở cửa từ 16h30 đến 22h30, không phải cuối tuần mới là thời gian để tụ tập vui chơi cùng bạn bè mà các ngày trong tuần quán đều rất đông khách. Không gian tại quán khá nhỏ, bù lại vị trí mặt đường nên rất thoáng mát, bàn ghế được bố trí thêm bên ngoài để phục vụ thêm nhiều thực khách. Cô chủ quán ăn vặt này dự định sẽ mở rộng quán hơn để thực khách có thể thoải mái ăn uống tại quán. </td>
 </tr>
 <tr>
 <td>
 <br>
	<img src="Logo/gt4.jpg" alt="gt4" style="width: 100%;"> <br>
</td>
</table>
<br>
<p style="color:red;margin-left: 500px;"> <b>Địa chỉ: 34 Hai Bà Trưng thành phố Huế </b></p>
<p style="color:red;margin-left: 500px;"> <b> Sđt :      0774516272</b></p>
<p style="color:red;margin-left: 500px;"> <b>Foody: Hotto Takoyaki</b></p>



<!-- Nút đầu trang -->
<button id="myBtn" title="Lên đầu trang"><img src='Logo/top.png' title='lên đầu trang' width='30px'/></button>
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
</body>
</html>