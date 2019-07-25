package pl.sda.store.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;


@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Product implements IBaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @ToString.Exclude
    @OneToMany(mappedBy = "product", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    @Cascade(org.hibernate.annotations.CascadeType.REMOVE)
    private List<Inventory> inventories;

}
