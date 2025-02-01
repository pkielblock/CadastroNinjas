package dev.kielblock.cadastroninjas.Ninjas;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("ninjas")
public class NinjaController {

    @PostMapping("/criar")
    public String criarNinja() {
        return "Ninja Criado";
    }

    @GetMapping("/todos")
    public String mostrarTodosNinjas() {
        return "Mostrar todos Ninjas";
    }

    @GetMapping("/{id}")
    public String mostrarNinjaPorID(@PathVariable long id) {
        return "Mostrar Ninja ID";
    }

    @PutMapping("/editar/{id}")
    public String alterarNinjaPorID(@PathVariable long id) {
        return "Ninja Editado";
    }

    @DeleteMapping("/deletar/{id}")
    public String deletarNinjaPorID (@PathVariable long id) {
        return "Ninja Deletado";
    }
}
