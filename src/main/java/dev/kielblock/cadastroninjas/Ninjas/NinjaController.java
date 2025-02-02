package dev.kielblock.cadastroninjas.Ninjas;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<String> criarNinja(@RequestBody NinjaDTO ninja) {
        NinjaDTO ninjaDTO = ninjaService.criarNinja(ninja);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Ninja Criado Com Sucesso: " + ninjaDTO.getNome() + " ID: " + ninjaDTO.getId());
    }

    @GetMapping("/listar")
    public ResponseEntity<List<NinjaDTO>> listarNinjas() {
        List<NinjaDTO> ninjas = ninjaService.listarNinjas();
        return ResponseEntity.ok(ninjas);
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<?> mostrarNinjaPorID(@PathVariable long id) {
        NinjaDTO ninja = ninjaService.listarNinjaPorID(id);
        if (ninja != null) {
            return ResponseEntity.ok(ninja);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja com o ID: " + id + " não encontrado.");
        }
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<?> alterarNinjaPorID(@PathVariable long id, @RequestBody NinjaDTO ninja) {
        NinjaDTO ninjaDTO = ninjaService.listarNinjaPorID(id);
        if (ninjaDTO != null) {
            return ResponseEntity.ok(ninjaService.editarNinja(id, ninja));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja com o ID: " + id + " não encontrado.");
        }
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarNinjaPorID (@PathVariable long id) {
        if (ninjaService.listarNinjaPorID(id) != null) {
            ninjaService.deletarNinja(id);
            return ResponseEntity.ok("Ninja Deletado ID: " + id);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja com o ID: " + id + " não encontrado.");
        }
    }
}
