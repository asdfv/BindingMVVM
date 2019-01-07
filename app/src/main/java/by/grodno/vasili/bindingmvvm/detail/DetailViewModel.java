package by.grodno.vasili.bindingmvvm.detail;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.os.AsyncTask;

import by.grodno.vasili.bindingmvvm.FakeRepository;
import by.grodno.vasili.bindingmvvm.model.Phone;

public class DetailViewModel extends ViewModel {
    private MutableLiveData<Phone> phoneLiveData;
    private final FakeRepository repository;

    public DetailViewModel() {
        this.repository = FakeRepository.getInstance();
    }

    MutableLiveData<Phone> getPhoneLiveData(String id) {
        if (phoneLiveData == null) {
            phoneLiveData = new MutableLiveData<>();
        }
        loadById(id);
        return phoneLiveData;
    }

    private void loadById(String id) {
        new LoadByIdAsyncTask().execute(id);
    }

    private class LoadByIdAsyncTask extends AsyncTask<String, Void, Phone> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            Phone phone = new Phone();
            phone.loading = true;
            phoneLiveData.setValue(phone);
        }

        @Override
        protected Phone doInBackground(String... params) {
            return repository.getOne(params[0]);
        }

        @Override
        protected void onPostExecute(Phone phone) {
            phone.loading = false;
            super.onPostExecute(phone);
            phoneLiveData.setValue(phone);
        }
    }
}
