package com.equalexperts.cart.domain;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Random;

public class OrderVO {
	private long orderId;
	private int userId;
	private BigDecimal totalPrice;
	private Map<String,ItemVO> orderItems;

	public OrderVO(int userId) {
		this.userId = userId;
		this.orderId = new Random().nextLong();
	}

	public long getOrderId() {
		return orderId;
	}
	
	public int getUserId() {
		return userId;
	}

	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Map<String, ItemVO> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(Map<String, ItemVO> orderItems) {
		this.orderItems = orderItems;
	}


}
