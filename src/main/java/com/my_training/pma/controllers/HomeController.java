package com.my_training.pma.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.my_training.pma.businesslogic.ProjectDTO;
import com.my_training.pma.businesslogic.ProjectService;

@Controller
@RequestMapping("/")
public class HomeController {
	
	@Value("${version}")
	private String ver;
	@Autowired
	ProjectService projectService;
	
	@GetMapping("/")
	public  String home(Model model ) {
		//per visualizzare la versione del progetto specificato nelle proprieta
		model.addAttribute("versionNumber", ver);
		List<ProjectDTO>projects= projectService.findAll();
		
		model.addAttribute("projects", projects);
		return "main/home";
	}

}
