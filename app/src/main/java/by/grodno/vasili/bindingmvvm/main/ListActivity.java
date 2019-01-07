package by.grodno.vasili.bindingmvvm.main;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import by.grodno.vasili.bindingmvvm.R;
import by.grodno.vasili.bindingmvvm.databinding.ActivityListBinding;
import by.grodno.vasili.bindingmvvm.detail.DetailsActivity;

public class ListActivity extends AppCompatActivity {
    private ActivityListBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_list);
        MyAdapter adapter = new MyAdapter();
        setupRecyclerView(adapter);
        MainViewModel model = ViewModelProviders.of(this).get(MainViewModel.class);
        model.getLiveData().observe(this, adapter::setPhones);
    }

    public void details(View view, String id) {
        Intent intent = new Intent(this, DetailsActivity.class);
        intent.putExtra(DetailsActivity.PHONE_NUMBER, id);
        startActivity(intent);
    }

    private void setupRecyclerView(MyAdapter adapter) {
        binding.recyclerView.setAdapter(adapter);
    }
}
