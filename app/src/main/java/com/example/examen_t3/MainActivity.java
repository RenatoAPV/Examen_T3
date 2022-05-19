package com.example.examen_t3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.examen_t3.Adapter.AnimeAdapter;
import com.example.examen_t3.Entities.Anime;
import com.example.examen_t3.Services.AnimeService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    List<Anime> animes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://run.mocky.io")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        AnimeService service = retrofit.create(AnimeService.class);
        Call<List<Anime>> call = service.GetAnimes();

        call.enqueue(new Callback<List<Anime>>() {
            @Override
            public void onResponse(Call<List<Anime>> call, Response<List<Anime>> response) {
                if(response.isSuccessful()){
                    animes = response.body();

                    AnimeAdapter adapter = new AnimeAdapter(animes);

                    RecyclerView rv = findViewById(R.id.rvAnimes);
                    rv.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                    rv.setHasFixedSize(true);
                    rv.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<List<Anime>> call, Throwable t) {
                Log.e("VJ_EX","Error de conectividad");
            }
        });
    }
    private List<Anime> getAnime(){
        List<Anime> animes = new ArrayList<>();
        animes.add(new Anime(1,"Luis Mendoza", "99999"));
        animes.add(new Anime(2,"Renato Prieto", "111111"));
        animes.add(new Anime(3,"Lucia Rodriguez", "22222"));
        animes.add(new Anime(4,"Cristian Cardozo", "33333"));
        animes.add(new Anime(5,"Juan Vilchez", "444444"));
        animes.add(new Anime(6,"Samuel Prieto", "55555"));
        animes.add(new Anime(7,"Sara Cabrera", "66666"));
        animes.add(new Anime(8,"Camila Rodriguez", "15478"));
        animes.add(new Anime(9,"Maria Medina", "12365"));
        animes.add(new Anime(10,"Lorena Ortiz", "98654"));
        return animes;
    }
}