package com.example.walker.ui.Pagamentos;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.walker.R;
import com.example.walker.Usuario;

public class GalleryFragment extends Fragment {
//    vai pegar o saldo do usuario
    double saldo = Usuario.listaUsuariosCadastrados.get(Usuario.usuariologado).getSaldo();
    double valorAdd = 0.00;
    TextView valorSaldo;
    EditText inputValor;
    Button addButton;

    public View onCreateView(@NonNull LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_pagamentos, container, false);
            valorSaldo = root.findViewById(R.id.valorSaldo);
            inputValor = root.findViewById(R.id.inputValor);
            addButton = root.findViewById(R.id.addButton);

//            inicializa o layout com o saldo atual do usuario
            valorSaldo.setText("R$ " + String.format("%.2f", saldo));

//          acrescenta saldo
            addButton.setOnClickListener( new View.OnClickListener() {

                public void onClick(View v) {
                    if (inputValor.getText().toString().isEmpty()) {
                        Toast.makeText(getActivity(), "Por favor Preencha os campos em branco", Toast.LENGTH_LONG).show();
                    } else {
                        valorAdd = Double.parseDouble(inputValor.getText().toString());
                        if (valorAdd > 0) {
                            saldo += valorAdd;
                            Usuario.listaUsuariosCadastrados.get(Usuario.usuariologado).setSaldo(saldo);
                        }

                        valorSaldo.setText("R$ " + String.format("%.2f", saldo));
                    }
                    inputValor.setText("");
                }
            });

            return root;
    }
}