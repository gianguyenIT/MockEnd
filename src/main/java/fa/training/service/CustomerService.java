package fa.training.service;

import fa.training.dto.CustomerDTO;

public interface CustomerService extends BaseService<CustomerDTO> {
    public boolean checkEmail(String email);
}
