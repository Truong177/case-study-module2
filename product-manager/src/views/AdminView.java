package views;

import models.electronic.Electronic;
import models.electronic.Laptop;
import models.electronic.Tivi;

import java.sql.SQLOutput;
import java.util.List;
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
        System.out.println("7: Check inventory");
        System.out.println("0: Exit");
        System.out.print("Input your choice: ");
        Scanner scanner = new Scanner(System.in);
        int choice;
        while (true) {
            try {
                choice = Integer.parseInt(scanner.nextLine());
                if (choice >= 0 && choice <= 7) {
                    break;
                } else {
                    System.out.print("Invalid choice. Please enter a number between 0 and 7: ");
                }
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Please enter a valid number: ");
            }
        }
        return choice;
    }

    public Electronic viewAdd() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input product type (1: Laptop, 2: TV): ");
        int type = Integer.parseInt(scanner.nextLine());
        System.out.println("Input your code ");
        int code = Integer.parseInt(scanner.nextLine());
        System.out.println("Input your name ");
        String name = scanner.nextLine();
        System.out.println("Input your price");
        double price = Double.parseDouble(scanner.nextLine());
        System.out.println("Input your manufacturer");
        String manufacturer = scanner.nextLine();
        System.out.println("Input your quantity");
        int quantity = Integer.parseInt(scanner.nextLine());
        if (type == 1) {
            System.out.println("Input your ram ");
            int ram = Integer.parseInt(scanner.nextLine());
            return new Laptop(code, name, price, manufacturer, quantity, ram);
        } else if (type == 2) {
            System.out.println("Input your size");
            int size = Integer.parseInt(scanner.nextLine());
            return new Tivi(code, name, price, manufacturer, quantity, size);
        } else {
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
        System.out.println("Input code ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public boolean confirmDelete(Electronic electronic) {
        System.out.print("Are you sure you want to delete product? (yes/no): ");
        Scanner scanner = new Scanner(System.in);
        String isConfirm = scanner.nextLine();
        if (isConfirm.equals("yes")) {
            return true;
        } else {
            return false;
        }
    }

    public int selectProductTypeToDisplay() {
        System.out.println("Select product type to display:");
        System.out.println("1: Display all products");
        System.out.println("2: Display laptops");
        System.out.println("3: Display TVs");
        System.out.print("Input your choice: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }


    public void display(List<Electronic> electronics, int displayChoice) {
        for (Electronic electronic : electronics) {
            if (displayChoice == 1 ||
                    (displayChoice == 2 && electronic instanceof Laptop) ||
                    (displayChoice == 3 && electronic instanceof Tivi)) {
                if (electronic instanceof Laptop) {
                    Laptop laptop = (Laptop) electronic;
                    System.out.println("Code: " + laptop.getCode() + ", Name: " + laptop.getName() + ", Price: " + laptop.getPrice() + ", Ram: " + laptop.getRam() + "GB" +", Quantity: " +laptop.getQuantity());
                } else if (electronic instanceof Tivi) {
                    Tivi tivi = (Tivi) electronic;
                    System.out.println("Code: " + tivi.getCode() + ", Name: " + tivi.getName() + ", Price: " + tivi.getPrice() + ", Size: " + tivi.getSize() + " inches" + ", Quantity: " +tivi.getQuantity());
                } else {
                    System.out.println("Code: " + electronic.getCode() + ", Name: " + electronic.getName() + ", Price: " + electronic.getPrice());
                }
            }
        }
    }

    public int selectProductType() {
        System.out.println("Select product type :");
        System.out.println("1: Laptop");
        System.out.println("2: TV");
        System.out.print("Input your choice: ");

        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public Laptop viewEditLaptop(Laptop laptop) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Updating product " +laptop.getName());
        System.out.println("Input your code ");
        int code = Integer.parseInt(scanner.nextLine());
        System.out.println("Input your name ");
        String name = scanner.nextLine();
        System.out.println("Input your price");
        double price = Double.parseDouble(scanner.nextLine());
        System.out.println("Input your manufacturer");
        String manufacturer = scanner.nextLine();
        System.out.println("Input your quantity");
        int quantity = Integer.parseInt(scanner.nextLine());
        System.out.println("Input your ram ");
        int ram = Integer.parseInt(scanner.nextLine());
        laptop.setCode(code);
        laptop.setName(name);
        laptop.setPrice(price);
        laptop.setManufacturer(manufacturer);
        laptop.setQuantity(quantity);
        laptop.setRam(ram);
        return laptop;
    }

    public Tivi viewEditTivi(Tivi tivi) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Updating product " +tivi.getName());
        System.out.println("Input your code ");
        int code = Integer.parseInt(scanner.nextLine());
        System.out.println("Input your name ");
        String name = scanner.nextLine();
        System.out.println("Input your price");
        double price = Double.parseDouble(scanner.nextLine());
        System.out.println("Input your manufacturer");
        String manufacturer = scanner.nextLine();
        System.out.println("Input your quantity");
        int quantity = Integer.parseInt(scanner.nextLine());
        System.out.println("Input your ram ");
        int size = Integer.parseInt(scanner.nextLine());
        tivi.setCode(code);
        tivi.setName(name);
        tivi.setPrice(price);
        tivi.setManufacturer(manufacturer);
        tivi.setQuantity(quantity);
        tivi.setSize(size);
        return tivi;
    }
}
