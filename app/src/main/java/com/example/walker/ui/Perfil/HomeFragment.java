package com.example.walker.ui.Perfil;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.walker.MainActivity;
import com.example.walker.Pet;
import com.example.walker.R;
import com.example.walker.Usuario;

public class HomeFragment extends Fragment {

    TextView cidade_usuario;
    TextView passeios_usuario;
    TextView pet_usuario;
    TextView descricao_usuario;

    public View onCreateView(@NonNull LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_perfil, container, false);

//      mostra os dados do usuario logado
        cidade_usuario = root.findViewById(R.id.cidade_usuario);
        passeios_usuario = root.findViewById(R.id.passeios_usuario);
        pet_usuario = root.findViewById(R.id.pet_usuario);
        descricao_usuario = root.findViewById(R.id.descricao_usuario);
            cidade_usuario.setText("Sou de " + Usuario.listaUsuariosCadastrados.get(Usuario.usuariologado).getCidade());
            passeios_usuario.setText("Passeios: " + Usuario.listaUsuariosCadastrados.get(Usuario.usuariologado).getQuantidadePasseios());
            String nomeUsuarioLogado = Usuario.listaUsuariosCadastrados.get(Usuario.usuariologado).getNome();
            pet_usuario.setText("Ola, eu sou o " + (Pet.mapaPet.get(nomeUsuarioLogado)).getNome());
            descricao_usuario.setText("Ola, eu sou o dono do " + (Pet.mapaPet.get(nomeUsuarioLogado)).getNome());
            pet_usuario.setText("Ola, eu sou o " + (Pet.mapaPet.get(nomeUsuarioLogado)).getNome());
        return root;
    }

}