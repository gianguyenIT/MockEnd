package fa.training.dto;

import fa.training.entity.Customer;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ItemDTO {
    private Long id;
    private ProductDTO product;
    private int quantity;
    private String code;
    private Customer customer;
}
