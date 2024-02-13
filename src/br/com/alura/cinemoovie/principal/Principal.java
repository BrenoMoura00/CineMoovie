package br.com.alura.cinemoovie.principal;

import br.com.alura.cinemoovie.calculos.CalculadoraDeTempo;
import br.com.alura.cinemoovie.calculos.FiltroRecomendacao;
import br.com.alura.cinemoovie.modelos.Episodio;
import br.com.alura.cinemoovie.modelos.Filme;
import br.com.alura.cinemoovie.modelos.Serie;

import java.util.ArrayList;

public class Principal {
    public static void main(String[] args) {
        Filme meuFilme = new Filme("O poderoso chefão", 1970);
        meuFilme.setDuracaoEmMinutos(180);

        meuFilme.exibeFichaTecnica();
        meuFilme.avalia(8);
        meuFilme.avalia(8);
        meuFilme.avalia(10);

        System.out.println(meuFilme.getDuracaoEmMinutos());
        System.out.println("Total de Avaliações: " + meuFilme.getTotalDeAvaliacoes());
        System.out.println(meuFilme.pegaMedia());

        System.out.println("==============================================================================");

        Filme filme2 = new Filme("avatar",2023);

        filme2.setDuracaoEmMinutos(200);

        Serie serie = new Serie("Grey's Anatomy",2006);
        serie.setTemporadas(19);
        serie.setEpisodiosPorTemporada(22);
        serie.setMinutosPorEpisodio(42);
        serie.exibeFichaTecnica();
        System.out.println(serie.getDuracaoEmMinutos() + serie.getTemporadas());

        System.out.println("==============================================================================");

        CalculadoraDeTempo calculadora = new CalculadoraDeTempo();
        calculadora.inclui(meuFilme);
        calculadora.inclui(filme2);
        calculadora.inclui(serie);
        System.out.println("total de minutos para maratonar: " + calculadora.getTempoTotal() + " minutos.");

        FiltroRecomendacao filtro = new FiltroRecomendacao();
        filtro.filtra(meuFilme);

        System.out.println("==============================================================================");

        Episodio episodio = new Episodio();
        episodio.setNumero(1);
        episodio.setSerie(serie);
        episodio.setTotalVisualizacoes(300);
        System.out.println(episodio.getSerie());
        filtro.filtra(episodio);

        Filme filmeBreno = new Filme("Dogville", 2023);

        filmeBreno.setDuracaoEmMinutos(200);
        filmeBreno.setAnoDeLancamento(2003);
        filmeBreno.avalia(10);

        ArrayList<Filme> listaDeFilmes = new ArrayList<>();
        listaDeFilmes.add(meuFilme);
        listaDeFilmes.add(filme2);
        listaDeFilmes.add(filmeBreno);
        System.out.println("Tamanho da lista: " + listaDeFilmes.size());
        System.out.println("Primeiro Filme: " + listaDeFilmes.get(0).getNome());
        System.out.println(listaDeFilmes);
        System.out.println("toString do filme " + listaDeFilmes.get(0).toString());

        
    }
}
