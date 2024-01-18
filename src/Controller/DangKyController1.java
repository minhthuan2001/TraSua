package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.khachhangbean;
import dao.logindao;

/**
 * Servlet implementation class DangKyController1
 */
@WebServlet("/DangKyController1")
public class DangKyController1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DangKyController1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String hoten =request.getParameter("dkhoten");
		String diachi =request.getParameter("dkdiachi");
		String sodt =request.getParameter("dksodt");
		String email =request.getParameter("dkemail");
		String user =request.getParameter("dkun");
		String pass =request.getParameter("dkpass");
		String repass =request.getParameter("dkrepass");
		
		if(!pass.equals(repass)) {
			response.sendRedirect("Login.jsp");
		}
		else {
			logindao logindao = new logindao();
			khachhangbean kh = logindao.kiemtratk(user);
			if(kh == null) { //chua co thi dang ky
				logindao.dangky(hoten, diachi, sodt, email, user, repass);
				request.setAttribute("message2", "Đăng ký thành công");
				response.sendRedirect("Login.jsp");
			}
			else { // chuyen ve trang login
				response.sendRedirect("Login.jsp");
			}
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
