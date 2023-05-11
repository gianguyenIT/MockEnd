package fa.training.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ImportDTO {
    private Long id;

    private String importUuid;

    private String productCode;

    private Integer importQuantity;

    private ProductDTO product;
}
