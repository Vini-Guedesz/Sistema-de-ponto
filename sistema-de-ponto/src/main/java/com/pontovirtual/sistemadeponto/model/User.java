package com.pontovirtual.sistemadeponto.model;
import com.pontovirtual.sistemadeponto.dto.UserRequestDTO;
import jakarta.persistence.*;
import lombok.*;


@Table(name = "app_user")
@Entity(name = "app_user")
@Getter
@NoArgsConstructor
@Builder
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String cpf;
    private String cargo;

    public User(UserRequestDTO data) {
        this.name = data.name();
        this.cpf = data.cpf();
        this.cargo = data.cargo();
    }

}
