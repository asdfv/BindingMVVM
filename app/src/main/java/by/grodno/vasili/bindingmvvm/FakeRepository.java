package by.grodno.vasili.bindingmvvm;

import android.support.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

import by.grodno.vasili.bindingmvvm.model.Phone;

public class FakeRepository {
    public List<Phone> phones;
    private static FakeRepository instance;

    private FakeRepository() {
        phones = new ArrayList<>(20);
        phones.add(new Phone("Samsung", 2016, "S7", "Flagman 2016"));
        phones.add(new Phone("Samsung", 2017, "S8", "Flagman 2017"));
        phones.add(new Phone("Samsung", 2019, "S9", "Flagman 2018"));
        phones.add(new Phone("Xiaomi", 2017, "Redmi 4", "Best china phone"));
    }

    public static FakeRepository getInstance() {
        if (instance == null) {
            instance = new FakeRepository();
        }
        return instance;
    }

    @Nullable
    public Phone getOne(String id) {
        for (Phone phone : phones) {
            if (phone.id.equals(id)) {
                return phone;
            }
        }
        return null;
    }
}
