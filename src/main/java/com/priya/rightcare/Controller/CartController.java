package com.priya.rightcare.Controller;

import java.util.List;
//import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.priya.rightcare.Entity.Cart;
//import com.priya.rightcare.Entity.Category;
import com.priya.rightcare.Repository.CartRepository;
import com.priya.rightcare.Service.CartService;
//import com.priya.rightcare.Service.ProductService;


@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class CartController {
   @Autowired
	private CartService cartService;
    @Autowired
    private CartRepository cartRepository;
    
   
    
    @PostMapping("/addcart")
	public Cart addCart(@RequestBody Cart cart) {

		return cartService.saveCart(cart);
	}
    
    @GetMapping("/Getcart/{CartId}")
	public Cart findByCartId(@PathVariable int CartId) {
		return cartService.getById(CartId);

	}
    @GetMapping("/Getallcarts")
    public List<Cart> findAllCarts(){
    	
    	return cartService.getCarts();
    }
  

  
}
