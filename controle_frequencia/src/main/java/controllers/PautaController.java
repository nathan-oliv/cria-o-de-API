package controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senai.backend.controle_frequencia.models.pauta;
import com.senai.backend.controle_frequencia.services.Pautaservice.PautaService;

@RestController
@RequestMapping("/pauta")
public class PautaController {

    @Autowired
    private PautaService pautaService;

    @GetMapping("/contar-pautas")
    public Long contarPautas(){
        return pautaService.contarPautas();
    }

    @GetMapping("/buscar-pauta/{id}")
    public pauta buscarPauta(@PathVariable Integer id){
        return pautaService.buscarPauta(id);
    }

    @GetMapping("/listar-pautas")
    public List<pauta> listarPautas(){
        return pautaService.listarPautas();
    }

    @DeleteMapping("/deletar-pauta/{id}")
    public String deletarPauta(@PathVariable Integer id){
        if (pautaService.deletarPauta(id)){
            return "Pauta deletada com sucesso";
        }
        return "Erro ao deletar pauta";
    }

    @PostMapping("/salvar-pauta")
    public pauta cadastrarPauta(@RequestBody pauta pauta){
        return pautaService.cadastrarPauta(pauta);
    }

    @PutMapping("/atualizar-pauta/{id}")
    public String atualizarPauta(
        @PathVariable Integer id,
        @RequestBody pauta pauta
    ){
        if (pautaService.atualizarPauta(id, pauta)!= null){
            return "Pauta atualizada com sucesso";
        }
        return "Erro ao atualizar pauta";
    }
}
