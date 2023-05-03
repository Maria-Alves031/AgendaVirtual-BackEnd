package br.com.zup.desafio.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.desafio.controllers.request.ContactsRequest;
import br.com.zup.desafio.controllers.response.ContactsResponse;
import br.com.zup.desafio.controllers.response.ContactsResponseWrapper;
import br.com.zup.desafio.models.Contacts;
import br.com.zup.desafio.repositories.ContactsRepository;

@RequestMapping("/api/contatos")
@RestController
public class ContactController {

	@Autowired
	private ContactsRepository repository;
	
	@PostMapping
	public void create(@RequestBody ContactsRequest contactsRequest) {
		repository.save(contactsRequest.toNewContact());
	}
	
	@GetMapping
	public List<ContactsResponse> list() {
		List<Contacts> contacts = repository.findAll();
		return ContactsResponseWrapper.list(contacts);
	}
	
	@GetMapping ("/{id}")
	public ResponseEntity<?> find(@PathVariable Long id) {
		Optional<Contacts> possibleContact = repository.findById(id);
		if(possibleContact.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(new ContactsResponse(possibleContact.get()));
	}
	
	@PutMapping ("/{id}")
	public ResponseEntity<?> update(@PathVariable Long id, @RequestBody ContactsRequest contactRequest) {
		Contacts contacts = contactRequest.toUpdateContact(repository, id);
		if(contacts == null) {
			return ResponseEntity.notFound().build();
		}
		repository.save(contacts);
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping ("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		Optional<Contacts> possibleContact = repository.findById(id);
		if(possibleContact.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		repository.deleteById(id);
		return ResponseEntity.noContent().build();
	}
}
