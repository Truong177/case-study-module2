package repositories;

import models.electronic.Electronic;
import models.electronic.Laptop;
import models.electronic.Tivi;
import models.user.User;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CustomerRepository {
    public void addItemToCart(User user, Electronic electronic, int quantity) {
        user.getCart().getItems().put(electronic, quantity);
    }

}
