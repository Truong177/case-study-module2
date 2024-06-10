package repositories;

import models.electronic.Electronic;

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


}
