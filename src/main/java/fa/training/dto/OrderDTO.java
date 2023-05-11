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
public class OrderDTO {
    private Long id;

    private String orderUuid;

    private String paymentMethod;

    private Double totalPrice;

    private Long deliveryDetail;

    private String orderStatus;

    private Long customer;

    private List<FeedbackDTO> feedback;
}
