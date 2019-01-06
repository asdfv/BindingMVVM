package by.grodno.vasili.bindingmvvm.detail;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import by.grodno.vasili.bindingmvvm.FakeRepository;
import by.grodno.vasili.bindingmvvm.model.Phone;

public class DetailViewModel extends ViewModel {
    private MutableLiveData<Phone> liveData;
    private final FakeRepository repository;

    public DetailViewModel() {
        this.repository = FakeRepository.getInstance();
    }

    MutableLiveData<Phone> getLiveData(String id) {
        if (liveData == null) {
            liveData = new MutableLiveData<>();
        }
        loadById(id);
        return liveData;
    }

    private void loadById(String id) {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        liveData.setValue(repository.getOne(id));
    }
}
