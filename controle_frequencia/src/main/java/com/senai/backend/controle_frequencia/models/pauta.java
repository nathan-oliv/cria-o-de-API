package com.senai.backend.controle_frequencia.models;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "pauta")
public class pauta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id; // Identificador único da pauta


    @Column(name = "turma")
    private String turma; // Nome da turma associada à pauta

    @OneToMany // Indica uma relação de um para muitos com a entidade usuario
    @JoinColumn(name = "id_pauta") // Especifica a coluna de junção para a relação OneToMany
    private List<usuario> usuarios; // Lista de usuários associados à pauta

    public pauta() {
    }

    public pauta(Integer id, String turma, List<usuario> usuarios) {
        this.id = id;
        this.turma = turma;
        this.usuarios = usuarios;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTurma() {
        return turma;
    }

    public void setTurma(String turma) {
        this.turma = turma;
    }

    public List<usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<usuario> usuarios) {
        this.usuarios = usuarios;
    }

    

}
