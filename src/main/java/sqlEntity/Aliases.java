package sqlEntity;


import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tb_aliases")
public class Aliases extends IdTable {

    @Column (nullable = false, unique = true)
    @Type(type ="text")
    private String alias;
    @Column(nullable = false)
    @Type(type ="text")
    private String rcpt;
    @Column
    @Type(type ="text")
    private String description;

    public Aliases() {
    }

    public Aliases(String alias, String rcpt, String description) {
        this.alias = alias;
        this.rcpt = rcpt;
        this.description = description;
    }
}
