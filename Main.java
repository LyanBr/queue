package fila;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        // Criação de alguns usuários, livros e aluguéis para teste
        Usuario usuario1 = new Usuario();
        usuario1.setNome("João");
        
        Livro livro1 = new Livro();
        livro1.setTitulo("O Senhor dos Anéis");
        livro1.setQuantidadeTotal(5);
        livro1.setQuantidadeLivre(3);
        
        Date dataAtual = new Date();
        Date dataFinal = new Date(dataAtual.getTime() + (1000 * 60 * 60 * 24 * 7)); //Adiciona uma semana à data atual
        
        Aluguel aluguel1 = new Aluguel(usuario1, livro1, dataAtual, dataFinal);
        aluguel1.alugarLivro(livro1, usuario1);
        
        System.out.println("Multa total: " + aluguel1.getMultaTotal()); //Imprime a multa total (deve ser 0.0 neste caso)
    }
}
