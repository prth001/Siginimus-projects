//  Product Entity

public class Product {
    private int id;
    private String productName;
    private double price;

    // Constructor
    public Product(int id, String productName, double price) {
        this.id = id;
        this.productName = productName;
        this.price = price;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{id=" + id + ", productName='" + productName + "', price=" + price + '}';
    }
}
//2. Product Service

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductService {
    private List<Product> products;

    public ProductService() {
        this.products = new ArrayList<>();
     
        products.add(new Product(1, "Laptop", 4500));
        products.add(new Product(2, "Smartphone", 6000));
        products.add(new Product(3, "Tablet", 5500));
        products.add(new Product(4, "Headphones", 1200));
    }

  
    public Product findProductById(int id) throws ProductNotFoundException {
        Optional<Product> product = products.stream().filter(p -> p.getId() == id).findFirst();
        if (product.isPresent()) {
            return product.get();
        } else {
            throw new ProductNotFoundException("Product with ID " + id + " not found.");
        }
    }


    public List<Product> getProductsAbovePrice(double price) {
        List<Product> result = new ArrayList<>();
        for (Product product : products) {
            if (product.getPrice() > price) {
                result.add(product);
            }
        }
        return result;
    }
}
//3. Custom Exception (ProductNotFoundException)

public class ProductNotFoundException extends Exception {
    public ProductNotFoundException(String message) {
        super(message);
    }
}
//4. Main Application (Testing the Service)

public class Main {
    public static void main(String[] args) {
        ProductService productService = new ProductService();

        try {
            // Test: Find product by ID
            Product product = productService.findProductById(2); // Try changing the ID to test exception
            System.out.println("Product found: " + product);
            
            // Test: Get products with price > 5000
            List<Product> expensiveProducts = productService.getProductsAbovePrice(5000);
            System.out.println("\nProducts above price 5000:");
            for (Product p : expensiveProducts) {
                System.out.println(p);
            }

        } catch (ProductNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
