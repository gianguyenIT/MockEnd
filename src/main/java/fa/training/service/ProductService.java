package fa.training.service;

import fa.training.dto.ProductDTO;

import java.util.List;

public interface ProductService extends BaseService<ProductDTO> {

    public List<ProductDTO> getProductByCategory(Long categoryId);

    ProductDTO getProductById(Long id);
}
