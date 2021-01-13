package sqlEntity;


import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "tb_client")
public class Client extends IdTable {

    @Column(nullable = false)
    @Type(type = "text")
    private String name;
    @Column
    @Type(type = "text")
    private String description;

    @OneToMany(mappedBy = "fk_tb_client")
    private List<Domain> domainList;

    public Client() {
    }

    public Client(String name, String description) {
        setName(name);
        this.description = description;
    }

    public Client(String name) {
        setName(name);
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().length() < 3) throw new IllegalArgumentException("мя должно быть не менее 3х символов");
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

}
