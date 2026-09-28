package org.techhub.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import org.techhub.Model.JobModel;
import org.techhub.service.JobService;
import org.techhub.service.JobServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/viewjobsadmin")
public class ViewJobsAdmin extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		JobModel model=new JobModel();
		JobService jbService=new JobServiceImpl();
		List<JobModel> jobList=jbService.viewJobs(model);
		out.println("<html>");
		out.println("<head>");
		out.println("<title>my page</title>");
		out.println("<link rel='stylesheet' type='text/css' href='CSS/viewjob.css'>");
		out.println("<script src='JS/AjaxHandler.js'></script>");
		out.println("</head>");
		out.println("<body>");
		out.println("<div class='container bg-dark text-white'>");
		
		out.println("<div class='header bg-white text-blue'>");
		out.println("<header>");
		out.println("<h1 class='logo'>FindJob</h1>");
		out.println("<a href='AdminDashboard.html' class='home-btn'>🏠 Home</a>");
		out.println("</header>");
		out.println("<div class='job-container'>");
		
	  for(JobModel jm:jobList)
	  {
		out.println("<div class='box'>");
		out.println("<h3 class='job-title'>"+jm.getTitle()+"</h3>");	
		out.println("<p class='desc'>"+jm.getCompany()+"</p>");
		out.println("<p class='desc'>"+jm.getLocation()+"</p>");
		out.println("<p class='desc'>"+jm.getDesc()+"</p>");
		 out.println("<button onclick='updateJobs(" + jm.getJobId() + ")'>Update</button>");
		 out.println("<div id='s'>");
		 out.println("</div>");
	     out.println("</div>");
	  }
	   
	      out.println("</div>");
	      out.println("<div id='s'>");
			 out.println("</div>");
	      out.println("</div>");
	      out.println("</div>");
	  
		out.println("</body>");
		out.println("</html>");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
