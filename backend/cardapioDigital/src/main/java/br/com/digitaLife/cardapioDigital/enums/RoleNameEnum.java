package br.com.digitaLife.cardapioDigital.enums;

import org.apache.commons.lang3.StringUtils;

public enum RoleNameEnum {
    ADMIN("ADMIN", "ROLE_ADMIN"),
    USER("USER", "ROLE_USER");

    private String name;
    private String value;

    RoleNameEnum(String name, String value){
        this.name = name;
        this.value = value;
    }

    public String getRoleFormat(String nameRole){
        return name.equals(nameRole) ? value : StringUtils.EMPTY;
    }
}