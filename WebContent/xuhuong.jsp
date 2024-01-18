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
<H2 style="color:#DF0029;margin-left: auto;
  margin-right: auto;">Thông Tin Các Khuyến Mãi !</H2>
<br>
<table style="display: flex; justify-content: center; align-items: center;">
<tr >
<td> 
	<h4 style="color: #CD0000">HOTTO UP SIZE - SỬA SAI TÌNH CŨ </h4>
	<p style="font-size: 17px;color: #8B7B8B;">Trời 37-38 độ, qua HOTTO hốt 1 ly trà xoài dưa lưới hay antea đào mát lạnh, mua size lớn chỉ tính tiền size nhỏ thì còn gì bằng nữa 🙊 
<br>Áp dụng khi mua trực tiếp tại quầy nha bạn mình ơi 👻 </p>
 </td>
 <td>
<img width="80%" src="Logo/km1.jpg" alt="km1 "> 
</td>
</tr>
<tr>
	<td>
		<h4 style="color: #CD0000"> 🙊HOTDEAL 19K - BẠN ĐÃ BIẾT CHƯA?</h4>
		<p style="font-size: 17px;color: #8B7B8B;">Đừng bỏ lỡ DEAL 19K ĐỒNG GIÁ tại Hotto trong khung giờ 11-13h hàng ngày bạn nha! Order đúng giờ, deal xịn đợi chờ. Tỉ thứ ngon lành đang chờ bạn qua khám phá chỉ với 19k ⚡️
<br>Áp dụng khi order trực tiếp tại cửa hàng bạn nha! </p>
	</td>
	
	<td>
	<img width="80%" src="Logo/km2.jpg" alt="km2 "> 
	</td>
</tr>
<tr>
	<td>
		<h4 style="color: #CD0000"> KHOAN GIẢM CÂN 🙈 <br> VÌ ĐANG GIẢM GIÁ 🙀</h4>
		<p style="font-size: 17px;color: #8B7B8B;">❌SỐC⚡️TAKOYAKI HOTTO đang tặng bạn "một rừng" VOUCHER GIẢM GIÁ luôn.<br>

Chỉ cần bạn vào 🍑SHOPEE FOOD và gõ ngay: 🔎𝐓𝐚𝐤𝐨𝐲𝐚𝐤𝐢 𝐇𝐨𝐭𝐭𝐨 - Shopee Food sẽ tự điều chỉnh để tìm luôn cho bạn cửa hàng gần nhất.<br>
Order và thêm mã! Chờ đợi một xíu và thưởng thức thôi 👻 </p>
	</td>
	
	<td>
	<img width="80%" src="Logo/km3.jpg" alt="km3"> 
	</td>
</tr>
<tr>
	<td>
		<h4 style="color: #CD0000"> ☀️ NEW-IN MÙA HÈ ☀️ GIẢM 20% KHI ORDER MÓN MỚI ☀️</h4>
		<p style="font-size: 17px;color: #8B7B8B;">🥤 Oolong Mãng Cầu - hot drink trong những ngày đầu của hè, ai ai cũng săn đón hiện đã có mặt tại Takoyaki Hotto<br>
🥤 Dưa Hấu Kem Cheese - sự kết hợp nghe thì lạ nhưng lại khiến bạn yêu ngay từ lần đầu tiên chạm môi<br>
🥤 Atea Đào - hoà quyện hoàn hảo giữa vị ngọt nhẹ và chua thanh giúp bạn hạ nhiệt ngay lập tức<br>
📌 Chương trình GIẢM 20% MÓN MỚI sẽ được áp dụng từ 29/5 - 2/6/2023.<br>
Chờ gì nữa mà không set kèo đến Takoyaki Hotto thôi nào! 😍</p>
	</td>
	
	<td>
	<img width="80%" src="Logo/km4.jpg" alt="km4"> 
	</td>
</tr>
</table>
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