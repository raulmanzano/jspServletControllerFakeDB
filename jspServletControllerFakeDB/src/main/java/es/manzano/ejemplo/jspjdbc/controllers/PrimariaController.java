package es.manzano.ejemplo.jspjdbc.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.manzano.ejemplo.jspjdbc.business.BusinessDelegate;
import es.manzano.ejemplo.jspjdbc.model.Primaria;

@WebServlet("/primaria/*")
public class PrimariaController extends HttpServlet {
	private static final long serialVersionUID = 1L;	
	private BusinessDelegate bussinessDelegate;
       
    public PrimariaController() {
        super();
    }

	public void init(ServletConfig config) throws ServletException {
		bussinessDelegate = new BusinessDelegate();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//System.out.println("doPost"+ request.getParameter("operacion"));
		doGet(request, response);		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// bug al ser el path compuesto
		String action = request.getServletPath()+request.getPathInfo() ;
        try {
            switch (action) {
                case "/primaria/new":                	
                    showNewForm(request, response);
                    break;
                case "/primaria/insert":
                    insert(request, response);
                    break;
                case "/primaria/delete":
                    delete(request, response);
                    break;
                case "/primaria/edit":
                    showEditForm(request, response);
                    break;
                case "/primaria/update":
                    update(request, response);
                    break;
                default:
                    list(request, response);
                    break;
            }
        } catch (Exception ex) {
            throw new ServletException(ex);
        }
    }

	private void update(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
		bussinessDelegate.updatePrimaria(new Primaria(Integer.valueOf(request.getParameter("id")),request.getParameter("campo1"),request.getParameter("campo2"),request.getParameter("campo3")));
		request.getSession().setAttribute("mensaje","Elemento actualizado");
        response.sendRedirect("list");		
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Primaria primaria = bussinessDelegate.getById(request.getParameter("id"));
		request.setAttribute("primaria",primaria);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/primariaform.jsp");		
	    dispatcher.forward(request, response);			
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
		  bussinessDelegate.delete(request.getParameter("id"));
		  request.getSession().setAttribute("mensaje","Elemento eliminado");
		  response.sendRedirect("list");
	}

	private void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	     	List<Primaria> listPrimaria = bussinessDelegate.getAllPrimaria();	     
	        request.setAttribute("listPrimaria", listPrimaria );	        	        	       
	        RequestDispatcher dispatcher = request.getRequestDispatcher("/primaria.jsp");
	        dispatcher.forward(request, response);
	}

	private void insert(HttpServletRequest request, HttpServletResponse response) throws IOException {
		bussinessDelegate.insertarPrimaria(new Primaria(request.getParameter("campo1"),request.getParameter("campo2"),request.getParameter("campo3")));
		request.getSession().setAttribute("mensaje","Elemento creado");
        response.sendRedirect("list");
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  RequestDispatcher dispatcher = request.getRequestDispatcher("/primariaform.jsp");
	        dispatcher.forward(request, response);		
	}

}



