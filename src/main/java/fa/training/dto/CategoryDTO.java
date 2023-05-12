package fa.training.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class CategoryDTO {
    @JsonProperty("id")
    private Long id;

    private String categoryUuid;
    @JsonProperty("categoryName")
    private String categoryName;

    private List<ProductDTO> products;
}
