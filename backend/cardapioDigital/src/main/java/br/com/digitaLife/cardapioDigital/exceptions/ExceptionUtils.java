package br.com.digitaLife.cardapioDigital.exceptions;

import br.com.digitaLife.cardapioDigital.utils.MessageUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class ExceptionUtils extends RuntimeException {
    public static void throwsErrorExceptionMessage(String errorMessage) {
        String errorMessageConverter = MessageUtils.getMessage(errorMessage);
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, errorMessageConverter);
    }

}