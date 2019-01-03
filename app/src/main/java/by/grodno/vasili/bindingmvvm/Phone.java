package by.grodno.vasili.bindingmvvm;

import android.databinding.Bindable;

public class Phone {
    private String brand;
    private int year;
    private String model;

    Phone(String brand, int year, String model) {
        this.brand = brand;
        this.year = year;
        this.model = model;
    }

    @Bindable
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Bindable
    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Bindable
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
