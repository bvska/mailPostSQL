package sqlEntity;


import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity
@Table(name = "tb_users", uniqueConstraints = {@UniqueConstraint(columnNames = {"email", "fk_tb_domain_id"})})
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
    @Column()
    @Type(type ="text")
    private String description;

    public Users() {
    }

    public Users(String email, Directories fk_tb_directories, Domain fk_tb_domain, String passwd, String description) {
       setEmail(email);
        this.fk_tb_directories = fk_tb_directories;
        this.fk_tb_domain = fk_tb_domain;
      setPasswd(passwd);
        setDescription(description);
    }

    public Users(String email, Directories fk_tb_directories, Domain fk_tb_domain, String passwd) {
        setEmail(email);
        setFk_tb_directories(fk_tb_directories);
        this.fk_tb_domain = fk_tb_domain;
        setPasswd(passwd);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email == null || email.trim().length() < 3) throw new IllegalArgumentException("Имя должно быть не менее 3х символов");
        this.email = email;
    }

    public Directories getFk_tb_directories() {
        return fk_tb_directories;
    }

    public Domain getFk_tb_domain() {
        return fk_tb_domain;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setFk_tb_directories(Directories fk_tb_directories) {
        this.fk_tb_directories = fk_tb_directories;
    }

    public void setPasswd(String passwd) {
        if (passwd == null || passwd.trim().length() < 8) throw new IllegalArgumentException("Требуется сложный пароль, сгенерируйте пароль");
        this.passwd = passwd;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return getId() + " " + getEmail() + "  " + getFk_tb_directories().getId() + " " + getFk_tb_domain().getId() + "  " + getPasswd() + "  " +
                getDescription() + '\n';    }
}
