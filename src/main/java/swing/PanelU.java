package swing;

import sqlEntity.Users;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelU extends JPanel {


    private JLabel label1 = new JLabel("Email");
    private JLabel label2 = new JLabel("Домен_Id");
    private JLabel label3 = new JLabel("Email");
    private JLabel label4 = new JLabel("Директория_Id");
    private JLabel label5 = new JLabel("Домен_Id");
    private JLabel label6 = new JLabel("passwd");
    private JLabel label7 = new JLabel("Описание");
    private JLabel label8 = new JLabel("Email");
    private JLabel label9 = new JLabel("Директория_Id");
    private JLabel label10 = new JLabel("Домен_Id");
    private JLabel label11 = new JLabel("passwd");
    private JLabel label12 = new JLabel("Описание");
    private JLabel label13 = new JLabel("Id");
    private JTextField emailSearch = new JTextField(20);
    private JTextField domenSearch = new JTextField(20);
    private JTextField emailAdd = new JTextField(20);
    private JTextField dirAdd = new JTextField(5);
    private JTextField domAdd = new JTextField(5);
    private JTextField passAdd = new JTextField(20);
    private JTextField descriptionAdd = new JTextField(20);
    private JTextField emailUpdate = new JTextField(20);
    private JTextField dirUpdate = new JTextField(5);
    private JTextField domUpdate = new JTextField(5);
    private JTextField passUpdate = new JTextField(20);
    private JTextField descriptionUpdate = new JTextField(20);
    private JTextField deleteId = new JTextField(5);
    private Button searchButton = new Button("Найти");
    private Button addButton = new Button("Добавить");
    private Button generateButton = new Button("Сгенерировать пароль");
    private Button updateButton = new Button("Обновить");
    private Button deleteButton = new Button("Удалить");
    private JTextArea search = new JTextArea(10, 20);
    private JScrollPane pane = new JScrollPane(search);



    public void init(){
        setLayout(new GridBagLayout());
        add(label1, new GridBagConstraints(0, 0, 1, 1, 2, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(1, 1, 1, 1), 0, 0));
        add(label2, new GridBagConstraints(1, 0, 1, 1, 2, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(1, 1, 1, 1), 0, 0));
        add(emailSearch, new GridBagConstraints(0, 1, 1, 1, 2, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(1, 1, 1, 1), 0, 0));
        add(domenSearch, new GridBagConstraints(1, 1, 1, 1, 2, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(1, 1, 1, 1), 0, 0));
        add(searchButton, new GridBagConstraints(5, 1, 1, 1, 2, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(1, 1, 1, 1), 0, 0));
        add(pane, new GridBagConstraints(0, 11, 4, 15, 2, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(1, 1, 1, 1), 0, 0));
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
        add(domAdd, new GridBagConstraints(2, 5, 1, 1, 2, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(1, 1, 1, 1), 0, 0));
        add(passAdd, new GridBagConstraints(3, 5, 1, 1, 2, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(1, 1, 1, 1), 0, 0));
        add(descriptionAdd, new GridBagConstraints(4, 5, 1, 1, 2, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(1, 1, 1, 1), 0, 0));
        add(addButton, new GridBagConstraints(5, 5, 1, 1, 2, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(1, 1, 1, 1), 0, 0));
        add(generateButton, new GridBagConstraints(3, 6, 1, 1, 2, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(1, 1, 1, 1), 0, 0));
        add(label8, new GridBagConstraints(0, 7, 1, 1, 2, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(1, 1, 1, 1), 0, 0));
        add(label9, new GridBagConstraints(1, 7, 1, 1, 2, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(1, 1, 1, 1), 0, 0));
        add(label10, new GridBagConstraints(2, 7, 1, 1, 2, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(1, 1, 1, 1), 0, 0));
        add(label11, new GridBagConstraints(3, 7, 1, 1, 2, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(1, 1, 1, 1), 0, 0));
        add(label12, new GridBagConstraints(4, 7, 1, 1, 2, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(1, 1, 1, 1), 0, 0));
        add(emailUpdate, new GridBagConstraints(0, 8, 1, 1, 2, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(1, 1, 1, 1), 0, 0));
        add(dirUpdate, new GridBagConstraints(1, 8, 1, 1, 2, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(1, 1, 1, 1), 0, 0));
        add(domUpdate, new GridBagConstraints(2, 8, 1, 1, 2, 1,
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
        deleteButton.addActionListener(new PanelU.DeleteButtonActionListener());
        addButton.addActionListener(new PanelU.AddButtonActionListener());
        searchButton.addActionListener(new PanelU.SearchButtonActionListener());
        updateButton.addActionListener(new PanelU.UpdateButtonActionListener());
    }


    class DeleteButtonActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }

    class AddButtonActionListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }
    class  SearchButtonActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

        }

    }

    class UpdateButtonActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
        }
    }

}
