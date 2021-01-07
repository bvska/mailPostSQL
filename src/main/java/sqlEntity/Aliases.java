package sqlEntity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tb_aliases")
public class Aliases extends IdTable {

    @Column (nullable = false)
    private String alias;
    @Column(nullable = false)
    private String rcpt;
    @Column
    private String description;

    public Aliases() {
    }

    public Aliases(String alias, String rcpt, String description) {
        this.alias = alias;
        this.rcpt = rcpt;
        this.description = description;
    }
}
