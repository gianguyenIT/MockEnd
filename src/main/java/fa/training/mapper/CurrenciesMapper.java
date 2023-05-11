package fa.training.mapper;

import fa.training.dto.CurrenciesDTO;
import fa.training.entity.Currencies;
import org.springframework.stereotype.Service;

@Service
public class CurrenciesMapper extends AbstractMapper<Currencies, CurrenciesDTO> {
    public CurrenciesMapper() {
        super(Currencies.class, CurrenciesDTO.class);
    }
}
