package by.grodno.vasili.bindingmvvm.model;

public class Phone {
    public String id;
    public String brand;
    public int year;
    public String model;
    public String description;
    public boolean loading;

    public Phone() {
    }

    public Phone(String brand, int year, String model, String description) {
        this.brand = brand;
        this.year = year;
        this.model = model;
        this.description = description;
        this.id = String.valueOf(Math.random());
        this.loading = false;
    }
}
