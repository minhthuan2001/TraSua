/*
 * package Controller;
 * 
 * import java.io.IOException;
 * 
 * import javax.servlet.RequestDispatcher; import
 * javax.servlet.ServletException; import javax.servlet.annotation.WebServlet;
 * import javax.servlet.http.HttpServlet; import
 * javax.servlet.http.HttpServletRequest; import
 * javax.servlet.http.HttpServletResponse; import
 * javax.servlet.http.HttpSession; import javax.websocket.Session;
 * 
 * import bean.giohangbean; import bean.khachhangbean; import bo.ctbo; import
 * bo.giohangbo; import bo.hoadonbo;
 * 
 *//**
	 * Servlet implementation class xacnhanController
	 */
/*
 * @WebServlet("/xacnhanController") public class xacnhanController extends
 * HttpServlet { private static final long serialVersionUID = 1L;
 * 
 *//**
	 * @see HttpServlet#HttpServlet()
	 */
/*
 * public xacnhanController() { super(); // TODO Auto-generated constructor stub
 * }
 * 
 *//**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
/*
 * protected void doGet(HttpServletRequest request, HttpServletResponse
 * response) throws ServletException, IOException { try { //Kiem tra xem
 * khachhang da dang nhap chua HttpSession session = request.getSession();
 * khachhangbean kh=(khachhangbean)session.getAttribute("acc");//dn if(kh==null)
 * {//khach hang chua dang nhap RequestDispatcher rd =
 * request.getRequestDispatcher("Login.jsp"); rd.forward(request, response);
 * }else { giohangbo gh = (giohangbo)session.getAttribute("gh"); if(gh!=null)
 * {//co hang trong gio //Tao 1 hoa don hoadonbo hdbo = new hoadonbo();
 * hdbo.Them(kh.getMakh()); long mahd = hdbo.getMaxHD(); //Duyet gio de luu vao
 * cthoadon ctbo ct = new ctbo(); for(giohangbean g: gh.ds)
 * ct.Them(g.getMasach(), g.getSoluongmua(), mahd); //xoa gio hang
 * session.removeAttribute("gh"); response.sendRedirect("XacNhan.jsp");
 * //request.getRequestDispatcher("XacNhan.jsp").forward(request, response); } }
 * } catch (Exception e) { // TODO: handle exception } }
 * 
 * 
 * 
 * 
 *//**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 *//*
		 * protected void doPost(HttpServletRequest request, HttpServletResponse
		 * response) throws ServletException, IOException { // TODO Auto-generated
		 * method stub doGet(request, response); }
		 * 
		 * }
		 */
package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.giohangbean;
import bean.khachhangbean;
import bo.ctbo;
import bo.giohangbo;
import bo.hoadonbo;

/**
 * Servlet implementation class xacnhanController
 */
@WebServlet("/xacnhanController")
public class xacnhanController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public xacnhanController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	try {	
		//Kiem tra xem khach hang da dang nhap chua
		HttpSession session=request.getSession();
		khachhangbean kh=(khachhangbean)session.getAttribute("acc");
		if(kh==null) {//Khach hang chua dang nhap
			RequestDispatcher rd= request.getRequestDispatcher("dangnhapController");
			rd.forward(request, response);
		}
		else {
			giohangbo gh=(giohangbo)session.getAttribute("gh");
			if(gh!=null) {//Co hang trong gio
				//Tao 1 hoa don
				hoadonbo hdbo= new hoadonbo();
				hdbo.Them(kh.getMaKhachHang());
				long mahd=hdbo.getMaxHD();
				//Duyet gio de luu vao cthoadon
				ctbo ct=new ctbo();
				for(giohangbean g: gh.ds)
					ct.Them(g.getMaSanPham(), g.getSoLuongMua(), mahd);
				//xoa gio hang
				session.removeAttribute("gh");
				//Lam them cho dep
				RequestDispatcher rd= request.getRequestDispatcher("XacNhan.jsp?kt=1");
				rd.forward(request, response);
			}
			//Lam them cho dep
			if (gh==null) {
				RequestDispatcher rd= request.getRequestDispatcher("XacNhan.jsp?kt=0");
				rd.forward(request, response);
			}
		}
	} catch (Exception e) {
		e.printStackTrace();
	}	
}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}