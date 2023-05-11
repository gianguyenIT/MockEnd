package fa.training.mapper;

import fa.training.dto.NotificationDTO;
import fa.training.entity.Notification;
import org.springframework.stereotype.Service;

@Service
public class NotificationMapper extends AbstractMapper<Notification, NotificationDTO> {
    public NotificationMapper() {
        super(Notification.class, NotificationDTO.class);
    }
}
