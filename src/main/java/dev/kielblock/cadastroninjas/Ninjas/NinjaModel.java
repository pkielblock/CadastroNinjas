package dev.kielblock.cadastroninjas.Ninjas;

import dev.kielblock.cadastroninjas.Missoes.MissoesModel;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tb_ninjas")
public class NinjaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String nome;

    @Column(unique = true)
    private String email;
    private int idade;

    //MUITOS Ninjas vao ter UMA missao
    @ManyToOne
    @JoinColumn(name = "missoes_id")
    private MissoesModel missao;
}
