package br.com.agenda.projetoagenda.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.agenda.projetoagenda.model.Cliente;
import br.com.agenda.projetoagenda.repository.ClienteRepository;

@RestController
@RequestMapping("/api/cliente")
public class ClienteControllerAPI {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@GetMapping
	public ResponseEntity<List<Cliente>> listarClientes(){
		List<Cliente> lista = clienteRepository.findAll();
		return new ResponseEntity<List<Cliente>>(lista,HttpStatus.OK);
	}
	@PostMapping
	public ResponseEntity<?> sabe(@RequestBody Cliente cliente){
		clienteRepository.save(cliente);
		return ResponseEntity.ok().build();
	}
	@PutMapping(path="/{cod_cliente}")
	public ResponseEntity<?> update(@PathVariable("cod_cliente")long cod_cliente, @RequestBody Cliente newCliente){
		Optional<Cliente> talvezCliente = clienteRepository.findById(cod_cliente);
		if(!talvezCliente.isPresent())
			return ResponseEntity.notFound().build();
		Cliente oldCliente = talvezCliente.get();
		oldCliente.setNomeCliente(newCliente.getNomeCliente());
		oldCliente.setSexoCliente(newCliente.getSexoCliente());
		oldCliente.setCepCliente(newCliente.getCepCliente());
		oldCliente.setEndCliente(newCliente.getEndCliente());
		oldCliente.setBairroCliente(newCliente.getBairroCliente());
		oldCliente.setCidadeCliente(newCliente.getCidadeCliente());
		oldCliente.setCellCliente(newCliente.getCellCliente());
		
		clienteRepository.save(oldCliente);
		return ResponseEntity.ok().build();
	}
	@DeleteMapping(path="/{cod_cliente}")
	public ResponseEntity<?> delete(@PathVariable("cod_cliente")long cod_cliente){
		Optional<Cliente> talvezCliente = clienteRepository.findById(cod_cliente);
		if(!talvezCliente.isPresent())
			return ResponseEntity.notFound().build();
		clienteRepository.delete(talvezCliente.get());
		return ResponseEntity.ok().build();
	}

}
