package es.rural.controller;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GeneralExceptionHandler {
	
	@ExceptionHandler(Exception.class)
	public ModelAndView handlerException(Exception ex) {
		return mensaje(ex);
	}
	
	@ExceptionHandler(DataIntegrityViolationException.class)
	public ModelAndView handlerDataIntegrityViolationException(DataIntegrityViolationException ex) {
		return mensaje(ex);
	}
	
	@ExceptionHandler(ConstraintViolationException.class)
	public ModelAndView handlerConstraintViolationException(ConstraintViolationException ex) {
		return mensaje(ex);
	}
	
	private ModelAndView mensaje (Exception ex) {
		ModelAndView model = new ModelAndView();
		model.addObject("errorLog", ex.toString());
		model.setViewName("error");
		return model;
		
	}
	
	@ExceptionHandler(HttpMediaTypeNotAcceptableException.class)
	public ModelAndView handleHttpMediaTypeNotAcceptableException(HttpMediaTypeNotAcceptableException ex) {
		return mensaje(ex);
	}

}
