package fa.training.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DeliveryDetailDTO {
    private Long id;

    private String deliveryDetailUuid;

    private Date deliveryDate;

    private String shippingUnit;

    private String shipperName;

    private String shipperPhone;

    private String shipperAddress;

    private List<OrderDTO> orders;
}
