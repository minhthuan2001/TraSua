package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bo.giohangbo;

/**
 * Servlet implementation class xoaController
 */
@WebServlet("/xoaController")
public class xoaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public xoaController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String msp = request.getParameter("msp");
		HttpSession session = request.getSession();
		if (msp != null) {
		    //  Lấy giỏ hàng từ session
		    giohangbo gh = (giohangbo) session.getAttribute("gh");
		    if (gh != null) {
		        //  Xóa mặt hàng khỏi giỏ hàng			  
		        gh.XoaHang(msp);
		        // Cập nhật lại giỏ hàng trong session
		        session.setAttribute("gh", gh);
		    }
		}
		// Chuyển hướng về trang hiển thị giỏ hàng
		request.getRequestDispatcher("htgioController").forward(request, response);
		//response.sendRedirect("gioController");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
