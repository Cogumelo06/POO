package dev.code.entity;

import dev.code.enums.Days;

import java.util.ArrayList;
import java.util.List;

/*
 * O menu contém o dia de referencia (Segunda, Terça, Quarta...) e
 * todos os "Itens" que vão nele, como Arroz, Feijão, Coca Cola.
 * */
public class Menu {

    private final Days referenceDay;
    private final List<Item> availableItems;

    // Inicializa o Cardápio
    public Menu(Days referenceDay) {
        this.referenceDay = referenceDay;
        this.availableItems = new ArrayList<>();
    }

    // Pega o dia referencia do Cardápio
    public Days getReferenceDay() {
        return referenceDay;
    }

    // Pega todos os itens do Cardápio
    public List<Item> getAvailableItems() {
        return availableItems;
    }

    // Adiciona um item ao Cardápio
    public void addItem(Item item) {
        availableItems.add(item);
    }

}
