package swing;

import controler.AliasSay;
import generator.PassGen;
import sqlEntity.Directories;
import sqlEntity.Domain;
import sqlEntity.Users;
import controler.DirectoriesSay;
import controler.DomainSay;
import controler.UsersSay;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class PanelU extends JPanel {


    private AliasSay aliasSay = new AliasSay();
    private Domain fk_tb_domain;
    private DomainSay domainSay = new DomainSay();
    private Directories fk_tb_directories;
    private DirectoriesSay directoriesSay = new DirectoriesSay();
    private UsersSay usersSay = new UsersSay();
    private JLabel label1 = new JLabel("Email");
    private JLabel label2 = new JLabel("Домен_Id");
    private JLabel label3 = new JLabel("Email");
    private JLabel label4 = new JLabel("Директория_Id");
    private JLabel label5 = new JLabel("Домен_Id");
    private JLabel label6 = new JLabel("passwd");
    private JLabel label7 = new JLabel("Описание");
    private JLabel label8 = new JLabel("Id объекта");
    private JLabel label9 = new JLabel("Директория_Id");
    private JLabel label11 = new JLabel("passwd");
    private JLabel label12 = new JLabel("Описание");
    private JLabel label13 = new JLabel("Id объекта");
    private JTextField emailSearch = new JTextField(20);
    private JTextField domainSearch = new JTextField(20);
    private JTextField emailAdd = new JTextField(20);
    private JTextField dirAdd = new JTextField(5);
    private JTextField domainAdd = new JTextField(5);
    private JTextField passAdd = new JTextField(20);
    private JTextField descriptionAdd = new JTextField(20);
    private JTextField emailUpdate = new JTextField(20);
    private JTextField dirUpdate = new JTextField(5);
    private JTextField passUpdate = new JTextField(20);
    private JTextField descriptionUpdate = new JTextField(20);
    private JTextField deleteId = new JTextField(5);
    private Button searchButton = new Button("Найти");
    private Button addButton = new Button("Добавить");
    private Button generateButton = new Button("Сгенерировать пароль");
    private Button updateButton = new Button("Обновить");
    private Button deleteButton = new Button("Удалить");
    private JCheckBox jcheckAlias = new JCheckBox("создать альяс");
    private JTable table = new JTable();
    private JScrollPane pane = new JScrollPane(table);


    public void init(){
        setLayout(new GridBagLayout());
        add(label1, new GridBagConstraints(0, 11, 1, 1, 2, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(1, 1, 1, 1), 0, 0));
        add(label2, new GridBagConstraints(1, 11, 1, 1, 2, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(1, 1, 1, 1), 0, 0));
        add(emailSearch, new GridBagConstraints(0, 12, 1, 1, 2, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(1, 1, 1, 1), 0, 0));
        add(domainSearch, new GridBagConstraints(1, 12, 1, 1, 2, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(1, 1, 1, 1), 0, 0));
        add(searchButton, new GridBagConstraints(5, 12, 1, 1, 2, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(1, 1, 1, 1), 0, 0));
        add(pane, new GridBagConstraints(0, 13, 6, 15, 5, 5,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(1, 1, 1, 1), 0, 200));
        add(label3, new GridBagConstraints(0, 4, 1, 1, 2, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(1, 1, 1, 1), 0, 0));
        add(label4, new GridBagConstraints(1, 4, 1, 1, 2, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(1, 1, 1, 1), 0, 0));
        add(label5, new GridBagConstraints(2, 4, 1, 1, 2, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(1, 1, 1, 1), 0, 0));
        add(label6, new GridBagConstraints(3, 4, 1, 1, 2, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(1, 1, 1, 1), 0, 0));
        add(label7, new GridBagConstraints(4, 4, 1, 1, 2, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(1, 1, 1, 1), 0, 0));
        add(emailAdd, new GridBagConstraints(0, 5, 1, 1, 2, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(1, 1, 1, 1), 0, 0));
        add(dirAdd, new GridBagConstraints(1, 5, 1, 1, 2, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(1, 1, 1, 1), 0, 0));
        add(domainAdd, new GridBagConstraints(2, 5, 1, 1, 2, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(1, 1, 1, 1), 0, 0));
        add(passAdd, new GridBagConstraints(3, 5, 1, 1, 2, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(1, 1, 1, 1), 0, 0));
        add(descriptionAdd, new GridBagConstraints(4, 5, 1, 1, 2, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(1, 1, 1, 1), 0, 0));
        add(addButton, new GridBagConstraints(5, 5, 1, 1, 2, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(1, 1, 1, 1), 0, 0));
        add(jcheckAlias, new GridBagConstraints(1, 6, 1, 1, 2, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(1, 1, 1, 1), 0, 0));
        add(generateButton, new GridBagConstraints(3, 6, 1, 1, 2, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(1, 1, 1, 1), 0, 0));
        add(label8, new GridBagConstraints(0, 7, 1, 1, 2, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(1, 1, 1, 1), 0, 0));
        add(label9, new GridBagConstraints(1, 7, 1, 1, 2, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(1, 1, 1, 1), 0, 0));
        add(label11, new GridBagConstraints(3, 7, 1, 1, 2, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(1, 1, 1, 1), 0, 0));
        add(label12, new GridBagConstraints(4, 7, 1, 1, 2, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(1, 1, 1, 1), 0, 0));
        add(emailUpdate, new GridBagConstraints(0, 8, 1, 1, 2, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(1, 1, 1, 1), 0, 0));
        add(dirUpdate, new GridBagConstraints(1, 8, 1, 1, 2, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(1, 1, 1, 1), 0, 0));
        add(passUpdate, new GridBagConstraints(3, 8, 1, 1, 2, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(1, 1, 1, 1), 0, 0));
        add(descriptionUpdate, new GridBagConstraints(4, 8, 1, 1, 2, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(1, 1, 1, 1), 0, 0));
        add(updateButton, new GridBagConstraints(5, 8, 1, 1, 2, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(1, 1, 1, 1), 0, 0));
        add(label13, new GridBagConstraints(0, 9, 1, 1, 2, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(1, 1, 1, 1), 0, 0));
        add(deleteId, new GridBagConstraints(0, 10, 1, 1, 2, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(1, 1, 1, 1), 0, 0));
        add(deleteButton, new GridBagConstraints(5, 10, 1, 1, 2, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(1, 1, 1, 1), 0, 0));

    }

    public void st(){
        init();
        deleteButton.addActionListener((ae)-> usersSay.sayDelete(Integer.parseInt(deleteId.getText())));
        addButton.addActionListener(new PanelU.AddButtonActionListener());
        searchButton.addActionListener(new PanelU.SearchButtonActionListener());
        updateButton.addActionListener(new PanelU.UpdateButtonActionListener());
        generateButton.addActionListener((ae) -> passAdd.setText(PassGen.passGen()));
    }

    public  void showTable(List<Users> users){
        DefaultTableModel model = new DefaultTableModel(new Object[]{"Id", "email", "fk", "fk", "passwd", "desc"}, 0);
        for (Users o : users ) {
           model.addRow(new Object[]{o.getId(), o.getEmail(), o.getFk_tb_directories().getId(), o.getFk_tb_domain().getId(), o.getPasswd(), o.getDescription()});
        }
        table.setModel(model);
    }


    class AddButtonActionListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            fk_tb_domain = domainSay.saySearchId(Integer.parseInt(domainAdd.getText()));
            fk_tb_directories = directoriesSay.saySearchId(Integer.parseInt(dirAdd.getText()));
            usersSay.sayAdd(new Users(emailAdd.getText(), fk_tb_directories, fk_tb_domain, passAdd.getText(), descriptionAdd.getText()));

            if (jcheckAlias.isSelected())
                aliasSay.addAliases(emailAdd.getText(), fk_tb_domain.getName());
            else return;
        }
    }

    class  SearchButtonActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (emailSearch.getText().length() >= 1) {
                showTable(usersSay.saySearchEmail(emailSearch.getText()));}
            else if (domainSearch.getText().length() >= 1){
                fk_tb_domain = domainSay.saySearchId(Integer.parseInt(domainSearch.getText()));
                showTable(usersSay.saySearchDomain(fk_tb_domain));}
            else {showTable(usersSay.saySearch());}

        }
    }

    class UpdateButtonActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
/*
               * for (int i = 0; i < 322; i++) {
               * Users users = usersSay.saySearchId(i);
               * if (users != null)
               * { users.setPasswd("12345678");
               * usersSay.sayUpdate(users);}
               * }
                */
            Users users = usersSay.saySearchId(Integer.parseInt((emailUpdate.getText())));
            if (dirUpdate.getText().trim().length() >= 1){
                fk_tb_directories = directoriesSay.saySearchId(Integer.parseInt(dirUpdate.getText()));
            users.setFk_tb_directories(fk_tb_directories);}
            if (passUpdate.getText().length() >= 1)
            users.setPasswd(passUpdate.getText());
            users.setDescription(descriptionUpdate.getText());
            usersSay.sayUpdate(users);
        }
    }



}
