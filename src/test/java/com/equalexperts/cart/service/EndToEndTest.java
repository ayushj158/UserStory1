package com.equalexperts.cart.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import com.equalexperts.cart.domain.OrderVO;

public class EndToEndTest {

	@Nested
	@DisplayName("Given An empty Shopping Cart And a product, Dove Soap with a unit price of 39.99")
	class AddItemTest {
		AddToCartService cart;

		@BeforeEach
		public void setup() {
			cart = new AddToCartService(1234);
		}

		@Test
		@DisplayName("When_user adds 5 Dove Soap to shopping cart "
				+ "_Then_Shopping cart should contain 5 Dove Soaps each with a unit price 39.99"
				+ " And the shopping cart’s total price should equal 199.95")
		public void test_addItem_verify_totalPrice() {
			final String productUPC = "Dove Soaps";
			final Double unitPrice = 39.99;
			final int  quantity= 5;
			cart.addItem(productUPC, unitPrice, quantity);
			OrderVO result = cart.calculateOrder(cart.getOrder());
			assertEquals(1, cart.getOrder().getOrderLines().size());
			assertEquals(quantity, cart.getOrder().getOrderLines().get(productUPC).getQuantity());
			assertEquals(unitPrice, cart.getOrder().getOrderLines().get(productUPC).getUnitPrice(),0.001);
			assertEquals(new BigDecimal(199.95).setScale(2, RoundingMode.HALF_DOWN),result.getTotalPrice());
		}
	}
}
