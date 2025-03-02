/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ecommerceapp.ecommercesystemm;

/**
 *
 * @author Administrator
 */



import java.util.ArrayList;
import java.util.List;

public class OrderService {
    private final List<Order> orders = new ArrayList<>();

    public void placeOrder(User user, Product product, int quantity) {
        if (product.getStock() >= quantity) {
            product.setStock(product.getStock() - quantity);
            Order order = new Order(user, product, quantity);
            orders.add(order);
            System.out.println("✅ Order placed successfully!");
        } else {
            System.out.println("❌ Insufficient stock!");
        }
    }

    public List<Order> getOrders() {
        return orders;
    }
}


