package br.univille.novostalentos.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;



@Data
@Entity
public class Cliente {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(length = 1000, nullable = false)
    @NotBlank(message = "Campo não pode ser em branco!")
    private String nome;
    @Column(length = 3000)
    private String endereco;
    @Pattern(regexp = "Masculino|Feminino",
            flags = Pattern.Flag.CANON_EQ,
            message = "Valor inválido, utilize Masculino ou Feminino!")
    private String sexo;
    @Temporal(value = TemporalType.DATE) // PARA ACEITAR APENAS DATA
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dataNascimento;
    
}
