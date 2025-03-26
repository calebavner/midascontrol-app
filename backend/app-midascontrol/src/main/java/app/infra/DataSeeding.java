package app.infra;

import app.domain.Registro;
import app.domain.Usuario;
import app.domain.enums.Status;
import app.repos.RegistroRepository;
import app.repos.UsuarioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.List;

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

        Registro novoRegistroFaturado = new Registro();
        novoRegistroFaturado.setCliente("Bridgestone");
        novoRegistroFaturado.setValor(19800D);
        novoRegistroFaturado.setStatus(Status.PENDENTE);
        novoRegistroFaturado.setMargem(79.07D);

        Registro novoRegistroPendente = new Registro();
        novoRegistroPendente.setCliente("Algetec");
        novoRegistroPendente.setValor(1275.17D);
        novoRegistroPendente.setStatus(Status.FATURADO);
        novoRegistroPendente.setMargem(24D);

        registroRepository.saveAll(List.of(novoRegistroFaturado, novoRegistroPendente));
        usuarioRepository.save(novoUsuario);
    }
}
