package dev.kielblock.cadastroninjas.Ninjas;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
    @Operation(summary = "Criar Ninjas", description = "Esta rota possibilita a criação de novos ninjas no sistema.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Ninja Criado com Sucesso."),
            @ApiResponse(responseCode = "400", description = "Erro na Criação do Ninja.")

    })
    public ResponseEntity<String> criarNinja(@RequestBody NinjaDTO ninja) {
        NinjaDTO ninjaDTO = ninjaService.criarNinja(ninja);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Ninja Criado Com Sucesso: " + ninjaDTO.getNome() + " ID: " + ninjaDTO.getId());
    }

    @GetMapping("/listar")
    @Operation(summary = "Listar Ninjas", description = "Esta rota possibilita a listagem de todos os ninjas no sistema.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ninjas Listados com Sucesso."),
            @ApiResponse(responseCode = "400", description = "Erro na Listagem dos Ninjas."),
            @ApiResponse(responseCode = "404", description = "Nenhum Ninja Encontrado.")

    })
    public ResponseEntity<List<NinjaDTO>> listarNinjas() {
        List<NinjaDTO> ninjas = ninjaService.listarNinjas();
        return ResponseEntity.ok(ninjas);
    }

    @GetMapping("/listar/{id}")
    @Operation(summary = "Listar Ninja por ID", description = "Esta rota possibilita a listagem de um único ninja do sistema pelo seu ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ninja Listado com Sucesso."),
            @ApiResponse(responseCode = "400", description = "Erro na Listagem do Ninja."),
            @ApiResponse(responseCode = "404", description = "Nenhum Ninja com Este ID Encontrado.")

    })
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
    @Operation(summary = "Atualizar Ninja", description = "Esta rota possibilita a atualizar os dados de um ninja.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ninja Atualizado com Sucesso."),
            @ApiResponse(responseCode = "400", description = "Erro na Atualização do Ninja."),
            @ApiResponse(responseCode = "404", description = "Nenhum Ninja com Este ID Encontrado.")

    })
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
    @Operation(summary = "Deletar Ninja", description = "Esta rota possibilita deletar um ninja do sistema pelo seu ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ninja Deletado com Sucesso."),
            @ApiResponse(responseCode = "400", description = "Erro em Deletar o Ninja."),
            @ApiResponse(responseCode = "404", description = "Nenhum Ninja com Este ID Encontrado.")

    })
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
