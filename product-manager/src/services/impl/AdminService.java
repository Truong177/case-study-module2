package services.impl;

import models.electronic.Electronic;
import repositories.AdminRepository;
import services.IAdminService;

import java.util.List;



public class AdminService implements IAdminService {
    private AdminRepository adminRepository = new AdminRepository();

    @Override
    public boolean add(Electronic electronic) {
        if (adminRepository.findByCode(electronic.getCode()) != null){
            return false;
        }
            return adminRepository.add(electronic);
    }

    @Override
    public List<Electronic> getAll() {
        return adminRepository.getAll();
    }

    @Override
    public Electronic findByCode(int code) {
        return adminRepository.findByCode(code);
    }

    @Override
    public void remove(Electronic electronic) {
        adminRepository.remove(electronic);
    }
}
