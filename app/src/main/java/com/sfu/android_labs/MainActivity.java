    package com.sfu.android_labs;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

    public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = findViewById(R.id.activity_main__rv_vacations);
        VacationAdapter vacationAdapter = new VacationAdapter(generateMovieList());
        recyclerView.setAdapter(vacationAdapter);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);

        FloatingActionButton fab = findViewById(R.id.activity_main__fb_add);
        Intent intent = new Intent(MainActivity.this, UserProfileActivity   .class);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);
            }
        });
    }

        private List<Vacation> generateMovieList() {
            List<Vacation> list = new ArrayList<>();
            list.add(new Vacation("some","dede",R.drawable.ic_launcher_background));
            list.add(new Vacation("some","dede",R.drawable.ic_launcher_background));
            return list;
        }

}