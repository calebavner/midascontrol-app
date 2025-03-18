package app.domain.dto;

public record RegistroCadastroDto(
        String cliente,
        Double valor,
        Double margem
) {
}
