package dev.kielblock.cadastroninjas.Missoes;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("missoes")
public class MissoesController {

    private final MissoesService missoesService;

    public MissoesController(MissoesService missoesService) {
        this.missoesService = missoesService;
    }

    @PostMapping("/criar")
    public ResponseEntity<String> criarMissao(@RequestBody MissoesDTO missao) {
        MissoesDTO missaoDTO = missoesService.criarMissao(missao);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Missão Criada com Sucesso: " + missaoDTO.getNome());
    }

    @GetMapping("/listar")
    public ResponseEntity<List<MissoesDTO>> listarMissoes() {
        List<MissoesDTO> missoes = missoesService.listarMissoes();
        return ResponseEntity.ok(missoes);
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<?> listarMissoesPorID(@PathVariable long id) {
       MissoesDTO missao = missoesService.listarMissaoPorID(id);
       if (missao != null) {
           return ResponseEntity.ok(missao);
       } else  {
           return ResponseEntity.status(HttpStatus.NOT_FOUND)
                   .body("Missao com o ID: " + id + " não encontrada.");
       }
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<?> atualizarMissao (@PathVariable long id, @RequestBody MissoesDTO missao) {
        MissoesDTO missoesDTO = missoesService.listarMissaoPorID(id);
        if (missoesDTO != null) {
            return ResponseEntity.ok(missoesService.editarMissao(id, missao));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Missao com o ID: " + id + " não encontrada.");
        }
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarMissaoPorID (@PathVariable long id) {
        if(missoesService.listarMissaoPorID(id) != null) {
            missoesService.deletarMissao(id);
            return ResponseEntity.ok("Missão Deletada ID: " + id);
        } else
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Missão com o ID: " + id + " não encontrada.");
    }
}
