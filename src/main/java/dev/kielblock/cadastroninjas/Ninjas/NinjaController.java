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

    @GetMapping("/listar/{id}")
    public NinjaModel mostrarNinjaPorID(@PathVariable long id) {
        return ninjaService.listarNinjaPorID(id);
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
