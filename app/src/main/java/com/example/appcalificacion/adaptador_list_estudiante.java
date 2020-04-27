package com.example.appcalificacion;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class adaptador_list_estudiante extends RecyclerView.Adapter<adaptador_list_estudiante.ViewHolder_Est> {
    List<estudiante> bdListado;

    public adaptador_list_estudiante(List<estudiante> bdListado) {
        this.bdListado = bdListado;
    }


    @NonNull
    @Override
    public adaptador_list_estudiante.ViewHolder_Est onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.drawable_item_estudiante,parent,false);
        ViewHolder_Est holder = new ViewHolder_Est(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull adaptador_list_estudiante.ViewHolder_Est holder, int position) {
        estudiante e = bdListado.get(position);
        holder.tv_nombre.setText(e.getNombre()+" "+ e.getApellido());

    }

    @Override
    public int getItemCount() {
        return bdListado.size();
    }

    public class ViewHolder_Est extends RecyclerView.ViewHolder {

        TextView tv_nombre, tv_rude;

        public ViewHolder_Est(@NonNull View itemView) {
            super(itemView);
            tv_nombre = itemView.findViewById(R.id.tv_nom_estudiante);
            tv_rude = itemView.findViewById(R.id.tv_rude);
        }
    }
}
