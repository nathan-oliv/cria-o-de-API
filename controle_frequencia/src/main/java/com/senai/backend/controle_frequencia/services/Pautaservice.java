//comente toda logica do codigo e oque ele faz
package com.senai.backend.controle_frequencia.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senai.backend.controle_frequencia.models.pauta;
import com.senai.backend.controle_frequencia.repositories.PautaRepository;


public class Pautaservice {

    @Service
    public class PautaService{//Classe de serviço para gerenciar as pautas

        @Autowired//Injeção de dependência do repositório de pautas
        private PautaRepository pautaRepository;//Repositório para acesso aos dados das pautas

        public long contarPautas(){//Contar o número de pautas
            return pautaRepository.count();//Retorna o número total de pautas
        }   

        public pauta buscarPauta(Integer id){//Buscar uma pauta pelo ID
            return pautaRepository.findById(id).get();//Retorna a pauta encontrada ou lança uma exceção
        }

        public List<pauta> listarPautas(){//Listar todas as pautas
            return pautaRepository.findAll();//Retorna a lista de todas as pautas
        }

        public Boolean deletarPauta(Integer id){//Deletar uma pauta pelo ID
            if(pautaRepository.existsById(id)){//Verifica se a pauta existe
                pautaRepository.deleteById(id);//Deleta a pauta
                return true;//Retorna verdadeiro se a deleção foi bem-sucedida
            }
            return false;//Retorna falso se a pauta não foi encontrada
        }

        public pauta cadastrarPauta(pauta pauta){//Cadastrar uma nova pauta
            return pautaRepository.save(pauta);//Salva a pauta e retorna a pauta salva
        }

        public pauta atualizarPauta(Integer id, pauta pauta){
            pauta pautaRecuperada = buscarPauta(id);
            if (pautaRecuperada != null){
                pautaRecuperada.setId(id);
                if(pauta.getTurma()!=null){
                    pautaRecuperada.setTurma(pauta.getTurma());
                }
                return pautaRepository.save(pautaRecuperada);   
            } 
            return null;
        }


    }

}
