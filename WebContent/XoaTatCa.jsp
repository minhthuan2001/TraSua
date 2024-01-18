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
	giohangbo gh = (giohangbo) session.getAttribute("gh");
	if (gh != null) {
		gh.XoaTatCa();
	}
	response.sendRedirect("gioController");

%>
</body>
</html>