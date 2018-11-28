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

import br.com.agenda.projetoagenda.model.Usuario;
import br.com.agenda.projetoagenda.repository.UsuarioRepository;

@Controller
@RequestMapping("/usuario")
@PreAuthorize("hasRole('ROLE_ADMIN')")
public class UsuarioController {
	@Autowired
	private UsuarioRepository usuarioRepository;
	@GetMapping("")
	public ModelAndView index() {
		List<Usuario> listaUsuario = this.usuarioRepository.findAll();
		
		return new ModelAndView("usuario/index","listapac", listaUsuario);
	}
	
	@GetMapping("/novo")
	public String createForm(@ModelAttribute Usuario usuario) {
		return "usuario/form";
	}
	@PostMapping(params="form")
    public ModelAndView save(@Valid Usuario usuario, BindingResult result, RedirectAttributes redirect) {
        
        usuario = this.usuarioRepository.save(usuario);
        
        return new ModelAndView("redirect:/usuario");
    }
	@GetMapping(value="/alterar/{cod_usuario}")
    public ModelAndView alterarForm(@PathVariable("cod_usuario") Usuario usuario) {
        return new ModelAndView("usuario/form","usuario",usuario);
    }
	@GetMapping(value="remover/{cod_usuario}")
    public ModelAndView remover(@PathVariable ("cod_usuario") String cod_usuario, RedirectAttributes redirect) {
        try {
    		this.usuarioRepository.deleteById(Long.parseLong(cod_usuario));        	
        }catch (Exception e) {
			e.printStackTrace();
		};
        return new ModelAndView("redirect:/usuario");
    }
}
