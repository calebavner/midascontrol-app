package app.infra;

import app.domain.Usuario;
import app.repos.UsuarioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSeeding implements CommandLineRunner {

    private final UsuarioRepository usuarioRepository;

    public DataSeeding(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Usuario novoUsuario = new Usuario();
        novoUsuario.setEmail("admin@email.com");
        novoUsuario.setPassword("admin");
        usuarioRepository.save(novoUsuario);
    }
}
