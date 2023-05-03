package br.com.zup.desafio.controllers.request;

import java.util.Optional;

import br.com.zup.desafio.models.Contacts;
import br.com.zup.desafio.repositories.ContactsRepository;

public class ContactsRequest {
	
	private String nomeDoContato;
	private String telefone;
	
	public Contacts toNewContact() {
		Contacts contacts = new Contacts();
		contacts.setNomeDoContato(nomeDoContato);
		contacts.setTelefone(telefone);
		return contacts;
	}
	
	public Contacts toUpdateContact(ContactsRepository repository, Long id) {
		Optional<Contacts> possibleContact = repository.findById(id);
		if(possibleContact.isEmpty()) {
			return null;
		}
		Contacts contacts = possibleContact.get();
		contacts.setNomeDoContato(nomeDoContato);
		contacts.setTelefone(telefone);
		
		return contacts;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getNomeDoContato() {
		return nomeDoContato;
	}

	public void setNomeDoContato(String nomeDoContato) {
		this.nomeDoContato = nomeDoContato;
	}
	
}
