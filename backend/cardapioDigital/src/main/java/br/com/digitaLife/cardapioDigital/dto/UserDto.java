package br.com.digitaLife.cardapioDigital.dto;

import br.com.digitaLife.cardapioDigital.model.UserModel;
import java.io.Serializable;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;

@Getter
@Setter
@Builder
public class UserDto implements Serializable {

    @NotBlank(message = "{usuario.username.campoObrigatorio}")
    String username;

    @NotBlank(message = "{usuario.password.campoObrigatorio}")
    String password;

    @NotNull
    boolean enable;

    public UserModel convertDTOToEntity() {
        return new ModelMapper().map(this, UserModel.class);
    }
}
