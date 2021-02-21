package com.johnjeremih.mvvmwithjava.view;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.johnjeremih.mvvmwithjava.R;
import com.johnjeremih.mvvmwithjava.databinding.FragmentMainScreenBinding;

/* Made by John De la cruz
 *  2/21/21
 */
public class MainFragment extends Fragment {

    private FragmentMainScreenBinding binding;


    public MainFragment() {

        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        binding = FragmentMainScreenBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        /*
        * Using navigation Component to navigate to the next screen.
         */
        binding.toDetailButton.setOnClickListener(view1 -> Navigation.findNavController(view1).navigate(R.id.toDetailFragment));

        return view;
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        binding = null;
    }
}