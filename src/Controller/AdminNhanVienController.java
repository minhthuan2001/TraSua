package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.nhanvienbean;
import bo.nhanvienbo;

/**
 * Servlet implementation class AdminNhanVienController
 */
@WebServlet("/AdminNhanVienController")
public class AdminNhanVienController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminNhanVienController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			/*
			 * nhanvienbo nvbo = new nhanvienbo(); String tab = request.getParameter("tab");
			 * String hoten = request.getParameter("txtten"); String tendangnhap
			 * =request.getParameter("txttendangnhap"); String matkhau
			 * =request.getParameter("txtmatkhau"); String manv
			 * =request.getParameter("txtmanv"); ArrayList<nhanvienbean> ds = nvbo.getnv();
			 * if(request.getParameter("butadd")!=null) { nvbo.Them(manv, tendangnhap,
			 * matkhau); }else { if(request.getParameter("butupdate")!=null) {
			 * nvbo.Sua(Long.parseLong(manv), matkhau); }else { //String
			 * tendn=request.getParameter("tendn"); if(tab!=null && tab.equals("xoa"))
			 * nvbo.Xoa(tendangnhap);
			 * 
			 * else if(tab!=null && tab.equals("chon")) { request.setAttribute("manv",
			 * manv); request.setAttribute("matkhau", nvbo.Them(manv, tendangnhap,
			 * matkhau)); }
			 * 
			 * } } request.setAttribute("dsnv", nvbo.getnv()); //Dat cau hinh gui len va lay
			 * ve =utf-8 request.setCharacterEncoding("utf-8");
			 * response.setCharacterEncoding("utf-8"); //Sai loaibo lay ve dsloai
			 * 
			 * //Sai sachbo lay ve dssach //Lay ve ml va txttim tu htsach.jsp gui len String
			 * mnv=request.getParameter("mnv");
			 * 
			 * String key=request.getParameter("txttim");
			 * 
			 * ArrayList<nhanvienbean> dsnv= nvbo.getnv(); //Neu ml!=null thi goi ham TimMa
			 * //Neu key!=null goi ham Tim if(mnv!=null)
			 * dsnv=nvbo.TimMa(Long.parseLong(mnv)); else if(key!=null) dsnv=nvbo.Tim(key);
			 * 
			 * //Chuyen dsloai va dssach ve ht.sach request.setAttribute("dsnv", dsnv); //
			 * request.setAttribute("dssp", dssp);
			 */
			RequestDispatcher rd = request.getRequestDispatcher("adminnhanvien.jsp");
			rd.forward(request, response);
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
