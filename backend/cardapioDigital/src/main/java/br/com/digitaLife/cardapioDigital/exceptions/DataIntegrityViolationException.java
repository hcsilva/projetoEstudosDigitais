package br.com.digitaLife.cardapioDigital.exceptions;

import br.com.digitaLife.cardapioDigital.utils.MessageUtils;

public class DataIntegrityViolationException extends RuntimeException {
    public DataIntegrityViolationException(String message) {
        super(MessageUtils.getMessage(message));
    }

}
