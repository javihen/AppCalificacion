package com.example.appcalificacion;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class listado_curso extends AppCompatActivity {
    RecyclerView recyclerView;
    EditText et_buscador;
    FloatingActionButton floatingActionButton;

    DatabaseReference dbr;
    ArrayList<curso> listCurso;
    adaptador_list_curso adaptador_curso;
    LinearLayoutManager llm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_curso);

        recyclerView = findViewById(R.id.rv_listado);
        et_buscador = findViewById(R.id.buscar);
        floatingActionButton = findViewById(R.id.floatingActionButton);
        llm = new LinearLayoutManager(this);

        dbr = FirebaseDatabase.getInstance().getReference().child("curso");
        recyclerView.setLayoutManager(llm);
        listCurso = new ArrayList<>();
        adaptador_curso = new adaptador_list_curso(listCurso);
        recyclerView.setAdapter(adaptador_curso);

        dbr.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    listCurso.clear();
                    for(DataSnapshot datos : dataSnapshot.getChildren()){
                        curso c = datos.getValue(curso.class);
                        listCurso.add(c);
                    }
                    adaptador_curso.notifyDataSetChanged();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogo_addCurso dialogo = new dialogo_addCurso();
                dialogo.show(getSupportFragmentManager(),"tag");
            }
        });
    }
}
