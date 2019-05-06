package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;

import com.example.dao.ContactRepository;
import com.example.entities.Contact;

@Controller
public class ContactController {

	@Autowired
	private ContactRepository contactRepository;
	
	public ContactController() {}
	
	@RequestMapping(value="/index",method=RequestMethod.GET)
	//@GetMapping("/index")
	public String listContacts(Model model, 
			@RequestParam(name="page",defaultValue="0") int page,
			@RequestParam(name="motCle",defaultValue="") String motCle){
		Page<Contact> pageContacts = contactRepository.findAll(PageRequest.of(page, 5));
		model.addAttribute("listContacts", pageContacts.getContent());
		model.addAttribute("pages",new int [pageContacts.getTotalPages()]);
		model.addAttribute("currentPage",page);
		return "contacts";
	}
	
	//Recherche par mot clé
	@RequestMapping(value="/search",method=RequestMethod.GET)
	public String search(Model model, 
			@RequestParam(name="page",defaultValue="0") int page,
			@RequestParam(name="motCle",defaultValue="") String mc){
		Page<Contact> pageContacts = contactRepository.findByNomContains(mc, PageRequest.of(page, 5));
		model.addAttribute("listContacts", pageContacts.getContent());
		model.addAttribute("pages",new int [pageContacts.getTotalPages()]);
		model.addAttribute("currentPage",page);
		model.addAttribute("mc",mc);
		return "contacts";
	}
	

}
