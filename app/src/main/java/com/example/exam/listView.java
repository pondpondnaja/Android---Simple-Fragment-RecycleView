package com.example.exam;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Arrays;

public class listView extends Fragment implements View.OnClickListener {
    private static final String TAG = "ListViewAc";

    private ArrayList<String> title = new ArrayList<>();
    private ArrayList<String> description = new ArrayList<>();
    private String[] data;

    private FloatingActionButton fab;
    private Context context;
    //Use to sent data from listView to fragment
    private RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.activity_listview, container, false);

        context = view.getContext();
        fab = view.findViewById(R.id.fab);
        recyclerView = view.findViewById(R.id.RecycleView);

        data = new String[]{
                "item 1", "item2", "item 3", "item 4", "item 5",
                "item6", "item 7", "item 8", "item 9", "item 10",
                "item 11", "item 12", "item 13", "item 14", "item 15"};

        fab.setOnClickListener(this);

        return view;
    }

    @Override
    public void onStart() {
        Log.d(TAG, "onStart: Start");
        super.onStart();
        initData();
    }

    private void initData() {
        Log.d(TAG, "initData: initData called");
        title.addAll(Arrays.asList(data));
        description.addAll(Arrays.asList(data));
        Log.d(TAG, "initData: Data : " + title);
        Log.d(TAG, "initData: Data : " + description);
        if (!title.isEmpty() && !description.isEmpty()) {
            initRecycleView();
        }
    }

    private void initRecycleView() {
        Log.d(TAG, "initRecycleView: Called");
        LinearLayoutManager layoutManager = new LinearLayoutManager(context, RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        listViewAdapter adapter = new listViewAdapter(context, title, description);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.fab) {
            String mailto = "mailto:supporter@gmail.com" +
                    "?subject=" + Uri.encode("Provide support");
            Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
            emailIntent.setData(Uri.parse(mailto));
            startActivity(emailIntent);
        }
    }
}
