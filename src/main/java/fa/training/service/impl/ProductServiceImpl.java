package fa.training.service.impl;

import fa.training.dto.ProductDTO;
import fa.training.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    RestTemplate restTemplate;


    @Override
    public List<ProductDTO> findAll() {
        return null;
    }

    @Override
    public ProductDTO findById(Long id) {
        return null;
    }

    @Override
    public ProductDTO save(ProductDTO productDTO) {
        return null;
    }

    @Override
    public int update(ProductDTO productDTO) {
        return 0;
    }

    @Override
    public boolean delete(ProductDTO productDTO) {
        return false;
    }

    @Override
    public List<ProductDTO> getProductByCategory(Long categoryId) {
        String url = "http://localhost:9090/api/v1/product/find-by-category/"+categoryId;
        ResponseEntity<List<ProductDTO>> productDto = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<ProductDTO>>(){});
        return productDto.getBody();
    }

    @Override
    public ProductDTO getProductById(Long id) {
        String url = "http://localhost:9090/api/v1/product/" + id;
        ResponseEntity<ProductDTO> productDto = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<ProductDTO>() {
                });
        return productDto.getBody();
    }
}
