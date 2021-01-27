package com.example.walker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    // Variaveis dos objetos da tela inicial
    TextView lblConta;
    Button  btnEntrar;
    Intent intent;
    EditText txtUserName, txtSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtUserName = findViewById(R.id.txtUsername);
        txtSenha = findViewById(R.id.txtSenha);
        btnEntrar = findViewById(R.id.btnEntrar);
        lblConta = findViewById(R.id.lblConta);


//      Cadastro de alguns usuarios para inicializacao do projeto
        Usuario usuario1 = new Usuario();
        usuario1.setNome("Vitor");
        usuario1.setCidade("Americana");
        usuario1.setQuantidadePasseios(0);
        usuario1.setTelefone("19 996776846");
        usuario1.setTipoUsuario("Cliente");
        usuario1.setUsername("porfirio");
        usuario1.setSenha("vp3711521");
        usuario1.setSaldo(130.0);
        Usuario.listaUsuariosCadastrados.add(usuario1);
        Pet pet1 = new Pet("Luna", "Pastor Belga", "Porte grande e brava.");
        Pet.mapaPet.put("Vitor", pet1 );

        Usuario usuario2 = new Usuario();
        usuario2.setNome("Guilherme");
        usuario2.setCidade("Piracicaba");
        usuario2.setQuantidadePasseios(0);
        usuario2.setTelefone("11 998776543");
        usuario2.setTipoUsuario("Cliente");
        usuario2.setUsername("gui");
        usuario2.setSenha("gui778899");
        usuario2.setSaldo(300.0);
        Usuario.listaUsuariosCadastrados.add(usuario2);
        Pet pet2 = new Pet("Zé", "Pitbull", "Forte e bravo.");
        Pet.mapaPet.put("Guilherme", pet2 );

        Usuario usuario3 = new Usuario();
        usuario3.setNome("Lucas");
        usuario3.setCidade("Piracicaba");
        usuario3.setQuantidadePasseios(0);
        usuario3.setTelefone("11 998556217");
        usuario3.setTipoUsuario("Cliente");
        usuario3.setUsername("lucas_fiori");
        usuario3.setSenha("Luc@123");
        usuario3.setSaldo(170.0);
        Usuario.listaUsuariosCadastrados.add(usuario3);
        Pet pet3 = new Pet("Pipoca", "Shitzu", "Pequenininho e fofinho.");
        Pet.mapaPet.put("Lucas", pet3 );


//      cadastro de alguns walkers para procura
        Walker walker1 = new Walker("Rodolfo", "Piracicaba", 5.0, 42,"Walker", 35 );
        Walker walker2 = new Walker("Pedro", "Piracicaba", 4.0, 30,"Walker" ,25);
        Walker walker3 = new Walker("Moises", "Piracicaba", 3.0, 22,"Walker" ,28);
        Walker walker4 = new Walker("Camila", "Piracicaba", 5.0, 63,"Walker" ,32);

        Walker.listaWalkerCadastrados.add(walker1);
        Walker.listaWalkerCadastrados.add(walker2);
        Walker.listaWalkerCadastrados.add(walker3);
        Walker.listaWalkerCadastrados.add(walker4);

//       O label que leva a tela de cadastro
        lblConta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                        intent = new Intent(MainActivity.this, cadastro_usuario.class);
                        startActivity(intent);
                }
        });
//        vai efetuar o login do usuario ja cadastrado
        btnEntrar.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick (View v){

            if(txtUserName.getText().toString().isEmpty() || txtSenha.getText().toString().isEmpty()){
                Toast.makeText(getApplicationContext(), "Preencha os campos necessarios para o login", Toast.LENGTH_LONG).show();
            }else if(!txtUserName.getText().toString().isEmpty() && !txtSenha.getText().toString().isEmpty()){
                if(Usuario.listaUsuariosCadastrados.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Não encontramos seu cadastro", Toast.LENGTH_LONG).show();
                }else{
                    System.out.println(Usuario.listaUsuariosCadastrados.size());

                    for (int i = 0; i < Usuario.listaUsuariosCadastrados.size(); i++) {
                        if (txtUserName.getText().toString().equals(Usuario.listaUsuariosCadastrados.get(i).getUsername()) && txtSenha.getText().toString().equals(Usuario.listaUsuariosCadastrados.get(i).getSenha())) {
                            intent = new Intent(MainActivity.this, MenuPrincipal.class);
                            Usuario.usuariologado = i;
                            startActivity(intent);
                        }
                    }
                }
            }
    }
        });


    }


}