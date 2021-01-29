package com.priya.rightcare.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.priya.rightcare.DTO.CustomerOrderResponse;
import com.priya.rightcare.Entity.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer>{

	 
	Cart findByCartId(int cartId);
	//@Query("SELECT new com.priya.rightcare.DTO.CustomerOrderResponse (p.customerId,cart.CartId,p.productName,p.productPrice,p.quantity) From Cart cart JOIN cart.products p")
	//public List<CustomerOrderResponse> getOrderDetails1();
	

}
