package dev.kielblock.cadastroninjas.Missoes;

import dev.kielblock.cadastroninjas.Ninjas.NinjaModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tb_missoes")
public class MissoesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String nome;
    private DificuldadeMissao dificuldade;

    //UM ninja vai ter MUITAS missoes
    @OneToMany(mappedBy = "missoes")
    private List<NinjaModel> ninjas;
}
