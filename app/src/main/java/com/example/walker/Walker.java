package com.example.walker;

import java.util.ArrayList;
import java.util.List;

public class Walker {

    public Walker(String nome, String cidade, Double rating, int quantidadePasseios, String tipo, double preco) {
        this.nome = nome;
        this.cidade = cidade;
        this.rating = rating;
        this.preco = preco;
        this.quantidadePasseios = quantidadePasseios;
        this.tipo = tipo;

    }

    private String nome;
    private String cidade;
    private Double rating;
    private int quantidadePasseios;
    private String tipo;
    private double preco;

    private List<Double> listaRatingUsuario = new ArrayList<Double>();
    static List<Walker> listaWalkerCadastrados = new ArrayList<Walker>();


    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public void setRating(Double rating) {
        listaRatingUsuario.add(rating);
        this.rating = mediaRating();
    }
    private Double mediaRating()
    {
        Double somaTotal = 0.0;
        Double media;
        for (int i = 0; i < listaRatingUsuario.size(); i++ )
        {
            somaTotal += listaRatingUsuario.get(i);
        }
        media = somaTotal/listaRatingUsuario.size();
        return media;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public int getQuantidadePasseios() {
        return quantidadePasseios;
    }

    public void setQuantidadePasseios(int quantidadePasseios) {
        this.quantidadePasseios = quantidadePasseios;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}


