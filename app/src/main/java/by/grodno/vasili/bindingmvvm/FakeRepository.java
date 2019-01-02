package by.grodno.vasili.bindingmvvm;

import java.util.ArrayList;
import java.util.List;

class FakeRepository {
    List<Phone> phones;

    FakeRepository() {
        phones = new ArrayList<>(20);
        phones.add(new Phone("Samsung", 2016, "G7"));
        phones.add(new Phone("Samsung", 2017, "G8"));
        phones.add(new Phone("Samsung", 2019, "G9"));
        phones.add(new Phone("Xiaomi", 2017, "Redmi 4"));
    }
}
