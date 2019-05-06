package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	public String listContacts(Model model) {
		List<Contact> listContacts = contactRepository.findAll();
		model.addAttribute("listContacts", listContacts);
		return "contacts";
	}
	

}
