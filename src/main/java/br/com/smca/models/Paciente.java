package br.com.smca.models;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Data
@Table(name = "TB_PACIENTE")
public class Paciente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pacienteId;

    @Column(unique = true)
    private Long cpf;

    @Column()
    private String nomeCompleto;

    @Column()
    private String dataNascimento;

    @Column()
    private String bairro;

    @Column()
    private Timestamp dataCadastro;

}
