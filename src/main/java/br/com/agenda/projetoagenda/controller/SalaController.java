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

import br.com.agenda.projetoagenda.model.Sala;
import br.com.agenda.projetoagenda.repository.SalaRepository;

@Controller
@RequestMapping("/sala")
@PreAuthorize("hasRole('ROLE_ADMIN')")
public class SalaController {
	@Autowired
	private SalaRepository salaRepository;
	@GetMapping("")
	public ModelAndView index() {
		List<Sala> listaSala = this.salaRepository.findAll();
		
		return new ModelAndView("sala/index","listapac", listaSala);
	}
	
	@GetMapping("/novo")
	public String createForm(@ModelAttribute Sala sala) {
		return "sala/form";
	}
	@PostMapping(params="form")
    public ModelAndView save(@Valid Sala sala, BindingResult result, RedirectAttributes redirect) {
        
        sala = this.salaRepository.save(sala);
        
        return new ModelAndView("redirect:/sala");
    }
	@GetMapping(value="/alterar/{cod_sala}")
    public ModelAndView alterarForm(@PathVariable("cod_sala") Sala sala) {
        return new ModelAndView("sala/form","sala",sala);
    }
	@GetMapping(value="remover/{cod_sala}")
    public ModelAndView remover(@PathVariable ("cod_sala") String cod_sala, RedirectAttributes redirect) {
		try {
			this.salaRepository.deleteById(Long.parseLong(cod_sala));
		}catch (Exception e) {
			e.printStackTrace();
		};
        return new ModelAndView("redirect:/sala");
    }
}
