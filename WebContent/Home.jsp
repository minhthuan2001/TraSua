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
   <link rel="stylesheet" href="cssfile.css">

   <link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" >
<link href="https://fonts.googleapis.com/css2?family=Lobster&display=swap" rel="stylesheet">
</head>
<body>
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
</body>
</html>