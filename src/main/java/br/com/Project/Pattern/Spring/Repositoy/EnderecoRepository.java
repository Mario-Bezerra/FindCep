package br.com.Project.Pattern.Spring.Repositoy;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.Project.Pattern.Spring.Model.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, String>{

}
