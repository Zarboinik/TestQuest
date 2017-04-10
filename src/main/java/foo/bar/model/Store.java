package foo.bar.model;

import lombok.Data;


import javax.persistence.*;

@Entity
@Data
@Table(name = "store")
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String addres;

    public Store(String addres) {
        this.addres = addres;
    }

    public Store() {
    }
}
