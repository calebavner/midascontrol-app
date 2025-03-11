package app.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_usuarios")
public class Usuario {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String email;
    private String password;
}
