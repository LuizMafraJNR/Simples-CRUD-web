package br.univille.novostalentos.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Data
@Entity
public class Cliente {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(length = 1000, nullable = false)
    private String nome;
    @Column(length = 3000)
    private String endereco;
    private String sexo;
    @Temporal(value = TemporalType.DATE) // PARA ACEITAR APENAS DATA
    private Date dataNascimento;
    
}
