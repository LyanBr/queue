package fila;
import java.util.Calendar;
import java.util.Date;

public class Aluguel {
    private Usuario usuario;
    private Livro livro;
    private Date dataAluguel;
    private Date dataFinal; 
    private float multaDiaria;
    private float multaTotal;

    // Construtor
    public Aluguel(Usuario usuario, Livro livro, Date dataAluguel, Date dataFinal) {
        this.usuario = usuario;
        this.livro = livro;
        this.dataAluguel = dataAluguel;
        this.dataFinal = dataFinal;
        this.multaDiaria = 5.0f; 
        this.multaTotal = 0.0f;
    }

    public void alugarLivro(Livro livro, Usuario usuario){
        if (disponibilidadeLivro(livro)) {
            livro.alugarLivro("alugar", usuario);
        } else {
            livro.addFila(usuario);
        }
    }

    public void devolverLivro(Usuario usuario, Livro livro){
        System.out.println(getMultaTotal(usuario));
        if (multaTotal > 0) {
            livro.alugarLivro("devolver", usuario); 
        } else {
            livro.alugarLivro("devolver", usuario);
        }
        
        
    }

    public boolean disponibilidadeLivro(Livro livro){
        return livro.getQuantidadeLivre() > 0;
    }

    public void calcularMulta() {
        Calendar cal = Calendar.getInstance();
        Date hoje = cal.getTime();
        if (hoje.after(dataFinal)) {
            long diferencaMillis = hoje.getTime() - dataFinal.getTime();
            long diferencaDias = diferencaMillis / (1000 * 60 * 60 * 24);

            multaTotal = diferencaDias * multaDiaria;
        } else {
            multaTotal = 0;
        }
    }

    public String getMultaTotal(Usuario usuario) {
        calcularMulta();
        if (multaTotal > 0) {
            return usuario.getNome()+ " seu prazo Expirou, você está com uma multa de: " + multaTotal;
        } 
        return "você está dentro do prazo";
    }
}

