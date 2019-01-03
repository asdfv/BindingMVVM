package by.grodno.vasili.bindingmvvm;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import by.grodno.vasili.bindingmvvm.databinding.PhoneItemBinding;

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
