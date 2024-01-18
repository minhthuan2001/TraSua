package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.loaibean;
import bean.sanphambean;
import bo.loaibo;
import bo.sanphambo;

/**
 * Servlet implementation class AdminSanPhamController
 */
@WebServlet("/AdminSanPhamController")
public class AdminSanPhamController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminSanPhamController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			sanphambo spbo = new sanphambo();
			String tab = request.getParameter("tab");
			String masp = request.getParameter("txtmasanpham");
			String tensp = request.getParameter("txttensanpham");
			String giasp = request.getParameter("txtgiasanpham");
			String maloaisp = request.getParameter("txtmaloaisanpham");
			String anhsp = request.getParameter("txtanhsanpham");
			ArrayList<sanphambean> ds = spbo.getsanpham();
			if(request.getParameter("butaddsp")!=null) {
				spbo.Them( masp, tensp,Long.parseLong(giasp), maloaisp,anhsp);
			}else {
				if(request.getParameter("butupdatesp")!=null) {
					spbo.Sua(masp, tensp);
			}else {
				String masanpham=request.getParameter("msp");
				if(tab!=null && tab.equals("xoa"))
					spbo.Xoa(masanpham);
				else
					if(tab!=null && tab.equals("chon")) {
						request.setAttribute("masp", masanpham);
						request.setAttribute("tensp", spbo.Them( masanpham, masanpham, Long.parseLong(giasp), masanpham,anhsp));
					}
			}
			}
			
			/*
			 * if(tab.equals("xoa")) lbo.Xoa(ml); else if(tab.equals("sua")) {
			 * lbo.Sua(tenloai, tenloai); }else if(tab.equals("them")) { lbo.Them(ml,
			 * tenloai); }
			 */
			
			request.setAttribute("dssp", spbo.getsanpham());
			RequestDispatcher rd = request.getRequestDispatcher("adminsanpham.jsp");
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
