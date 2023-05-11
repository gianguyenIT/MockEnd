package fa.training.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PriceDTO {
    private Long id;

    private String priceUuid;

    private String productCode;

    private Double price;

    private Integer discount;

    private ProductDTO product;
}
