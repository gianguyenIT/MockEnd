package fa.training.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReportDTO {
    private Long id;

    private String reportUuid;

    private String reportType;

    private OrderDTO order;

    private Account account;
}
