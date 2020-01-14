package com.example.exam;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Fragment2 extends Fragment {

    private Bundle bundle;
    private String title, description;
    private TextView t1, t2;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.layout_fragment2, container, false);

        t1 = view.findViewById(R.id.f2_t1);
        t2 = view.findViewById(R.id.f2_t2);

        bundle = getArguments();
        if (bundle != null) {
            title = bundle.getString("data");
            description = bundle.getString("des");

            setData();
        }

        return view;
    }

    private void setData() {
        t1.setText(title);
        t2.setText(description);
    }
}
