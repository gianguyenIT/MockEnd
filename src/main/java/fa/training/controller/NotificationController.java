package fa.training.controller;

import fa.training.consts.ApiPath;
import fa.training.dto.NotificationDTO;
import fa.training.repository.NotificationRepository;
import fa.training.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class NotificationController {

    @Autowired
    private NotificationRepository repository;

    @Autowired
    NotificationService service;


    @PostMapping(value = ApiPath.NOTIFICATION_CREATE)
    public NotificationDTO createNotification(@RequestBody NotificationDTO newNotification) {
        return service.save(newNotification);
    }

    @GetMapping(value = ApiPath.NOTIFICATION_GET_ALL)
    public List<NotificationDTO> getAllNotifications() {
        return service.findAll();
    }

    @GetMapping(value = ApiPath.NOTIFICATION_BY_ID)
    public NotificationDTO getNotificationById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PutMapping(value = ApiPath.NOTIFICATION_UPDATE)
    public Integer updateNotification(@RequestBody NotificationDTO newNotification) {
        return service.update(newNotification);
    }

    @DeleteMapping(value = ApiPath.NOTIFICATION_DELETE)
    public String deleteNotification(@RequestBody NotificationDTO notification) {
        boolean isDelete = service.delete(notification);
        return isDelete ? "Delete successful" : "Delete failed";
    }
}
