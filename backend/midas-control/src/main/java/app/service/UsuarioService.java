package app.service;

import app.domain.Usuario;
import app.domain.dto.UsuarioCadastroDto;
import app.repos.UsuarioRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario cadastrar(UsuarioCadastroDto dto) {
        Usuario novoUsuario = new Usuario();
        BeanUtils.copyProperties(dto, novoUsuario);
        return usuarioRepository.save(novoUsuario);
    }
}
