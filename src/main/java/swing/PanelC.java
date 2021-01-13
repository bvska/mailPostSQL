package swing;

import sqlEntity.Client;
import start.ClientSay;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelC extends JPanel {

    private Client client;
    private ClientSay clientSay = new ClientSay();
    private JLabel label2 = new JLabel("Имя");
    private JLabel label3 = new JLabel("описание");
    private JLabel label5 = new JLabel("Имя");
    private JLabel label7 = new JLabel("описание");
    private JLabel label4 = new JLabel("Id объекта");
    private Button searchButton = new Button("Показать");
    private Button updateButton = new Button("Обновить");
    private Button addButton = new Button("Добавить");
    private Button deleteButton = new Button("Удалить");
    private JTextPane search = new JTextPane();
    private JTextField idUpdate = new JTextField(5);
    private JTextField nameUpdate = new JTextField(30);
    private JTextField descriptionUpdate = new JTextField(30);
    private JTextField nameAdd = new JTextField(30);
    private JTextField descriptionAdd = new JTextField(30);
    private JTextField deleteId = new JTextField(30);


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
        add(searchButton, new GridBagConstraints(0, 6, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(1,1,1,1), 0, 0));
        add(search, new GridBagConstraints(1, 6, 3, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(1,1,1,1), 0, 0));
    }

    public void st(){
        init();
        deleteButton.addActionListener(new DeleteButtonActionListener());
        addButton.addActionListener(new AddButtonActionListener());
    }

    class DeleteButtonActionListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            clientSay.say(Integer.parseInt(deleteId.getText()));
        }
    }


    class AddButtonActionListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            if (descriptionAdd.getText().equals(null)){
                System.out.println(nameAdd.getText());
            clientSay.sayAdd(new Client(nameAdd.getText()));
            }
            else {
                clientSay.sayAdd(new Client(nameAdd.getText(),descriptionAdd.getText()));
                System.out.println(nameAdd.getText() + " " + descriptionAdd.getText());
            }
        }
    }

}
