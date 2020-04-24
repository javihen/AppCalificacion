package com.example.appcalificacion;

import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class adaptador_list_curso extends RecyclerView.Adapter<adaptador_list_curso.viewHolder_curso> {

    List<curso> listCurso;

    public adaptador_list_curso(List<curso> listCurso) {
        this.listCurso = listCurso;
    }

    @NonNull
    @Override
    public adaptador_list_curso.viewHolder_curso onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.drawable_item_curso,parent,false);
        viewHolder_curso holder = new viewHolder_curso(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull adaptador_list_curso.viewHolder_curso holder, int position) {
        curso c = listCurso.get(position);
        holder.tv_curso.setText(c.getNombre());
        holder.tv_materia.setText(c.getMateria());
    }

    @Override
    public int getItemCount() {
        return listCurso.size();
    }

    public class viewHolder_curso extends RecyclerView.ViewHolder {
        TextView tv_curso, tv_materia;
        public viewHolder_curso(@NonNull View itemView) {
            super(itemView);
            tv_curso = itemView.findViewById(R.id.list_curso);
            tv_materia = itemView.findViewById(R.id.list_materia);
        }
    }
}
