package org.techhub.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import org.techhub.Model.JobModel;

import org.techhub.service.JobService;
import org.techhub.service.JobServiceImpl;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/UpdateJobAdmin")
public class UpdateJobAdmin extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		Integer jobId = Integer.parseInt(request.getParameter("jobId"));

		JobModel model=new JobModel();

		JobService jbService=new JobServiceImpl();
		JobModel model1 = jbService.getJobById(jobId);

		System.out.println("ID = " + model1.getJobId());
		
		
		out.println("<div style='display:flex; justify-content:center; align-items:center; height:80vh;'>");

		out.println("<form method='post' action='UpdateJobAdmin' style='width:400px; padding:20px; background:#222; color:white; border-radius:10px;'>");

		out.println("<h3 style='text-align:center; margin-bottom:15px;'>Update Job</h3>");

		
		out.println("<input type='hidden' name='jobId' value='" + model1.getJobId() + "' />");

		
		out.println("<label>Title</label>");
		out.println("<input type='text' name='title' value='" + model1.getTitle() + "' style='width:100%; padding:8px; margin-bottom:10px;'/>");

		
		out.println("<label>Company</label>");
		out.println("<input type='text' name='company' value='" + model1.getCompany() + "' style='width:100%; padding:8px; margin-bottom:10px;'/>");

		
		out.println("<label>Location</label>");
		out.println("<input type='text' name='location' value='" + model1.getLocation() + "' style='width:100%; padding:8px; margin-bottom:10px;'/>");

		
		out.println("<label>Description</label>");
		out.println("<input type='text' name='desc' value='" + model1.getDesc() + "' style='width:100%; padding:8px; margin-bottom:15px;'/>");

		
		out.println("<button type='submit' style='width:100%; padding:10px; background:green; color:white; border:none; border-radius:5px;'>Update Job</button>");

		out.println("</form>");
		out.println("</div>");
		
		}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			response.setContentType("text/html");
			PrintWriter out=response.getWriter();
			
			
			  Integer jobId = Integer.parseInt(request.getParameter("jobId"));

		  
		    String title = request.getParameter("title");
		    String company = request.getParameter("company");
		    String location = request.getParameter("location");
		    String desc = request.getParameter("desc");
		    

		   JobModel jb= new JobModel();
		    jb.setJobId(jobId);
		    jb.setTitle(title);
		    jb.setCompany(company);
		    jb.setLocation(location);
		    jb.setDesc(desc);
		   

		    JobService jbService=new JobServiceImpl();
			boolean b = jbService.updateJob(jb);


		    if (b) {
		        response.sendRedirect("viewjobsadmin"); 
		    } else {
		        
		        out.println("<h3>Updation Failed</h3>");
		    }
	}
}
