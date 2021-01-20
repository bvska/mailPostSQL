package swing;

import sqlEntity.Aliases;
import controler.AliasSay;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelA extends JPanel {

    AliasSay aliasSay = new AliasSay();
    private JLabel label1 = new JLabel("Альяс");
    private JLabel label2 = new JLabel("Получатель");
    private JLabel label3 = new JLabel("Альяс");
    private JLabel label4 = new JLabel("Получатель");
    private JLabel label5 = new JLabel("Описание");
    private JLabel label6 = new JLabel("Id объекта");
    private JLabel label7 = new JLabel("Получатель");
    private JLabel label8 = new JLabel("Id объекта");
    private JLabel label9 = new JLabel("Описание");
    private JTextField aliasSearch = new JTextField(20);
    private JTextField rcptSearch = new JTextField(20);
    private JTextField aliasAdd = new JTextField(null, 20);
    private JTextField rcptAdd = new JTextField(20);
    private JTextField descriptionAdd = new JTextField(20);
    private JTextField idUpdate = new JTextField(5);
    private JTextField rcptUpdate = new JTextField(30);
    private JTextField deleteId = new JTextField(5);
    private JTextField descriptionUpdate = new JTextField(30);
    private Button searchButton = new Button("Найти");
    private Button addButton = new Button("Добавить");
    private Button updateButton = new Button("Обновить");
    private Button deleteButton = new Button("Удалить");
    private JTextArea search = new JTextArea(10, 20);
    private JScrollPane pane = new JScrollPane(search);

    public void init() {
        setLayout(new GridBagLayout());
        add(label1, new GridBagConstraints(0, 10, 1, 1, 2, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(1, 1, 1, 1), 0, 0));
        add(label2, new GridBagConstraints(1, 10, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(1, 1, 1, 1), 0, 0));
        add(aliasSearch, new GridBagConstraints(0, 11, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
        add(rcptSearch, new GridBagConstraints(1, 11, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
        add(searchButton, new GridBagConstraints(3, 11, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
        add(pane, new GridBagConstraints(0, 12, 4, 15, 1, 1,
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
        add(label9, new GridBagConstraints(2, 6, 1, 1, 2, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(1, 1, 1, 1), 0, 0));
        add(idUpdate, new GridBagConstraints(0, 7, 1, 1, 2, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(1, 1, 1, 1), 0, 0));
        add(rcptUpdate, new GridBagConstraints(1, 7, 1, 1, 2, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(1, 1, 1, 1), 0, 0));
        add(descriptionUpdate, new GridBagConstraints(2, 7, 1, 1, 2, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(1, 1, 1, 1), 0, 0));
        add(updateButton, new GridBagConstraints(3, 7, 1, 1, 2, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(1, 1, 1, 1), 0, 0));
        add(label8, new GridBagConstraints(0, 8, 1, 1, 2, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(1, 1, 1, 1), 0, 0));
        add(deleteId, new GridBagConstraints(0, 9, 1, 1, 2, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(1, 1, 1, 1), 0, 0));
        add(deleteButton, new GridBagConstraints(3, 9, 1, 1, 2, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(1, 1, 1, 1), 0, 0));
    }

    public void st(){
        init();
        deleteButton.addActionListener(new DeleteButtonActionListener());
        addButton.addActionListener(new AddButtonActionListener());
        searchButton.addActionListener(new SearchButtonActionListener());
        updateButton.addActionListener(new UpdateButtonActionListener());
    }

    class DeleteButtonActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {aliasSay.sayDelete(Integer.parseInt(deleteId.getText()));
            }
        }

    class AddButtonActionListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
                aliasSay.sayAdd(new Aliases(aliasAdd.getText(), rcptAdd.getText(), descriptionAdd.getText()));
        }
    }


    class  SearchButtonActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (aliasSearch.getText().length() >= 1) {
                search.setText(aliasSay.saySearchAliases(aliasSearch.getText()).toString());}
           else if (rcptSearch.getText().length() >= 1){
                search.setText(aliasSay.saySearchRcpt(rcptSearch.getText()).toString());}
            else {search.setText(aliasSay.saySearch().toString());}
        }
    }

    class UpdateButtonActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Aliases aliases = aliasSay.saySearchId(Integer.parseInt((idUpdate.getText())));
            if (rcptUpdate.getText().length() >= 1){
                aliases.setRcpt(rcptUpdate.getText());}
            if (descriptionUpdate.getText().length() >= 1){
                aliases.setDescription(descriptionUpdate.getText());}
            aliasSay.sayUpdate(aliases);


        }
    }
}
