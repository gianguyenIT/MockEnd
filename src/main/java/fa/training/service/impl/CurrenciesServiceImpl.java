package fa.training.service.impl;

import fa.training.dto.CurrenciesDTO;
import fa.training.entity.Currencies;
import fa.training.mapper.CurrenciesMapper;
import fa.training.repository.CurrenciesRepository;
import fa.training.service.CurrenciesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CurrenciesServiceImpl implements CurrenciesService {
     
    @Autowired
    CurrenciesRepository repository;
    
    @Autowired
    CurrenciesMapper mapper;

    @Override
    public List<CurrenciesDTO> findAll() {
        List<Currencies> currencies = repository.findAll();
        return currencies == null || currencies.size() == 0 ? new ArrayList<>()
                : currencies.stream().map(item -> mapper.convertEntityToDTO(item))
                .collect(Collectors.toList());
    }

    @Override
    public CurrenciesDTO findById(Long id) {
        Optional<Currencies> currencies = repository.findById(id);
        return currencies != null && currencies.isPresent() ? mapper.convertEntityToDTO(currencies.get())
                : new CurrenciesDTO();
    }

    @Override
    public CurrenciesDTO save(CurrenciesDTO currenciesDTO) {
        if (currenciesDTO == null) return new CurrenciesDTO();
        Currencies currencies = repository.save(mapper.convertDTOToEntity(currenciesDTO));
        return currencies == null ? new CurrenciesDTO() : mapper.convertEntityToDTO(currencies);
    }

    @Override
    public int update(CurrenciesDTO currenciesDTO) {
        if (currenciesDTO == null || currenciesDTO.getCurrenciesId() == null) return -1;
        Optional<Currencies> currencies = repository.findById(currenciesDTO.getCurrenciesId());
        if (currencies != null && currencies.isPresent()) {
            Currencies currenciesUpdate =  repository.save(mapper.convertDTOToEntity(currenciesDTO));
            return currenciesUpdate == null ? 0 : 1;
        }
        return -1;
    }

    @Override
    public boolean delete(CurrenciesDTO currenciesDTO) {
        try {
            if (currenciesDTO == null || currenciesDTO.getCurrenciesId() == null) return false;
            Optional<Currencies> currencies = repository.findById((currenciesDTO.getCurrenciesId()));
            if (currencies != null && currencies.isPresent()) {
                repository.delete(currencies.get());
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
