package fa.training.controller;

import fa.training.consts.ApiPath;
import fa.training.dto.CartItemsDTO;
import fa.training.repository.CartItemsRepository;
import fa.training.service.CartItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CartItemsController {

    @Autowired
    private CartItemsRepository repository;

    @Autowired
    CartItemsService service;

    @PostMapping(value = ApiPath.CARTITEMS_CREATE)
    public CartItemsDTO createCartItems(@RequestBody CartItemsDTO newCartItems) {
        return service.save(newCartItems);
    }

    @GetMapping(value = ApiPath.CARTITEMS_GET_ALL)
    public List<CartItemsDTO> getAllCartItems() {
        return service.findAll();
    }

    @GetMapping(value = ApiPath.CARTITEMS_BY_ID)
    public CartItemsDTO getCartItemsById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PutMapping(value = ApiPath.CARTITEMS_UPDATE)
    public Integer updateCartItems(@RequestBody CartItemsDTO newCartItems) {
        return service.update(newCartItems);
    }

    @DeleteMapping(value = ApiPath.CARTITEMS_DELETE)
    public String deleteCartItems(@RequestBody CartItemsDTO cartItems) {
        boolean isDelete = service.delete(cartItems);
        return isDelete ? "Delete successful" : "Delete failed";
    }
}
