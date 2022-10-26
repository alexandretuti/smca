package br.com.smca.repositories;

import br.com.smca.models.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {
}
