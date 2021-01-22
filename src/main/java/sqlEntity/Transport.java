package sqlEntity;


import org.hibernate.annotations.Type;
import javax.persistence.*;

@Entity
@Table(name = "tb_transport")
public class Transport extends IdTable {


    @ManyToOne
    @JoinColumn(nullable = false)
    private Domain fk_tb_domain;

    @Column(nullable = false)
    private String transport;

    @Column
    @Type(type ="text")
    private String description;

    public Transport() {
    }

    public Transport(Domain fk_tb_domain, String transport, String description) {
        this.fk_tb_domain = fk_tb_domain;
        setTransport(transport);
        setDescription(description);
    }

    public Transport(Domain fk_tb_domain, String transport) {
        this.fk_tb_domain = fk_tb_domain;
        setTransport(transport);
    }

    public Domain getFk_tb_domain() {
        return fk_tb_domain;
    }

    public String getTransport() {
        return transport;
    }

    public void setTransport(String transport) {
        this.transport = transport;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return getId() + "   " +  getFk_tb_domain().getId() + " " + getTransport() + "   " + getDescription()   + '\n';
    }
}
