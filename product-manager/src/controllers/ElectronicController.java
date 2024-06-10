package controllers;

import models.electronic.Electronic;
import models.electronic.Laptop;
import models.electronic.Tivi;
import models.user.User;
import services.IAdminService;
import services.ICustomerService;
import services.impl.AdminService;
import services.impl.CustomerService;
import views.AdminView;
import views.CustomerView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ElectronicController {
    public static void main(String[] args) {
        AdminView adminView = new AdminView();
        IAdminService adminService = new AdminService();
        CustomerView customerView = new CustomerView(adminService);
        ICustomerService customerService = new CustomerService();
        Map<Electronic, Integer> items = new HashMap<>();
        Electronic electronic;
        User user;
        int choice;
        boolean result;
        int code;
        while (true) {
            System.out.println("Select user type:");
            System.out.println("1: Customer");
            System.out.println("2: Admin");
            System.out.print("Input your choice: ");
            choice = new Scanner(System.in).nextInt();
            if (choice == 1) {
                while (true) {
                    int customerChoice = customerView.displayMenuCustomer();
                    switch (customerChoice) {
                        case 1:
                            break;
                        case 2:
                            user = customerView.viewAddCustomer();
                            electronic = customerView.viewAddItem();
                            if (electronic != null) {
                                customerService.addItemToCart(user, electronic, electronic.getQuantity());
                                System.out.println("Product added to cart.");
                            }
                            break;
                        case 3:
                            user = customerView.viewAddCustomer();
                            customerView.viewCart(user);

                    }
                    if (customerChoice == 0) {
                        break;
                    }
                }
            }
            if (choice == 2) {
                while (true) {
                    int adminChoice = adminView.displayMenuAdmin();
                    switch (adminChoice) {
                        case 1:
                            electronic = adminView.viewAdd();
                            result = adminService.add(electronic);
                            adminView.viewMessage(result);
                            break;
                        case 2:
                            break;
                        case 3:
                            int deleteChoice = adminView.selectProductTypeToDelete();
                            code = adminView.inputCode();
                            electronic = adminService.findByCode(code);
                            if (electronic == null) {
                                adminView.viewMessage(false);
                            } else if ((deleteChoice == 1 && electronic instanceof Laptop) ||
                                    (deleteChoice == 2 && electronic instanceof Tivi)) {
                                boolean isConfirm = adminView.confirmDelete(electronic);
                                if (isConfirm) {
                                    adminService.remove(electronic);
                                    adminView.viewMessage(true);
                                }
                            } else {
                                adminView.viewMessage(false);
                            }
                            break;
                        case 4:
                            int displayChoice = adminView.selectProductTypeToDisplay();
                            List<Electronic> electronics = adminService.getAll();
                            adminView.display(electronics, displayChoice);
                            break;
                        case 0:
                            break;
                        default:
                            System.out.println("Invalid choice. Try again.");
                    }
                    if (adminChoice == 0) {
                        break;
                    }
                }
            }
        }
    }
}
