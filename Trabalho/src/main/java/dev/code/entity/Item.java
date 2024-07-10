package dev.code.entity;

import dev.code.enums.ItemType;

/*
 * Classe criada para gerencia os Itens do Cardápio,
 * com um tipo (Bebida, Comida) e com um nome.
 * */
public record Item(
        ItemType type,
        String name) {
}
