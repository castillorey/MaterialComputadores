package com.kevinmcr.materialcomputadores;

import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Android on 28/05/2018.
 */

public class AdaptadorComputador extends RecyclerView.Adapter<AdaptadorComputador.ComputadorViewHolder>{

    private ArrayList<Computador> computadores;
    private OnComputadorClickListener clickListener;



    public AdaptadorComputador(ArrayList<Computador> computadores, OnComputadorClickListener clickListener){
        this.computadores = computadores;
        this.clickListener = clickListener;

    }

    @Override
    public ComputadorViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_computador,parent,false);
        return new ComputadorViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ComputadorViewHolder holder, int position) {
        final Computador c = computadores.get(position);

        holder.imagen.setImageResource(c.getImg());
        holder.marca.setText(c.getMarca());
        holder.ram.setText(""+ c.getRam());
        holder.color.setText(c.getColor());

        holder.v.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                clickListener.onComputadorClick(c);

            }
        });
    }

    @Override
    public int getItemCount() {
        return computadores.size();
    }


    public static class ComputadorViewHolder extends RecyclerView.ViewHolder{
        private ImageView imagen;
        private TextView marca, ram, color, tipo, so;
        private View v;

        public ComputadorViewHolder(View itemView){

            super(itemView);
            v = itemView;
            imagen = v.findViewById(R.id.imgFoto);
            marca = v.findViewById(R.id.tvMarca);
            ram = v.findViewById(R.id.tvRam);
            color = v.findViewById(R.id.tvColor);
            tipo = v.findViewById(R.id.tvTipo);
            so = v.findViewById(R.id.tvSo);
        }
    }
    public interface OnComputadorClickListener{
        void onComputadorClick(Computador p);
    }

}
