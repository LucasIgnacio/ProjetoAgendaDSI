package br.com.agenda.projetoagenda.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import br.com.agenda.projetoagenda.model.UserLogin;

@Repository
public interface UserLoginRepository extends JpaRepository<UserLogin, Long> {
	UserLogin findByUsername(String username);
}