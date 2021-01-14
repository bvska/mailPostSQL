package sqlEntity;


import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity
@Table(name = "tb_users")
public class Users extends IdTable {

    @Column(nullable = false)
    @Type(type ="text")
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
    @Type(type ="text")
    private String passwd;
    @Column(unique = true)
    @Type(type ="text")
    private String description;

    public Users() {
    }

    public Users(String email, Directories fk_tb_directories, Domain fk_tb_domain, String passwd, String description) {
        this.email = email;
        this.fk_tb_directories = fk_tb_directories;
        this.fk_tb_domain = fk_tb_domain;
        this.passwd = passwd;
        this.description = description;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Directories getFk_tb_directories() {
        return fk_tb_directories;
    }

    public void setFk_tb_directories(Directories fk_tb_directories) {
        this.fk_tb_directories = fk_tb_directories;
    }

    public Domain getFk_tb_domain() {
        return fk_tb_domain;
    }

    public void setFk_tb_domain(Domain fk_tb_domain) {
        this.fk_tb_domain = fk_tb_domain;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getDescription() {
        return description;
    }
}
