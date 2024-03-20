package fila;
import java.util.Date;
import java.util.Queue;
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
    public void alugar(Livro livro, Usuario usuario){
        if (disponibilidadelivro(livro)) {
            livro.alugar("alugar", usuario);
        } else {
            livro.addfila(usuario);
        }

    }
    public void devolver(Usuario usuario, Livro livro){
      livro.alugar("devolver", usuario);
    }
    public boolean disponibilidadelivro(Livro livro){
        if (livro.quantidadelivre > 0) {
            return true;
        }else{
            return false;
        }
    }

    public void calcularMulta() {
        Date hoje = new Date(); 
        if (hoje.after(dataFinal)) {
            long diferencaMillis = hoje.getTime() - dataFinal.getTime();
            long diferencaDias = diferencaMillis / (1000 * 60 * 60 * 24);

            multaTotal = diferencaDias * multaDiaria;
        } else {
            multaTotal = 0.0f;
        }
    }

    public float getMultaTotal() {
        return multaTotal;
    }

}
