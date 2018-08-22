package es.rural.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import es.rural.pojo.Admin;
import es.rural.pojo.Direccion;
import es.rural.service.AdminService;
import es.rural.service.DireccionService;

@Controller
@SessionAttributes("admin")
public class DireccionController {

	@Autowired
	private AdminService adminService;
	
	@Autowired
	private DireccionService direccionService;

	@RequestMapping("/direccion/{idAd}")
	public String showDireccion(Model model, 
			@ModelAttribute("resultado") String resultado, 
			@PathVariable("idAd") int id) throws Exception {

		Admin admin = adminService.findById(id);
		model.addAttribute("admin", admin);		
		model.addAttribute("direccion", new Direccion());
		model.addAttribute("resultado", resultado);
		
		List<Direccion> direcciones = direccionService.findByAdmin(admin);
		model.addAttribute("direcciones", direcciones);

		return "direccionTiles";
	}

	@RequestMapping(value = "/direccion/save", method = RequestMethod.POST) // esta petición sólo obedece a peticiones POST
	public String handleDireccion(Model model, 
			@ModelAttribute("direccion") Direccion direccion, 
			@ModelAttribute("admin") Admin admin, 
			RedirectAttributes ra) throws Exception {


		direccionService.saveOrUpdate(admin, direccion);
		ra.addFlashAttribute("resultado", "Cambios realizados con éxito");

		return "redirect:/direccion/" + admin.getIdAd();
	}

	@RequestMapping(value = "/direccion/{idDir}/update")
	public String showUpdate(Model model, @PathVariable("idDir") int id, RedirectAttributes ra) throws Exception {

		Direccion direccion = direccionService.findById(id);
		model.addAttribute("direccion", direccion);

		return "direccionTiles";
	}

	@RequestMapping(value = "/direccion/{idDir}/delete")
	public String showDelete(@PathVariable("idDir") int id, 
			@ModelAttribute("admin") Admin admin, RedirectAttributes ra) throws Exception {
		
		direccionService.delete(id);
		ra.addFlashAttribute("resultado", "Cambios realizados con éxito");
		
		return "redirect:/direccion/" + admin.getIdAd();
		
	}

}
