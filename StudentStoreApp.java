import java.util.*;

class Product {
    private String name;
    private double costPrice;
    private double sellingPrice;
    private int stock;

    public Product(String name, double costPrice, double sellingPrice, int stock) {
        this.name = name;
        this.costPrice = costPrice;
        this.sellingPrice = sellingPrice;
        this.stock = stock;
    }

    public String getName() {
        return name;
    }

    public double getCostPrice() {
        return costPrice;
    }

    public double getSellingPrice() {
        return sellingPrice;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getProfitMargin() {
        return sellingPrice - costPrice;
    }

    public void sellProduct(int quantity) {
        if (quantity <= stock) {
            stock -= quantity;
        } else {
            System.out.println("❌ Not enough stock for " + name);
        }
    } 

    @Override
    public String toString() {
        return name + " | Price: $" + sellingPrice + " | Stock: " + stock;
    }
}

class StudentStore {
    private List<Product> inventory = new ArrayList<>();
    private Map<String, Integer> salesData = new HashMap<>();
    private Map<String, Double> profitData = new HashMap<>();
    private double totalRevenue = 0;
    private double totalProfit = 0;
    private Scanner scanner = new Scanner(System.in);

    public void addProduct(Product product) {
        inventory.add(product);
    }

    public void displayProducts() {
        System.out.println("\n===== Available Products =====");
        if (inventory.isEmpty()) {
            System.out.println("No products available.");
            return;
        }
        for (Product product : inventory) {
            System.out.println(product);
        }
    }

    public void sellProduct(String productName, int quantity) {
        for (Product product : inventory) {
            if (product.getName().equalsIgnoreCase(productName)) {
                if (quantity > 0 && quantity <= product.getStock()) {
                    product.sellProduct(quantity);//method of product class to reduce product stock
                    totalRevenue += product.getSellingPrice() * quantity;
                    totalProfit += product.getProfitMargin() * quantity;

                    salesData.put(productName, salesData.getOrDefault(productName, 0) + quantity);
                    profitData.put(productName, profitData.getOrDefault(productName, 0.0) + (product.getProfitMargin() * quantity));

                    System.out.println("\n✅ Sold " + quantity + "x " + productName + " successfully!");
                } else {
                    System.out.println("\n❌ Not enough stock or invalid quantity.");
                }
                return;
            }
        }
        System.out.println("\n❌ Product not found.");
    }

    public void showSalesReport() {
        System.out.println("\n===== Sales Report =====");
        if (salesData.isEmpty()) {
            System.out.println("No sales have been made yet.");
        } else {
            for (Map.Entry<String, Integer> entry : salesData.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue() + " units sold");
            }
            System.out.printf("Total Revenue: $%.2f%n", totalRevenue);
            System.out.printf("Total Profit: $%.2f%n", totalProfit);
        }
    }

    public void showPopularAndProfitableProducts() {
        if (inventory.isEmpty()) {
            System.out.println("\nNo products in inventory.");
            return;
        }
    
        if (salesData.isEmpty()) {
            System.out.println("\nNo sales data available yet.");
            return;
        }
    
        String mostPopular = null, leastPopular = null, mostProfitable = null;
        int maxSales = 0;
        double maxProfit = 0.0;
        int minSales = Integer.MAX_VALUE;
    
        // Check all products in inventory
        for (Product product : inventory) {
            String productName = product.getName();
            int salesCount = salesData.getOrDefault(productName, 0);
            double productProfit = profitData.getOrDefault(productName, 0.0);
    
            // Most Popular Product
            if (salesCount > maxSales) {
                maxSales = salesCount;
                mostPopular = productName;
            }
    
            // Least Popular Product (now includes products with 0 sales)
            if (salesCount < minSales) {
                minSales = salesCount;
                leastPopular = productName;
            }
    
            // Most Profitable Product
            if (productProfit > maxProfit) {
                maxProfit = productProfit;
                mostProfitable = productName;
            }
        }
    
        System.out.println("\n===== Product Insights =====");
        System.out.println("🔥 Most Popular Product: " + mostPopular + " (" + maxSales + " units sold)");
        System.out.println("🧊 Least Popular Product: " + leastPopular + " (" + minSales + " units sold)");
        System.out.printf("💰 Most Profitable Product: %s ($%.2f profit)%n", mostProfitable, maxProfit);
    }

    public void addNewProduct() {
        System.out.println("\n===== Add New Product =====");

        System.out.print("Enter product name: ");
        String name = scanner.nextLine();

        double costPrice = getValidDoubleInput("Enter cost price: ");
        double sellingPrice = getValidDoubleInput("Enter selling price: ");
        int stock = getValidIntInput("Enter stock quantity: ");

        Product newProduct = new Product(name, costPrice, sellingPrice, stock);
        inventory.add(newProduct);
        System.out.println("\n✅ Product '" + name + "' added successfully!");
    }

    public void restock(String productName, int quantity) {
        if (quantity <= 0) {
            System.out.println("\n❌ Invalid quantity. Please enter a positive number.");
            return;
        }
    
        for (Product product : inventory) {
            if (product.getName().equalsIgnoreCase(productName)) {
                product.setStock(product.getStock() + quantity);
                System.out.println("\n✅ " + quantity + " units added to " + productName + ". New stock: " + product.getStock());
                return;
            }
        }
        System.out.println("\n❌ Product not found.");
    }
    

    private double getValidDoubleInput(String message) {
        double value;
        while (true) {
            System.out.print(message);
            if (scanner.hasNextDouble()) {
                value = scanner.nextDouble();
                if (value >= 0) {
                    scanner.nextLine(); // Consume newline
                    return value;
                }
            } else {
                scanner.next(); // Discard invalid input
            }
            System.out.println("\n❌ Invalid input. Please enter a valid non-negative number.");
        }
    }

    private int getValidIntInput(String message) {
        int value;
        while (true) {
            System.out.print(message);
            if (scanner.hasNextInt()) {
                value = scanner.nextInt();
                if (value >= 0) {
                    scanner.nextLine(); // Consume newline
                    return value;
                }
            } else {
                scanner.next(); // Discard invalid input
            }
            System.out.println("\n❌ Invalid input. Please enter a valid non-negative integer.");
        }
    }
}

public class StudentStoreApp {
    public static void main(String[] args) {
        StudentStore store = new StudentStore();
        Scanner scanner = new Scanner(System.in);

        store.addProduct(new Product("Sprite", 5, 25, 100));
        store.addProduct(new Product("Coke", 5, 25, 100));
        store.addProduct(new Product("Milk tea", 5, 25, 100));
        store.addProduct(new Product("Red tea", 5, 30, 100));
        store.addProduct(new Product("Chocolate milk", 5, 15, 100));

        while (true) {
            System.out.println("\n===== Student Store Menu =====");
            System.out.println("1. Show Products");
            System.out.println("2. Buy Product");
            System.out.println("3. Show Sales Report");
            System.out.println("4. Show Most & Least Popular Products");
            System.out.println("5. Add New Product");
            System.out.println("6. Restock product");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");

            if (!scanner.hasNextInt()) {
                System.out.println("\n❌ Invalid input. Please enter a number.");
                scanner.next();
                continue;
            }

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1: store.displayProducts(); break;
                case 2:
                    System.out.print("\nEnter product name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter quantity: ");
                    int quantity = scanner.nextInt();
                    store.sellProduct(name, quantity);
                    break;
                case 3: store.showSalesReport(); break;
                case 4: store.showPopularAndProfitableProducts(); break;
                case 5: store.addNewProduct(); break;
                case 6: 
                    System.out.print("\nEnter product name: ");
                    String name1 = scanner.nextLine();
                    System.out.print("Enter quantity: ");
                    int quantity1 = scanner.nextInt();
                    store.restock(name1, quantity1);
                    break;
                case 7:
                    System.out.println("\nExiting... Thank you! 🛒");
                    scanner.close();
                    return;
                default: System.out.println("\n❌ Invalid choice. Try again.");
            }
        }
    }
} 