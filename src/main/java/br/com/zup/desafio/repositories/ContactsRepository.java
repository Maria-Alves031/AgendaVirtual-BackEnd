package br.com.zup.desafio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.zup.desafio.models.Contacts;

public interface ContactsRepository extends JpaRepository<Contacts, Long>{

}
