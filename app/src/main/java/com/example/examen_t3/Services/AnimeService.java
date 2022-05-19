package com.example.examen_t3.Services;

import com.example.examen_t3.Entities.Anime;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface AnimeService {
    @GET("/v3/ffaad862-5540-42a6-9be9-b460e74e7085")
    Call<List<Anime>> GetAnimes();

}
