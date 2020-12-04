package com.ipartek.formacion.uf2218.crud.controladores;

import com.ipartek.formacion.uf2218.crud.accesodatos.Dao;
import com.ipartek.formacion.uf2218.crud.accesodatos.PeliculasDaoMySql;
import com.ipartek.formacion.uf2218.crud.accesodatos.PeliculasDaoTreeMap;
import com.ipartek.formacion.uf2218.crud.modelos.Pelicula;

public class Configuracion {
	public static Dao<Pelicula> dao = PeliculasDaoMySql.getInstancia();
	//public static Dao<Pelicula> dao = PeliculasDaoTreeMap.getInstancia();
}
