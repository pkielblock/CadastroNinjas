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
    public NinjaDTO criarNinja(@RequestBody NinjaDTO ninja) {
        return ninjaService.criarNinja(ninja);
    }

    @GetMapping("/listar")
    public List<NinjaDTO> listarNinjas() {
        return ninjaService.listarNinjas();
    }

    @GetMapping("/listar/{id}")
    public NinjaDTO mostrarNinjaPorID(@PathVariable long id) {
        return ninjaService.listarNinjaPorID(id);
    }

    @PutMapping("/atualizar/{id}")
    public NinjaDTO alterarNinjaPorID(@PathVariable long id, @RequestBody NinjaDTO ninja) {
        return ninjaService.editarNinja(id, ninja);
    }

    @DeleteMapping("/deletar/{id}")
    public void deletarNinjaPorID (@PathVariable long id) {
        ninjaService.deletarNinja(id);
    }
}
