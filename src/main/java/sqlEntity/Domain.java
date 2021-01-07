package sqlEntity;


import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tb_domain")
public class Domain extends IdTable {

    @ManyToOne
    @JoinColumn(nullable = false)
    private Client fk_tb_client;

    @Column(nullable = false)
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

    public Domain(Client client, String name, String description) {
        this.fk_tb_client = client;
        this.name = name;
        this.description = description;
    }
}
