package br.com.smca.services;

import br.com.smca.dto.LocalidadeDTO;
import br.com.smca.dto.PacienteDTO;
import br.com.smca.models.Paciente;
import br.com.smca.repositories.LocalidadeDAO;
import br.com.smca.repositories.PacienteRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.*;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private LocalidadeDAO localidadeDAO;

    public Paciente save(PacienteDTO pacienteDTO) {
        ModelMapper mapper = new ModelMapper();
        Paciente paciente = mapper.map(pacienteDTO, Paciente.class);
        try {
            Date date = new Date();
            Timestamp ts = new Timestamp(date.getTime());
            paciente.setDataCadastro(ts);
            return pacienteRepository.save(paciente);
        }catch (Exception e){
            throw new RuntimeException("Ocorreu um erro ao cadastrar paciente");
        }
    }


    public List<PacienteDTO> findAll() {

        List<Paciente> PacientesLst = pacienteRepository.findAll();
        List<PacienteDTO> pacienteDTO = new ArrayList<PacienteDTO>();
        ModelMapper mapper = new ModelMapper();
        for (Paciente paciente : PacientesLst) {
            pacienteDTO.add(mapper.map(paciente, PacienteDTO.class));
        }
        return pacienteDTO;
    }


    public List<LocalidadeDTO> getAllLocalidades() {

        List<LocalidadeDTO> localidadeDTOList = localidadeDAO.listarLocalidades();
        return localidadeDTOList;

    }

    public PacienteDTO findById(Long id) {
        ModelMapper mapper = new ModelMapper();
        Optional<Paciente> pacienteModel = pacienteRepository.findById(id);
        PacienteDTO dto = null;
        if (pacienteModel.isPresent()) {
            return dto = mapper.map(pacienteModel.get(), PacienteDTO.class);
        } else {
            return dto;
        }

    }
}
