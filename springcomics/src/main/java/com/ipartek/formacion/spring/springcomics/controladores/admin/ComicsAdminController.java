package com.ipartek.formacion.spring.springcomics.controladores.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ipartek.formacion.spring.springcomics.entidades.Comic;
import com.ipartek.formacion.spring.springcomics.entidades.Mensaje;
import com.ipartek.formacion.spring.springcomics.servicios.ComicService;

import lombok.extern.java.Log;

@Log
@Controller
@RequestMapping("/admin")
public class ComicsAdminController {
	@Autowired
	private ComicService servicio;
	
	@GetMapping // ("/comics")
	public String comics(Model modelo) {
		modelo.addAttribute("comics", servicio.listar());
		return "admin/comics";
	}

	@GetMapping("/{id}")
	public String comic(@PathVariable Long id, Model modelo) {
		Comic comic;
		if (id != 0) {
			comic = servicio.obtenerPorId(id);
		} else {
			comic = new Comic();
		}

		modelo.addAttribute("comic", comic);
		
		return "admin/comic";
	}
	
	@PostMapping
	public String comicPost(Comic comic, RedirectAttributes atributos) {
		Mensaje mensaje;
		
		log.info(comic.toString());
		
		if(comic.getId() != null) {
			servicio.guardar(comic);
			mensaje = new Mensaje("success", "Comic editado correctamente");
		} else {
			servicio.agregar(comic);
			mensaje = new Mensaje("success", "Comic añadido correctamente");
		}
		
		atributos.addFlashAttribute("mensaje", mensaje);
		
		//return "admin/comic";
		return "redirect:/admin";
	}
	
	@PostMapping("/borrar")
	public String comicPostBorrar(Long id, RedirectAttributes atributos) {
		Mensaje mensaje;
		
		servicio.borrar(id);
		
		mensaje = new Mensaje("success", "Comic borrado correctamente");
		
		atributos.addFlashAttribute("mensaje", mensaje);
		
		return "redirect:/admin";
	}
	
}
