package controllers;
 
    import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senai.backend.controle_frequencia.models.usuario;
import com.senai.backend.controle_frequencia.services.UsuarioServices;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioServices UsuarioServices; 

    @GetMapping("/contar-usuarios")
    public long contarUsuarios() {
        return UsuarioServices.contarUsuarios();
    }

    @GetMapping("/buscar-usuario/{id}")
    public usuario buscarUsuario(@PathVariable Integer id) {
        return UsuarioServices.buscarUsuarioa(id);
    }

    public List<usuario> listarUsuarios() {
        return UsuarioServices.listarUsuarios();
    }

    @DeleteMapping("/deletar-usuario/{id}")
    public String deletarUsuario(@PathVariable Integer id) {
        if(UsuarioServices.deletarUsuario(id)){
            return "Usuario deletado com sucesso";
        } 
            return "Usuario não encontrado";
        }
        @PostMapping("/salvar-usuario")
        public usuario cadastrarUsuario( @RequestBody usuario usuario) {
            return UsuarioServices.cadastrarUsuario(usuario);
        }
        @PutMapping("/atualizar-usuario/{id}")
        public String atualizarUsuario(@PathVariable Integer id, @RequestBody usuario usuario) {
            if (UsuarioServices.atualizarUsuario(id, usuario)!= null) {
                return "Usuario atualizado com sucesso";
            }
            return "Falha ao atualizar usuario";
        }

        
     }


    
