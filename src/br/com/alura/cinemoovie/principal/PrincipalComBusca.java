package br.com.alura.cinemoovie.principal;

import br.com.alura.cinemoovie.exception.ErroDeConversaoDeAndoException;
import br.com.alura.cinemoovie.modelos.Titulo;
import br.com.alura.cinemoovie.modelos.TituloOmdb;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class PrincipalComBusca {

    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("digite um filme para busca: ");
        var busca = scanner.nextLine();

        try {
            String endereco = "https://www.omdbapi.com/?t=" + busca.replace(" ",  "+") + "&apikey=d1f51703";
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(endereco))
                    .build();
            System.out.println(endereco);
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            String json = response.body();
            System.out.println(json);


            Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).create();

            TituloOmdb meuTituloOmdb = gson.fromJson(json, TituloOmdb.class);

            Titulo meuTitulo = new Titulo(meuTituloOmdb);
            System.out.println("Título já convertido");
            System.out.println(meuTitulo);
        } catch (NumberFormatException e) {
            System.out.println("Aconteceu um erro: ");
            System.out.println(e.getMessage());


        }catch (IllegalArgumentException e){
            System.out.println("Alguma erro de argumento");
        } catch (ErroDeConversaoDeAndoException e){
            System.out.println(e.getMessage());
        }

        System.out.println("O programa finalizou com sucesso!");
    }
}
