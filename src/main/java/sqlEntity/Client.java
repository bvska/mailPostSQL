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
    @Type(type ="text")
    private String name;
    @Column
    @Type(type ="text")
    private String description;

    @OneToMany (mappedBy = "fk_tb_client")
    private List<Domain> domainList;

    public Client() {
    }

    public Client(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
