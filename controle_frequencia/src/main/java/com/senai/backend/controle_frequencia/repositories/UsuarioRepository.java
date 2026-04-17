package com.senai.backend.controle_frequencia.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.senai.backend.controle_frequencia.models.usuario;

@Repository // Repository serve para encapsular a lógica de acesso a dados
public interface UsuarioRepository extends JpaRepository<usuario, Integer> { // Interface para acesso a dados de pautas

}
