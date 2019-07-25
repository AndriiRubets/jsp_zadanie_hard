package pl.sda.store.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Inventory implements IBaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String quantity;
    private String value;

    @CreationTimestamp
    private LocalDate dateArrived;

    public Inventory(String quantity, String value) {
        this.quantity = quantity;
        this.value = value;
    }

    @ManyToOne
    private Product product;


}
