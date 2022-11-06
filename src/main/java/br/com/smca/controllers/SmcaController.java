package br.com.smca.controllers;

import br.com.smca.dto.PacienteDTO;
import br.com.smca.models.Paciente;
import br.com.smca.services.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api")
public class SmcaController {

    @Autowired
    private PacienteService pacienteService;

    @GetMapping("/hello")
    public String helloWorld(){
        return "hello World!";
    }

    @PostMapping("/pacientes")
    public ResponseEntity<PacienteDTO> salvarPaciente(@Valid @RequestBody PacienteDTO pacienteDTO){
        Paciente retModel = pacienteService.save(pacienteDTO);
        pacienteDTO.setPacienteId(retModel.getPacienteId());
        pacienteDTO.setDataCadastro(retModel.getDataCadastro());
        return new ResponseEntity<PacienteDTO>(pacienteDTO, HttpStatus.CREATED);
    }

    @GetMapping("/pacientes")
    public ResponseEntity<List<PacienteDTO>> getAllPacientes() {

        List<PacienteDTO> pacientesLst = pacienteService.findAll();
        if(pacientesLst.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else {
            return new ResponseEntity<List<PacienteDTO>>(pacientesLst, HttpStatus.OK);
        }

    }

    @GetMapping("/pacientes/{id}")
    public ResponseEntity<PacienteDTO> getPacienteEspecifico(@PathVariable(value = "id") Long id) {
        PacienteDTO pacienteDTO = pacienteService.findById(id);
        if (pacienteDTO != null) {
            return new ResponseEntity<PacienteDTO>(pacienteDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/pacientes/localidade")
    public ResponseEntity<Map<String,Long>> getAllLocalidades() {

        List<PacienteDTO> pacientesLst = pacienteService.findAll();
        if(pacientesLst.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else {
            Map<String,Long> mapa = pacientesLst.stream()
                    .collect(Collectors.groupingBy(PacienteDTO::getBairro, Collectors.counting()));
            return new ResponseEntity<>(mapa, HttpStatus.OK);
        }

    }

}
