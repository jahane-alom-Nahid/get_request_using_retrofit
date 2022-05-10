package com.example.getrequest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyle;
    LinearLayoutManager layoutManager;
    postAdapter adapter;
    List<posts> postsList=new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyle=findViewById(R.id.recyclerview);
        layoutManager=new LinearLayoutManager(this);
        recyle.setLayoutManager(layoutManager);
        adapter=new postAdapter(postsList);
        recyle.setAdapter(adapter);

        fetchPost();

    }

    private void fetchPost() {
        RetrofitClient.getRetrofitClient().getPost().enqueue(new Callback<List<posts>>() {
            @Override
            public void onResponse(Call<List<posts>> call, Response<List<posts>> response) {
                if (response.isSuccessful() && response.body()!=null){
                    postsList.addAll(response.body());
                    adapter.notifyDataSetChanged();

                }
            }

            @Override
            public void onFailure(Call<List<posts>> call, Throwable t) {

            }
        });
    }
}