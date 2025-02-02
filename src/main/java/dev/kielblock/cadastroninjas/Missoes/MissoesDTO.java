package dev.kielblock.cadastroninjas.Missoes;

import dev.kielblock.cadastroninjas.Ninjas.NinjaModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MissoesDTO {

    private long id;
    private String nome;
    private String dificuldade;
    private List<NinjaModel> ninjas;
}
