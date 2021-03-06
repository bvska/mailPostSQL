package sqlEntity;


import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.swing.*;
import java.util.List;

@Entity
@Table(name = "tb_client")
public class Client extends IdTable {

    @Column(nullable = false, unique = true)
    @Type(type = "text")
    private String name;
    @Column
    @Type(type = "text")
    private String description;

    @OneToMany(mappedBy = "fk_tb_client", fetch = FetchType.LAZY)
    private List<Domain> domainList;


    public Client() {
    }

    public Client(String name, String description) {
        setName(name);
        setDescription(description);
    }

    public Client(String name) {
        setName(name);
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {

        if (name == null || name.trim().length() < 3) {
            JOptionPane.showMessageDialog(null , "Имя должно быть не менее 3х символов","" ,JOptionPane.ERROR_MESSAGE);
            throw new IllegalArgumentException("Имя должно быть не менее 3х символов");}

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
        return getId() + " " + getName() + "    " + getDescription()   + '\n';
    }

}



