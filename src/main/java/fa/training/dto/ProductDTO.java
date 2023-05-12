package fa.training.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
    private Long id;

    private String productUuid;

    private String productImage;

    private String productName;

    private String productCode;

    private String description;

    private Double price;

    private String brand;

    private String color;

    private String size;

    private Integer importQuantity;

    private CategoryDTO category;

    private Account account;

    private PostDTO post;

    private FeedbackDTO feedback;

    private List<PriceDTO> prices;

    private List<ImportDTO> imports;

    private ItemDTO item;

}
