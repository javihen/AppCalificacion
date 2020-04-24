package com.example.appcalificacion;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class registro_estudiante extends AppCompatActivity {

    Spinner spinnerCursos, spinnerMateria;
    BottomAppBar bottomAppBar;
    Button btnguardar, btncancelar;
    EditText et_nombre, et_apellido, et_rude;
    Spinner sp_curso, sp_materia;
    private DatabaseReference mDatabase;
    private BottomSheetDialog bottomSheetDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_estudiante);

        mDatabase = FirebaseDatabase.getInstance().getReference();

        et_rude = findViewById(R.id.et_rude);
        et_nombre = findViewById(R.id.et_nombre);
        et_apellido = findViewById(R.id.et_apellido);

        bottomAppBar = findViewById(R.id.bottom_app_bar);
        setSupportActionBar(bottomAppBar);

        String[] lenguajes = {"Seleccione","Ruby","Java",".NET","Python","PHP","JavaScript","GO"};
        spinnerCursos = findViewById(R.id.sp_curso);
        spinnerMateria = findViewById(R.id.sp_materia);
        spinnerCursos.setAdapter(new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item,lenguajes));
        spinnerMateria.setAdapter(new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item,lenguajes));

        btncancelar = findViewById(R.id.btn_cancelar);
        btnguardar = findViewById(R.id.btn_guardar);

        btncancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(registro_estudiante.this, Principal.class);
                startActivity(i);
            }
        });
        btnguardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(et_rude.getText().toString()!=null){
                    guardar_estudiante(et_rude.getText().toString(),et_nombre.getText().toString(),et_apellido.getText().toString());
                    Toast.makeText(registro_estudiante.this, "Se registro con exito.", Toast.LENGTH_LONG).show();
                    Intent i = new Intent(registro_estudiante.this, Principal.class);
                    i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(i);
                }else{
                    Toast.makeText(registro_estudiante.this, "Existe un error en guardar los datos", Toast.LENGTH_SHORT).show();
                }
            }
        });
        bottomAppBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Toast.makeText(getApplicationContext(),"hola mudo", Toast.LENGTH_LONG).show();
                lanzarMenu();
            }
        });
    }

        private void guardar_estudiante(String rude, String nombre, String apellido) {

        estudiante obj = new estudiante(rude, nombre, apellido);
        mDatabase.child("estudiante").child(rude).setValue(obj);
    }

        private void lanzarMenu() {
        final View bottom_navegacion = getLayoutInflater().inflate(R.layout.navegation_menu,null);
        bottomSheetDialog = new BottomSheetDialog(registro_estudiante.this);
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
                        break;
                    case R.id.op_usuario:
                        Toast.makeText(registro_estudiante.this,"opcion agregar nuevo usuario",Toast.LENGTH_SHORT).show();
                        bottomSheetDialog.dismiss();
                        break;
                    case R.id.op_reporte:
                        Toast.makeText(registro_estudiante.this,"Enviar reporte de notas",Toast.LENGTH_SHORT).show();
                        bottomSheetDialog.dismiss();
                        break;
                }

                return false;
            }
        });

    }
}
