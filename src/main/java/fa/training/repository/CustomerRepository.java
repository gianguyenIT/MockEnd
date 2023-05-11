package fa.training.repository;

import fa.training.dto.CustomerDTO;
import fa.training.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>, CrudRepository<Customer, Long> {

    public boolean existsByEmail(String email);

    public Customer findByEmail(String email);
}
