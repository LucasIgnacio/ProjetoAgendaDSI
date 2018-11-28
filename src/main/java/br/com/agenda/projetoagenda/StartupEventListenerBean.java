package br.com.agenda.projetoagenda;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import br.com.agenda.projetoagenda.model.UserLogin;
import br.com.agenda.projetoagenda.repository.UserLoginRepository;

@Component
public class StartupEventListenerBean {
    @Autowired
    private UserLoginRepository usuarioRepository;

    @EventListener
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if(usuarioRepository.findByUsername("user") == null) {
            UserLogin user = new UserLogin();
            user.setUsername("user");
            user.setPassword("user");
            user.setRole("ROLE_USER");
            usuarioRepository.save(user);
        }


    }
}
