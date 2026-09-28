package org.techhub.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import org.techhub.Model.ApplicationModel;
import org.techhub.service.ApplicationService;
import org.techhub.service.ApplicationServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



@WebServlet("/Shortlisted")
public class ShortlistedCandidates extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		  
		  ApplicationModel model=new ApplicationModel();
		 ApplicationService apService=new ApplicationServiceImpl();
		 boolean b=apService.updateStatus(id);
		 if(b)
		 {
			 out.println("Candidate shortlisted.");
		 }
		
	      
	        
	}

	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
