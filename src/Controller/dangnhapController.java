package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.khachhangbean;
import dao.logindao;

/**
 * Servlet implementation class dangnhapController
 */
@WebServlet("/dangnhapController")
public class dangnhapController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public dangnhapController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("txtun");
		String password = request.getParameter("txtpass");
		
		logindao logindao = new logindao();
		khachhangbean kh = logindao.login(username, password);
		if(kh==null) {
			request.setAttribute("message", "Sai tài khoản hoặc mật khẩu");
			request.getRequestDispatcher("DangNhap.jsp").forward(request, response);
		}
		else {
			HttpSession session = request.getSession();
			session.setAttribute("acc", kh);// 
			request.getRequestDispatcher("sanphamController").forward(request, response);

		}
		
	}

	/**v
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
