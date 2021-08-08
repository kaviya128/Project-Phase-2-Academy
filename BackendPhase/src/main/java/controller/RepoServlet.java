package controller;


import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import Dao.ClasstReport;

import models.Teacher;

/**
 * Servlet implementation class RepoServlet
 */
@WebServlet("/RepoServlet")
public class RepoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ClasstReport classtReport;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RepoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		classtReport = new ClasstReport();
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
         response.setContentType("text/html");
		
		String className = request.getParameter("className");
		List<Teacher> reportListt = classtReport.generateReport(className);
		request.setAttribute("reportListt", reportListt);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("treport.jsp");
		dispatcher.forward(request, response);
		
		
	}

	
}
