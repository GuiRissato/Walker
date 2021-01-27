package com.example.walker;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Usuario {

    public static List<Usuario> listaUsuariosCadastrados = new ArrayList<>();
    public static int usuariologado;
    private String nome;
    private String telefone;
    private String cidade;
    private String username;
    private String senha;
    private String tipoUsuario;
    private int quantidadePasseios;
    private double saldo;



    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
    public int getQuantidadePasseios() {
        return quantidadePasseios;
    }
    public void setQuantidadePasseios(int quantidadePasseios) {this.quantidadePasseios = quantidadePasseios; }
    public String getTipoUsuario() {
        return tipoUsuario;
    }
    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) { this.nome = nome; }
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String usuario) {
        this.username = usuario;
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {this.senha = senha;}
    public double getSaldo() {
        return saldo;
    }
    public void setSaldo(double saldo) {this.saldo = saldo;}


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(username, usuario.username) &&
                Objects.equals(senha, usuario.senha);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, senha);
    }
}

