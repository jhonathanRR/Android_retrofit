package com.example.jhonathan.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private final String baseUrl="http://0.0.0.1:8000/";
    List<Auditorio>listaAuditorio= new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // retrofit
        Retrofit retrofit = new Retrofit.Builder().baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        AuditorioService auditorioService = retrofit.create(AuditorioService.class);
        Call<List<Auditorio>> lista= auditorioService.getAuditorio();

        //para hacer que sea una llamada asincrona

        lista.enqueue(new Callback<List<Auditorio>>() {
            @Override
            public void onResponse(Call<List<Auditorio>> call, Response<List<Auditorio>> response) {
                if(response.isSuccessful()) {
                    listaAuditorio = response.body();
                }

            }

            @Override
            public void onFailure(Call<List<Auditorio>> call, Throwable t) {

            }
        });
    }
}
