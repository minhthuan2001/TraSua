package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.khachhangbean;
import bean.loaibean;
import bean.sanphambean;
import bo.khachhangbo;
import bo.loaibo;
import bo.sanphambo;

/**
 * Servlet implementation class AdminKhachHangController
 */
@WebServlet("/AdminKhachHangController")
public class AdminKhachHangController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminKhachHangController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			khachhangbo khbo = new khachhangbo();
			String tab = request.getParameter("tab");
			String hoten = request.getParameter("txtten");
			String diachi =request.getParameter("txtdiachi");
			String sodienthoai =request.getParameter("txtsodienthoai");
			String email =request.getParameter("txtemail");
			String tendangnhap =request.getParameter("txttendangnhap");
			String matkhau =request.getParameter("txtmatkhau");
			String makh =request.getParameter("txtmakhachhang");
			ArrayList<khachhangbean> ds = khbo.getkh();
			if(request.getParameter("butadd")!=null) {
				khbo.Them(hoten, diachi, sodienthoai, email, tendangnhap, matkhau);	
			}else {
				if(request.getParameter("butupdate")!=null) {
					khbo.Sua(Long.parseLong(makh), matkhau);
			}else {
				//String tendn=request.getParameter("tendn");
				if(tab!=null && tab.equals("xoa"))
					khbo.Xoa(tendangnhap);
				
				  else if(tab!=null && tab.equals("chon")) {
					  request.setAttribute("makh", makh);
				request.setAttribute("matkhau", khbo.Them(hoten, diachi, sodienthoai, email, tendangnhap, matkhau)); }
				 
			}
			}
			
			/*
			 * if(tab.equals("xoa")) lbo.Xoa(ml); else if(tab.equals("sua")) {
			 * lbo.Sua(tenloai, tenloai); }else if(tab.equals("them")) { lbo.Them(ml,
			 * tenloai); }
			 */
			
			request.setAttribute("dskh", khbo.getkh());
			//Dat cau hinh gui len va lay ve =utf-8
			  request.setCharacterEncoding("utf-8");
			  response.setCharacterEncoding("utf-8");
			//Sai loaibo lay ve dsloai
		
			//Sai sachbo lay ve dssach
			  //Lay ve ml va txttim tu htsach.jsp gui len
			  String makhach=request.getParameter("makhach");
			  
		      String key=request.getParameter("txttim");
		    
			  ArrayList<khachhangbean> dskh= khbo.getkh();
			  //Neu ml!=null thi goi ham TimMa
			  //Neu key!=null goi ham Tim
			  if(makhach!=null)
				  dskh=khbo.TimMa(Long.parseLong(makhach));
		      else
		    	  if(key!=null)
		    		  dskh=khbo.Tim(key);
			  
			//Chuyen dsloai va dssach ve ht.sach
			  			  request.setAttribute("dskh", dskh);
			  			// request.setAttribute("dssp", dssp);

			RequestDispatcher rd = request.getRequestDispatcher("adminkhachhang.jsp");
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
