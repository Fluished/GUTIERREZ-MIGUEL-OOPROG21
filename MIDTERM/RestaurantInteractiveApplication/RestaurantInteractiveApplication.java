import java.util.*;
import java.time.*;

class Common {
    void showMenu() {
        System.out.println("\n[ ===== MENU ====== ]");
        System.out.println("[ 1. C1 - Php 100.00 ]");
        System.out.println("[ 2. C2 - Php 150.00 ]");
        System.out.println("[ 3. C3 - Php 200.00 ]");
        System.out.println("\n[ ===== ADD ONS ====== ]");
        System.out.println("[ 4. R1 - Php 35.00 ]");
        System.out.println("[ 5. R2 - Php 50.00 ]");
    }
}

class Product {
    double productPrice;
    int stockQuantity, productId;
    String productName;

    Product(int productId, String productName, double productPrice, int stockQuantity) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.stockQuantity = stockQuantity;
    }
}

class Order {
    Order(ArrayList<Product> customerCart) {
        this.customerCart = customerCart;
    }

    ArrayList<Product> customerCart;
    double totalAmount = 0;

    ArrayList<Product> addItemToOrder(byte orderOption, int quantity, ArrayList<Product> customerCart,
            ArrayList<Product> productMasterList) {

        Iterator<Product> itr = productMasterList.iterator();

        while (itr.hasNext()) {
            Product product = itr.next();
            if (orderOption == product.productId) {
                customerCart.add(product);
                product.stockQuantity -= quantity;

                // if (product.stockQuantity == 0) {
                // itr.remove();
                // }
            }
        }

        return customerCart;
    }

    double calculateTotalAmount(int quantity, ArrayList<Integer> quantityList) {
        double orderAmount = 0;
        totalAmount = 0;
        int i = 0;

        for (Product product : customerCart) {
            orderAmount = product.productPrice * quantityList.get(i);
            totalAmount = totalAmount + orderAmount;
            i++;
        }

        return totalAmount;
    }

    void viewOrder(byte orderOption, int quantity, ArrayList<Product> customerCart,
            ArrayList<Integer> quantityList) {
        System.out.println("\n[ ===== CART ===== ]");

        int i = 0;
        for (Product product : customerCart) {
            System.out.println("[ Order: " + product.productName + " | Php " + product.productPrice
                    + " | Quantity: " + quantityList.get(i) + " ]");
            i++;
        }

        System.out.printf("[ Total amount: Php %.2f | $ %.2f ]",
                calculateTotalAmount(quantity, quantityList), (calculateTotalAmount(quantity, quantityList) / 56));

        System.out.println("\n[ ==================== ]");
    }

    void confirmOrder(byte orderOption, int quantity, int orderId, ArrayList<Product> customerCart,
            ArrayList<Integer> quantityList) {

        LocalDate localDate = LocalDate.now();
        System.out.println("\n[ =============== CART =============== ]");

        int i = 0;
        for (Product product : customerCart) {
            System.out.println("[ Order: " + product.productName + " | Php " + product.productPrice
                    + " | Quantity: " + quantityList.get(i) + " ]");
            i++;
        }

        System.out.printf("\n[ Total amount to be paid: Php %.2f | $ %.2f ]",
                calculateTotalAmount(quantity, quantityList), (calculateTotalAmount(quantity, quantityList) / 56));

        System.out.printf("\n[ ===== ORDER ID %d | Date: %s ===== ]\n", orderId, localDate);
    }
}

public class RestaurantInteractiveApplication {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int quantity = 0, orderId = 1;
        byte menuOption, orderOption, addOrderOption, confirmOption;

        // Products
        // =====================================
        Product product1 = new Product(1, "C1", 100, 100);
        Product product2 = new Product(2, "C2", 150, 100);
        Product product3 = new Product(3, "C3", 200, 100);
        Product addon1 = new Product(4, "R1", 35, 100);
        Product addon2 = new Product(5, "R2", 50, 100);

        // Resizable List
        // =====================================
        ArrayList<Product> productMasterList = new ArrayList<Product>();
        productMasterList.add(product1);
        productMasterList.add(product2);
        productMasterList.add(product3);
        productMasterList.add(addon1);
        productMasterList.add(addon2);

        // Customer
        // =====================================
        boolean isConfirmed = false;
        do {
            ArrayList<Product> customerCart = new ArrayList<Product>();
            ArrayList<Integer> quantityList = new ArrayList<Integer>();
            Order order = new Order(customerCart);
            boolean firstOrder = true;

            System.out.println("\n[ 1. Order ]");
            System.out.println("[ 2. Exit ]");
            System.out.print(" == ");
            menuOption = scan.nextByte();

            switch (menuOption) {
                case 1:
                    do {
                        Common commonUtility = new Common();
                        commonUtility.showMenu();

                        System.out.print("\n[ Select Order: ]");
                        System.out.print(" == ");
                        orderOption = scan.nextByte();

                        for (Product product : productMasterList) {
                            if (orderOption == product.productId && product.stockQuantity == 0) {
                                System.out.println("\n[ Order out of stock! ]");
                                orderOption = 6;
                            }
                        }

                        if (firstOrder == true && orderOption == 4 || orderOption == 5) {
                            System.out.println("\n[ Can't add Addons without having a main dish! ]");
                            orderOption = 6;
                        } else {
                            if (orderOption < 1 || orderOption > 5) {
                                System.out.println("[ Order not listed on menu! ]");
                            } else {
                                do {
                                    System.out.print("[ Enter quantity: ]");
                                    System.out.print(" == ");
                                    quantity = scan.nextInt();

                                    if (quantity < 0) {
                                        System.out.println("\n[ Quantity must be greater than 0! ]\n");
                                    }
                                    firstOrder = false;
                                } while (quantity < 0);

                                customerCart = order.addItemToOrder(orderOption, quantity, customerCart,
                                        productMasterList);
                                quantityList.add(quantity);
                                order.viewOrder(orderOption, quantity, customerCart, quantityList);

                                do {
                                    System.out.println("\n[ Add Another Order? ]");
                                    System.out.println("[ 1. Yes ]");
                                    System.out.println("[ 2. No ]");
                                    System.out.print(" == ");
                                    addOrderOption = scan.nextByte();

                                    switch (addOrderOption) {
                                        case 1:
                                            orderOption = 6;
                                            break;
                                        case 2:
                                            do {
                                                System.out.println("\n[ Confirm Order? ]");
                                                System.out.println("[ 1. Yes ]");
                                                System.out.println("[ 2. No ]");
                                                System.out.print(" == ");
                                                confirmOption = scan.nextByte();
                                                switch (confirmOption) {
                                                    case 1:
                                                        order.confirmOrder(orderOption, quantity, orderId, customerCart,
                                                                quantityList);
                                                        isConfirmed = true;
                                                        orderId++;
                                                        break;
                                                    case 2:
                                                        addOrderOption = 3;
                                                        break;
                                                    default:
                                                        System.out.println("\n[ Option not allowed! ]");
                                                        break;
                                                }
                                            } while (confirmOption < 1 || confirmOption > 2);
                                            break;
                                        default:
                                            System.out.println("\n[ Option not allowed! ]");
                                            break;
                                    }
                                } while (addOrderOption < 1 || addOrderOption > 2);

                            }
                        }
                    } while (orderOption < 1 || orderOption > 5);
                    break;
                case 2:
                    isConfirmed = false;
                    break;
                default:
                    System.out.println("\n[ Option not allowed! ]\n");
                    break;
            }
        } while (menuOption < 1 || menuOption > 2 || isConfirmed == true);

        scan.close();
    }
}
