package org.techhub.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import org.techhub.service.UserService;
import org.techhub.service.UserServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/CheckUserExistence")
public class CheckUserExistence extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String username=request.getParameter("username");
		UserService uService=new UserServiceImpl();
		boolean result=uService.isUserExist(username);
		if(result)
		{
			out.println("<h5 style='color:red'>Username is exits...</h5>");
		}
		else
		{
			out.println("<h5 style='color:green'>Username is Available...!</h5>");
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
