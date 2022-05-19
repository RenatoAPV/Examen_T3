package com.example.examen_t3.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.examen_t3.Entities.Anime;
import com.example.examen_t3.R;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.List;

public class AnimeAdapter extends RecyclerView.Adapter<AnimeAdapter.AnimeViewHolder> {
    List<Anime> animes;
    public AnimeAdapter(List<Anime> animes){
        this.animes = animes;
    }


    @NonNull
    @Override
    public AnimeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,parent,false);
        return new AnimeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AnimeViewHolder vh, int position) {
        Anime anime = animes.get(position);
        TextView tvNombreA = vh.itemView.findViewById(R.id.tvNombreAnime);
        TextView tvDescripA = vh.itemView.findViewById(R.id.tvDescripcion);
        tvNombreA.setText(anime.nombre);
        tvDescripA.setText(anime.desripcion);

        //ImageView imagen = vh.itemView.findViewById(R.id.imageView);
        //Picasso.get().load("https://pics.filmaffinity.com/Komi_san_no_puede_comunicarse_Serie_de_TV-821423565-large.jpg").into(imagen);

    }

    @Override
    public int getItemCount() {
        return animes.size();
    }

    class AnimeViewHolder extends RecyclerView.ViewHolder{

        public AnimeViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

}
