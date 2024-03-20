package fila;
import java.util.Queue;
import java.util.LinkedList;

public class Livro {
    String titulo, autor;
    int quantidadeTotal, quantidadeLivre;
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
        } else if(alugarOuDevolver.equals("alugar") && quantidadeLivre == 0){
            addFila(usuario);
        } else if(alugarOuDevolver.equals("devolver") && quantidadeLivre != quantidadeTotal){
            if (!filaAluguel.isEmpty()) {
                filaAluguel.poll();
            } else {
                quantidadeLivre++;
            }
        } else {
            System.out.println("Algo deu errado, tente novamente");
        }
    }
    
    public void addFila(Usuario usuario){
        filaAluguel.add(usuario);
    }
}

