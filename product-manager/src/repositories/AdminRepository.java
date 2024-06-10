package repositories;

import models.electronic.Electronic;
import models.electronic.Laptop;
import models.electronic.Tivi;

import java.util.ArrayList;
import java.util.List;

public class AdminRepository {
    private static ArrayList<Electronic> electronics = new ArrayList<>();
    public boolean add(Electronic electronic) {
        return electronics.add(electronic);
    }

    public List<Electronic> getAll() {
        return new ArrayList<>(electronics);
    }

    public Electronic findByCode(int code) {
       for (Electronic electronic : electronics){
            if (electronic == null){
                return null;
            }
            if (electronic.getCode() == code){
                return electronic;
            }
       }
       return null;
    }

    public void remove(Electronic electronic) {
        electronics.remove(electronic);
    }


    public boolean updateLaptop(Laptop updateLaptop) {
        for (int i = 0; i < electronics.size(); i++) {
            Electronic electronic = electronics.get(i);
            if (electronic instanceof Laptop && electronic.getCode() == updateLaptop.getCode()) {
                electronics.set(i, updateLaptop);
                return true;
            }
        }
        return false;
    }

    public boolean updateTivi(Tivi updateTivi) {
        for (int i = 0; i < electronics.size(); i++) {
            Electronic electronic = electronics.get(i);
            if (electronic instanceof Laptop && electronic.getCode() == updateTivi.getCode()) {
                electronics.set(i, updateTivi);
                return true;
            }
        }
        return false;
    }
}
