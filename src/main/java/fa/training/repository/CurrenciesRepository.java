package fa.training.repository;

import fa.training.entity.Currencies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrenciesRepository extends JpaRepository<Currencies, Long>, CrudRepository<Currencies, Long> {
}
