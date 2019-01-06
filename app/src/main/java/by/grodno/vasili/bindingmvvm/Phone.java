package by.grodno.vasili.bindingmvvm;

public class Phone {
    private String brand;
    private int year;
    private String model;

    Phone(String brand, int year, String model) {
        this.brand = brand;
        this.year = year;
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public int getYear() {
        return year;
    }

    public String getModel() {
        return model;
    }
}
