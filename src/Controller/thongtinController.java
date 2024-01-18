package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.khachhangbean;

/**
 * Servlet implementation class thongtinController
 */
@WebServlet("/thongtinController")
public class thongtinController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public thongtinController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
        khachhangbean khbean= (khachhangbean) session.getAttribute("acc");

        if (khbean != null) {
            String HoTen = khbean.getHoTen();
            String DiaChi = khbean.getDiaChi();
            String SoDienThoai = khbean.getSoDienThoai();
            
            
            // Sử dụng thông tin khách hàng ở đây để hiển thị trên trang JSP
            request.setAttribute("HoTen", HoTen);
            request.setAttribute("DiaChi", DiaChi);
            request.setAttribute("SoDienThoai", SoDienThoai);
        

            request.getRequestDispatcher("thongtin.jsp").forward(request, response);
        } else {
            // Xử lý trường hợp chưa đăng nhập
            response.sendRedirect("dangnhapController");
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
