package com.pontovirtual.sistemadeponto.model;
import com.pontovirtual.sistemadeponto.dto.UserRequestDTO;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;

@Table(name = "tb_user")
@Entity(name = "user")
@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class UserModel implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String name;
    private String cpf;
    private String role;

    public UserModel(UserRequestDTO data) {
        this.name = data.name();
        this.cpf = data.cpf();
        this.role = data.role();
    }

}
