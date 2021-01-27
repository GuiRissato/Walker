package com.example.walker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class cadastro_usuario extends AppCompatActivity {
//  a activity vai cadastrar o usuario
    EditText nomeUsuario;
    EditText telefoneUsuario;
    EditText cidadeUsuario;
    EditText usernameUsuario;
    EditText senhaUsuario;
    Button botaoCadastrar;
    Usuario usuario;


    private View.OnClickListener clickCadastrar = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(nomeUsuario.getText().toString().isEmpty() || telefoneUsuario.getText().toString().isEmpty() || cidadeUsuario.getText().toString().isEmpty()
                    || usernameUsuario.getText().toString().isEmpty() || senhaUsuario.getText().toString().isEmpty()){

                Toast.makeText(getApplicationContext(), "Por favor Preencha os campos em branco", Toast.LENGTH_LONG).show();

            }else {
                usuario = new Usuario();
                usuario.setNome(nomeUsuario.getText().toString());
                usuario.setTelefone(telefoneUsuario.getText().toString());
                usuario.setUsername(usernameUsuario.getText().toString());
                usuario.setSenha(senhaUsuario.getText().toString());
                usuario.setCidade(cidadeUsuario.getText().toString());
                Usuario.listaUsuariosCadastrados.add(usuario);
                Usuario.usuariologado = Usuario.listaUsuariosCadastrados.size() -1;
                Intent intent = new Intent(cadastro_usuario.this, cadastro_pet.class);
                startActivity(intent);
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_usuario);
        nomeUsuario = findViewById(R.id.nomeUsuario);
        telefoneUsuario = findViewById(R.id.telefoneUsuario);
        cidadeUsuario = findViewById(R.id.cidadeUsuario);
        usernameUsuario = findViewById(R.id.usernameUsuario);
        senhaUsuario = findViewById(R.id.senhaUsuario);
        botaoCadastrar = findViewById(R.id.botaoCadastrar);
        botaoCadastrar.setOnClickListener(clickCadastrar);
    }
}