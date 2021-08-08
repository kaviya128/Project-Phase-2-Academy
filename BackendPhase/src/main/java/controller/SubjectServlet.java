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

import Dao.SubjectDao;

import models.Subject;

/**
 * Servlet implementation class SubjectServlet
 */
@WebServlet(name = "SubjectServlet",urlPatterns = {"/snew","/sinsert","/sdelete","/sedit","/supdate","/slist"})
public class SubjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private SubjectDao subjectDao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubjectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		subjectDao = new SubjectDao();
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
		
    String saction = request.getServletPath();
		
		try {
			switch (saction) {
			case "/snew":
				showNewForm(request,response);
				break;
			case "/sinsert":
				insertSubject(request,response);
				break;
				
			case "/sdelete":
				deleteSubject(request,response);
				break;
			case "/sedit":
				showEditForm(request,response);
				break;
			case "/supdate":
				updateSubject(request,response);
				break;
			default:
				listSubject(request,response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void listSubject(HttpServletRequest request,HttpServletResponse response)
			throws SQLException, IOException, ServletException {
				List<Subject> listSubject = subjectDao.selectAllSubjects();
				request.setAttribute("listSubject",listSubject);
				RequestDispatcher dispatcher = request.getRequestDispatcher("subjectlist.jsp");
				dispatcher.forward(request, response);
			}
			
			private void showNewForm(HttpServletRequest request,HttpServletResponse response)
					throws SQLException, IOException, ServletException {
				RequestDispatcher dispatcher = request.getRequestDispatcher("subjectform.jsp");
				dispatcher.forward(request, response);
			}
			
			private void showEditForm(HttpServletRequest request,HttpServletResponse response)
					throws SQLException, IOException, ServletException {
				int subjectId = Integer.parseInt(request.getParameter("subjectId"));
				Subject existingSubject = subjectDao.selectSubject(subjectId);
				RequestDispatcher dispatcher = request.getRequestDispatcher("subjectform.jsp");
				request.setAttribute("subject",existingSubject);
				dispatcher.forward(request, response);
				
			}
			
			private void insertSubject(HttpServletRequest request,HttpServletResponse response)
					throws SQLException, IOException, ServletException {
				String subjectName = request.getParameter("subjectName");
				String className = request.getParameter("className");
				Subject newSubject = new Subject(subjectName,className);
				subjectDao.insertSubject(newSubject);
				response.sendRedirect("slist");
			}
			
			
			private void updateSubject(HttpServletRequest request,HttpServletResponse response)
					throws SQLException, IOException, ServletException {
				int subjectId = Integer.parseInt(request.getParameter("subjectId"));
				String subjectName = request.getParameter("subjectName");
				String className = request.getParameter("className");
				Subject sub = new Subject(subjectId,subjectName,className);
				subjectDao.updateSubject(sub);
				response.sendRedirect("slist");
			}
			
			
			private void deleteSubject(HttpServletRequest request,HttpServletResponse response)
					throws SQLException, IOException, ServletException {
				int subjectId = Integer.parseInt(request.getParameter("subjectId"));
				subjectDao.deleteSubject(subjectId);
				response.sendRedirect("slist");
			}
			
	}

