package com.priya.rightcare.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.priya.rightcare.Entity.Cart;

import com.priya.rightcare.Repository.CartRepository;

@Service
public class CartService {
	
@Autowired
	private CartRepository cartRepository;
	
	 public Cart saveOrUpdateACart(Cart cart) {
	        return cartRepository.save(cart);
	    }
	 public List<Cart> saveCarts(List<Cart> carts) {

		return cartRepository.saveAll(carts);
	}
	public List<Cart> getCarts() {

		return cartRepository.findAll();
			
	}
	public Cart getById(int cartId) {
		// TODO Auto-generated method stub
		return cartRepository.findByCartId(cartId);
	}
	public Cart saveCart(Cart cart) {
		// TODO Auto-generated method stub
		return cartRepository.save(cart);
	}
	
	
	
}
