package dev.kielblock.cadastroninjas.Missoes;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
    @Operation(summary = "Criar Missoes", description = "Esta rota possibilita a criação de novas missoes no sistema.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Missao Criada com Sucesso."),
            @ApiResponse(responseCode = "400", description = "Erro na Criação da Missão.")

    })
    public ResponseEntity<String> criarMissao(@RequestBody MissoesDTO missao) {
        MissoesDTO missaoDTO = missoesService.criarMissao(missao);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Missão Criada com Sucesso: " + missaoDTO.getNome());
    }

    @GetMapping("/listar")
    @Operation(summary = "Listar Missoes", description = "Esta rota possibilita a listagem de todas as missoes no sistema.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Missoes Listadss com Sucesso."),
            @ApiResponse(responseCode = "400", description = "Erro na Listagem das Missoes."),
            @ApiResponse(responseCode = "404", description = "Nenhuma Missao Encontrada.")

    })
    public ResponseEntity<List<MissoesDTO>> listarMissoes() {
        List<MissoesDTO> missoes = missoesService.listarMissoes();
        return ResponseEntity.ok(missoes);
    }

    @GetMapping("/listar/{id}")
    @Operation(summary = "Listar Missao por ID", description = "Esta rota possibilita a listagem de uma única missao do sistema pelo seu ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Missao Listada com Sucesso."),
            @ApiResponse(responseCode = "400", description = "Erro na Listagem da Missao."),
            @ApiResponse(responseCode = "404", description = "Nenhuma Missao com Este ID Encontrado.")

    })
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
    @Operation(summary = "Atualizar Missao", description = "Esta rota possibilita a atualizar os dados de uma missao.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Missao Atualizado com Sucesso."),
            @ApiResponse(responseCode = "400", description = "Erro na Atualização da Missao."),
            @ApiResponse(responseCode = "404", description = "Nenhuma Missao com Este ID Encontrado.")

    })
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
    @Operation(summary = "Deletar Missao", description = "Esta rota possibilita deletar uma missao do sistema pelo seu ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Missao Deletado com Sucesso."),
            @ApiResponse(responseCode = "400", description = "Erro em Deletar a Missao."),
            @ApiResponse(responseCode = "404", description = "Nenhuma Missao com Este ID Encontrado.")

    })
    public ResponseEntity<String> deletarMissaoPorID (@PathVariable long id) {
        if(missoesService.listarMissaoPorID(id) != null) {
            missoesService.deletarMissao(id);
            return ResponseEntity.ok("Missão Deletada ID: " + id);
        } else
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Missão com o ID: " + id + " não encontrada.");
    }
}
