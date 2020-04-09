package com.hsilva.ws.soap;

import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;

import com.hsilva.CustomerOrdersPortType;
import com.hsilva.GetOrdersRequest;
import com.hsilva.GetOrdersResponse;
import com.hsilva.Order;
import com.hsilva.Product;

import java.util.*;

public class CustomerOrderWsClient {

	public static void main(String[] args) throws MalformedURLException {

		CustomerOrdersWsImplService service = new CustomerOrdersWsImplService(
				new URL("http://localhost:8080/customerordersservice?wsdl"));
		CustomerOrdersPortType customerOrdersWsImplPort = service.getCustomerOrdersWsImplPort();
		
		GetOrdersRequest request = new GetOrdersRequest();
		request.setCustomerId(BigInteger.valueOf(1));
		GetOrdersResponse response = customerOrdersWsImplPort.getOrders(request);
		List<Order> orders = response.getOrder();
		
		for(Order order : orders) {
			List<Product> products = order.getProduct();
			for (Product product : products) {
				System.out.println("Product Description: "+product.getDescription());
				System.out.println("Product Quantity: "+ product.getQuantity());
			}
		}
		
		System.out.println("Number of orders for the customer are: "+ orders.size());
	}

}
