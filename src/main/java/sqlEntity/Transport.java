package sqlEntity;


import javax.persistence.*;

@Entity
@Table(name = "tb_transport")
public class Transport extends IdTable {


    @ManyToOne
    @JoinColumn(nullable = false)
    private Transport fk_tb_domain;

    @Column(nullable = false)
    private char transport;

    @Column
    private String description;

    public Transport() {
    }

    public Transport(Transport fk_tb_domain, char transport, String description) {
        this.fk_tb_domain = fk_tb_domain;
        this.transport = transport;
        this.description = description;
    }
}
