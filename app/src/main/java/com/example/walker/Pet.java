package com.example.walker;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Pet {

    public static List<Pet> listaPetCadastrados = new ArrayList<Pet>();
    private String nome;
    private String raca;
    private String descricao;

    public Pet(String nome, String raca, String descricao) {
        this.nome = nome;
        this.raca = raca;
        this.descricao = descricao;
    }
    public Pet(){


    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public static Map<String, Pet> mapaPet = new HashMap<String, Pet>();
}
