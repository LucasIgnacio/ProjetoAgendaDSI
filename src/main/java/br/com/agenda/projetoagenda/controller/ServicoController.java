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

import br.com.agenda.projetoagenda.model.Servico;
import br.com.agenda.projetoagenda.repository.ServicoRepository;




@Controller
@RequestMapping("/servico")
@PreAuthorize("hasRole('ROLE_ADMIN')")
public class ServicoController {
	@Autowired
	private ServicoRepository servicoRepository;
	@GetMapping("")
	public ModelAndView index() {
		List<Servico> listaServico = this.servicoRepository.findAll();
		
		return new ModelAndView("servico/index","listapac", listaServico);
	}
	
	@GetMapping("/novo")
	public String createForm(@ModelAttribute Servico servico) {
		return "servico/form";
	}
	@PostMapping(params="form")
    public ModelAndView save(@Valid Servico servico, BindingResult result, RedirectAttributes redirect) {
        
        servico = this.servicoRepository.save(servico);
        
        return new ModelAndView("redirect:/servico");
    }
	@GetMapping(value="/alterar/{cod_servico}")
    public ModelAndView alterarForm(@PathVariable("cod_servico") Servico servico) {
        return new ModelAndView("servico/form","servico",servico);
    }
	@GetMapping(value="remover/{cod_servico}")
    public ModelAndView remover(@PathVariable ("cod_servico") String cod_servico, RedirectAttributes redirect) {
		try {
			this.servicoRepository.deleteById(Long.parseLong(cod_servico));
		}catch (Exception e) {
			e.printStackTrace();
		};
        return new ModelAndView("redirect:/servico");
    }
}
