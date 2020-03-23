package com.example.login;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class FirstFragment extends Fragment {

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState){
        View mView = inflater.inflate(R.layout.fragment_list,container,false);

        RecyclerView recyclerView = mView.findViewById(R.id.recyclerview);

        ListAdapter listAdapter = new ListAdapter(getActivity());
        recyclerView.setAdapter(listAdapter);
        RecyclerView.LayoutManager layoutManager =new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        return mView;
    }

}
