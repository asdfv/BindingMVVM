package by.grodno.vasili.bindingmvvm.main;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.os.AsyncTask;

import java.util.List;

import by.grodno.vasili.bindingmvvm.FakeRepository;
import by.grodno.vasili.bindingmvvm.model.Phone;

public class ListViewModel extends ViewModel {
    private MutableLiveData<List<Phone>> phonesLiveData;
    MutableLiveData<Boolean> loadingLiveData;
    private final FakeRepository repository;

    public ListViewModel() {
        this.repository = FakeRepository.getInstance();
        this.loadingLiveData = new MutableLiveData<>();
        loadingLiveData.setValue(false);
    }

    MutableLiveData<List<Phone>> getPhonesLiveData() {
        if (phonesLiveData == null) {
            phonesLiveData = new MutableLiveData<>();
        }
        new LoadPhonesAsyncTask().execute();
        return phonesLiveData;
    }

    class LoadPhonesAsyncTask extends AsyncTask<Void, Void, List<Phone>> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            loadingLiveData.setValue(true);
        }

        @Override
        protected List<Phone> doInBackground(Void... voids) {
            return repository.getPhones();
        }

        @Override
        protected void onPostExecute(List<Phone> phones) {
            super.onPostExecute(phones);
            loadingLiveData.setValue(false);
            phonesLiveData.setValue(phones);
        }
    }
}
