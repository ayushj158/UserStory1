package com.equalexperts.cart.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.stream.Collectors;

import com.equalexperts.cart.domain.ItemVO;
import com.equalexperts.cart.domain.OrderVO;

public class OrderCalculateService implements OrderCalculate {

	public OrderVO calculateOrder(OrderVO order) {
		order.setTotalPrice(calculateOrderItems(order));
		return order;
	}

	private BigDecimal calculateOrderItems(OrderVO order) {
		final Double orderLinesTotal = order.getOrderItems().entrySet().stream().map(i -> i)
				.collect(Collectors.summingDouble(i -> calculateOrderItem(i.getValue())));
		return BigDecimal.valueOf(orderLinesTotal).setScale(2, RoundingMode.HALF_UP);
	}

	private Double calculateOrderItem(ItemVO orderLine) {
		return orderLine.getUnitPrice() * orderLine.getQuantity();
	}
}
