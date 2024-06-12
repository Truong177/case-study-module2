package views;

import models.electronic.Electronic;
import models.electronic.Laptop;
import models.electronic.Tivi;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class AdminView {

    public int displayMenuAdmin() {
        System.out.println("--------Admin Menu--------");
        System.out.println("1: Add product");
        System.out.println("2: Edit product");
        System.out.println("3: Delete product");
        System.out.println("4: Display products");
        System.out.println("5: Search product");
        System.out.println("6: Sort products");
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

    public Electronic viewAddLaptop() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Input your code: ");
            int code = Integer.parseInt(scanner.nextLine());
            System.out.println("Input your name: ");
            String name = "Laptop " + scanner.nextLine();
            System.out.println("Input your price: ");
            double price = Double.parseDouble(scanner.nextLine());
            System.out.println("Input your manufacturer: ");
            String manufacturer = scanner.nextLine();
            System.out.println("Input your quantity: ");
            int quantity = Integer.parseInt(scanner.nextLine());
            System.out.println("Input your ram: ");
            int ram = Integer.parseInt(scanner.nextLine());
            return new Laptop(code, name, price, manufacturer, quantity, ram);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please try again.");
            return null;
        }
    }

    public void viewMessage(boolean result) {
        if (result) {
            System.out.println("Operation successful");
        } else {
            System.out.println("Operation failed");
        }
    }

    public int inputCode() {
        System.out.println("Input code: ");
        Scanner scanner = new Scanner(System.in);
        int code = -1;
        try {
            code = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a valid number.");
        }
        return code;
    }

    public boolean confirmDelete(Electronic electronic) {
        System.out.print("Are you sure you want to delete product? (yes/no): ");
        Scanner scanner = new Scanner(System.in);
        String isConfirm = scanner.nextLine();
        return isConfirm.equalsIgnoreCase("yes");
    }

    public int selectProductTypeToDisplay() {
        System.out.println("Select product type to display:");
        System.out.println("1: Display all products");
        System.out.println("2: Display laptops");
        System.out.println("3: Display TVs");
        System.out.print("Input your choice: ");
        Scanner scanner = new Scanner(System.in);
        int choice = -1;
        try {
            choice = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a valid number.");
        }
        return choice;
    }

    public void display(List<Electronic> electronics, int displayChoice) {
        for (Electronic electronic : electronics) {
            if (displayChoice == 1 ||
                    (displayChoice == 2 && electronic instanceof Laptop) ||
                    (displayChoice == 3 && electronic instanceof Tivi)) {
                if (electronic instanceof Laptop) {
                    Laptop laptop = (Laptop) electronic;
                    System.out.println("Code: " + laptop.getCode() +
                            ", Name: " + laptop.getName() +
                            ", Price: " + laptop.getPrice() +
                            ", Ram: " + laptop.getRam() + "GB" +
                            ", Quantity: " + laptop.getQuantity());
                } else if (electronic instanceof Tivi) {
                    Tivi tivi = (Tivi) electronic;
                    System.out.println("Code: " + tivi.getCode() +
                            ", Name: " + tivi.getName() +
                            ", Price: " + tivi.getPrice() +
                            ", Size: " + tivi.getSize() + " inches" +
                            ", Quantity: " + tivi.getQuantity());
                } else {
                    System.out.println("Code: " + electronic.getCode() +
                            ", Name: " + electronic.getName() +
                            ", Price: " + electronic.getPrice() +
                            ", Quantity: " + electronic.getQuantity());
                }
            }
        }
    }

    public int selectProductType() {
        System.out.println("Select product type:");
        System.out.println("1: Laptop");
        System.out.println("2: TV");
        System.out.print("Input your choice: ");
        Scanner scanner = new Scanner(System.in);
        int choice = -1;
        try {
            choice = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a valid number.");
        }
        return choice;
    }

    public Laptop viewEditLaptop(Laptop laptop) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Updating product " + laptop.getName());
            System.out.println("Input your code: ");
            int code = Integer.parseInt(scanner.nextLine());
            System.out.println("Input your name: ");
            String name = scanner.nextLine();
            System.out.println("Input your price: ");
            double price = Double.parseDouble(scanner.nextLine());
            System.out.println("Input your manufacturer: ");
            String manufacturer = scanner.nextLine();
            System.out.println("Input your quantity: ");
            int quantity = Integer.parseInt(scanner.nextLine());
            System.out.println("Input your ram: ");
            int ram = Integer.parseInt(scanner.nextLine());
            laptop.setCode(code);
            laptop.setName(name);
            laptop.setPrice(price);
            laptop.setManufacturer(manufacturer);
            laptop.setQuantity(quantity);
            laptop.setRam(ram);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please try again.");
        }
        return laptop;
    }

    public Tivi viewEditTivi(Tivi tivi) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Updating product " + tivi.getName());
            System.out.println("Input your code: ");
            int code = Integer.parseInt(scanner.nextLine());
            System.out.println("Input your name: ");
            String name = scanner.nextLine();
            System.out.println("Input your price: ");
            double price = Double.parseDouble(scanner.nextLine());
            System.out.println("Input your manufacturer: ");
            String manufacturer = scanner.nextLine();
            System.out.println("Input your quantity: ");
            int quantity = Integer.parseInt(scanner.nextLine());
            System.out.println("Input your size: ");
            int size = Integer.parseInt(scanner.nextLine());
            tivi.setCode(code);
            tivi.setName(name);
            tivi.setPrice(price);
            tivi.setManufacturer(manufacturer);
            tivi.setQuantity(quantity);
            tivi.setSize(size);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please try again.");
        }
        return tivi;
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

    public void sortProductView(Map<Electronic, Integer> sortedProducts) {
        System.out.println("Sorted Products:");
        for (Map.Entry<Electronic, Integer> entry : sortedProducts.entrySet()) {
            Electronic product = entry.getKey();
            int quantity = entry.getValue();
            System.out.println("Code: " + product.getCode() + ", Name: " + product.getName() + ", Price: " + product.getPrice() + ", Quantity: " + quantity);
        }
    }

    public Electronic viewAddTivi() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Input your code: ");
            int code = Integer.parseInt(scanner.nextLine());
            System.out.println("Input your name: ");
            String name = "Tivi " + scanner.nextLine();
            System.out.println("Input your price: ");
            double price = Double.parseDouble(scanner.nextLine());
            System.out.println("Input your manufacturer: ");
            String manufacturer = scanner.nextLine();
            System.out.println("Input your quantity: ");
            int quantity = Integer.parseInt(scanner.nextLine());
            System.out.println("Input your size: ");
            int size = Integer.parseInt(scanner.nextLine());
            return new Tivi(code, name, price, manufacturer, quantity, size);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please try again.");
            return null;
        }
    }
}
