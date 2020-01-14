package com.example.exam;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class listViewAdapter extends RecyclerView.Adapter<listViewAdapter.ViewHolder> {

    private static final String TAG = "IVA";
    private ArrayList<String> title = new ArrayList<>();
    private ArrayList<String> description = new ArrayList<>();

    private Context context;
    private Bundle bundle;

    public listViewAdapter(Context context, ArrayList<String> title, ArrayList<String> description) {
        this.context = context;
        this.title = title;
        this.description = description;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.content_listview, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull listViewAdapter.ViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: Data : " + title);
        Log.d(TAG, "onBindViewHolder: Data : " + description);

        holder.title.setText(title.get(position));
        holder.description.setText(description.get(position));

        holder.parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppCompatActivity activity = (AppCompatActivity) view.getContext();
                bundle = new Bundle();

                switch (position) {
                    case 0:
                        bundle.putString("data", title.get(position));
                        bundle.putString("des", description.get(position));
                        Fragment1 fragment1 = new Fragment1();
                        fragment1.setArguments(bundle);

                        Toast.makeText(context, title.get(position), Toast.LENGTH_SHORT).show();
                        activity.getSupportFragmentManager()
                                .beginTransaction()
                                .add(R.id.fragmentContainer, fragment1)
                                .addToBackStack(null)
                                .commit();
                        break;

                    case 1:
                        bundle.putString("data", title.get(position));
                        bundle.putString("des", description.get(position));
                        Fragment2 fragment2 = new Fragment2();
                        fragment2.setArguments(bundle);

                        Toast.makeText(context, title.get(position), Toast.LENGTH_SHORT).show();
                        activity.getSupportFragmentManager()
                                .beginTransaction()
                                .add(R.id.fragmentContainer, fragment2)
                                .addToBackStack(null)
                                .commit();
                        break;
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return title.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView title, description;
        RelativeLayout parent;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            description = itemView.findViewById(R.id.description);
            parent = itemView.findViewById(R.id.information_holder);
        }
    }
}
