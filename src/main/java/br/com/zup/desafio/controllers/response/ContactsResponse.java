package br.com.zup.desafio.controllers.response;

import br.com.zup.desafio.models.Contacts;

public class ContactsResponse {

	private Long id;
	private String nomeDoContato;
	private String telefone;
	
	public ContactsResponse(Contacts contacts) {
		id = contacts.getId();
		nomeDoContato = contacts.getNomeDoContato();
		telefone = contacts.getTelefone();
	}
	
	public Long getId() {
		return id;
	}
	
	public String getNomeDoContato() {
		return nomeDoContato;
	}

	public String getTelefone() {
		return telefone;
	}
	
}
