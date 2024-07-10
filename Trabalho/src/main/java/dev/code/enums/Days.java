package dev.code.enums;

public enum Days {

    SEGUNDA,
    TERCA,
    QUARTA,
    QUINTA,
    SEXTA;

    // Procura o dia com base no texto digitado pelo usuario;
    public static Days fromString(String text) {

        for (final var day : values()) {

            if (day.name().equalsIgnoreCase(text))
                return day;

        }

        return null;
    }

}
