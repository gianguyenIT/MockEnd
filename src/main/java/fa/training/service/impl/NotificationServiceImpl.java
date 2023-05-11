package fa.training.service.impl;

import fa.training.dto.NotificationDTO;
import fa.training.entity.Notification;
import fa.training.mapper.NotificationMapper;
import fa.training.repository.NotificationRepository;
import fa.training.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NotificationServiceImpl implements NotificationService {
    
    @Autowired
    NotificationRepository repository;
    
    @Autowired
    NotificationMapper mapper;

    @Override
    public List<NotificationDTO> findAll() {
        List<Notification> notification = repository.findAll();
        return notification == null || notification.size() == 0 ? new ArrayList<>()
                : notification.stream().map(item -> mapper.convertEntityToDTO(item))
                .collect(Collectors.toList());
    }

    @Override
    public NotificationDTO findById(Long id) {
        Optional<Notification> notification = repository.findById(id);
        return notification != null && notification.isPresent() ? mapper.convertEntityToDTO(notification.get())
                : new NotificationDTO();
    }

    @Override
    public NotificationDTO save(NotificationDTO notificationDTO) {
        if (notificationDTO == null) return new NotificationDTO();
        Notification notification = repository.save(mapper.convertDTOToEntity(notificationDTO));
        return notification == null ? new NotificationDTO() : mapper.convertEntityToDTO(notification);
    }

    @Override
    public int update(NotificationDTO notificationDTO) {
        if (notificationDTO == null || notificationDTO.getId() == null) return -1;
        Optional<Notification> notification = repository.findById(notificationDTO.getId());
        if (notification != null && notification.isPresent()) {
            Notification notificationUpdate =  repository.save(mapper.convertDTOToEntity(notificationDTO));
            return notificationUpdate == null ? 0 : 1;
        }
        return -1;
    }

    @Override
    public boolean delete(NotificationDTO notificationDTO) {
        try {
            if (notificationDTO == null || notificationDTO.getId() == null) return false;
            Optional<Notification> notification = repository.findById((notificationDTO.getId()));
            if (notification != null && notification.isPresent()) {
                repository.delete(notification.get());
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
