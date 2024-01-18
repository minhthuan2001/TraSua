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
 * Servlet implementation class gioController
 */
@WebServlet("/gioController")
public class gioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public gioController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			//Lay ve ms,ts va giatam
			String anh = request.getParameter("anh");
		  	String msp= request.getParameter("msp");
			String tsp= request.getParameter("tsp");
			String giatam = request.getParameter("giasp");

		  //Neu ms,ts,giatam khac null
		  if(msp!=null&&tsp!=null&&giatam!=null){
		  		giohangbo gh=null;
		  		long giasp=Long.parseLong(giatam);//Doi giatam tu chuoi  ra so
		  		//Kiem tra neu chua tao session("gh") thi:
		  		HttpSession session=request.getSession();
		  		if(session.getAttribute("gh")==null){
		  			gh= new giohangbo();//new giohangbo();
		  			session.setAttribute("gh", gh);//tao session("gh")
		  		}
		  		gh=(giohangbo)session.getAttribute("gh");//Luu session("gh") vao bien gh
		  		//Goi ham Them de them hang vao bien gh
		  		gh.Them(anh,msp, tsp, giasp, 1);
		  		//Luu gh vao lai session("gh")
		  		session.setAttribute("gh", gh);
		  		//Dieu huong sang trang htgio.jsp
		  		response.sendRedirect("htgioController");
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
