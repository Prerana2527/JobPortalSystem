package org.techhub.Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

import org.techhub.model.JobApplicationModel;
import org.techhub.service.JobService;
import org.techhub.service.JobServiceImpl;

@WebServlet("/applyjob")
public class ApplyJobServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.setContentType("text/html");
	        PrintWriter out = response.getWriter();

	        HttpSession session = request.getSession();
	        Integer userId = (Integer) session.getAttribute("Id");

	        if (userId == null) {
	            out.print("LOGIN");
	            return;
	        }
            
	        int jobId = Integer.parseInt(request.getParameter("jobId"));

	        JobApplicationModel model = new JobApplicationModel();
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
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
