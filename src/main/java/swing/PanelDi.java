package swing;


import sqlEntity.Directories;
import controler.DirectoriesSay;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class PanelDi extends JPanel {

    private DirectoriesSay directoriesSay = new DirectoriesSay();
    private JLabel label2 = new JLabel("Путь");
    private JLabel label3 = new JLabel("описание");
    private JLabel label5 = new JLabel("Id объекта");
    private JLabel label7 = new JLabel("описание");
    private JLabel label4 = new JLabel("Id объекта");
    private Button searchButton = new Button("Показать");
    private Button updateButton = new Button("Обновить");
    private Button addButton = new Button("Добавить");
    private Button deleteButton = new Button("Удалить");
    private JTextField idUpdate = new JTextField(5);
    private JTextField descriptionUpdate = new JTextField(30);
    private JTextField pathAdd = new JTextField(30);
    private JTextField descriptionAdd = new JTextField(30);
    private JTextField deleteId = new JTextField(30);
    private JTable table = new JTable();
    private JScrollPane pane = new JScrollPane(table);

    public void init() {
        setLayout(new GridBagLayout());
        add(label2, new GridBagConstraints(0, 0, 1, 1, 2, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(1, 1, 1, 1), 0, 0));
        add(label3, new GridBagConstraints(1, 0, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(1, 1, 1, 1), 0, 0));
        add(pathAdd, new GridBagConstraints(0, 1, 1, 1, 2, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(1, 1, 1, 1), 0, 0));
        add(descriptionAdd, new GridBagConstraints(1, 1, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(1, 1, 1, 1), 0, 0));
        add(addButton, new GridBagConstraints(2, 1, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(1, 1, 1, 1), 0, 0));
        add(label5, new GridBagConstraints(0, 2, 1, 1, 2, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(1, 1, 1, 1), 0, 0));
        add(label7, new GridBagConstraints(1, 2, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(1, 1, 1, 1), 0, 0));
        add(idUpdate, new GridBagConstraints(0, 3, 1, 1, 2, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(1, 1, 1, 1), 0, 0));
        add(descriptionUpdate, new GridBagConstraints(1, 3, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(1, 1, 1, 1), 0, 0));
        add(updateButton, new GridBagConstraints(2, 3, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(1, 1, 1, 1), 0, 0));
        add(label4, new GridBagConstraints(0, 4, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(1, 1, 1, 1), 0, 0));
        add(deleteId, new GridBagConstraints(0, 5, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(1, 1, 1, 1), 0, 0));
        add(deleteButton, new GridBagConstraints(2, 5, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(1, 1, 1, 1), 0, 0));
        add(searchButton, new GridBagConstraints(2, 6, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(1, 1, 1, 1), 0, 0));
        add(pane, new GridBagConstraints(0, 7, 4, 15, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(1, 1, 1, 1), 0, 150));
    }

    public void st() {
        init();
        deleteButton.addActionListener((ae) -> directoriesSay.sayDelete(Integer.parseInt(deleteId.getText())));
        addButton.addActionListener((ae) -> directoriesSay.sayAdd(new Directories(pathAdd.getText(), descriptionAdd.getText())));
        searchButton.addActionListener((ae) -> showTable(directoriesSay.saySearch()));
        updateButton.addActionListener((ae) -> {
            Directories directories = directoriesSay.saySearchId(Integer.parseInt((idUpdate.getText())));
            directories.setDescription(descriptionUpdate.getText());
            directoriesSay.sayUpdate(directories);
        });
    }

    public void showTable(List<Directories> directories) {
        DefaultTableModel model = new DefaultTableModel(new Object[]{"Id", "path", "desc"}, 0);
        for (Directories o : directories) {
            model.addRow(new Object[]{o.getId(), o.getPath(), o.getDescription()});
        }
        table.setModel(model);
    }

}
