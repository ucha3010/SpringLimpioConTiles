package es.rural.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import es.rural.pojo.Usuario;
import es.rural.service.UsuarioService;
import es.rural.util.valid.SpringFormGroup;

@Controller
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	@RequestMapping("/usuario")
	public ModelAndView showUsuarios(ModelAndView model, @ModelAttribute("resultado") String resultado) throws Exception {

		List<Usuario> usuarios = usuarioService.findAll();

		model.addObject("usuario", new Usuario());
		model.addObject("resultado", resultado);
		model.addObject("usuarios", usuarios);

		model.setViewName("usuarioTiles");
		return model;
	}

	@RequestMapping(value = "/usuario/save", method = RequestMethod.POST) // esta petición sólo obedece a peticiones POST
	public ModelAndView handleUsuarios(@ModelAttribute("usuario") @Validated(value=SpringFormGroup.class) Usuario usuarioForm, 
			BindingResult bindingResult, ModelAndView model, RedirectAttributes ra) throws Exception {

		if(bindingResult.hasErrors()) {
			model.setViewName("usuarioTiles");
			return model;
		}

		if(usuarioService.saveOrUpdate(usuarioForm)) {
			ra.addFlashAttribute("resultado", "Cambios realizados con éxito");
			model.setViewName("redirect:/usuario");
			return model;
		} else {
			model.addObject("usuario", usuarioForm);
			ra.addFlashAttribute("resultado", "Error al intentar guardar");

			model.setViewName("usuarioTiles");
			return model;
		}
	}

	@RequestMapping(value = "/usuario/{idAd}/update")
	public ModelAndView showUpdate(ModelAndView model, @PathVariable("idAd") int id) throws Exception {

		Usuario usuario = usuarioService.findById(id);
		model.addObject("usuario", usuario);

		model.setViewName("usuarioTiles");
		return model;
	}

	@RequestMapping(value = "/usuario/{idAd}/delete")
	public String showDelete(@PathVariable("idAd") int id, RedirectAttributes ra) throws Exception {
		
		usuarioService.delete(id);
		ra.addFlashAttribute("resultado", "Cambios realizados con éxito");

		return "redirect:/usuario";
	}

}
