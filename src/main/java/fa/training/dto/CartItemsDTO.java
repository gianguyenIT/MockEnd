package fa.training.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CartItemsDTO {
    @JsonProperty("id")
    private Long id;
    @JsonProperty("product_id")
    private Long productId;
    @JsonProperty("quantity")
    private Integer quantity;
    @JsonProperty("status")
    private Boolean status;


}
