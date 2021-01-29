package com.priya.rightcare.DTO;

import com.priya.rightcare.Entity.Cart;
import com.priya.rightcare.Entity.Customer;
import com.priya.rightcare.Entity.PaymentInfo;

public class CustomerOrderRequest {
	
	//private Cart cart;
    private Customer customer;
    
	//public Cart getCart() {
		//return cart;
	//}

	//public void setCustomer(Cart cart) {
	//	this.cart = cart;
	//}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}


}
