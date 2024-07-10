package dev.code.enums;

public enum ItemType {

    BEBIDA,
    COMIDA;

    // Procura o tipo de item com base no texto digitado pelo usuario;
    public static ItemType fromString(String text) {

        for (final var type : values()) {

            if (type.name().equalsIgnoreCase(text))
                return type;

        }

        return null;
    }

}
