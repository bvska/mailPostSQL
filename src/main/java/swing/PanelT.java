package swing;


import sqlEntity.Domain;
import sqlEntity.Transport;
import controler.DomainSay;
import controler.TransportSay;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class PanelT extends JPanel {

    private Domain fk_tb_domain;
    private DomainSay domainSay = new DomainSay();
    private TransportSay transportSay = new TransportSay();
    private JLabel label1 = new JLabel("Id объекта");
    private JLabel label2 = new JLabel("протокол");
    private JLabel label3 = new JLabel("описание");
    private JLabel label5 = new JLabel("Домен Id");
    private JLabel label6 = new JLabel("протокол");
    private JLabel label7 = new JLabel("описание");
    private JLabel label4 = new JLabel("Id объекта");
    private Button searchButton = new Button("Показать");
    private Button updateButton = new Button("Обновить");
    private Button addButton = new Button("Добавить");
    private Button deleteButton = new Button("Удалить");
    private JTextField idUpdate = new JTextField(5);
    private JTextField nameUpdate = new JTextField(30);
    private JTextField descriptionUpdate = new JTextField(30);
    private JTextField domainAdd = new JTextField(5);
    private JTextField nameAdd = new JTextField(15);
    private JTextField descriptionAdd = new JTextField(30);
    private JTextField deleteId = new JTextField(5);
    private JTable table = new JTable();
    private JScrollPane pane = new JScrollPane(table);

    public void init() {
        setLayout(new GridBagLayout());
        add(label5, new GridBagConstraints(0, 0, 1, 1, 2, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(1, 1, 1, 1), 0, 0));
        add(label6, new GridBagConstraints(1, 0, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(1, 1, 1, 1), 0, 0));
        add(label7, new GridBagConstraints(2, 0, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(1, 1, 1, 1), 0, 0));
        add(domainAdd, new GridBagConstraints(0, 1, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(1, 1, 1, 1), 0, 0));
        add(nameAdd, new GridBagConstraints(1, 1, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(1, 1, 1, 1), 0, 0));
        add(descriptionAdd, new GridBagConstraints(2, 1, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(1, 1, 1, 1), 0, 0));
        add(addButton, new GridBagConstraints(3, 1, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(1, 1, 1, 1), 0, 0));
        add(label4, new GridBagConstraints(0, 2, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));
        add(deleteId, new GridBagConstraints(0, 3, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));
        add(deleteButton, new GridBagConstraints(3, 3, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));
        add(label1, new GridBagConstraints(0, 4, 1, 1, 2, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(1, 1, 1, 1), 0, 0));
        add(label2, new GridBagConstraints(1, 4, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(1, 1, 1, 1), 0, 0));
        add(label3, new GridBagConstraints(2, 4, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(1, 1, 1, 1), 0, 0));
        add(idUpdate, new GridBagConstraints(0, 5, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));
        add(nameUpdate, new GridBagConstraints(1, 5, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));
        add(descriptionUpdate, new GridBagConstraints(2, 5, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));
        add(updateButton, new GridBagConstraints(3, 5, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));
        add(searchButton, new GridBagConstraints(3, 6, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));
        add(pane, new GridBagConstraints(0, 7, 4, 15, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 150));


    }

    public void st() {
        init();
        deleteButton.addActionListener((ae) -> transportSay.sayDelete(Integer.parseInt(deleteId.getText())));
        addButton.addActionListener((ae) -> {
            fk_tb_domain = domainSay.saySearchId(Integer.parseInt(domainAdd.getText()));
            transportSay.sayAdd(new Transport(fk_tb_domain, nameAdd.getText(), descriptionAdd.getText()));
        });
        searchButton.addActionListener((ae) -> showTable(transportSay.saySearch()));
        updateButton.addActionListener((ae) -> {
            Transport transport = transportSay.saySearchId(Integer.parseInt((idUpdate.getText())));
            if (nameUpdate.getText().trim().length() >= 1) {
                transport.setTransport(nameUpdate.getText());
            }
            transport.setDescription(descriptionUpdate.getText());
            transportSay.sayUpdate(transport);
        });
    }

    public void showTable(List<Transport> transports) {
        DefaultTableModel model = new DefaultTableModel(new Object[]{"Id", "Transport", "Fk_tb_domain", "Desc"}, 0);
        for (Transport o : transports) {
            model.addRow(new Object[]{o.getId(), o.getTransport(), o.getFk_tb_domain(), o.getDescription()});
        }
        table.setModel(model);
    }


}

