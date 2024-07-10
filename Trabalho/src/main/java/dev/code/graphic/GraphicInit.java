package dev.code.graphic;

import dev.code.entity.Item;
import dev.code.entity.Menu;
import dev.code.enums.Days;
import dev.code.enums.ItemType;
import dev.code.manager.MenuManager;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class GraphicInit {

    private JFrame frame;

    private JPanel viewPanel;
    private JPanel registerPanel;

    private JTextField componentName;

    private JButton buttonAdd;

    private JComboBox<Days> componentDay;
    private JComboBox<ItemType> componentType;

    private DefaultTableModel tableModel;

    private final MenuManager menuManager;

    public GraphicInit() {
        menuManager = new MenuManager();
        createWindow();
        registerComponents();
        registerListeners();
    }

    private void createWindow() {

        frame = new JFrame("Restaurante Universitário");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        viewPanel = new JPanel(new BorderLayout());
        registerPanel = new JPanel(new GridLayout(4, 2));

        final var tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Cadastro", registerPanel);
        tabbedPane.addTab("Visualização", viewPanel);

        frame.add(tabbedPane);
        frame.setVisible(true);
    }

    private void registerComponents() {
        componentDay = new JComboBox<>(Days.values());
        componentType = new JComboBox<>(ItemType.values());

        componentName = new JTextField();
        buttonAdd = new JButton("Adicionar Item");

        registerPanel.add(new JLabel("Dia da Semana:"));
        registerPanel.add(componentDay);
        registerPanel.add(new JLabel("Tipo:"));
        registerPanel.add(componentType);
        registerPanel.add(new JLabel("Nome do Item:"));
        registerPanel.add(componentName);
        registerPanel.add(new JLabel(""));
        registerPanel.add(buttonAdd);

        tableModel = new DefaultTableModel(Days.values(), 0);
        viewPanel.add(new JScrollPane(new JTable(tableModel)), BorderLayout.CENTER);
    }

    private void registerListeners() {

        buttonAdd.addActionListener(e -> {

            final var day = (Days) componentDay.getSelectedItem();

            if (day == null) {
                JOptionPane.showMessageDialog(frame, "Dia inválido", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }

            final var itemType = (ItemType) componentType.getSelectedItem();

            if (itemType == null) {
                JOptionPane.showMessageDialog(frame, "Tipo inválido", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }

            final var name = componentName.getText();

            if (name.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Nome do item não pode ser vazio", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }

            final var item = new Item(itemType, name);
            final var menu = menuManager.getMenusMap().computeIfAbsent(day, Menu::new);
            menu.addItem(item);

            updateTable();
            JOptionPane.showMessageDialog(frame, "Item adicionado com sucesso ao cardápio!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        });

    }

    private void updateTable() {

        tableModel.setRowCount(0);

        int maxItems = menuManager.getMenusMap().values().stream()
                .mapToInt(menu -> menu.getAvailableItems().size())
                .max()
                .orElse(0);

        for (int i = 0; i < maxItems; i++) {

            String[] row = new String[5];

            for (final var day : Days.values()) {

                final var menu = menuManager.getMenusMap().get(day);

                if (menu != null && i < menu.getAvailableItems().size()) {
                    final var item = menu.getAvailableItems().get(i);
                    row[day.ordinal()] = item.name() + " (" + item.type().name() + ")";
                }

            }

            tableModel.addRow(row);
        }

    }

}