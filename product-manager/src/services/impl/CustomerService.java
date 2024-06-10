package services.impl;

import models.electronic.Electronic;
import models.user.User;
import services.ICustomerService;

public class CustomerService implements ICustomerService {
    @Override
    public void addItemToCart(User user, Electronic electronic, int quantity) {
        user.getCart().getItems().put(electronic, quantity);
    }
}
