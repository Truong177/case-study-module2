package repositories;

import models.electronic.Electronic;
import models.electronic.Laptop;
import models.electronic.Tivi;

import java.io.*;
import java.util.*;

public class AdminRepository {
    private static final String FILE_PATH = "electronic.csv";
    private static List<Electronic> electronics = new ArrayList<>();

    public boolean add(Electronic electronic) {
        boolean result = electronics.add(electronic);
        writeFile(electronics, false);
        return result;
    }

    public List<Electronic> getAll() {
        List<Electronic> electronics1 = new LinkedList<>();
        File file = new File(FILE_PATH);
        try (FileReader fr = new FileReader(file);
             BufferedReader br = new BufferedReader(fr)) {
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] temp = line.split(",");
                if (temp.length >= 6) {
                    if (line.contains("Laptop")) {
                        electronics1.add(new Laptop(Integer.parseInt(temp[0]), temp[1], Double.parseDouble(temp[2]), temp[3], Integer.parseInt(temp[4]), Integer.parseInt(temp[5])));
                    } else if (line.contains("Tivi")) {
                        electronics1.add(new Tivi(Integer.parseInt(temp[0]), temp[1], Double.parseDouble(temp[2]), temp[3], Integer.parseInt(temp[4]), Integer.parseInt(temp[5])));
                    }
                } else {
                    System.out.println("Invalid data: " + line);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("File does not exist: " + FILE_PATH);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error reading file: " + FILE_PATH);
        }

        electronics = new ArrayList<>(electronics1);
        return electronics1;
    }


    private void writeFile(List<Electronic> electronics, boolean append) {
        File file = new File(FILE_PATH);
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, append))) {
            if (!append) {
                bufferedWriter.write("code,name,price,manufacturer,quantity");
                bufferedWriter.newLine();
            }
            for (Electronic temp : electronics) {
                bufferedWriter.write(toString(temp));
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Lỗi ghi file: " + e.getMessage());
        }
    }

    public String toString(Electronic electronic) {
        return electronic.getCode() + "," +
                electronic.getName() + "," +
                electronic.getPrice() + "," +
                electronic.getManufacturer() + "," +
                electronic.getQuantity();
    }

    public Electronic findByCode(int code) {
        for (Electronic electronic : electronics) {
            if (electronic.getCode() == code) {
                return electronic;
            }
        }
        return null;
    }

    public void remove(Electronic electronic) {
        electronics.remove(electronic);
        writeFile(electronics, false);
    }

    public boolean updateLaptop(Laptop updateLaptop) {
        for (int i = 0; i < electronics.size(); i++) {
            Electronic electronic = electronics.get(i);
            if (electronic instanceof Laptop && electronic.getCode() == updateLaptop.getCode()) {
                electronics.set(i, updateLaptop);
                writeFile(electronics, false);
                return true;
            }
        }
        return false;
    }

    public boolean updateTivi(Tivi updateTivi) {
        for (int i = 0; i < electronics.size(); i++) {
            Electronic electronic = electronics.get(i);
            if (electronic instanceof Tivi && electronic.getCode() == updateTivi.getCode()) {
                electronics.set(i, updateTivi);
                writeFile(electronics, false);
                return true;
            }
        }
        return false;
    }

    public boolean updateElectronic(Electronic updateElectronic) {
        for (int i = 0; i < electronics.size(); i++) {
            Electronic electronic = electronics.get(i);
            if (electronic.getCode() == updateElectronic.getCode()) {
                electronics.set(i, updateElectronic);
                writeFile(electronics, false);
                return true;
            }
        }
        return false;
    }

    public Map<Electronic, Integer> sortProduct() {
        Map<Electronic, Integer> sortedProducts = new LinkedHashMap<>();
        List<Electronic> sortedList = new ArrayList<>(electronics);
        Collections.sort(sortedList, Comparator.comparingDouble(Electronic::getPrice));
        for (Electronic product : sortedList) {
            sortedProducts.put(product, product.getQuantity());
        }
        return sortedProducts;
    }

    public List<Electronic> getAllProduct() {
        return new ArrayList<>(electronics);
    }
}
