package by.grodno.vasili.bindingmvvm;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import by.grodno.vasili.bindingmvvm.databinding.PhoneItemBinding;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private MainViewModel model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final MyAdapter adapter = new MyAdapter();
        setupRecyclerView(adapter);
        model = ViewModelProviders.of(this).get(MainViewModel.class);
        model.getLiveData().observe(this, adapter::setPhones);
    }

    private void setupRecyclerView(MyAdapter adapter) {
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }
}

class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private List<Phone> phones;

    MyAdapter() {
        this.phones = new ArrayList<>();
    }

    void setPhones(List<Phone> phones) {
        this.phones = phones;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.phone_item, viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Phone phone = phones.get(position);
        holder.binding.setPhone(phone);
    }

    @Override
    public int getItemCount() {
        return phones.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        PhoneItemBinding binding;

        MyViewHolder(@NonNull View itemView) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);
        }
    }
}
