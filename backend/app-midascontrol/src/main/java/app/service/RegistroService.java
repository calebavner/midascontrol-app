package app.service;

import app.domain.Registro;
import app.domain.dto.RegistroCadastroDto;
import app.domain.dto.TotalResponseDto;
import app.domain.enums.Status;
import app.repos.RegistroRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegistroService {

    private final RegistroRepository registroRepository;

    public RegistroService(RegistroRepository registroRepository) {
        this.registroRepository = registroRepository;
    }

    public List<Registro> listarRegistros() {
        return registroRepository.findAll();
    }

    public Registro buscarRegistroPorId(Long id) {
        return registroRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }

    public Registro cadastrarRegistro(RegistroCadastroDto dto) {
        Registro novoRegistro = new Registro();
        BeanUtils.copyProperties(dto, novoRegistro);
        novoRegistro.setStatus(Status.PENDENTE);
        return registroRepository.save(novoRegistro);
    }

    public void deletarRegistro(Long id) {
        registroRepository.deleteById(id);
    }

    public TotalResponseDto retornaTotalExpectado() {

        List<Registro> registros = listarRegistros();

        /*return registros.stream()
                .map(Registro::getValor)
                .reduce(0D, Double::sum);*/

        return new TotalResponseDto(registros.stream()
                .map(Registro::getValor)
                .reduce(0D, Double::sum));
    }
}
