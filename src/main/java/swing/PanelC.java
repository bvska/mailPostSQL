package swing;


import sqlEntity.Client;
import controler.ClientSay;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;


public class PanelC extends JPanel {

    private ClientSay clientSay = new ClientSay();
    private JLabel label2 = new JLabel("Имя");
    private JLabel label3 = new JLabel("описание");
    private JLabel label5 = new JLabel("Id объекта");
    private JLabel label7 = new JLabel("описание");
    private JLabel label4 = new JLabel("Id объекта");
    private Button searchButton = new Button("Показать");
    private Button updateButton = new Button("Обновить");
    private Button addButton = new Button("Добавить");
    private Button deleteButton = new Button("Удалить");
    private JTextField idUpdate = new JTextField(5);
    private JTextField nameUpdate = new JTextField(5);
    private JTextField descriptionUpdate = new JTextField(30);
    private JTextField nameAdd = new JTextField(5);
    private JTextField descriptionAdd = new JTextField(30);
    private JTextField deleteId = new JTextField(30);
    private JTextPane info = new JTextPane();
    private JTable table = new JTable();
    private JScrollPane pane = new JScrollPane(table);

    public void init(){
        setLayout(new GridBagLayout());
        add(label2, new GridBagConstraints(0, 0, 1, 1, 2, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(1,1,1,1), 0, 0));
        add(label3, new GridBagConstraints(1, 0, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(1,1,1,1), 0, 0));
        add(nameAdd, new GridBagConstraints(0, 1, 1, 1, 2, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(1,1,1,1), 0, 0));
        add(descriptionAdd, new GridBagConstraints(1, 1, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(1,1,1,1), 0, 0));
        add(addButton, new GridBagConstraints(2, 1, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(1,1,1,1), 0, 0));
        add(label5, new GridBagConstraints(0, 2, 1, 1, 2, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(1,1,1,1), 0, 0));
        add(label7, new GridBagConstraints(1, 2, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(1,1,1,1), 0, 0));
        add(nameUpdate, new GridBagConstraints(0, 3, 1, 1, 2, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(1,1,1,1), 0, 0));
        add(descriptionUpdate, new GridBagConstraints(1, 3, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(1,1,1,1), 0, 0));
        add(updateButton, new GridBagConstraints(2, 3, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(1,1,1,1), 0, 0));
        add(label4, new GridBagConstraints(0, 4, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(1,1,1,1), 0, 0));
        add(deleteId, new GridBagConstraints(0, 5, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(1,1,1,1), 0, 0));
        add(deleteButton, new GridBagConstraints(2, 5, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(1,1,1,1), 0, 0));
        add(searchButton, new GridBagConstraints(2, 6, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(1,1,1,1), 0, 0));
        add(pane, new GridBagConstraints(0, 7, 4, 15, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(1,1,1,1), 0, 150));
    }

    public void st(){
        init();
        deleteButton.addActionListener((ae)-> clientSay.sayDelete(Integer.parseInt(deleteId.getText())));
        addButton.addActionListener((ae)-> clientSay.sayAdd(new Client(nameAdd.getText(),descriptionAdd.getText())));
        searchButton.addActionListener((ae)-> showTable(clientSay.saySearch()));
        updateButton.addActionListener((ae)-> clientSay.sayUpdate(Integer.parseInt(nameUpdate.getText()), descriptionUpdate.getText()));
    }

    public  void showTable(List<Client> clients){
        DefaultTableModel model = new DefaultTableModel(new Object[]{"Id", "name", "desc"}, 0);
        for (Client o : clients ) {
            model.addRow(new Object[]{o.getId(), o.getName(),  o.getDescription()});
        }
        table.setModel(model);
    }


}
