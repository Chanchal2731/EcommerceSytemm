/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ecommerceapp.ecommercesystemm;

/**
 *
 * @author Administrator
 */
public class Order {
    private final User user;
    private final Product product;
    private final int quantity;
    private final double totalAmount;

    public Order(User user, Product product, int quantity) {
        this.user = user;
        this.product = product;
        this.quantity = quantity;
        this.totalAmount = quantity * product.getPrice();
    }

    public User getUser() { return user; }
    public Product getProduct() { return product; }
    public int getQuantity() { return quantity; }
    public double getTotalAmount() { return totalAmount; }

    @Override
    public String toString() {
        return "Order: " + user.getUsername() + " bought " + quantity + "x " + product.getName() +
               " | Total: $" + totalAmount;
    }
}