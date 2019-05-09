package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.validation.Valid;

import com.example.dao.ContactRepository;
import com.example.entities.Contact;

@Controller
public class ContactController {

	@Autowired
	private ContactRepository contactRepository;

	public ContactController() {
	}

	@RequestMapping(value = "/user/index", method = RequestMethod.GET)
	public String listContacts(Model model, @RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "motCle", defaultValue = "") String motCle) {
		Page<Contact> pageContacts = contactRepository.findAll(PageRequest.of(page, 5));
		model.addAttribute("listContacts", pageContacts.getContent());
		model.addAttribute("pages", new int[pageContacts.getTotalPages()]);
		model.addAttribute("currentPage", page);
		return "contacts";
	}

	// Recherche par mot clé
	@RequestMapping(value = "/user/search", method = RequestMethod.GET)
	public String search(Model model, @RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "motCle", defaultValue = "") String motCle) {
		Page<Contact> pageContacts = contactRepository.findByNomContains(motCle, PageRequest.of(page, 5));
		model.addAttribute("listContacts", pageContacts.getContent());
		model.addAttribute("pages", new int[pageContacts.getTotalPages()]);
		model.addAttribute("currentPage", page);
		model.addAttribute("motCle", motCle);
		return "contacts";
	}

	@RequestMapping(value = "/admin/delete", method = RequestMethod.GET)
	public String delete(Long id, int page, String motCle) {
		contactRepository.deleteById(id);
		return "redirect:/search?page=" + page + "&motCle=" + motCle;
	}

	@GetMapping(value = "/admin/formContact")
	public String formContact(Model model) {
		model.addAttribute("contact", new Contact());
		return "formContact";
	}

	@PostMapping(value = "/admin/addContact")
	public String saveContact(Model model, @Valid Contact contact, BindingResult bindingResult) throws ParseException {
		if (bindingResult.hasErrors())
			return "formContact";
		contactRepository.save(contact);
		return "redirect:/user/search";
	}

	@GetMapping(value = "/admin/formEditContact")
	public String formEditContact(Model model, Long id) {
		
		model.addAttribute("contact", contactRepository.findById(id).get());
		return "formEditContact";
	}
	
	@GetMapping("/")
	public String byDefault() {
		return "redirect:/user/search";
	}
	
	@GetMapping("/403")
	public String httpExceptionErrorPage() {
		return "403";
	}

	@GetMapping("/login")
	public String login() {
		return "login";
	}
}
