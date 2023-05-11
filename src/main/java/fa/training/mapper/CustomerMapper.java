package fa.training.mapper;

import fa.training.dto.CustomerDTO;
import fa.training.entity.Customer;
import org.springframework.stereotype.Service;

@Service
public class CustomerMapper extends AbstractMapper<Customer, CustomerDTO> {
    public CustomerMapper() {
        super(Customer.class, CustomerDTO.class);
    }
}
