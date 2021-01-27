package com.example.walker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class cadastro_pet extends AppCompatActivity {
// a activity vai cadastrar o pet do usuario
    EditText nomePet;
    EditText racaPet;
    EditText descricaoPet;
    Button botaoCadastrarPet;

    private View.OnClickListener clickCadastrarPet = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(nomePet.getText().toString().isEmpty() || racaPet.getText().toString().isEmpty()){
                Toast.makeText(getApplicationContext(), "Por favor Preencha os campos em branco", Toast.LENGTH_LONG).show();
            }else{
                Pet pet = new Pet();
                int num = Usuario.listaUsuariosCadastrados.size();
                pet.setNome(nomePet.getText().toString());
                pet.setRaca(racaPet.getText().toString());
                pet.setDescricao(descricaoPet.getText().toString());
                pet.mapaPet.put(Usuario.listaUsuariosCadastrados.get(num-1).getNome(), pet);
                Intent intent = new Intent(cadastro_pet.this, MenuPrincipal.class);
                startActivity(intent);
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_pet);
        nomePet = findViewById(R.id.nomePet);
        racaPet = findViewById(R.id.racaPet);
        descricaoPet = findViewById(R.id.descricaoPet);
        botaoCadastrarPet = findViewById(R.id.botaoCadastrarPet);
        botaoCadastrarPet.setOnClickListener(clickCadastrarPet);

    }
}