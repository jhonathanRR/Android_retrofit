package com.example.jhonathan.myapplication;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiServicio {

    @GET("api/users")
    Call<Evento> getExample();

    @GET("api/events")
    Call<EventoResponse> getEventos();
}
