package org.techhub.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import org.techhub.Model.AdminModel;
import org.techhub.service.AdminService;
import org.techhub.service.AdminServiceImpl;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/adminregister")
public class AdminRegisterServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
	    RequestDispatcher r=request.getRequestDispatcher("AdminLogin.html");
    	r.include(request,response);
    	
    	String email=request.getParameter("email");
        String password=request.getParameter("password");
        
    	AdminModel model= new AdminModel();
    	model.setEmail(email);
    	model.setPassword(password);
    	
    	AdminService adService=new AdminServiceImpl();
    	boolean result=adService.isRegister(model);
    	if(result) {
    		out.println("<h3 style=\"color:green;\">Admin Registered Successfully</h3>");
    	}
    	else {
    	
    		out.println("<h3>Registration Failed</h3>");
    	}
	     
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
