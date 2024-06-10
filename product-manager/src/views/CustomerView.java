package views;

import models.electronic.Electronic;
import models.user.User;
import services.IAdminService;

import java.util.*;

public class CustomerView {
    private Map<Integer, User> users;
    private IAdminService adminService;

    public CustomerView(IAdminService adminService) {
        this.adminService = adminService;
        this.users = new HashMap<>();
    }

    public int displayMenuCustomer() {
        System.out.println("--------Customer Menu--------");
        System.out.println("1: Search product");
        System.out.println("2: Add product to cart");
        System.out.println("3: View cart");
        System.out.println("4: View purchase history");
        System.out.println("5: List product");
        System.out.println("6: Checkout");
        System.out.println("0: Exit");
        System.out.print("Input your choice: ");

        Scanner scanner = new Scanner(System.in);
        int choice;
        while (true) {
            try {
                choice = Integer.parseInt(scanner.nextLine());
                if (choice >= 0 && choice <= 6) {
                    break;
                } else {
                    System.out.print("Invalid choice. Please enter a number between 0 and 6: ");
                }
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Please enter a valid number: ");
            }
        }
        return choice;
    }

    public User viewAddCustomer() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter user ID: ");
        int userId = Integer.parseInt(scanner.nextLine());

        User user = users.get(userId);
        if (user == null) {
            System.out.println("Enter user name: ");
            String name = scanner.nextLine();

            System.out.println("Enter phone number: ");
            long phone = Long.parseLong(scanner.nextLine());

            user = new User(userId, name, phone);
            users.put(userId, user);
        }
        return user;
    }

    public Electronic viewAddItem() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter product code: ");
        int code = Integer.parseInt(scanner.nextLine());

        Electronic electronic = adminService.findByCode(code);
        if (electronic != null) {
            System.out.println("Enter quantity: ");
            int quantity = Integer.parseInt(scanner.nextLine());

            electronic.setQuantity(quantity); // Store quantity in electronic object for return
            return electronic;
        } else {
            System.out.println("Product not found.");
            return null;
        }
    }

    public void viewCart(User user) {
        System.out.println("--------Your Cart--------");
        Map<Electronic, Integer> items = user.getCart().getItems();
        if (items.isEmpty()) {
            System.out.println("Your cart is empty.");
        } else {
            for (Map.Entry<Electronic, Integer> entry : items.entrySet()) {
                Electronic electronic = entry.getKey();
                int quantity = entry.getValue();
                System.out.println("Product: " + electronic.getName() + ", Code: " + electronic.getCode() +
                        ", Quantity: " + quantity + ", Price: " + electronic.getPrice());
            }
        }
    }

    public void disPlayProduct(Electronic electronic) {
        if (electronic != null) {
            System.out.println("Code: " + electronic.getCode());
            System.out.println("Name: " + electronic.getName());
            System.out.println("Price: " + electronic.getPrice());
        } else {
            System.out.println("No product found.");

        }
    }

    public void checkout(User user) {
        Map<Electronic, Integer> items = user.getCart().getItems();
        if (items.isEmpty()) {
            System.out.println("Your cart is empty. Nothing to checkout.");
        } else {
            List<Electronic> itemsToRemove = new ArrayList<>();
            for (Electronic electronic : items.keySet()) {
                int quantity = items.get(electronic);
                for (int i = 0; i < quantity; i++) {
                    user.addPurchase(new Electronic(electronic));
                }
                itemsToRemove.add(electronic);
            }
            for (Electronic electronic : itemsToRemove) {
                items.remove(electronic);
            }
            System.out.println("Checkout successful. Your cart is now empty.");
        }
    }

    public void viewPurchaseHistory(User user) {
        System.out.println("--------Purchase History--------");
        List<Electronic> purchaseHistory = user.getPurchaseHistory();
        if (purchaseHistory.isEmpty()){
            System.out.println("No purchase history.");
        }
        else {
            for (Electronic electronic : purchaseHistory){
                System.out.println("Product: " + electronic.getName() + ", Code: " + electronic.getCode() +
                        ", Quantity: " + electronic.getQuantity() + ", Price: " + electronic.getPrice());
            }
        }
    }

    public boolean confirmCheckout() {
        System.out.print("Are you sure you want to checkout? (yes/no): ");
        Scanner scanner = new Scanner(System.in);
        String isConfirm = scanner.nextLine();
        if (isConfirm.equals("yes")){
            return true;
        }else {
            return false;
        }
    }
}
