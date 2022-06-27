package br.com.Project.Pattern.Spring.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.Project.Pattern.Spring.Model.Cliente;
import br.com.Project.Pattern.Spring.Model.Endereco;
import br.com.Project.Pattern.Spring.Repositoy.ClienteRepository;
import br.com.Project.Pattern.Spring.Repositoy.EnderecoRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private EnderecoRepository enderecoRepository;

	@Autowired
	private ViaCepService viaCepService;

	public Iterable<Cliente> buscarTodos() {
		return clienteRepository.findAll();
	}

	public Cliente buscarPorId(Long id) {
		return clienteRepository.findById(id).get();
	}

	public void inserirCliente(Cliente cliente) {
		salvarClienteComCep(cliente);
	}

	public void atualizarCliente(Long id, Cliente cliente) {
		Optional<Cliente> clienteBD = clienteRepository.findById(id);
		if (clienteBD.isPresent()) {
			salvarClienteComCep(cliente);
		}

	}

	public void deletarCliente(Long id) {
		clienteRepository.deleteById(id);

	}

	private void salvarClienteComCep(Cliente cliente) {
		String cep = cliente.getEndereco().getCep();
		Endereco enderecoProcurado = enderecoRepository.findById(cep).orElseGet(() -> {
			Endereco cepConsultado = viaCepService.consultarCep(cep);
			enderecoRepository.save(cepConsultado);
			return cepConsultado;
		});
		cliente.setEndereco(enderecoProcurado);
		clienteRepository.save(cliente);
	}
}
