package sqlEntity;


import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.swing.*;
import java.util.List;

@Entity
@Table(name = "tb_domain")
public class Domain extends IdTable {

    @ManyToOne
    @JoinColumn(nullable = false)
    private Client fk_tb_client;

    @Column(nullable = false, unique = true)
    @Type(type ="text")
    private String name;

    @Column
    @Type(type ="text")
    private String description;

    @OneToMany (mappedBy = "fk_tb_domain")
    private List<Users> usersList;

    @OneToMany (mappedBy = "fk_tb_domain")
    private List<Transport> transportList;

    public Domain() {
    }

    public Domain(Client fk_tb_client, String name, String description) {
        this.fk_tb_client = fk_tb_client;
        setName(name);
        setDescription(description);

    }

    public Domain(Client fk_tb_client, String name) {
        this.fk_tb_client = fk_tb_client;
        setName(name);
    }

    public Client getFk_tb_client() {
        return fk_tb_client;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        JOptionPane.showMessageDialog(null , "Имя должно быть не менее 3х символов","" ,JOptionPane.ERROR_MESSAGE);
        if (name == null || name.trim().length() < 3) throw new IllegalArgumentException("Имя должно быть не менее 3х символов");
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return  getId() + "  "  +   getFk_tb_client().getId() + "  "  + getName() + "  "  + getDescription()  + '\n';

    }
}
