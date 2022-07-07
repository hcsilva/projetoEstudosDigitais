package br.com.digitaLife.cardapioDigital.exceptions;

import br.com.digitaLife.cardapioDigital.utils.MessageUtils;

public class ObjectNotFoundException extends RuntimeException {
    public ObjectNotFoundException(String message) {
        super(MessageUtils.getMessage(message));
    }
}
