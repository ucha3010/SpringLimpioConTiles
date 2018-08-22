package es.rural.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes({"resultado","nombre","valor"}) //los atributos que pueden mantenerse en sesión y verse en distintas páginas (sección 4 clase 27)
public class indexController {
	
	@RequestMapping("/")
	public ModelAndView showIndex(ModelAndView model) throws Exception {
		//model.addAttribute("resultado", "Resultado desde Session"); //agrega atributo "resultado" a la sesión
		model.addObject("resultado", "Resultado desde Session");
		model.setViewName("indexTiles");
		return model;
	}

	@RequestMapping("/login")
	public ModelAndView showLogin(ModelAndView model) throws Exception {
		model.setViewName("loginTiles");
		return model;		
	}
	
	@RequestMapping("/logout")
	public ModelAndView showLogout(ModelAndView model) throws Exception {
		model.setViewName("logout");
		return model;		
	}
	
	@RequestMapping("/about")
	public String showAbout(SessionStatus sessionStatus) throws Exception {
		//sessionStatus.setComplete(); //elimina TODOS los atributos que están en sesión
		return "aboutTiles";
	}

	@RequestMapping("/index2")
	public ModelAndView showIndex2(ModelAndView model) throws Exception {
		model.addObject("resultado", "Resultado desde index2");
		model.setViewName("redirect:/index3");
		return model;
	}

	@RequestMapping("/index3")
	public ModelAndView showIndex3(ModelAndView model) throws Exception {
		model.setViewName("index3Tiles");
		return model;
	}

}
