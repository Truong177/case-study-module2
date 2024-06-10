package services;

import models.electronic.Electronic;

import java.util.List;

public interface IAdminService {

    boolean add(Electronic electronic);

    List<Electronic> getAll();

    Electronic findByCode(int code);

    void remove(Electronic electronic);
}
