package dev.code.manager;

import dev.code.entity.Menu;
import dev.code.enums.Days;

import java.util.HashMap;
import java.util.Map;

/*
* Classe responsável por gerencia os Cardápios com base no Dia.
* */
public class MenuManager {

    // Armazena os Cardápios na memoria
    private final Map<Days, Menu> menus;

    // Inicializa o Gerenciador de Cardápios
    public MenuManager() {
        menus = new HashMap<>();
    }

    // Pega os Cardápios
    public Map<Days, Menu> getMenusMap() {
        return menus;
    }

}
