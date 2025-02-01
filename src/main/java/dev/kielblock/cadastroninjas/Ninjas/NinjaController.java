package dev.kielblock.cadastroninjas.Ninjas;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("ninjas")
public class NinjaController {

    private final NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @PostMapping("/criar")
    public String criarNinja() {
        return "Ninja Criado";
    }

    @GetMapping("/listar")
    public List<NinjaModel> listarNinjas() {
        return ninjaService.listarNinjas();
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
