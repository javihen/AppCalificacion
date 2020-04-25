package com.example.appcalificacion;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class dialogo_addCurso extends DialogFragment {

    private DatabaseReference mDatabase;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        setCancelable(false);
        mDatabase = FirebaseDatabase.getInstance().getReference();
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        View view = getActivity().getLayoutInflater().inflate(R.layout.layout_crear_curso, null);

        final EditText nom_curso = view.findViewById(R.id.et_nom_curso);
        final EditText nom_materia = view.findViewById(R.id.et_nom_materia);
        final TextView tvCancelar = view.findViewById(R.id.dialogo_cancelar);
        final TextView tvGuardar = view.findViewById(R.id.dialogo_guardar);

        tvGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Guardando el curso", Toast.LENGTH_SHORT).show();
                curso c = new curso("id",nom_curso.getText().toString(),nom_materia.getText().toString());
                mDatabase.child("curso").push().setValue(c);
                dismiss();
            }
        });
        tvCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               //Toast.makeText(getActivity(), "Estamos cerrando el formulario", Toast.LENGTH_SHORT).show();
                dismiss();
            }
        });

        builder.setView(view);
        return builder.create();
    }
}
