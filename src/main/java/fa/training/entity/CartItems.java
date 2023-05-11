package fa.training.entity;

import javax.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "cart_items")
public class CartItems implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "product_id")
    private Long productId;
    @Column(name = "quantity")
    private Integer quantity;
    @Column(name = "status")
    private Boolean status;
    @ManyToOne
    @JoinColumn(name = "id_customer")
    private Customer customer;
}
