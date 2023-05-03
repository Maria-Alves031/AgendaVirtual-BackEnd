package br.com.zup.desafio.controllers.response;

import java.util.List;
import java.util.stream.Collectors;

import br.com.zup.desafio.models.Contacts;

public class ContactsResponseWrapper {

	public static List<ContactsResponse> list(List<Contacts> contacts){
		return contacts.stream().map(t -> new ContactsResponse(t)).collect(Collectors.toList());
	}
}
