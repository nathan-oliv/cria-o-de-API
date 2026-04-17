//a pasta service é responsável por conter a lógica de negócio da aplicação
// Ela interage com os repositórios para realizar operações de CRUD
//comente todo o codigo e a logica de cada coisa
package com.senai.backend.controle_frequencia.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senai.backend.controle_frequencia.models.usuario;
import com.senai.backend.controle_frequencia.repositories.UsuarioRepository;

@Service
public class UsuarioServices {

    @Autowired // Injeção de dependência do repositório de usuários, Autowired é uma anotação que permite a injeção automática de dependências
    private UsuarioRepository usuarioRepository; // Repositório para acesso a dados de usuários



    public long contarUsuarios(){ // Método para contar o número de usuários, long é para representar um número inteiro grande
        return usuarioRepository.count(); // Retorna a contagem de usuários do repositório
    }



    public usuario buscarUsuarioa(Integer id){ // Método para buscar um usuário pelo ID
        return usuarioRepository.findById(id).get(); // Retorna o usuário encontrado ou lança uma exceção se não existir
    }


    public List<usuario> listarUsuarios(){ // Método para listar todos os usuários, list<> é para representar uma coleção de objetos do tipo Usuario
        return usuarioRepository.findAll(); // Retorna a lista de todos os usuários do repositório
    }


    public Boolean deletarUsuario(Integer id){ // Método para deletar um usuário pelo ID
        if(usuarioRepository.existsById(id)){// Verifica se o usuário existe
            usuarioRepository.deleteById(id); // Deleta o usuário do repositório
            return true; // Retorna verdadeiro se a deleção foi bem-sucedida
        }
        return false; // Retorna falso se o usuário não foi encontrado
    }


    public usuario cadastrarUsuario(usuario usuario){ // Método para cadastrar um novo usuário
        return usuarioRepository.save(usuario); // Salva o usuário no repositório e retorna o usuário salvo
    }


    public usuario atualizarUsuario(Integer id, usuario usuario){ // Método para atualizar um usuário existente
        usuario usuarioRecuperado = buscarUsuarioa(id);
        if(usuarioRecuperado != null) {
           usuarioRecuperado.setId(id);
           if (usuario.getNome() != null) {
               usuarioRecuperado.setNome(usuario.getNome());
            }
              if (usuario.getDataNascimento() != null) {
                usuarioRecuperado.setDataNascimento(usuario.getDataNascimento());
               }
               if (usuario.getDataNascimento() != null) {
                   usuarioRecuperado.setDataNascimento
                   (usuario.getDataNascimento());
                }
             return usuarioRepository.save(usuarioRecuperado);
        }
        return null;
    }
}