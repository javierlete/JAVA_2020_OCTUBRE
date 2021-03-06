package com.ipartek.formacion.uf2216;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Ficheros {
	// private static final boolean AUTO_FLUSH = true;
	private static final boolean APPEND = true;
	private static final String NOMBRE_FICHERO = "datos.txt";

	public static void main(String[] args) throws IOException {
		try (FileWriter fw = new FileWriter(NOMBRE_FICHERO, APPEND); PrintWriter pw = new PrintWriter(fw)) { // ,
																												// AUTO_FLUSH)
																												// { //
																												// "C:\\nuevos\\trabajos");

			pw.println(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").format(new Date()) + ": " + "Hola");
			pw.println(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").format(new Date()) + ": " + "Qué tal");

			// pw.flush();
		}
		
		try (FileReader fr = new FileReader(NOMBRE_FICHERO); BufferedReader br = new BufferedReader(fr)) {
			String linea;

			while ((linea = br.readLine()) != null) {// s.nextLine();
				System.out.println(linea);
			}
		}
	}
}
