package com.ipartek.formacion.uf2218;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hola")
public class HolaMundo extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombre = request.getParameter("nombre");
		
		response.setContentType("text/plain");
		
		PrintWriter out = response.getWriter();
		
		System.out.println("En la consola del SERVIDOR");
		
		System.out.println(request.getHeader("User-agent"));
		
		System.out.println(request.getHeader("Accept-language"));
		
		System.out.println(request.getRemoteAddr());
		
		if(nombre == null) {
			out.println("Hola");
		} else {
			out.println("¡Qué pasa " + nombre + "!");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
