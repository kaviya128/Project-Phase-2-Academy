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

import Dao.TeacherDao;

import models.Teacher;

/**
 * Servlet implementation class TeacherServlet
 */
@WebServlet(name = "TeacherServlet",urlPatterns = {"/tnew","/tinsert","/tdelete","/tedit","/tupdate","/tlist"})
public class TeacherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private TeacherDao teacherDao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeacherServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		teacherDao = new TeacherDao();
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
		
String taction = request.getServletPath();
		
		try {
			switch (taction) {
			case "/tnew":
				showNewForm(request,response);
				break;
			case "/tinsert":
				insertTeacher(request,response);
				break;
				
			case "/tdelete":
				deleteTeacher(request,response);
				break;
			case "/tedit":
				showEditForm(request,response);
				break;
			case "/tupdate":
				updateTeacher(request,response);
				break;
			default:
				listTeacher(request,response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}
	
	private void listTeacher(HttpServletRequest request,HttpServletResponse response)
			throws SQLException, IOException, ServletException {
				List<Teacher> listTeacher = teacherDao.selectAllTeachers();
				request.setAttribute("listTeacher",listTeacher);
				RequestDispatcher dispatcher = request.getRequestDispatcher("teacherlist.jsp");
				dispatcher.forward(request, response);
			}
	
	private void showNewForm(HttpServletRequest request,HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("teacherform.jsp");
		dispatcher.forward(request, response);
	}
	
	private void showEditForm(HttpServletRequest request,HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		int teacherId = Integer.parseInt(request.getParameter("teacherId"));
		Teacher existingTeacher = teacherDao.selectTeacher(teacherId);
		RequestDispatcher dispatcher = request.getRequestDispatcher("teacherform.jsp");
		request.setAttribute("teacher",existingTeacher);
		dispatcher.forward(request, response);
		
	}
	
	private void insertTeacher(HttpServletRequest request,HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		String teacherName = request.getParameter("teacherName");
		String subjectName= request.getParameter("subjectName");
		String className = request.getParameter("className");
		Teacher newTeacher = new Teacher(teacherName,subjectName,className);
		teacherDao.insertTeacher(newTeacher);
		response.sendRedirect("tlist");
	}
	
	private void updateTeacher(HttpServletRequest request,HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		int teacherId = Integer.parseInt(request.getParameter("teacherId"));
		String teacherName = request.getParameter("teacherName");
		String subjectName = request.getParameter("subjectName");
		String className = request.getParameter("className");
		Teacher teach = new Teacher(teacherId,teacherName,subjectName,className);
		teacherDao.updateTeacher(teach);
		response.sendRedirect("tlist");
	}
	
	
	private void deleteTeacher(HttpServletRequest request,HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		int teacherId = Integer.parseInt(request.getParameter("teacherId"));
		teacherDao.deleteTeacher(teacherId);
		response.sendRedirect("tlist");
	}
	
	}

	

