package org.techhub.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import org.techhub.Model.UserModel;
import org.techhub.service.UserService;
import org.techhub.service.UserServiceImpl;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/viewprofile")
public class ViewProfileServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    response.setContentType("text/html");
	    PrintWriter out = response.getWriter();
	   
	    
	    
	    HttpSession session = request.getSession();
	    Integer userId = (Integer) session.getAttribute("userId");

	    UserService uService = new UserServiceImpl();
	    UserModel model = uService.getProfile(userId);

	    
	    
	    out.println("<html>");
	    out.println("<head>");
	    out.println("<link href='https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css' rel='stylesheet'>");
	   
	    out.println("<h3 class='text-center mb-4'>User Profile</h3>");
	    
	    out.println("<form name='frm' action='' method='POST'>");
	    out.println("<div class='container p-2 m-10 bg-dark'>");
	    out.println("<div class='card shadow p-2'>");
	    

	    out.println("<div class='form-group m-1 p-1'>");
	    out.println("<input type='text' name='name' value='"+model.getName()+"' class='form-control'/>");
	    out.println("</div>");

	    out.println("<div class='form-group m-1 p-1'>");
	    out.println("<input type='text' name='email' value='"+model.getEmail()+"' class='form-control'/>");
	    out.println("</div>");

	    out.println("<div class='form-group m-1 p-1'>");
	    out.println("<input type='text' name='contact' value='"+model.getContact()+"' class='form-control'/>");
	    out.println("</div>");

	    out.println("<div class='form-group m-1 p-1'>");
	    out.println("<input type='text' name='username' value='"+model.getUsername()+"' class='form-control'/>");
	    out.println("</div>");

	    out.println("<div class='form-group m-1 p-1'>");
	    out.println("<input type='text' name='password' value='"+model.getPassword()+"' class='form-control'/>");
	    out.println("</div>");

	    out.println("<div class='form-group m-1 p-1'>");
	    out.println("<a href='updateprofileuser' class='btn btn-primary w-100'>Update Profile</a>");
	    out.println("</div>");
	    out.println("</div>");
	    out.println("</div>");
	    
	    out.println("</form>");
	    out.println("</head>");
	    out.println("<body>");
	    out.println("</html>");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
