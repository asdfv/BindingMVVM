package by.grodno.vasili.bindingmvvm.detail;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.os.AsyncTask;

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
        new LoadByIdAsyncTask().execute(id);
    }

    private class LoadByIdAsyncTask extends AsyncTask<String, Void, Phone> {

        @Override
        protected Phone doInBackground(String... params) {
            return repository.getOne(params[0]);
        }

        @Override
        protected void onPostExecute(Phone phone) {
            super.onPostExecute(phone);
            liveData.setValue(phone);
        }
    }
}
