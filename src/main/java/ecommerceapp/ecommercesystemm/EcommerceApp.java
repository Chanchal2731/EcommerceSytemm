/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package ecommerceapp.ecommercesystemm;

/**
 *
 * @author Administrator
 */

import java.util.Scanner;

public class EcommerceApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ProductService productService = new ProductService();
        OrderService orderService = new OrderService();

        // Adding sample products
        productService.addProduct(new Product(1, "Laptop", 999.99, 10));
        productService.addProduct(new Product(2, "Smartphone", 499.99, 20));
        productService.addProduct(new Product(3, "Headphones", 79.99, 50));

        System.out.println("🛒 Welcome to E-Commerce System!");
        System.out.print("Enter username: ");
        String username = scanner.next();
        System.out.print("Enter password: ");
        String password = scanner.next();
        
        User user = new User(username, password, false);

        while (true) {
            System.out.println("\n1. View Products");
            System.out.println("2. Place Order");
            System.out.println("3. View Orders");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            
            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.println("\n📦 Available Products:");
                    for (Product p : productService.getProducts()) {
                        System.out.println(p);
                    }
                }

                case 2 -> {
                    System.out.print("Enter Product ID to buy: ");
                    int productId = scanner.nextInt();
                    System.out.print("Enter quantity: ");
                    int quantity = scanner.nextInt();

                    Product selectedProduct = productService.getProductById(productId);
                    if (selectedProduct != null) {
                        orderService.placeOrder(user, selectedProduct, quantity);
                    } else {
                        System.out.println("❌ Product not found!");
                    }
                }

                case 3 -> {
                    System.out.println("\n📝 Your Orders:");
                    for (var order : orderService.getOrders()) {
                        System.out.println(order);
                    }
                }

                case 4 -> {
                    System.out.println("🚀 Exiting...");
                    scanner.close();
                    return;
                }

                default -> System.out.println("❌ Invalid option. Try again.");
            }
        }
    }
}
