package br.com.smca.models;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
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

    @NotBlank
    @Size(max=100)
    @Column()
    private String nomeCompleto;

    @NotBlank
    @Size(max=10)
    @Column()
    private String dataNascimento;

    @NotBlank
    @Column()
    private String bairro;

    @Column()
    private Timestamp dataCadastro;

    @NotBlank
    @Column()
    private String telefone;

    @NotBlank
    @Email
    @Column()
    private String email;

}
