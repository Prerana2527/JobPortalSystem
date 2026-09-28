package org.techhub.Controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

import org.techhub.model.JobModel;
import org.techhub.service.JobService;
import org.techhub.service.JobServiceImpl;

@WebServlet("/addjob")
public class AddJobServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  response.setContentType("text/html");
	        PrintWriter out = response.getWriter();
	        RequestDispatcher r=request.getRequestDispatcher("admindashboard.html");
	    	r.include(request,response);

	        HttpSession session = request.getSession(false);
	        if (session == null || session.getAttribute("admin") == null) {
	            out.print("<span style='color:red;'>Session Expired. Login Again</span>");
	            return;
	        }

	        String title = request.getParameter("title");
	        
	        if (title != null) {
               JobModel model = new JobModel();
	            model.setTitle(title);
	            model.setCompany(request.getParameter("company"));
	            model.setLocation(request.getParameter("location"));
	            model.setDescription(request.getParameter("description"));

	            JobService service = new JobServiceImpl();
	            boolean result = service.isAddJob(model);

	            if (result) {
	                out.print("<h3 style='color:lightgreen;text-align:center;'>Job Added Successfully</h3>");
	            } else {
	                out.print("<h3 style='color:red;text-align:center;'>Failed to Add Job</h3>");
	            }
	        }

	        out.println("<style>");
	        out.println("body{font-family:Arial;background:#2f2f2f;}");
	        out.println(".box{width:350px;margin:80px auto;padding:20px;background:white;border-radius:10px;box-shadow:0px 5px 15px rgba(0,0,0,0.4);}");
	        out.println("input,textarea{width:100%;margin:8px 0;padding:8px;border:1px solid #ccc;border-radius:5px;}");
	        out.println("input[type=submit]{width:100%;padding:10px;background:#0d6efd;color:white;border:none;border-radius:5px;cursor:pointer;}");
	        out.println("</style>");

	        out.println("<div class='box'>");
	        out.println("<h3 style='text-align:center;'>Add Job</h3>");

	        out.println("<form method='get' action='addjob'>");

	        out.println("<input type='text' name='title' placeholder='Job Title' required>");
	        out.println("<input type='text' name='company' placeholder='Company' required>");
	        out.println("<input type='text' name='location' placeholder='Location' required>");
	        out.println("<textarea name='description' placeholder='Description' required></textarea>");

	        out.println("<input type='submit' value='Add Job'>");

	        out.println("</form>");
	        out.println("</div>");
	    }
	
	    
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
