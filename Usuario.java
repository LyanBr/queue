package fila;
import java.util.ArrayList;
import java.util.Date;

public class Usuario {
    String nome, endereco;
    ArrayList<String> livroPosse = new ArrayList<>(5);
    Date dataNascimento;
    Date dataAtual;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public ArrayList<String> getLivroPosse() {
        return livroPosse;
    }

    public void setLivroPosse(ArrayList<String> livroPosse) {
        this.livroPosse = livroPosse;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
}


