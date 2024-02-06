package br.com.alura.cinemoovie.modelos;

import br.com.alura.cinemoovie.calculos.Classificavel;

public class Filme extends Titulo implements Classificavel {
    private String diretor;

    public Filme(String nome, int ano) {
        super();
        this.setNome(nome);
        this.setAnoDeLancamento(ano);
    }

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    @Override
    public int getClassificacao() {
        return (int) pegaMedia() / 2;
    }

    @Override
    public String toString() {
        return "Filme: " + this.getNome() + "|" + getAnoDeLancamento() + "|";
    }
}