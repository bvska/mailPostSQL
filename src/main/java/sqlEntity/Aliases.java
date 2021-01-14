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
        setAlias(alias);
        setRcpt(rcpt);
        setDescription(description);
    }

    public Aliases(String alias, String rcpt) {
        setAlias(alias);
        setRcpt(rcpt);
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        if (alias == null || alias.trim().length() < 7) throw new IllegalArgumentException("Альяс не может быть короче 7 символов");
        this.alias = alias;

    }

    public String getRcpt() {
        return rcpt;
    }

    public void setRcpt(String rcpt) {
        if (rcpt == null || rcpt.trim().length() < 7) throw new IllegalArgumentException("Поле не может быть пустым");
        this.rcpt = rcpt;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return  getId() + " " + getAlias() + "    " + getRcpt() + "   " + getDescription() + "   ";
    }
}
