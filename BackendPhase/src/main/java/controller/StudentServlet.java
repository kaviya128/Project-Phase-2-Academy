package controller;


import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.StudentDao;
import models.Student;



/**
 * Servlet implementation class StudentServlet
 */
@WebServlet(name = "StudentServlet",urlPatterns = {"/new","/insert","/delete","/edit","/update","/list"})
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private StudentDao studentDao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		
		// TODO Auto-generated method stub
		
		studentDao = new StudentDao();
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
		
String action = request.getServletPath();
		
		try {
			switch (action) {
			case "/new":
				showNewForm(request,response);
				break;
			case "/insert":
				insertStudent(request,response);
				break;
				
			case "/delete":
				deleteStudent(request,response);
				break;
			case "/edit":
				showEditForm(request,response);
				break;
			case "/update":
				updateStudent(request,response);
				break;
			default:
				listStudent(request,response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	

	private void listStudent(HttpServletRequest request,HttpServletResponse response)
	throws SQLException, IOException, ServletException {
		List<Student> listStudent = studentDao.selectAllStudents();
		request.setAttribute("listStudent",listStudent);
		RequestDispatcher dispatcher = request.getRequestDispatcher("studentlist.jsp");
		dispatcher.forward(request, response);
	}
	
	private void showNewForm(HttpServletRequest request,HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("studentform.jsp");
		dispatcher.forward(request, response);
	}
	
	private void showEditForm(HttpServletRequest request,HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		int studentId = Integer.parseInt(request.getParameter("studentId"));
		Student existingStudent = studentDao.selectStudent(studentId);
		RequestDispatcher dispatcher = request.getRequestDispatcher("studentform.jsp");
		request.setAttribute("student",existingStudent);
		dispatcher.forward(request, response);
		
	}
	
	
	private void insertStudent(HttpServletRequest request,HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		String studentName = request.getParameter("studentName");
		int rollNo = Integer.parseInt(request.getParameter("rollNo"));
		String className = request.getParameter("className");
		Student newStudent = new Student(studentName,rollNo,className);
		studentDao.insertStudent(newStudent);
		response.sendRedirect("list");
	}
	
	
	private void updateStudent(HttpServletRequest request,HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		int studentId = Integer.parseInt(request.getParameter("studentId"));
		String studentName = request.getParameter("studentName");
		int rollNo = Integer.parseInt(request.getParameter("rollNo"));
		String className = request.getParameter("className");
		Student stud = new Student(studentId,studentName,rollNo,className);
		studentDao.updateStudent(stud);
		response.sendRedirect("list");
	}
	
	
	private void deleteStudent(HttpServletRequest request,HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		int studentId = Integer.parseInt(request.getParameter("studentId"));
		studentDao.deleteStudent(studentId);
		response.sendRedirect("list");
	}
	
	


	}

	

