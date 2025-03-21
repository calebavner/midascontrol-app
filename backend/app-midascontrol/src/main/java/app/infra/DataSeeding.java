package app.infra;

import app.domain.Registro;
import app.domain.Usuario;
import app.domain.enums.Status;
import app.repos.RegistroRepository;
import app.repos.UsuarioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSeeding implements CommandLineRunner {

    private final UsuarioRepository usuarioRepository;
    private final RegistroRepository registroRepository;

    public DataSeeding(UsuarioRepository usuarioRepository, RegistroRepository registroRepository) {
        this.usuarioRepository = usuarioRepository;
        this.registroRepository = registroRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Usuario novoUsuario = new Usuario();
        novoUsuario.setEmail("admin@email.com");
        novoUsuario.setPassword("admin");

        Registro novoRegistro = new Registro();
        novoRegistro.setCliente("Bridgestone");
        novoRegistro.setValor(19800D);
        novoRegistro.setStatus(Status.FATURADO);
        novoRegistro.setMargem(59.88D);

        registroRepository.save(novoRegistro);
        usuarioRepository.save(novoUsuario);
    }
}
