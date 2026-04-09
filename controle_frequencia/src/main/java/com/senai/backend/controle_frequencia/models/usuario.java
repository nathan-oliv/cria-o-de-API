// comente a logica do codigo para fins de estudo
// a pasta models é responsável por conter as classes que representam as entidades do sistema
package com.senai.backend.controle_frequencia.models;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity // Indica que esta classe é uma entidade JPA
@Table(name = "usuarios") // Especifica o nome da tabela no banco de dados
public class usuario {

    @Id // Identifica o campo como chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Indica que o valor do ID será gerado automaticamente
    @Column(name = "id") // Especifica o nome da coluna no banco de dados
    private Integer id; // Identificador único do usuário
    
    @Column(name = "nome") // Especifica o nome da coluna no banco de dados
    private String nome; // Nome completo do usuário

    @Column(name = "data_nascimento") // Especifica o nome da coluna no banco de dados
    private LocalDate dataNascimento; // Data de nascimento do usuário

    // construtor padrão
    public usuario() {
    }
    // Este construtor é utilizado para criar um novo objeto usuario com valores específicos
    // clique no botão direito, selecione source action e depois constructor
    // construtor com parâmetros, construtor da classe usuario
    public usuario(Integer id, String nome, LocalDate dataNascimento) {
        this.id = id;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
    }
    public Integer getId() { // Método para obter o ID do usuário
        return id; // Retorna o ID do usuário
    }
    public void setId(Integer id) { // Método para definir o ID do usuário
        this.id = id; // Define o ID do usuário
    }
    public String getNome() { // Método para obter o nome do usuário
        return nome; // Retorna o nome do usuário
    }
    public void setNome(String nome) { // Método para definir o nome do usuário
        this.nome = nome; // Define o nome do usuário
    }
    public LocalDate getDataNascimento() { // Método para obter a data de nascimento do usuário
        return dataNascimento; // Retorna a data de nascimento do usuário
    }
    public void setDataNascimento(LocalDate dataNascimento) { // Método para definir a data de nascimento do usuário
        this.dataNascimento = dataNascimento; // Define a data de nascimento do usuário
    }

    
    

}
