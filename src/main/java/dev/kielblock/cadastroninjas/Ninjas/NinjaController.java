package dev.kielblock.cadastroninjas.Ninjas;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class NinjaController {

    @PostMapping("/criar")
    public String criarNinja() {
        return "Ninja Criado";
    }

    @GetMapping("/todos")
    public String mostrarTodosNinjas() {
        return "Mostrar todos Ninjas";
    }

    @GetMapping("/ninja-{id}")
    public String mostrarNinjaPorID(long id) {
        return "Mostrar Ninja ID";
    }

    @PutMapping("/editar-{id}")
    public String alterarNinjaPorID(long id) {
        return "Ninja Editado";
    }

    @DeleteMapping("/deletar-{id}")
    public String deletarNinjaPorID (long id) {
        return "Ninja Deletado";
    }
}
