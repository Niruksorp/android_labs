    package com.sfu.android_labs;

    import android.annotation.SuppressLint;
    import android.content.Intent;
    import android.os.Bundle;
    import android.os.Handler;
    import android.os.Looper;
    import android.view.View;
    import android.widget.Toast;

    import androidx.appcompat.app.AppCompatActivity;
    import androidx.recyclerview.widget.LinearLayoutManager;
    import androidx.recyclerview.widget.RecyclerView;

    import com.google.android.material.floatingactionbutton.FloatingActionButton;

    import java.io.BufferedReader;
    import java.io.IOException;
    import java.io.InputStreamReader;
    import java.net.HttpURLConnection;
    import java.net.URL;
    import java.util.ArrayList;
    import java.util.List;

    public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

            new Thread(new Runnable() {
                @SuppressLint("ShowToast")
                @Override
                public void run() {
                    URL url;
                    HttpURLConnection connection = null;

                    try {
                        url = new URL("http://10.0.2.2:8080/projects");
                        connection = (HttpURLConnection) url.openConnection();
                        BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));

                        String line = br.readLine();

                        new Handler(Looper.getMainLooper()).post(() -> {
                            Toast.makeText(MainActivity.this, line, Toast.LENGTH_LONG);
                        });
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();

        RecyclerView recyclerView = findViewById(R.id.activity_main__rv_vacations);
        VacationAdapter vacationAdapter = new VacationAdapter(generateMovieList());
        recyclerView.setAdapter(vacationAdapter);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);


        FloatingActionButton fab = findViewById(R.id.activity_main__fb_add);
        Intent intent = new Intent(MainActivity.this, MainCrudActivity.class);
        // MainCrudActivity UserProfileActivity
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);
            }
        });
    }

        private List<Vacation> generateMovieList() {
            List<Vacation> list = new ArrayList<>();
            list.add(new Vacation("С++ Calculator","Пишем самый лучший калькулятор на планете земля, а мб и чуть лучше"
                    ,R.drawable.ic_launcher_background));
            list.add(new Vacation("Vue Framework","Напишем свой собственный Вью фреймворк!!",R.drawable.ic_launcher_background));
            list.add(new Vacation("Vue Framework","Напишем свой собственный Вью фреймворк!!",R.drawable.ic_launcher_background));
            list.add(new Vacation("Vue Framework","Напишем свой собственный Вью фреймворк!!",R.drawable.ic_launcher_background));
            list.add(new Vacation("Vue Framework","Напишем свой собственный Вью фреймворк!!",R.drawable.ic_launcher_background));
            return list;
        }

}