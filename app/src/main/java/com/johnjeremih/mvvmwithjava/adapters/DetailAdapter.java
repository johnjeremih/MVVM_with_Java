package com.johnjeremih.mvvmwithjava.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.johnjeremih.mvvmwithjava.databinding.ListItemBinding;
import com.johnjeremih.mvvmwithjava.model.Employee;

import java.util.ArrayList;

/* Made by John De la cruz
 *  2/21/21
 */
public class DetailAdapter extends RecyclerView.Adapter<DetailAdapter.DetailViewHolder> {

    // Remember the ListItemBinding is auto created from the xml file
    private ListItemBinding binding;

    private final ArrayList<Employee> employeesList;
    private final DetailAdapterClickHandler mHandler;

    public DetailAdapter(DetailAdapterClickHandler mHandler, ArrayList<Employee> employees) {

        this.mHandler = mHandler;
        this.employeesList = employees;
    }

    @NonNull
    @Override
    public DetailViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        // Inflating the layout and adding viewBinding.
        binding = ListItemBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        View view = binding.getRoot();



        return new DetailViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DetailViewHolder holder, int position) {

        Employee employee = employeesList.get(position);

        // Getting the textViews from the list_item.xml
        binding.itemNameEmployee.setText(employee.getName());
        binding.nameDescriptionEmployee.setText(employee.getDescription());





    }

    @Override
    public int getItemCount() {
        return employeesList.size();
    }

    public class DetailViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public DetailViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Employee employee = employeesList.get(getAdapterPosition());
            mHandler.onClickListener(employee);
        }
    }

    public interface DetailAdapterClickHandler {

        void onClickListener(Employee employee);
    }
}
