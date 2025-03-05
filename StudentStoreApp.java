import java.util.*;

class Product {
    private String name;
    private double costPrice;
    private double sellingPrice;
    private int stock;
    private int totalSold;
    private double totalProfit;

    public Product(String name, double costPrice, double sellingPrice, int stock) {
        this.name = name;
        this.costPrice = costPrice;
        this.sellingPrice = sellingPrice;
        this.stock = stock;
        this.totalSold = 0;
        this.totalProfit = 0.0;
    }

    public String getName() { return name; }
    public double getCostPrice() { return costPrice; }
    public double getSellingPrice() { return sellingPrice; }
    public int getStock() { return stock; }
    public int getTotalSold() { return totalSold; }
    public double getTotalProfit() { return totalProfit; }

    public void setStock(int stock) { this.stock = stock; }

    public double getProfitMargin() { return sellingPrice - costPrice; }

    public void sellProduct(int quantity) {
        if (quantity <= stock) {
            stock -= quantity;
            totalSold += quantity;
            totalProfit += getProfitMargin() * quantity;
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
                    product.sellProduct(quantity);
                    totalRevenue += product.getSellingPrice() * quantity;
                    totalProfit += product.getProfitMargin() * quantity;
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
        if (inventory.isEmpty()) {
            System.out.println("No sales have been made yet.");
            return;
        }
        for (Product product : inventory) {
            if (product.getTotalSold() > 0) {
                System.out.println(product.getName() + ": " + product.getTotalSold() + " units sold");
            }
        }
        System.out.printf("Total Revenue: $%.2f%n", totalRevenue);
        System.out.printf("Total Profit: $%.2f%n", totalProfit);
    }

    public void showPopularAndProfitableProducts() {
        if (inventory.isEmpty()) {
            System.out.println("\nNo products in inventory.");
            return;
        }

        Product mostPopular = null, leastPopular = null, mostProfitable = null;
        int maxSales = 0, minSales = Integer.MAX_VALUE;
        double maxProfit = 0.0;

        for (Product product : inventory) {
            int salesCount = product.getTotalSold();
            double productProfit = product.getTotalProfit();

            if (salesCount > maxSales) {
                maxSales = salesCount;
                mostPopular = product;
            }

            if (salesCount < minSales) {
                minSales = salesCount;
                leastPopular = product;
            }

            if (productProfit > maxProfit) {
                maxProfit = productProfit;
                mostProfitable = product;
            }
        }

        System.out.println("\n===== Product Insights =====");
        System.out.println("🔥 Most Popular Product: " + (mostPopular != null ? mostPopular.getName() + " (" + maxSales + " units sold)" : "N/A"));
        System.out.println("🧊 Least Popular Product: " + (leastPopular != null ? leastPopular.getName() + " (" + minSales + " units sold)" : "N/A"));
        System.out.printf("💰 Most Profitable Product: %s ($%.2f profit)%n", mostProfitable != null ? mostProfitable.getName() : "N/A", maxProfit);
    }
}

public class StudentStoreApp {
    public static void main(String[] args) {
        StudentStore store = new StudentStore();

        store.addProduct(new Product("Sprite", 5, 25, 100));
        store.addProduct(new Product("Coke", 5, 25, 100));
        store.addProduct(new Product("Milk tea", 5, 25, 100));
        store.addProduct(new Product("Red tea", 5, 30, 100));
        store.addProduct(new Product("Chocolate milk", 5, 15, 100));

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n===== Student Store Menu =====");
            System.out.println("1. Show Products");
            System.out.println("2. Buy Product");
            System.out.println("3. Show Sales Report");
            System.out.println("4. Show Most & Least Popular Products");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            if (!scanner.hasNextInt()) {
                System.out.println("\n❌ Invalid input. Please enter a number.");
                scanner.next();
                continue;
            }

            int choice = scanner.nextInt();
            scanner.nextLine();

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
                case 5:
                    System.out.println("\nExiting... Thank you! 🛒");
                    scanner.close();
                    return;
                default: System.out.println("\n❌ Invalid choice. Try again.");
            }
        }
    }
}
