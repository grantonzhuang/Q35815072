package com.grant.q35619180;

/**
 * Created by grant on 2016/2/25.
 */

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<FirstModel> firstModels;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_holder);


        createTenFirstModels();
        FirstAdapter firstAdapter = new FirstAdapter(firstModels);
        firstAdapter.setActivity(this);
        RecyclerView rcv = (RecyclerView) findViewById(R.id.main_rcv);
        rcv.setLayoutManager(new LinearLayoutManager(this));
        rcv.setAdapter(firstAdapter);
    }

    private void createTenFirstModels() {
        firstModels = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            FirstModel firstModel = new FirstModel();
            firstModel.setSecondModels(createSecondModels());
            firstModel.setCat("cat" + i);
            firstModels.add(firstModel);
        }
    }

    private List<SecondModel> createSecondModels() {
        List<SecondModel> secondModels = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            SecondModel secondModel = new SecondModel();
            secondModel.setRes(R.drawable.file);
            secondModels.add(secondModel);
        }
        return secondModels;
    }
}