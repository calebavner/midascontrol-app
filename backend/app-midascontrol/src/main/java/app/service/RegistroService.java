package app.service;

import app.domain.Registro;
import app.domain.dto.RegistroCadastroDto;
import app.domain.dto.TotalResponseDto;
import app.domain.enums.Status;
import app.repos.RegistroRepository;
import jakarta.persistence.EntityNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegistroService {

    private static final Logger LOGGER = LoggerFactory.getLogger(RegistroService.class);
    private final RegistroRepository registroRepository;

    public RegistroService(RegistroRepository registroRepository) {
        this.registroRepository = registroRepository;
    }

    public List<Registro> listarRegistros() {
        LOGGER.info("Executanto listagem de registros: " + getClass());
        return registroRepository.findAll();
    }

    public Registro buscarRegistroPorId(Long id) {
        LOGGER.info("Executando busca por ID: " + getClass() + ", ID: " + id);
        return registroRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }

    public Registro cadastrarRegistro(RegistroCadastroDto dto) {
        LOGGER.info("Executando cadastro de novo registro: " + getClass());
        Registro novoRegistro = new Registro();
        BeanUtils.copyProperties(dto, novoRegistro);
        novoRegistro.setStatus(Status.PENDENTE);
        return registroRepository.save(novoRegistro);
    }

    public void deletarRegistro(Long id) {
        LOGGER.info("Executanto deleção de registro: " + getClass());
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
