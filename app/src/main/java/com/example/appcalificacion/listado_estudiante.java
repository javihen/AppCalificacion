package com.example.appcalificacion;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.Toolbar;

import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

public class listado_estudiante extends AppCompatActivity {
    RecyclerView recyclerView;
    adaptador_list_estudiante adaptador_est;
    List<estudiante> Lista_est;
    BottomAppBar bottomAppBar;
    FloatingActionButton floatingActionButton;
    Toolbar toolbar;
    DatabaseReference dbr;
    LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_estudiante);
        dbr = FirebaseDatabase.getInstance().getReference().child("estudiante");
        toolbar = findViewById(R.id.toolbar);


        recyclerView = findViewById(R.id.rv_estudiantes);
        adaptador_est = new adaptador_list_estudiante(Lista_est);

        //adicionamos el BottomAppBar al activity
        bottomAppBar = findViewById(R.id.bar_estudiante);
        setSupportActionBar(bottomAppBar);

        floatingActionButton = findViewById(R.id.fab_buscar);




    }

}
