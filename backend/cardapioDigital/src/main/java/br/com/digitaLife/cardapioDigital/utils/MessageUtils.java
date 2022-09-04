package br.com.digitaLife.cardapioDigital.utils;

import br.com.digitaLife.cardapioDigital.enums.IdiomaEnum;
import org.apache.commons.lang3.StringUtils;

import java.util.Locale;
import java.util.ResourceBundle;

public class MessageUtils {


    /**
     * Método usado para buscar as mensagens default pt-BR
     *
     * @param message
     * @return
     */
    public static String getMessage(String message) {
        if (StringUtils.isEmpty(message)) {
            return StringUtils.EMPTY;
        }

        ResourceBundle bundle = ResourceBundle.getBundle("messages", new Locale(IdiomaEnum.PT.getIdioma(), IdiomaEnum.PT.getPais()));
        return bundle.getString(message);
    }


    public static String getMessageComSubstituicao(String message, String texto) {
        if (StringUtils.isEmpty(message)) {
            return StringUtils.EMPTY;
        }

        ResourceBundle bundle = ResourceBundle.getBundle("messages", new Locale(IdiomaEnum.PT.getIdioma(), IdiomaEnum.PT.getPais()));
        var mensagem = bundle.getString(message);

        return String.format(mensagem, texto);
    }


    /**
     * Método Criado para conversão das mensagens para a linguagem utilizada no sistema
     * Necessário uma refatoração futura
     *
     * @param message
     * @param idioma
     * @return
     */
    public String getMessage(String message, String idioma) {
        if (StringUtils.isEmpty(message) || StringUtils.isEmpty(idioma)) {
            return StringUtils.EMPTY;
        }

        ResourceBundle bundle = ResourceBundle.getBundle("messages", new Locale("pt", "BR"));
        return bundle.getString(message);
    }


}
