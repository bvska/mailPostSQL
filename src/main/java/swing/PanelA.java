package swing;

import javax.swing.*;
import java.awt.*;

public class PanelA extends JPanel {
    private JLabel label1 = new JLabel("Альяс");
    private JLabel label2 = new JLabel("Получатель");
    private JLabel label3 = new JLabel("Альяс");
    private JLabel label4 = new JLabel("Получатель");
    private JLabel label5 = new JLabel("Описание");
    private JLabel label6 = new JLabel("Id");
    private JLabel label7 = new JLabel("Получатель");
    private JLabel label8 = new JLabel("Id");
    private JTextField aliasSearch = new JTextField(20);
    private JTextField rcptSearch = new JTextField(20);
    private JTextField aliasAdd = new JTextField(20);
    private JTextField rcptAdd = new JTextField(20);
    private JTextField descriptionAdd = new JTextField(20);
    private JTextField idUpdate = new JTextField(5);
    private JTextField rcptUpdate = new JTextField(30);
    private JTextField deleteId = new JTextField(5);
    private Button searchButton = new Button("Найти");
    private Button addButton = new Button("Добавить");
    private Button updateButton = new Button("Обновить");
    private Button DeleteButton = new Button("Удалить");
    private JTextPane search = new JTextPane();

    public void st() {
        setLayout(new GridBagLayout());
        add(label1, new GridBagConstraints(0, 0, 1, 1, 2, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(1, 1, 1, 1), 0, 0));
        add(label2, new GridBagConstraints(1, 0, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(1, 1, 1, 1), 0, 0));
        add(aliasSearch, new GridBagConstraints(0, 1, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
        add(rcptSearch, new GridBagConstraints(1, 1, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
        add(searchButton, new GridBagConstraints(3, 1, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
        add(search, new GridBagConstraints(0, 2, 4, 2, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(1, 1, 1, 1), 0, 0));
        add(label3, new GridBagConstraints(0, 4, 1, 1, 2, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(1, 1, 1, 1), 0, 0));
        add(label4, new GridBagConstraints(1, 4, 1, 1, 2, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(1, 1, 1, 1), 0, 0));
        add(label5, new GridBagConstraints(2, 4, 1, 1, 2, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(1, 1, 1, 1), 0, 0));
        add(aliasAdd, new GridBagConstraints(0, 5, 1, 1, 2, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(1, 1, 1, 1), 0, 0));
        add(rcptAdd, new GridBagConstraints(1, 5, 1, 1, 2, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(1, 1, 1, 1), 0, 0));
        add(descriptionAdd, new GridBagConstraints(2, 5, 1, 1, 2, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(1, 1, 1, 1), 0, 0));
        add(addButton, new GridBagConstraints(3, 5, 1, 1, 2, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(1, 1, 1, 1), 0, 0));
        add(label6, new GridBagConstraints(0, 6, 1, 1, 2, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(1, 1, 1, 1), 0, 0));
        add(label7, new GridBagConstraints(1, 6, 1, 1, 2, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(1, 1, 1, 1), 0, 0));
        add(idUpdate, new GridBagConstraints(0, 7, 1, 1, 2, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(1, 1, 1, 1), 0, 0));
        add(rcptUpdate, new GridBagConstraints(1, 7, 1, 1, 2, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(1, 1, 1, 1), 0, 0));
        add(updateButton, new GridBagConstraints(3, 7, 1, 1, 2, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(1, 1, 1, 1), 0, 0));
        add(label8, new GridBagConstraints(0, 8, 1, 1, 2, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(1, 1, 1, 1), 0, 0));
        add(deleteId, new GridBagConstraints(0, 9, 1, 1, 2, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(1, 1, 1, 1), 0, 0));
        add(DeleteButton, new GridBagConstraints(3, 9, 1, 1, 2, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(1, 1, 1, 1), 0, 0));
    }
}