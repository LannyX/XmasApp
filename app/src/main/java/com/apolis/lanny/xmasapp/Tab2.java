package com.apolis.lanny.xmasapp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Tab2 extends Fragment {

    public Tab2(){

    }
    TextView textView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v =  inflater.inflate(R.layout.tab2, container, false);

        textView = (TextView)v.findViewById(R.id.tvResult);

        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Bundle b = this.getArguments();
        if (b != null){
            String result = b.getString("key");
            textView.setText(result);
        }

//        ArrayList<String> values = b.getStringArrayList("arrayList");

        //textView.setText(result);

//        textView.setText(values.get(1));
    }
}
