package com.example.exercicio_3_new;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {

    Context contexto;
    ArrayList<HumorData> itemDataAl;

    public ItemAdapter(Context contexto, ArrayList<HumorData> itemDataAl){
        this.contexto = contexto;
        this.itemDataAl = itemDataAl;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View view = LayoutInflater.from(contexto).inflate(R.layout.item_view, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.nome.setText(itemDataAl.get(position).getNomeHumor());
        holder.imageView.setImageResource(itemDataAl.get(position).getHumorId());
    }

    @Override
    public int getItemCount(){ return itemDataAl.size();}

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView nome;
        ImageView imageView;

        public ViewHolder (View itemVew){
            super(itemVew);
            nome = itemView.findViewById(R.id.humor);
            imageView = itemView.findViewById(R.id.imagemHumor);

            itemView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        HumorData clickedItem = itemDataAl.get(position);
                        Toast.makeText(contexto, clickedItem.getNomeHumor(), Toast.LENGTH_SHORT).show();
                    }
                }
            });

        }



    }

}
