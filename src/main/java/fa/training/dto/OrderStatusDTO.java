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
public class OrderStatusDTO {
    private Long id;

    private String orderStatusUuid;

    private String name;

    private List<OrderDTO> orders;
}
