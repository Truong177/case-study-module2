package services;

import models.electronic.Electronic;
import models.user.User;

public interface ICustomerService {
    void addItemToCart(User user, Electronic electronic, int quantity);
}
