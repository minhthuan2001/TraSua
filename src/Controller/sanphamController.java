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
 * Servlet implementation class sanphamController
 */
@WebServlet("/sanphamController")
public class sanphamController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public sanphamController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			//Dat cau hinh gui len va lay ve =utf-8
			  request.setCharacterEncoding("utf-8");
			  response.setCharacterEncoding("utf-8");
			//Sai loaibo lay ve dsloai
			  loaibo lbo=new loaibo();
			  ArrayList<loaibean> dsloai=lbo.getloai();
			//Sai sachbo lay ve dssach
			  //Lay ve ml va txttim tu htsach.jsp gui len
			  String ml=request.getParameter("ml");
		      String key=request.getParameter("txttim");
		      
			  sanphambo spbo= new sanphambo();
			  ArrayList<sanphambean> dssp= spbo.getsanpham();
			  //Neu ml!=null thi goi ham TimMa
			  //Neu key!=null goi ham Tim
			  if(ml!=null)
				  dssp=spbo.TimMa(ml);
		      else
		    	  if(key!=null)
		    		  dssp=spbo.Tim(key);
			  
			//Chuyen dsloai va dssach ve ht.sach
			  request.setAttribute("dsloai", dsloai);
			  request.setAttribute("dssp", dssp);
			  RequestDispatcher rd= 
						request.getRequestDispatcher("TrangChu.jsp");
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
