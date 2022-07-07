package br.com.digitaLife.cardapioDigital.exceptions;

import lombok.*;

import java.util.Arrays;
import java.util.List;

@Data
@Getter
@Setter
@AllArgsConstructor
public class ApiErrors {
    private List<String> errors;

    public ApiErrors(String message) {
        this.errors = Arrays.asList(message);
    }


}
