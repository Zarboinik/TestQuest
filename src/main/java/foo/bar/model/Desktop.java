package foo.bar.model;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Data
@Table(name="desktop")
@PrimaryKeyJoinColumn(name = "desktop_id", referencedColumnName = "id")
public class Desktop extends Product{
    @Column(name = "form_factor")
    private String formFactor;

}
