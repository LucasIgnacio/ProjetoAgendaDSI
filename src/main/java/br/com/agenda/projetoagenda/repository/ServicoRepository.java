package br.com.agenda.projetoagenda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.agenda.projetoagenda.model.Servico;

@Repository
public interface ServicoRepository extends JpaRepository<Servico, Long>{

}
