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


@WebServlet("/UserRegisterServlet")
public class UserRegisterServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String contact=request.getParameter("contact");
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		
		UserModel model=new UserModel();
		model.setName(name);
		model.setEmail(email);
		model.setContact(contact);
		model.setUsername(username);
		model.setPassword(password);
		
		UserService uService=new UserServiceImpl();
		boolean b=uService.isAddNewUser(model);
		if(b)
		{
			RequestDispatcher r=request.getRequestDispatcher("UserLogin.html");
			r.include(request, response);
			response.sendRedirect("UserLogin.html?msg1=Registered,Please Login");
		}
		else
		{
			RequestDispatcher r=request.getRequestDispatcher("UserRegister.html");
			r.include(request, response);
			out.println("<script>");
			out.println("document.getElementById('msg').innerHTML='Registration failed';");
			out.println("</script>");
		}
		
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
