package sqlEntity;


import javax.persistence.*;

@Entity
@Table(name = "tb_users")
public class Users extends IdTable {

    @Column(nullable = false)
    private String email;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Directories fk_tb_directories;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Domain fk_tb_domain;

    @Column(nullable = false)
    private Boolean bool_admin = false;
    @Column(nullable = false)
    private Boolean bool_gadmin = false;
    @Column(nullable = false)
    private String passwd;
    @Column
    private String description;

    public Users() {
    }

    public Users(String email, Directories fk_tb_directories, Domain fk_tb_domain, Boolean bool_admin, Boolean bool_gadmin, String passwd, String description) {
        this.email = email;
        this.fk_tb_directories = fk_tb_directories;
        this.fk_tb_domain = fk_tb_domain;
        this.bool_admin = bool_admin;
        this.bool_gadmin = bool_gadmin;
        this.passwd = passwd;
        this.description = description;
    }
}
