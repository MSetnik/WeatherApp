package com.example.weatherappjava.Fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.weatherappjava.R;

public class SearchFragment extends Fragment {
    private static final String TAG = "MyApp";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        GetSearchValue(view);
    }

    private void GetSearchValue(View view) {
        ImageButton searchBtn = view.findViewById(R.id.searchFragmentB);
        EditText search = view.findViewById(R.id.searchET);


        searchBtn.setOnClickListener(v -> {
            Bundle bundle = new Bundle();
            bundle.putString("searchInput", String.valueOf(search.getText()));

            Navigation.findNavController(view).navigate(R.id.action_searchFragment_to_currentWeatherFragment, bundle);
        });
    }
}