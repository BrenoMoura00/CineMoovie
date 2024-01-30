import br.com.alura.cinemoovie.modelos.Filme;
import br.com.alura.cinemoovie.modelos.Serie;

public class Principal {
    public static void main(String[] args) {
        Filme meuFilme = new Filme();
        meuFilme.setNome("O poderoso chefão");
        meuFilme.setAnoDeLancamento(1970);
        meuFilme.setDuracaoEmMinutos(180);

        meuFilme.exibeFichaTecnica();
        meuFilme.avalia(8);
        meuFilme.avalia(5);
        meuFilme.avalia(10);

        System.out.println(meuFilme.getDuracaoEmMinutos());
        System.out.println("Total de Avaliações: " + meuFilme.getTotalDeAvaliacoes());
        System.out.println(meuFilme.pegaMedia());

        Serie serie1 = new Serie();
        serie1.setNome("Grey's Anatomy");
        serie1.setAnoDeLancamento(2006);
        serie1.setTemporadas(19);
        serie1.setEpisodiosPorTemporada(22);
        serie1.setMinutosPorEpisodio(42);
        serie1.exibeFichaTecnica();
        System.out.println(serie1.getDuracaoEmMinutos() + serie1.getTemporadas());
    }
}
