package app.domain;

import app.domain.enums.Status;
import jakarta.persistence.*;

@Entity
@Table(name = "tb_registros")
public class Registro {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String cliente;
    private Double valor;
    private Double margem;

    @Enumerated(EnumType.STRING)
    private Status status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Double getMargem() {
        return margem;
    }

    public void setMargem(Double margem) {
        this.margem = margem;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
