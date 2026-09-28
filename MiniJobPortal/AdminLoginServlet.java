package org.techhub.Controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

import org.techhub.model.AdminModel;
import org.techhub.service.AdminService;
import org.techhub.service.AdminServiceImpl;

@WebServlet("/adminlog")
public class AdminLoginServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
	
	   // RequestDispatcher r=request.getRequestDispatcher("admindashboard.html");
    	//r.include(request,response);
    	
    	String email=request.getParameter("email");
        String password=request.getParameter("password");
        
    	AdminModel model= new AdminModel();
    	model.setEmail(email);
    	model.setPassword(password);
    	
    	AdminService adService=new AdminServiceImpl();
    	boolean result=adService.isLogin(model);
    	if(result) {
    		HttpSession session=request.getSession(true);
    		session.setAttribute("admin",email);
    		
    		out.println("SUCCESS");
    	}
    	else {
    	
    		out.println("<h3>Login Failed</h3>");
    	}
	     
	}


	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
