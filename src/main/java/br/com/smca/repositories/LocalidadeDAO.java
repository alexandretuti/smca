package br.com.smca.repositories;

import br.com.smca.dto.LocalidadeDTO;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class LocalidadeDAO {

    @PersistenceContext
    private EntityManager manager;

    public List<LocalidadeDTO> listarLocalidades(){

        Query query = manager.createNativeQuery("\n" +
                "select count(1) as qtdeCasos, bairro from  smca.tb_paciente  \n" +
                "group by bairro;" , LocalidadeDTO.class);

        return query.getResultList();

    }

}
