package fa.training.service.impl;

import fa.training.dto.CategoryDTO;
import fa.training.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    RestTemplate restTemplate;

    @Override
    public List<CategoryDTO> findAll() {
        String Url_AllCategory = "http://localhost:9090/api/v1/categories";
        ResponseEntity<List<CategoryDTO>> response = restTemplate.exchange(
                Url_AllCategory,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<CategoryDTO>>(){}
        );
        return response.getBody();
    }

    @Override
    public CategoryDTO findById(Long id) {
        return null;
    }

    @Override
    public CategoryDTO save(CategoryDTO categoryDTO) {
        return null;
    }

    @Override
    public int update(CategoryDTO categoryDTO) {
        return 0;
    }

    @Override
    public boolean delete(CategoryDTO categoryDTO) {
        return false;
    }
}
