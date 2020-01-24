package com.geektech.taskapp.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.geektech.taskapp.R;
import com.geektech.taskapp.TaskAdapter;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private TaskAdapter adapter;
    private List<String> list;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        RecyclerView recyclerView = root.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        list = new ArrayList<>();
        list.add("Номер 1");
        list.add("Номер 2");
        list.add("Номер 3");
        list.add("Номер 4");
        adapter = new TaskAdapter(list);
        recyclerView.setAdapter(adapter);
        return root;
    }
}