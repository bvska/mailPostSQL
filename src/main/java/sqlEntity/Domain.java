package sqlEntity;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tb_domain")
public class Domain extends IdTable {

    @ManyToOne
    @JoinColumn(nullable = false)
    private Client client;

    @Column(nullable = false)
    private String name;

    @Column
    private String description;

    @OneToMany (mappedBy = "fk_tb_domain")
    private List<Users> usersList;

    @OneToMany (mappedBy = "fk_tb_domain")
    private List<Transport> transportList;

    public Domain() {
    }

    public Domain(Client client, String name, String description) {
        this.client = client;
        this.name = name;
        this.description = description;
    }
}
