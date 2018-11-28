package br.com.agenda.projetoagenda.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.agenda.projetoagenda.model.Cliente;
import br.com.agenda.projetoagenda.repository.ClienteRepository;

@Controller
@RequestMapping("/cliente")
@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
public class ClienteController {
	@Autowired
	private ClienteRepository clienteRepository;
	@GetMapping("")
	public ModelAndView index() {
		List<Cliente> listaCliente = this.clienteRepository.findAll();
		
		return new ModelAndView("cliente/index","listapac", listaCliente);
	}
	
	@GetMapping("/novo")
	public String createForm(@ModelAttribute Cliente cliente) {
		return "cliente/form";
	}
	@PostMapping(params="form")
    public ModelAndView save(@Valid Cliente cliente, BindingResult result, RedirectAttributes redirect) {
        
        cliente = this.clienteRepository.save(cliente);
        
        return new ModelAndView("redirect:/cliente");
    }
	@GetMapping(value="/alterar/{cod_cliente}")
    public ModelAndView alterarForm(@PathVariable("cod_cliente") Cliente cliente) {
        return new ModelAndView("cliente/form","cliente",cliente);
    }
	@GetMapping(value="remover/{cod_cliente}")
    public ModelAndView remover(@PathVariable ("cod_cliente") String cod_cliente, RedirectAttributes redirect) {
		try {
			this.clienteRepository.deleteById(Long.parseLong(cod_cliente));
		}catch (Exception e) {
			e.printStackTrace();
		};
        
        return new ModelAndView("redirect:/cliente");
    }
}
