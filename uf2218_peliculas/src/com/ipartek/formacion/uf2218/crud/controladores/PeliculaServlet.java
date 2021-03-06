package com.ipartek.formacion.uf2218.crud.controladores;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.uf2218.crud.modelos.Pelicula;

@WebServlet("/admin/pelicula")
/**
 * Servlet para el mantenimiento de una película, facilitando las operaciones CRUD básicas
 */
public class PeliculaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * Visualización de la pantalla de detalles de la película
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sId = request.getParameter("id");
		
		if(sId != null) {
			Long id = Long.parseLong(sId);
		
			Pelicula pelicula = Configuracion.dao.obtenerPorId(id);
			
			request.setAttribute("pelicula", pelicula);
		}
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/vistas/admin/pelicula.jsp");
		requestDispatcher.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}	
	

}
