package com.example.jhonathan.myapplication;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface AuditorioService {

    @GET("api/events")
    Call<List<Auditorio>>getAuditorio();
}
