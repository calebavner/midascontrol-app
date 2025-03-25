package app.service;

import app.domain.Registro;
import app.domain.dto.RegistroCadastroDto;
import app.domain.dto.TotalResponseDto;
import app.domain.enums.Status;
import app.repos.RegistroRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
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

    public List<Registro> listarRegistrosPorStatus(Status status) {
        LOGGER.info("Executanto listagem de registros por Status de faturamento: " + getClass());
        return registroRepository.findByStatus(status);
    }

    public Registro buscarRegistroPorId(Long id) {
        LOGGER.info("Executando busca por ID: " + getClass() + ", ID: " + id);
        return registroRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }

    @Transactional
    public Registro cadastrarRegistro(RegistroCadastroDto dto) {
        LOGGER.info("Executando cadastro de novo registro: " + getClass());
        Registro novoRegistro = new Registro();
        BeanUtils.copyProperties(dto, novoRegistro);
        novoRegistro.setStatus(Status.PENDENTE);
        return registroRepository.save(novoRegistro);
    }

    @Transactional
    public void deletarRegistro(Long id) {
        LOGGER.info("Executanto deleção de registro: " + getClass());
        registroRepository.deleteById(id);
    }

    public TotalResponseDto retornaTotalExpectado() {

        List<Registro> registrosPendentes = listarRegistrosPorStatus(Status.PENDENTE);

        return new TotalResponseDto(registrosPendentes.stream()
                .map(Registro::getValor)
                .reduce(0D, Double::sum));
    }

    public TotalResponseDto retornaTotalFaturado() {
        List<Registro> registrosFaturados = listarRegistrosPorStatus(Status.FATURADO);

        return new TotalResponseDto(registrosFaturados.stream()
                .map(Registro::getValor)
                .reduce(0D, Double::sum));
    }

    public TotalResponseDto retornaMargemTotal() {

        Double totalFaturado = retornaTotalFaturado().total();
        Double totalMargem = listarRegistrosPorStatus(Status.FATURADO)
                .stream()
                .map(x -> x.getValor() * x.getMargem())
                .reduce(0D, Double::sum);

        Double numeroArredondado = Math.round((totalMargem / totalFaturado) * 100) / 100.0;
        return new TotalResponseDto(numeroArredondado);
    }

    public TotalResponseDto retornaTotalComissao() {
        Double comissao = Math.round((retornaTotalFaturado().total() * getMargemDeComissao())) / 100D;
        return new TotalResponseDto(comissao);
    }

    @Transactional
    public void faturarRegistro(Long id) {
        Registro registro = buscarRegistroPorId(id);
        registro.setStatus(Status.FATURADO);
        LOGGER.info("Status do Registro alterado para: " + registro.getStatus());
        registroRepository.save(registro);
    }

    private Double getMargemDeComissao() {

        Double margemTotal = retornaMargemTotal().total();

        return switch (margemTotal) {
            case Double n when n <= 10  -> 0.5D;
            case Double n when n <= 15  -> 0.7D;
            case Double n when n <= 20  -> 0.9D;
            case Double n when n <= 25  -> 1.5D;
            case Double n when n <= 30  -> 2D;
            case Double n when n <= 35  -> 2.25D;
            case Double n when n <= 40  -> 2.5D;
            case Double n when n > 45  -> 3D;
            default -> 5D;
        };
    }
}
