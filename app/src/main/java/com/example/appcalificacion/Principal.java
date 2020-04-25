package com.example.appcalificacion;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.navigation.NavigationView;

public class Principal extends AppCompatActivity {

    BottomAppBar bottomAppBar;
    private BottomSheetDialog bottomSheetDialog;
    private CardView list_curso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        bottomAppBar = findViewById(R.id.bottomAppBar);
        setSupportActionBar(bottomAppBar);
        list_curso = findViewById(R.id.card_listado);

        bottomAppBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // Toast.makeText(getApplicationContext(),"hola mudo", Toast.LENGTH_LONG).show();
                lanzarMenu();
            }
        });

        list_curso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Principal.this, listado_curso.class);
                startActivity(i);
            }
        });
    }

    private void lanzarMenu() {
        final View bottom_navegacion = getLayoutInflater().inflate(R.layout.navegation_menu,null);
        bottomSheetDialog = new BottomSheetDialog(Principal.this);
        bottomSheetDialog.setContentView(bottom_navegacion);
        bottomSheetDialog.show();

        NavigationView navigationView = bottom_navegacion.findViewById(R.id.navigation_menu);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                switch (id){
                    case R.id.op_estudiante:
                        //Toast.makeText(Principal.this, "Opcion agregar nuevo estudiante", Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(Principal.this, registro_estudiante.class);
                        startActivity(i);

                        bottomSheetDialog.dismiss();
                        break;
                    case R.id.op_usuario:
                        Toast.makeText(Principal.this,"opcion agregar nuevo usuario",Toast.LENGTH_SHORT).show();
                        bottomSheetDialog.dismiss();
                        break;
                    case R.id.op_reporte:
                        Toast.makeText(Principal.this,"Enviar reporte de notas",Toast.LENGTH_SHORT).show();
                        bottomSheetDialog.dismiss();
                        break;
                }

                return false;
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.botomappbar_menu, menu);
        return true;

    }

}
