package es.rural.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import es.rural.pojo.Admin;
import es.rural.service.AdminService;

@Controller
public class AdminController {

	@Autowired
	private AdminService adminService;

	@RequestMapping("/admin")
	public String showAdmin(Model model,
			@ModelAttribute("resultado") String resultado) throws Exception {

		List<Admin> admins = adminService.findAll();


		model.addAttribute("admin", new Admin());
		model.addAttribute("resultado", resultado);
		model.addAttribute("admins", admins);

		return "adminTiles";
	}

	@RequestMapping(value = "/admin/save", method = RequestMethod.POST) // esta petición sólo obedece a peticiones POST
	public String handleAdmin(@ModelAttribute("admin") Admin adminForm,
			Model model, RedirectAttributes ra) throws Exception {

		adminService.saveOrUpdate(adminForm);
		ra.addFlashAttribute("resultado", "Cambios realizados con éxito"); // este atributo se puede llevar a la
																			// siguiente página y entraría con
																			// @ModelAttribute

		return "redirect:/admin"; // redirijo para que si le dan a F5 no esté entrando en este método a cada rato
									// y llenando la base de datos con basura
	}

	@RequestMapping(value = "/admin/{idAd}/update")
	public String showUpdate(Model model, @PathVariable("idAd") int id) throws Exception {

		Admin admin = adminService.findById(id);
		model.addAttribute("admin", admin);

		return "admin";
	}

	@RequestMapping(value = "/admin/{idAd}/delete")
	public String showDelete(@PathVariable("idAd") int id, RedirectAttributes ra) 
		throws Exception {
		adminService.delete(id);
		ra.addFlashAttribute("resultado", "Cambios realizados con éxito");

		return "redirect:/admin";
	}
	

	@RequestMapping(value="/admin/json/search", produces="application/json")
	@ResponseBody
	public Map<String, Object> findAll(@RequestParam("term") String nombreAdmin) {
		Map<String, Object> map = new HashMap<String, Object>();

		List<Admin> admins = adminService.findAllLikeNombre(nombreAdmin);

		for (int i = 0; i < admins.size(); i++) {
			Admin admin = admins.get(i);
			map.put("nombre" + i, admin.getIdAd() + " " + admin.getNombre());
		}
		System.out.println(map.toString());

		return map;
	}

}
