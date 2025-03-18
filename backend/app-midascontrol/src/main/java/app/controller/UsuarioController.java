package app.controller;

import app.domain.Usuario;
import app.domain.dto.UsuarioCadastroDto;
import app.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> listarUsuariosCadastrados() {
        return ResponseEntity.ok(usuarioService.listarUsuariosCadastrados());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> buscasUsuarioPorId(@PathVariable Long id) {
        return ResponseEntity.ok(usuarioService.buscarUsuarioPorId(id));
    }

    @PostMapping
    public ResponseEntity<Usuario> cadastrarUsuario(@RequestBody UsuarioCadastroDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(usuarioService.cadastrarNovoUsuario(dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarUsuario(@PathVariable Long id) {
        usuarioService.deletarUsuario(id);
        return ResponseEntity.noContent().build();
    }
}
