package swing;


import sqlEntity.Client;
import sqlEntity.Domain;
import controler.ClientSay;
import controler.DomainSay;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class PanelD extends JPanel {

    private Client fk_tb_client;
    private ClientSay clientSay = new ClientSay();
    private DomainSay domainSay = new DomainSay();
    private JLabel label1 = new JLabel("Клиент Id");
    private JLabel label2 = new JLabel("имя домена");
    private JLabel label3 = new JLabel("описание");
    private JLabel label5 = new JLabel("Id объекта");
    private JLabel label6 = new JLabel("имя домена");
    private JLabel label7 = new JLabel("описание");
    private JLabel label4 = new JLabel("Id объекта");
    private Button searchButton = new Button("Показать");
    private Button updateButton = new Button("Обновить");
    private Button addButton = new Button("Добавить");
    private Button deleteButton = new Button("Удалить");
    private JTextField idUpdate = new JTextField(5);
    private JTextField nameUpdate = new JTextField(30);
    private JTextField descriptionUpdate = new JTextField(30);
    private JTextField clientAdd = new JTextField(5);
    private JTextField nameAdd = new JTextField(15);
    private JTextField descriptionAdd = new JTextField(30);
    private JTextField deleteId = new JTextField(5);
    private JTable table = new JTable();
    private JScrollPane pane = new JScrollPane(table);

    public void init(){
        setLayout(new GridBagLayout());
        add(label5, new GridBagConstraints(0, 0, 1, 1, 2, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(1,1,1,1), 0, 0));
        add(label6, new GridBagConstraints(1, 0, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(1,1,1,1), 0, 0));
        add(label7, new GridBagConstraints(2, 0, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(1,1,1,1), 0, 0));
        add(clientAdd, new GridBagConstraints(0, 1, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(1,1,1,1), 0, 0));
        add(nameAdd, new GridBagConstraints(1, 1, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(1,1,1,1), 0, 0));
        add(descriptionAdd, new GridBagConstraints(2, 1, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(1,1,1,1), 0, 0));
        add(addButton, new GridBagConstraints(3, 1, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(1,1,1,1), 0, 0));
        add(label4, new GridBagConstraints(0, 2, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2,2,2,2), 0, 0));
        add(deleteId, new GridBagConstraints(0, 3, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2,2,2,2), 0, 0));
        add(deleteButton, new GridBagConstraints(3, 3, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2,2,2,2), 0, 0));
        add(label1, new GridBagConstraints(0, 4, 1, 1, 2, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(1,1,1,1), 0, 0));
        add(label2, new GridBagConstraints(1, 4, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(1,1,1,1), 0, 0));
        add(label3, new GridBagConstraints(2, 4, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(1,1,1,1), 0, 0));
        add(idUpdate, new GridBagConstraints(0, 5, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2,2,2,2), 0, 0));
        add(nameUpdate, new GridBagConstraints(1, 5, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2,2,2,2), 0, 0));
        add(descriptionUpdate, new GridBagConstraints(2, 5, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2,2,2,2), 0, 0));
        add(updateButton, new GridBagConstraints(3, 5, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2,2,2,2), 0, 0));
        add(searchButton, new GridBagConstraints(3, 6, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2,2,2,2), 0, 0));
        add(pane, new GridBagConstraints(0, 7, 4, 15, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2,2,2,2), 0, 150));


    }

    public void st(){
        init();
        deleteButton.addActionListener((ae)-> domainSay.sayDelete(Integer.parseInt(deleteId.getText())));
        addButton.addActionListener((ae)->{
            fk_tb_client = clientSay.saySearchId(Integer.parseInt(clientAdd.getText()));
            domainSay.sayAdd(new Domain(fk_tb_client, nameAdd.getText(), descriptionAdd.getText()));
        });
        searchButton.addActionListener((ae)-> showTable(domainSay.saySearch()));
        updateButton.addActionListener((ae)-> {
            Domain domain = domainSay.saySearchId(Integer.parseInt((idUpdate.getText())));
            if (nameUpdate.getText().length() >= 1){
                domain.setName(nameUpdate.getText());}
            domain.setDescription(descriptionUpdate.getText());
            domainSay.sayUpdate(domain);
        });
    }

    public  void showTable(List<Domain> domains){
        DefaultTableModel model = new DefaultTableModel(new Object[]{"Id", "name", "Fk_tb_client", "desc"}, 0);
        for (Domain o : domains ) {
            model.addRow(new Object[]{o.getId(), o.getName(), o.getFk_tb_client(), o.getDescription()});
        }
        table.setModel(model);
    }

}
