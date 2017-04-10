package foo.bar.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="product")
@Inheritance(strategy= InheritanceType.JOINED)
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "store_id")
    private Integer storeId;
    @Column(name = "serial_number")
    private Integer serialNumber;
    private String manufacturer;
    private Integer price;
    private Integer amount;
}
