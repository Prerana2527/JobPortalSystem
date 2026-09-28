package org.techhub.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import org.techhub.Model.ApplicationModel;
import org.techhub.service.JobService;
import org.techhub.service.JobServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/applicationservlet")
public class ApplicationServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.setContentType("text/html");
		 PrintWriter out=response.getWriter();
		 
		 HttpSession session = request.getSession();
	        Integer userId = (Integer) session.getAttribute("userId");
	        	
	        if (userId == null) {
	            out.print("Please Login First");
	            return;
	        }
	        
         
	        int jobId = Integer.parseInt(request.getParameter("jobId"));

	        ApplicationModel model = new ApplicationModel();
	        model.setUserId(userId);
	        model.setJobId(jobId);

	        JobService service = new JobServiceImpl();
	        boolean result = service.applyJob(model);

	        if (result) {
	            out.print("APPLIED");
	        } else {
	            out.print("ALREADY");
	        }
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
