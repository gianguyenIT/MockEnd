package fa.training.controller;

import fa.training.consts.ApiPath;
import fa.training.dto.CustomerDTO;
import fa.training.entity.Customer;
import fa.training.repository.CustomerRepository;
import fa.training.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    private CustomerRepository repository;

    @Autowired
    CustomerService service;

    @GetMapping(value = ApiPath.PING)
    public String ping() {
        System.out.println("ping");
        return "ping";

    }

    @PostMapping(value = ApiPath.CUSTOMER_CREATE)
    public CustomerDTO createCustomer(@RequestBody CustomerDTO newCustomer) {
        return service.save(newCustomer);
    }

    @GetMapping(value = ApiPath.CUSTOMER_GET_ALL)
    public List<CustomerDTO> getAllCustomers() {
        return service.findAll();
    }

    @GetMapping(value = ApiPath.CUSTOMER_BY_ID)
    public CustomerDTO getCustomerById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PutMapping(value = ApiPath.CUSTOMER_UPDATE)
    public Integer updateCustomer(@RequestBody CustomerDTO newCustomer) {
        return service.update(newCustomer);
    }

    @DeleteMapping(value = ApiPath.CUSTOMER_DELETE)
    public String deleteCustomer(@RequestBody CustomerDTO customer) {
        boolean isDelete = service.delete(customer);
        return isDelete ? "Delete successful" : "Delete failed";
    }

}
