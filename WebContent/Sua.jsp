<%@page import="bo.giohangbo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	//Lay ve masach va soluong can sua
	String ms=request.getParameter("msp");
	String sl=request.getParameter("txtsl");
	//luu session ra bien
	giohangbo gh= (giohangbo)session.getAttribute("gh");
	//sua lai so luong
	gh.Sua(ms, Long.parseLong(sl));
	//luu bien vao session
	session.setAttribute("gh", gh);
	//qua ve trang htgio.jsp
	response.sendRedirect("giohang.jsp");
	%>
</body>
</html>