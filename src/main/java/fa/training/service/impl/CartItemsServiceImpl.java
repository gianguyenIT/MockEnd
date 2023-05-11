package fa.training.service.impl;

import fa.training.dto.CartItemsDTO;
import fa.training.entity.CartItems;
import fa.training.mapper.CartItemsMapper;
import fa.training.repository.CartItemsRepository;
import fa.training.service.CartItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CartItemsServiceImpl implements CartItemsService {
    
    @Autowired
    CartItemsRepository repository;
    
    @Autowired
    CartItemsMapper mapper;

    @Override
    public List<CartItemsDTO> findAll() {
        List<CartItems> cartItems = repository.findAll();
        return cartItems == null || cartItems.size() == 0 ? new ArrayList<>()
                : cartItems.stream().map(item -> mapper.convertEntityToDTO(item))
                .collect(Collectors.toList());
    }

    @Override
    public CartItemsDTO findById(Long id) {
        Optional<CartItems> cartItems = repository.findById(id);
        return cartItems != null && cartItems.isPresent() ? mapper.convertEntityToDTO(cartItems.get())
                : new CartItemsDTO();
    }

    @Override
    public CartItemsDTO save(CartItemsDTO cartItemsDTO) {
        if (cartItemsDTO == null) return new CartItemsDTO();
        CartItems cartItems = repository.save(mapper.convertDTOToEntity(cartItemsDTO));
        return cartItems == null ? new CartItemsDTO() : mapper.convertEntityToDTO(cartItems);
    }

    @Override
    public int update(CartItemsDTO cartItemsDTO) {
        if (cartItemsDTO == null || cartItemsDTO.getId() == null) return -1;
        Optional<CartItems> cartItems = repository.findById(cartItemsDTO.getId());
        if (cartItems != null && cartItems.isPresent()) {
            CartItems cartItemsUpdate =  repository.save(mapper.convertDTOToEntity(cartItemsDTO));
            return cartItemsUpdate == null ? 0 : 1;
        }
        return -1;
    }

    @Override
    public boolean delete(CartItemsDTO cartItemsDTO) {
        try {
            if (cartItemsDTO == null || cartItemsDTO.getId() == null) return false;
            Optional<CartItems> cartItems = repository.findById((cartItemsDTO.getId()));
            if (cartItems != null && cartItems.isPresent()) {
                repository.delete(cartItems.get());
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
