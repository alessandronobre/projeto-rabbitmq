package com.devpro.msconta.model;

import com.devpro.msconta.enums.Reputacao;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Table
@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="cod_cliente")
    private Long id;

    @Column(nullable = false)
    private String nome;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name="cod_endereco", nullable = false)
    private Endereco endereco;

    @Column(nullable = false, unique = true)
    private int conta;

    @Column(nullable = false)
    private int agencia;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Reputacao reputacao;

}
