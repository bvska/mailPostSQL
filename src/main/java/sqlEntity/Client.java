package sqlEntity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "tb_client")
public class Client extends IdTable {

    @Column(nullable = false)
    private String name;
    @Column
    private String description;

    @OneToMany (mappedBy = "fk_tb_client_id")
    private List<Domain> domainList;

    public Client() {
    }

    public Client(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
