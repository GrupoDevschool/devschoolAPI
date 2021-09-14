package br.com.devschool.devschool.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.devschool.devschool.model.Gestor;

public interface GestorRepository extends JpaRepository<Gestor , Integer> {

}
