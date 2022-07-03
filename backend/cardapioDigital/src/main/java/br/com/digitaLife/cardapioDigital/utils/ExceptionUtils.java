package br.com.digitaLife.cardapioDigital.utils;

import br.com.digitaLife.cardapioDigital.exceptions.BadRequestException;

public class ExceptionUtils extends RuntimeException {
    public static void throwsErrorExceptionMessage(String errorMessage) {
        String errorMessageConverter = MessageUtils.getMessage(errorMessage);
        throw new BadRequestException(errorMessageConverter);
    }
}
