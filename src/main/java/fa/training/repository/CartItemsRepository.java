package fa.training.repository;

import fa.training.entity.CartItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartItemsRepository extends JpaRepository<CartItems, Long>, CrudRepository<CartItems, Long> {
}
