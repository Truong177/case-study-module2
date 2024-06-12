package services.impl;

import models.electronic.Electronic;
import models.user.User;
import repositories.CustomerRepository;
import services.ICustomerService;

public class CustomerService implements ICustomerService {
    private CustomerRepository customerRepository = new CustomerRepository();
    @Override
    public void addItemToCart(User user, Electronic electronic, int quantity) {
        customerRepository.addItemToCart(user, electronic, quantity);
    }
}
