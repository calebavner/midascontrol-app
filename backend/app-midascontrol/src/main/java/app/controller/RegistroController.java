package app.controller;

import app.domain.Registro;
import app.domain.dto.RegistroCadastroDto;
import app.domain.dto.TotalResponseDto;
import app.domain.enums.Status;
import app.service.RegistroService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/registros")
public class RegistroController {

    private final RegistroService registroService;

    public RegistroController(RegistroService registroService) {
        this.registroService = registroService;
    }

    @GetMapping
    public ResponseEntity<List<Registro>> listarRegistrosCadastrados() {
        return ResponseEntity.ok(registroService.listarRegistros());
    }

    @GetMapping("/status")
    public ResponseEntity<List<Registro>> listarRegistrosPorStatus(@RequestParam Status status) {
        return ResponseEntity.ok(registroService.listarRegistrosPorStatus(status));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Registro> buscarRegistroPorId(@PathVariable Long id) {
        return ResponseEntity.ok(registroService.buscarRegistroPorId(id));
    }

    @PostMapping
    public ResponseEntity cadastrarNovoRegistro(@RequestBody RegistroCadastroDto dto, UriComponentsBuilder uriBuilder) {
        Registro novoRegistro = registroService.cadastrarRegistro(dto);
        URI uri = uriBuilder.path("/usuarios/{id}").buildAndExpand(novoRegistro.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarRegistro(@PathVariable Long id) {
        registroService.deletarRegistro(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/total/expectado")
    public ResponseEntity<TotalResponseDto> retornaTotalExpectado() {
        return ResponseEntity.ok(registroService.retornaTotalExpectado());
    }

    @GetMapping("/total/faturado")
    public ResponseEntity<TotalResponseDto> retornaTotalFaturado() {
        return ResponseEntity.ok(registroService.retornaTotalFaturado());
    }

    @GetMapping("/total/margem")
    public ResponseEntity<TotalResponseDto> retornaMargemTotal() {
        return ResponseEntity.ok(registroService.retornaMargemTotal());
    }

    @GetMapping("/total/comissao")
    public ResponseEntity<TotalResponseDto> retornaValorComissao() {
        return ResponseEntity.ok(registroService.retornaTotalComissao());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Registro> faturarRegistro(@PathVariable Long id) {
        registroService.faturarRegistro(id);
        return ResponseEntity.ok().build();
    }
}
