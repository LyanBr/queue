package fila;
import java.util.Scanner;
import java.util.Queue;
import java.util.ArrayList;
public class Livro {
    String titulo, autor;
    int quantidadetotal,quantidadelivre;
    Queue filaaluguel;
    ArrayList listaalugado;
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
    public int getQuantidadetotal() {
        return quantidadetotal;
    }
    public void setQuantidadetotal(int quantidadetotal) {
        this.quantidadetotal = quantidadetotal;
    }
    public int getQuantidadelivre() {
        return quantidadelivre;
    }
    public void setQuantidadelivre(int quantidadelivre) {
        this.quantidadelivre = quantidadelivre;
    }
    public void alugar(String alugaroudevolver, Usuario usuario){
        if (alugaroudevolver == "alugar" & quantidadelivre > 0) {
            quantidadelivre = quantidadelivre-1;
            listaalugado.add(usuario); 
        } else if(alugaroudevolver == "alugar" & quantidadelivre == 0){
             addfila(usuario);
        }
         else if(alugaroudevolver == "devolver" & quantidadelivre != quantidadetotal){
            listaalugado.remove(usuario);
            if (!filaaluguel.isEmpty()) {
                listaalugado.add(filaaluguel.poll()); 
            }else{
                quantidadelivre = quantidadelivre+1;
            }
        }else{
            System.out.println("algo deu errado, tente denovo");
        }
    }
    public void addfila(Usuario usuario){
        filaaluguel.add(usuario);

    }


}
