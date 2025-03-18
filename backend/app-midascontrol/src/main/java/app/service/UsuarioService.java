package app.service;

import app.domain.Usuario;
import app.domain.dto.UsuarioCadastroDto;
import app.repos.UsuarioRepository;
import jakarta.persistence.EntityExistsException;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuariosRepository) {
        this.usuarioRepository = usuariosRepository;
    }

    public List<Usuario> listarUsuariosCadastrados() {
        return usuarioRepository.findAll();
    }

    public Usuario buscarUsuarioPorId(Long id) {
        return usuarioRepository.findById(id)
                .orElseThrow(EntityExistsException::new);
    }

    public Usuario cadastrarNovoUsuario(UsuarioCadastroDto dto) {
        Usuario novoUsuario = new Usuario();
        BeanUtils.copyProperties(dto, novoUsuario);
        return usuarioRepository.save(novoUsuario);
    }

    public void deletarUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }
}
