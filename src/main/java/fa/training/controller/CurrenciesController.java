package fa.training.controller;

import fa.training.consts.ApiPath;
import fa.training.dto.CurrenciesDTO;
import fa.training.repository.CurrenciesRepository;
import fa.training.service.CurrenciesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CurrenciesController {

    @Autowired
    private CurrenciesRepository repository;

    @Autowired
    CurrenciesService service;

    @PostMapping(value = ApiPath.CURRENCIES_CREATE)
    public CurrenciesDTO createCurrencies(@RequestBody CurrenciesDTO newCurrencies) {
        return service.save(newCurrencies);
    }

    @GetMapping(value = ApiPath.CURRENCIES_GET_ALL)
    public List<CurrenciesDTO> getAllCurrencies() {
        return service.findAll();
    }

    @GetMapping(value = ApiPath.CURRENCIES_BY_ID)
    public CurrenciesDTO getCurrenciesById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PutMapping(value = ApiPath.CURRENCIES_UPDATE)
    public Integer updateCurrencies(@RequestBody CurrenciesDTO newCurrencies) {
        return service.update(newCurrencies);
    }

    @DeleteMapping(value = ApiPath.CURRENCIES_DELETE)
    public String deleteCurrencies(@RequestBody CurrenciesDTO currencies) {
        boolean isDelete = service.delete(currencies);
        return isDelete ? "Delete successful" : "Delete failed";
    }
}
