package com.fruit.frontend.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping( "/finding" )
public class FindingController extends AbstractController {

	@RequestMapping( value = "/list", method = RequestMethod.GET )
	@ResponseStatus( HttpStatus.OK )
	public ModelAndView list() throws Exception {
		
		ModelAndView modelAndView = new ModelAndView("finding");
		modelAndView.addObject("findings", getFindingLibraryService().getAllFindings());
		
		return modelAndView;
	}
}
