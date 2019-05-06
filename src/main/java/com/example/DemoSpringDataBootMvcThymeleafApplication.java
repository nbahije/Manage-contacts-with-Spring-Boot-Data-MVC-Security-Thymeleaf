package com.example;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.dao.ContactRepository;
import com.example.entities.Contact;

/**
 * @author BAHIJE
 * @date 29 avr. 2019 12:54:44
 */
@SpringBootApplication
public class DemoSpringDataBootMvcThymeleafApplication implements CommandLineRunner {

//	@Autowired
//	private ContactRepository contactRepository;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(DemoSpringDataBootMvcThymeleafApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyyy");
//		contactRepository.save(new Contact("3SILA", "Mhmed", dateFormat.parse("12/04/1986"), "", "3sila@gmail.com", 0623015566));
//		contactRepository.save(new Contact("SMINA", "Ghdifa", dateFormat.parse("03/04/1950"), "", "smina@gmail.com", 0653015566));
//		contactRepository.save(new Contact("SAMATI", "Kiki", dateFormat.parse("02/06/1955"), "", "samati@hotmail.com", 067015566));
//		contactRepository.save(new Contact("KRIKIBA", "Toutou", dateFormat.parse("01/04/1931"), "", "krikiba@yahoo.fr", 0612121313));
//		
//		contactRepository.findAll().forEach(c->{
//			System.out.println(c.getNom());
//		});
	}

}
