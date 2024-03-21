package fila;
import java.util.Queue;
import java.util.LinkedList;

public class Livro {
    String titulo, autor;
    int quantidadeTotal, quantidadeLivre,idLivro;
    public int getIdLivro() {
        return idLivro;
    }

    public void setIdLivro(int idLivro) {
        this.idLivro = idLivro;
    }

    Queue<Usuario> filaAluguel = new LinkedList<>();
    
    public String getTitulo() {
        return titulo;
    }
    
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
    public String getAutor() {
        return autor;
    }
    
    public void setAutor(String autor) {
        this.autor = autor;
    }
    
    public int getQuantidadeTotal() {
        return quantidadeTotal;
    }
    
    public void setQuantidadeTotal(int quantidadeTotal) {
        this.quantidadeTotal = quantidadeTotal;
    }
    
    public int getQuantidadeLivre() {
        return quantidadeLivre;
    }
    
    public void setQuantidadeLivre(int quantidadeLivre) {
        this.quantidadeLivre = quantidadeLivre;
    }
    
    public void alugarLivro(String alugarOuDevolver, Usuario usuario){
        if (alugarOuDevolver.equals("alugar") && quantidadeLivre > 0) {
            quantidadeLivre--;
            System.out.println(usuario.getNome() + " alugou o livro " + titulo);
            usuario.listadelivros(titulo);
        } else if(alugarOuDevolver.equals("alugar") && quantidadeLivre == 0){
            addFila(usuario);
            usuario.esperando(titulo);
        } else if(alugarOuDevolver.equals("devolver") && quantidadeLivre != quantidadeTotal){
            if (!filaAluguel.isEmpty()) {
               Usuario esperando= filaAluguel.poll();
                System.out.println(usuario.getNome() + " devolveu o livro " + titulo);
                System.out.println(esperando.getNome() + " alugou o livro " + titulo+" pois estava na fila de espera");
                esperando.listadelivros(titulo);
                
            } else {
                quantidadeLivre++;
                System.out.println(usuario.getNome() + " devolveu o livro " + titulo);
            }
        } else {
            System.out.println("Algo deu errado, tente novamente");
        }
    }
    
    public void addFila(Usuario usuario){
        filaAluguel.add(usuario);
        System.out.println(usuario.getNome() + " foi adicionado à fila de espera para o livro " + titulo);
    }
}


