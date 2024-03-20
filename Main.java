package fila;
import java.util.Calendar;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        // Obtendo a data atual
        Calendar cal = Calendar.getInstance();
        Date dataAtual = cal.getTime();

        cal.add(Calendar.DAY_OF_MONTH, -32);
        Date dataTrintaDiasAtras = cal.getTime();

        cal.add(Calendar.DAY_OF_MONTH, -1);
        Date dataOntem = cal.getTime();

        // Criando um novo objeto Calendar para calcular a data de 30 dias depois da data atual
        Calendar calLimite = Calendar.getInstance();
        calLimite.setTime(dataAtual);
        calLimite.add(Calendar.DAY_OF_MONTH, 30);
        Date dataLimite = calLimite.getTime();

        // Criação de alguns usuários, livros e aluguéis para teste
        Usuario usuario1 = new Usuario();
        usuario1.setNome("João");
        
        Usuario usuario2 = new Usuario();
        usuario2.setNome("Maria");
        
        Usuario usuario3 = new Usuario();
        usuario3.setNome("Pedro");
        
        Usuario usuario4 = new Usuario();
        usuario4.setNome("Ana");
        
        Usuario usuario5 = new Usuario();
        usuario5.setNome("Carlos");
        
        Livro livro1 = new Livro();
        livro1.setTitulo("O Senhor dos Anéis");
        livro1.setQuantidadeTotal(1);
        livro1.setQuantidadeLivre(1);
        
        Livro livro2 = new Livro();
        livro2.setTitulo("Harry Potter");
        livro2.setQuantidadeTotal(3);
        livro2.setQuantidadeLivre(3);

        
        Aluguel aluguel1 = new Aluguel(usuario1, livro1, dataTrintaDiasAtras, dataOntem );
        aluguel1.alugarLivro(livro1, usuario1);
        
        Aluguel aluguel2 = new Aluguel(usuario2, livro1, dataAtual, dataLimite);
        aluguel2.alugarLivro(livro1, usuario2);
        
        Aluguel aluguel3 = new Aluguel(usuario3, livro2, dataAtual, dataLimite);
        aluguel3.alugarLivro(livro2, usuario3);
        

        aluguel1.devolverLivro(usuario1, livro1);
        aluguel3.devolverLivro(usuario3, livro2);
    }
}

