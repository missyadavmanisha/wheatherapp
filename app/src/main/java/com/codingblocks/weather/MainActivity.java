package com.codingblocks.weather;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    ArrayList<Solution> arrayList=new ArrayList<>();
    String url="http://api.openweathermap.org/data/2.5/forecast?id=1269750&APPID=25bd7c8f0933b1559a290b40e8742d54";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        makenetworkcall(url);


    }

    public void makenetworkcall(String url) {
        OkHttpClient okHttpClient=new OkHttpClient();
        final Request request = new Request.Builder().url(url).build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {


            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                String jsonResponse = response.body().string();
                Gson gson = new Gson();

                Result result = gson.fromJson(jsonResponse, Result.class);

                ArrayList<Allvalue> allvalues = result.getList();
                for (int i = 0; i < allvalues.size(); i++) {
                    arrayList.add(new Solution(allvalues.get(i).getMain().getTemp(),
                            allvalues.get(i).getMain().getTemp_min(), allvalues.get(i).getMain().
                            getTemp_max(), allvalues.get(i).getDt_txt(),
                            allvalues.get(i).getMain().getHumidity()));

                }
                MainActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        RecyclerView recyclerView = findViewById(R.id.rVusers);
                        recyclerView.setLayoutManager(new LinearLayoutManager(getBaseContext()));
                        GithubAdapter githubAdapter = new GithubAdapter(arrayList, getBaseContext());

                        recyclerView.setAdapter(githubAdapter);
                        //This code runs in the Main Thread
                    }
                });

            }
        });
        //....
    }
}







