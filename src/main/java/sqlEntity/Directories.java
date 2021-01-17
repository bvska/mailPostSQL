package sqlEntity;


import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "tb_directories")
public class Directories extends IdTable {

    @Column(nullable = false)
    @Type(type ="text")
    private String path;
    @Column
    @Type(type ="text")
    private String description;


    @OneToMany(mappedBy = "fk_tb_directories")
    private List<Users> usersList;

    public Directories() {
    }

    public Directories(String path, String description) {
        this.path = path;
        this.description = description;
    }

    public Directories(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return  getId() + "  "  +   getPath() + "  " + getDescription() + '\n';
    }
}
