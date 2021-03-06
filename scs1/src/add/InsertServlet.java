package add;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class InsertServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String strCourseName=request.getParameter("name");
		String strSection=request.getParameter("section");
		
		
		
		if(BookDao.save(strCourseName, strSection)){
			RequestDispatcher rd=request.getRequestDispatcher("saved");
			rd.forward(request,response);
		}
		else{
			out.print("Error occured while saving data.");
			RequestDispatcher rd=request.getRequestDispatcher("add.jsp");
			rd.include(request,response);
		}
		
		out.close();
	}

}
