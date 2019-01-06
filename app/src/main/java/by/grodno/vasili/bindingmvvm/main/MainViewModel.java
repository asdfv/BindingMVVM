package by.grodno.vasili.bindingmvvm.main;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import java.util.List;

import by.grodno.vasili.bindingmvvm.FakeRepository;
import by.grodno.vasili.bindingmvvm.model.Phone;

public class MainViewModel extends ViewModel {
    private MutableLiveData<List<Phone>> liveData;
    private final FakeRepository repository;

    public MainViewModel() {
        this.repository = FakeRepository.getInstance();
    }

    MutableLiveData<List<Phone>> getLiveData() {
        if (liveData == null) {
            liveData = new MutableLiveData<>();
        }
        loadFromRepository();
        return liveData;
    }

    private void loadFromRepository() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        liveData.setValue(repository.phones);
    }
}
