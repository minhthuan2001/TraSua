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
 * Servlet implementation class suaController
 */
@WebServlet("/suaController")
public class suaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public suaController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Lay ve masach va soluong can sua
		String msp=request.getParameter("msp");
		String sl=request.getParameter("txtsl");
		HttpSession session = request.getSession();
		//luu session ra bien
		giohangbo gh= (giohangbo)session.getAttribute("gh");
		//sua lai so luong
		gh.Sua(msp, Long.parseLong(sl));
		//luu bien vao session
		session.setAttribute("gh", gh);
		//qua ve trang htgio.jsp
		request.getRequestDispatcher("htgioController").forward(request, response);
		//response.sendRedirect("htgioController");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
