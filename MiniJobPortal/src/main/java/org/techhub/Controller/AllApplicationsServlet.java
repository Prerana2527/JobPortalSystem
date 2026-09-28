package org.techhub.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import org.techhub.Model.ApplicationModel;
import org.techhub.service.AdminService;
import org.techhub.service.AdminServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/AppliedJobs")
public class AllApplicationsServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();

	        ApplicationModel model = new ApplicationModel();
	        AdminService adService=new AdminServiceImpl();
	        List<ApplicationModel> list=adService.getApplications();
	        
	        
	        out.println("<html>");
	        out.println("<head>");

	      
	        out.println("<link rel='stylesheet' href='https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css'>");
	        out.println("<script src='JS/AjaxHandler.js'></script>");
	        out.println("</head>");
	        out.println("<body>");

	        out.println("<div class='container mt-5'>");

	        out.println("<h2 class='text-center mb-4'>Applications</h2>");

	        out.println("<table class='table table-bordered table-striped'>");
	        out.println("<thead class='table-dark'>");
	        out.println("<tr>");
	        out.println("<th>Application No</th>");
	        out.println("<th>Job Title</th>");
	        out.println("<th>Applicant Name</th>");
	        out.println("<th>Contact</th>");
	        out.println("<th>Email</th>");
	        out.println("<th>Status</th>");
	        out.println("</tr>");
	        out.println("</thead>");
	        out.println("<tbody>");

	        for(ApplicationModel ap : list)
	        {
	            out.println("<tr>");
	            out.println("<td>"+ap.getId()+"</td>");
	            out.println("<td>"+ap.getTitle()+"</td>");
	            out.println("<td>"+ap.getName()+"</td>");
	            out.println("<td>"+ap.getContact()+"</td>");
	            out.println("<td>"+ap.getEmail()+"</td>");
	            out.println("<td>");
	            out.println("<button class='btn btn-success' onclick='updateStatusUser("+ap.getId()+")'>Shortlist</button> ");
	            out.println("<button class='btn btn-danger'onclick='updateStatusReject("+ap.getId()+")'>Reject</button>");
	            out.println("<div id='s'>");
	            out.println("</div>");
	            out.println("</td>");

	            out.println("</tr>");
	        }

	        out.println("</tbody>");
	        out.println("</table>");
	        out.println("</div>");

	        out.println("</body>");
	        out.println("</html>");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
