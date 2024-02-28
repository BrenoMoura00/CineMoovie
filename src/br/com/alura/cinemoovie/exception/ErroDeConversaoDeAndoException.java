package br.com.alura.cinemoovie.exception;

public class ErroDeConversaoDeAndoException extends RuntimeException {
private String mensagem;
    public ErroDeConversaoDeAndoException(String mensagem) {
this.mensagem = mensagem;
    }

    @Override
    public String getMessage() {
        return this.mensagem;
    }
}
