package fila;
import java.util.ArrayList;
import java.util.Date;

public class Usuario {
    String nome, endereco, senha;
    ArrayList<String> livroPosse = new ArrayList<>(5);
    ArrayList<String> livrosesperando= new ArrayList<>();
    
    public void listadelivros(String nomelivro){
         livroPosse.add(nomelivro);
    }
    public void esperando(String nomeLivro){
          livrosesperando.add(nomeLivro);
    }
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

    public String getsenha() {
        return senha;
    }

    public void setsenha(String senha) {
        this.senha = senha;
    }
}


