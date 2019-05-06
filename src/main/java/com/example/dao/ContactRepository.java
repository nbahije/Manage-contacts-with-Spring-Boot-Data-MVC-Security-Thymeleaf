package com.example.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entities.Contact;


public interface ContactRepository extends JpaRepository<Contact, Long> {
	
	public Page<Contact> findByNomContains(String mc,Pageable pageable);

}
