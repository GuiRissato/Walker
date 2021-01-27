package com.example.walker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class passeio extends AppCompatActivity {

    TextView lblCidade, lblQtdPasseio, lblTipoPerfil, lblNomeUsuario, lblPreco;
    Button btnProcurar, btnAceitar;
    int  i;

    // gera um numero aleatorio para definir um walker
    public int numAleatorioIntevalo(int max,int min){
        int num;
        Random aleatorio = new Random();
        num = aleatorio.nextInt((max - min) + 1)+ min;

        return num;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passeio);

        // set das variaveis do layout
        btnProcurar = findViewById(R.id.btnProcurar);
        btnAceitar = findViewById(R.id.btnAceitar);
        lblCidade = findViewById(R.id.lblCidade);
        lblQtdPasseio = findViewById(R.id.lblQtdPasseio);
        lblTipoPerfil = findViewById(R.id.lblTipoPerfil);
        lblNomeUsuario = findViewById(R.id.lblNomeUsuario);
        lblPreco = findViewById(R.id.lblPreco);

        //inicializando um walker no layout
        i = numAleatorioIntevalo(3,0);
        lblCidade.setText(Walker.listaWalkerCadastrados.get(i).getCidade());
        lblNomeUsuario.setText("Ola eu sou " + Walker.listaWalkerCadastrados.get(i).getNome());
        lblQtdPasseio.setText("passeios feitos: "+String.valueOf(Walker.listaWalkerCadastrados.get(i).getQuantidadePasseios()));
        lblTipoPerfil.setText("Walker");
        lblPreco.setText("R$ " + String.format("%.2f", Walker.listaWalkerCadastrados.get(i).getPreco()));

//       vai procurar um walker novo
        btnProcurar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i = numAleatorioIntevalo(3,0);
                lblCidade.setText(Walker.listaWalkerCadastrados.get(i).getCidade());
                lblNomeUsuario.setText("Ola eu sou " + Walker.listaWalkerCadastrados.get(i).getNome());
                lblQtdPasseio.setText( "passeios feitos: "+String.valueOf(Walker.listaWalkerCadastrados.get(i).getQuantidadePasseios()));
                lblTipoPerfil.setText("Walker");
                lblPreco.setText("R$ " + String.format("%.2f", Walker.listaWalkerCadastrados.get(i).getPreco()));
            }
        });
//      vai aceitar o passeio e voltar para a tela principal
        btnAceitar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Usuario.listaUsuariosCadastrados.get(Usuario.usuariologado).getSaldo() < Walker.listaWalkerCadastrados.get(i).getPreco()){
                    Toast.makeText(passeio.this, "Saldo insuficiente!", Toast.LENGTH_LONG).show();
                }else{
                    Intent intent;
                    intent = new Intent(passeio.this, MenuPrincipal.class);
                    Toast.makeText(getApplicationContext(), "Seu Walker esta a caminho", Toast.LENGTH_LONG).show();
                    startActivity(intent);
                }
            }
        });



    }
}