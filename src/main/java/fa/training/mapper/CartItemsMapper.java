package fa.training.mapper;

import fa.training.dto.CartItemsDTO;
import fa.training.entity.CartItems;
import org.springframework.stereotype.Service;

@Service
public class CartItemsMapper extends AbstractMapper<CartItems, CartItemsDTO> {
    public CartItemsMapper() {
        super(CartItems.class, CartItemsDTO.class);
    }
}
