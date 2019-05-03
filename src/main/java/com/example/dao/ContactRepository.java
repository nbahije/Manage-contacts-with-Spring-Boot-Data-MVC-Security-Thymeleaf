package com.example.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entities.Contact;


public interface ContactRepository extends JpaRepository<Contact, Long> {
	

}
