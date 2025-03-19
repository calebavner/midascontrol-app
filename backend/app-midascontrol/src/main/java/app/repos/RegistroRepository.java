package app.repos;

import app.domain.Registro;
import app.domain.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RegistroRepository extends JpaRepository<Registro, Long> {

    List<Registro> findByStatus(Status status);
}
