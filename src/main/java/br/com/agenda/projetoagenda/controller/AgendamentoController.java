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

import br.com.agenda.projetoagenda.model.Agendamento;
import br.com.agenda.projetoagenda.repository.AgendamentoRepository;




@Controller
@RequestMapping("/agendamento")
@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
public class AgendamentoController {
	@Autowired
	private AgendamentoRepository agendamentoRepository;
	@GetMapping("")
	public ModelAndView index() {
		List<Agendamento> listaAgendamento = this.agendamentoRepository.findAll();
		
		return new ModelAndView("agendamento/index","listapac", listaAgendamento);
	}
	
	@GetMapping("/novo")
	public String createForm(@ModelAttribute Agendamento agendamento) {
		return "agendamento/form";
	}
	@PostMapping(params="form")
    public ModelAndView save(@Valid Agendamento agendamento, BindingResult result, RedirectAttributes redirect) {
        
        agendamento = this.agendamentoRepository.save(agendamento);
        
        return new ModelAndView("redirect:/agendamento");
    }
	@GetMapping(value="/alterar/{cod_agenda}")
    public ModelAndView alterarForm(@PathVariable("cod_agenda") Agendamento agendamento) {
        return new ModelAndView("agendamento/form","agendamento",agendamento);
    }
	@GetMapping(value="remover/{cod_agenda}")
    public ModelAndView remover(@PathVariable ("cod_agenda") String cod_agenda, RedirectAttributes redirect) {
        try{
        	this.agendamentoRepository.deleteById(Long.parseLong(cod_agenda));
        }catch (Exception e) {
			e.printStackTrace();
		};
        return new ModelAndView("redirect:/agendamento");
    }
}
