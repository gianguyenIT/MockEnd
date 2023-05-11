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
public class Account {
    private Long id;

    private String accountUuid;

    private String bannerImg;

    private String accountImgPath;

    private String accountImg;

    private String bannerImgPath;

    private String accountName;

    private String accountEmail;

    private String phone;

    private String address;

    private Boolean active;

    private String encryptedPassword;

    private RoleDTO role;

    private OrderDTO order;

    private List<NotificationDTO> notifications;

    private List<ProductDTO> products;

    private List<ReportDTO> reports;

}
