package com.johnjeremih.mvvmwithjava.view;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.johnjeremih.mvvmwithjava.adapters.DetailAdapter;
import com.johnjeremih.mvvmwithjava.R;
import com.johnjeremih.mvvmwithjava.databinding.FragmentDetailBinding;
import com.johnjeremih.mvvmwithjava.model.Employee;
import com.johnjeremih.mvvmwithjava.viewmodel.DetailViewModel;
import org.jetbrains.annotations.NotNull;
/*
* Made by John De la cruz
*  2/21/21
 */

public class DetailFragment extends Fragment implements DetailAdapter.DetailAdapterClickHandler{

    //This FragmentDetailBinding is auto created from the xml file.
    private FragmentDetailBinding binding;

    private DetailViewModel viewModel;
    DetailAdapter mAdapter;
    public DetailFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment by using the FragmentDetailBinding
        binding = FragmentDetailBinding.inflate(inflater,container,false);
        View view = binding.getRoot();

        /*
        * Here we initialize the viewModel from the DetailViewModel
        * */
        viewModel = new ViewModelProvider(requireActivity()).get(DetailViewModel.class);
        viewModel.init();


        /* Here we observe the changes on the viewModel data. If the data changes the Adapter
         * will be notified
         */
        viewModel.getEmployee().observe(getViewLifecycleOwner(),v ->{
            mAdapter.notifyDataSetChanged();

        });

        // Binding the ToolBar and adding a title.
        binding.detailToolbar.setTitle("Detail Activity");
        binding.detailToolbar.setNavigationIcon(R.drawable.ic_back_button);
        binding.detailToolbar.setNavigationOnClickListener(v -> Navigation.findNavController(view).navigateUp());

        initRecyclerView();

        return view;
    }



    // Initiating the RecyclerView and passing the viewModel value for Employees.
    private void initRecyclerView() {

        mAdapter = new DetailAdapter(this, viewModel.getEmployee().getValue());
        RecyclerView.LayoutManager linearLayoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
        binding.detailRecyclerView.setLayoutManager(linearLayoutManager);
        binding.detailRecyclerView.setAdapter(mAdapter);

    }


    /**
     * Adding the onClickListener from the DetailAdapter
     */
    @Override
    public void onClickListener(Employee employee) {

        Toast.makeText(getContext(),"You clicked "+employee.getName(),Toast.LENGTH_LONG).show();

    }

    // Make sure you add the onDestroy Method on your fragment

    @Override
    public void onDestroy() {
        super.onDestroy();
        binding = null;
    }
}