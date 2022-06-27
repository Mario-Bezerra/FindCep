package br.com.Project.Pattern.Spring.Repositoy;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.Project.Pattern.Spring.Model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente , Long>{
	

}
