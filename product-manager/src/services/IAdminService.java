package services;

import models.electronic.Electronic;
import models.electronic.Laptop;
import models.electronic.Tivi;

import java.util.List;

public interface IAdminService {

    boolean add(Electronic electronic);

    List<Electronic> getAll();

    Electronic findByCode(int code);

    void remove(Electronic electronic);

    boolean updateLaptop(Laptop updateLaptop);

    boolean updateTivi(Tivi updateTivi);
}
