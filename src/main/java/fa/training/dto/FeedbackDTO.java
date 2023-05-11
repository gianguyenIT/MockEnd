package fa.training.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FeedbackDTO {
    private Long id;

    private String feedbackUuid;

    private Integer rating;

    private String opinion;

    private String images;

    private Boolean active;

    private String reply;

    private CustomerDTO customer;

    private OrderDTO order;
}
