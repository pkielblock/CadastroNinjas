package dev.kielblock.cadastroninjas.Missoes;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("missoes")
public class MissoesController {
    @GetMapping("/listar")
    public String listarMissoes() {
        return "Missões Listadas";
    }

    @GetMapping("/listar/{id}")
    public String listarMissoesPorID(@PathVariable long id) {
        return "Missões Listadas";
    }

    @PostMapping("/criar")
    public String criarMissao() {
        return "Missão Criada";
    }

    @PutMapping("/alterar/{id}")
    public String alterarMissaoPorID (@PathVariable long id) {
        return "Missão Alterada";
    }

    @DeleteMapping("/deletar/{id}")
    public String deletarMissaoPorID (@PathVariable long id) {
        return "Missão Deletada";
    }
}
