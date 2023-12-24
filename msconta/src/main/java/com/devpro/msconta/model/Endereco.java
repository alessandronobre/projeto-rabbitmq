package com.devpro.msconta.model;

import com.devpro.msconta.enums.Cidade;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Table
@Entity
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="cod_endereco")
    private Long id;

    @Column(nullable = false)
    private String rua;

    @Column(nullable = false)
    private int numero;

    @Column
    private String complemento;

    @Column(nullable = false)
    private String bairro;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Cidade cidade;

    @Column(nullable = false)
    private String cep;

    @JsonIgnore
    @OneToOne(mappedBy = "endereco")
    private Cliente cliente;

}
