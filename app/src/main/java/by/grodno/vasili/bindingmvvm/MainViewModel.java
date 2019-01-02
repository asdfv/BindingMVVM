package by.grodno.vasili.bindingmvvm;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import java.util.List;

public class MainViewModel extends ViewModel {
    private MutableLiveData<List<Phone>> liveData;
    private final FakeRepository repository;

    public MainViewModel() {
        this.repository = new FakeRepository();
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
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        liveData.setValue(repository.phones);
    }
}
