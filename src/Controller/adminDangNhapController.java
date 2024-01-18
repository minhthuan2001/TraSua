package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import bean.nhanvienbean;
import dao.adminlogindao;


/**
 * Servlet implementation class adminDangNhapController
 */
@WebServlet("/adminDangNhapController")
public class adminDangNhapController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public adminDangNhapController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("txtun");
		String password = request.getParameter("txtpass");
		adminlogindao adminlogindao = new adminlogindao();
		nhanvienbean nv = adminlogindao.login(username, password);
		if(nv==null) {
			request.setAttribute("message", "Sai tĂ i khoáº£n hoáº·c máº­t kháº©u");
			request.getRequestDispatcher("DangNhap.jsp").forward(request, response);
		}
		else {
			HttpSession session = request.getSession();
			session.setAttribute("acc", nv);// đẩy kh lên session acc
			request.getRequestDispatcher("sanphamController").forward(request, response);

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
