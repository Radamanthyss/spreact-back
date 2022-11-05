package com.brunob.api.spreact.Entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "produto")
@Data
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String marca;
}
