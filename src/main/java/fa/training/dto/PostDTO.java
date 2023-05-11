package fa.training.dto;

import fa.training.entity.Notification;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PostDTO {
    private Long id;

    private String postUuid;

    private Date expiredDate;

    private String reason;

    private String status;;

    private ProductDTO product;

    private String accountId;

    private List<Notification> notifications;
}
