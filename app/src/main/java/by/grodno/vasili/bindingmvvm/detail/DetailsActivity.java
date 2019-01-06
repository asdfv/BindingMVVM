package by.grodno.vasili.bindingmvvm.detail;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import by.grodno.vasili.bindingmvvm.R;
import by.grodno.vasili.bindingmvvm.databinding.ActivityDetailsBinding;

public class DetailsActivity extends AppCompatActivity {
    public static final String PHONE_NUMBER = "phone_number";
    private ActivityDetailsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_details);
        DetailViewModel model = ViewModelProviders.of(this).get(DetailViewModel.class);
        String id = getIntent().getStringExtra(PHONE_NUMBER);
        model.getLiveData(id).observe(this, phone -> binding.setPhone(phone));
    }
}
