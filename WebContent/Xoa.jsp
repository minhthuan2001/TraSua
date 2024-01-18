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
String ms = request.getParameter("ms");
if (ms != null) {
    // Lấy giỏ hàng từ session
    giohangbo gh = (giohangbo) session.getAttribute("gh");
    if (gh != null) {
        // Xóa mặt hàng khỏi giỏ hàng
  
        gh.XoaHang(ms);
        // Cập nhật lại giỏ hàng trong session
        session.setAttribute("gh", gh);
    }
}
// Chuyển hướng về trang hiển thị giỏ hàng
response.sendRedirect("gioController");
%>

</body>
</html>