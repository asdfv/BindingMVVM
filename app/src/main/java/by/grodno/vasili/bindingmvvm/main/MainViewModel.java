package by.grodno.vasili.bindingmvvm.main;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.os.AsyncTask;

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
        new LoadPhonesAsyncTask().execute();
        return liveData;
    }

    class LoadPhonesAsyncTask extends AsyncTask<Void, Void, List<Phone>> {

        @Override
        protected List<Phone> doInBackground(Void... voids) {
            return repository.getPhones();
        }

        @Override
        protected void onPostExecute(List<Phone> phones) {
            super.onPostExecute(phones);
            liveData.setValue(phones);
        }
    }
}
