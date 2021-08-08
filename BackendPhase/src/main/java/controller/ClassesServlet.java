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

import Dao.ClassesDao;
import models.Classes;


/**
 * Servlet implementation class ClassesServlet
 */
@WebServlet(name = "ClassesServlet",urlPatterns = {"/clnew","/clinsert","/cldelete","/cledit","/clupdate","/cllist"})
public class ClassesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ClassesDao classesDao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClassesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		classesDao = new ClassesDao();
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
		
        String claction = request.getServletPath();
		
		try {
			switch (claction) {
			case "/clnew":
				showNewForm(request,response);
				break;
			case "/clinsert":
				insertClasses(request,response);
				break;
				
			case "/cldelete":
				deleteClasses(request,response);
				break;
			case "/cledit":
				showEditForm(request,response);
				break;
			case "/clupdate":
				updateClasses(request,response);
				break;
			default:
				listClasses(request,response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}
	
	
	private void listClasses(HttpServletRequest request,HttpServletResponse response)
			throws SQLException, IOException, ServletException {
				List<Classes> listClasses = classesDao.selectAllClasses();
				request.setAttribute("listClasses",listClasses);
				RequestDispatcher dispatcher = request.getRequestDispatcher("classeslist.jsp");
				dispatcher.forward(request, response);
			}
			
			private void showNewForm(HttpServletRequest request,HttpServletResponse response)
					throws SQLException, IOException, ServletException {
				RequestDispatcher dispatcher = request.getRequestDispatcher("classesform.jsp");
				dispatcher.forward(request, response);
			}
			
			private void showEditForm(HttpServletRequest request,HttpServletResponse response)
					throws SQLException, IOException, ServletException {
				int classId = Integer.parseInt(request.getParameter("classId"));
				Classes existingClasses = classesDao.selectClasses(classId);
				RequestDispatcher dispatcher = request.getRequestDispatcher("classesform.jsp");
				request.setAttribute("classes",existingClasses);
				dispatcher.forward(request, response);
				
			}
			
			
			private void insertClasses(HttpServletRequest request,HttpServletResponse response)
					throws SQLException, IOException, ServletException {
				String className = request.getParameter("className");
				String classSection = request.getParameter("classSection");
				Classes newClasses = new Classes(className,classSection);
				classesDao.insertClasses(newClasses);
				response.sendRedirect("cllist");
			}
			
			
			private void updateClasses(HttpServletRequest request,HttpServletResponse response)
					throws SQLException, IOException, ServletException {
				int classId = Integer.parseInt(request.getParameter("classId"));
				String className = request.getParameter("className");
				String classSection = request.getParameter("classSection");
				Classes clas = new Classes(classId,className,classSection);
				classesDao.updateClasses(clas);
				response.sendRedirect("cllist");
			}
			
			
			private void deleteClasses(HttpServletRequest request,HttpServletResponse response)
					throws SQLException, IOException, ServletException {
				int classId = Integer.parseInt(request.getParameter("classId"));
				classesDao.deleteClasses(classId);
				response.sendRedirect("cllist");
			}
			
	}
