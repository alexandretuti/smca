package br.com.smca.dto;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class PacienteDTO {

    private Long pacienteId;
    private Long cpf;
    private String nomeCompleto;
    private String dataNascimento;
    private String bairro;
    private Timestamp dataCadastro;
}
