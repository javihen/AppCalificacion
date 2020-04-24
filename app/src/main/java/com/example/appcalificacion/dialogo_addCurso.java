package com.example.appcalificacion;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class dialogo_addCurso extends DialogFragment {

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setView(getActivity().getLayoutInflater().inflate(R.layout.layout_crear_curso,null));

        return super.onCreateDialog(savedInstanceState);
    }
}
