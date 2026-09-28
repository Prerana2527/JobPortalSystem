package org.techhub.Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import org.techhub.Model.ApplicationModel;
import org.techhub.service.ApplicationService;
import org.techhub.service.ApplicationServiceImpl;


@WebServlet("/RejectedCandidates")
public class RejectedCandidates extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		  
		  ApplicationModel model=new ApplicationModel();
		 ApplicationService apService=new ApplicationServiceImpl();
		 boolean b=apService.rejectStatus(id);
		 if(b)
		 {
			 out.println("Candidate Rejected.");
		 }
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
