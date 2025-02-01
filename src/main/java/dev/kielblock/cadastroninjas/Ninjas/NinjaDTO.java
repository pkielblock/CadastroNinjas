package dev.kielblock.cadastroninjas.Ninjas;

import dev.kielblock.cadastroninjas.Missoes.MissoesModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class NinjaDTO {

    private long id;
    private String nome;
    private String email;
    private String imgUrl;
    private int idade;
    private MissoesModel missoes;
    private String rank;
}
