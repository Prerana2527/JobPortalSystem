package org.techhub.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;

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


@WebServlet("/UserLoginServlet")
public class UserLoginServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		
		UserModel model=new UserModel();
		model.setUsername(username);
		model.setPassword(password);
		
		UserService uService=new UserServiceImpl();
		Optional<UserModel> o=uService.validateUser(model);
		if(o.isPresent()) {
			UserModel user=o.get();
			HttpSession session = request.getSession();
		    session.setAttribute("userId", user.getId());
		    
			RequestDispatcher r=request.getRequestDispatcher("UserDashboard.html");
			r.forward(request, response);
		}	
		else {
			RequestDispatcher r=request.getRequestDispatcher("UserLogin.html");
			r.include(request, response);
			out.println("<h5>Invalid Username or Password</h5>");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
