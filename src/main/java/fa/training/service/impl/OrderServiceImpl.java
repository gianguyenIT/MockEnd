package fa.training.service.impl;

import fa.training.dto.OrderDTO;
import fa.training.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    RestTemplate restTemplate;

    @Override
    public List<OrderDTO> findAll() {
        String Url_AllOrder = "http://localhost:9090/api/v1/orders";
        ResponseEntity<List<OrderDTO>> response = restTemplate.exchange(
                Url_AllOrder,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<OrderDTO>>() {}
        );
        return response.getBody();
    }

    @Override
    public OrderDTO findById(Long id) {
        return null;
    }

    @Override
    public OrderDTO save(OrderDTO orderDTO) {
        return null;
    }

    @Override
    public int update(OrderDTO orderDTO) {
        return 0;
    }

    @Override
    public boolean delete(OrderDTO orderDTO) {
        return false;
    }
}
