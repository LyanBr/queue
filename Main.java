package fila;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        // pegar as datas que vou usar no sistema
        Calendar cal = Calendar.getInstance();
        Date dataAtual = cal.getTime();

        cal.add(Calendar.DAY_OF_MONTH, -32);
        Date dataTrintaDiasAtras = cal.getTime();

        cal.add(Calendar.DAY_OF_MONTH, -1);
        Date dataOntem = cal.getTime();

        Calendar calLimite = Calendar.getInstance();
        calLimite.setTime(dataAtual);
        calLimite.add(Calendar.DAY_OF_MONTH, 30);
        Date dataLimite = calLimite.getTime();

        Scanner scanner = new Scanner(System.in);
        ArrayList<Usuario> usuarios = new ArrayList<>();
        int contadorUsuarios = 0; // Inicializa o contador de usuários
        ArrayList<String> usuariosRegistrados = new ArrayList<>();
        ArrayList<String> senhasRegistradas = new ArrayList<>();
        ArrayList<Aluguel> alugueís = new ArrayList<>();
        int contadoralugueis = 0; // Inicializa o contador de usuários
        ArrayList<Livro> livros = new ArrayList<>();
        int contadorlivros = 0; // Inicializa o contador de usuários
        Usuario usuarioLogado = null;

        // Adicione alguns usuários registrados para fins de demonstração
        usuariosRegistrados.add("admin");
        senhasRegistradas.add("admin");
        Usuario admin= new Usuario();
        admin.nome="admin";
        admin.senha="admin";
        usuarios[0]=admin;
        usuariosRegistrados.add("sair");
        Usuario sair= new Usuario();
        sair.nome="sair";
   
       

        while (true) {
            int opcao = 0;
             if (usuarioLogado==null) {
                System.out.println("Bem-vindo ao sistema de gerenciamento de biblioteca!");
                System.out.println("Selecione uma opção:");
                System.out.println("1. Fazer login");
                System.out.println("2. Fazer cadastro de usuário");
                System.out.println("3. Sair");
                opcao = scanner.nextInt();
                switch (opcao) {
                    case 1:
                        // Login
                        usuarioLogado = fazerLogin(scanner, usuariosRegistrados, senhasRegistradas, usuarios);
                        break;
                    case 2:
                        // Cadastro de novo usuário
                        Usuario novoUsuario = criarUsuario(contadorUsuarios); // Cria um novo usuário com o contador atual
                        usuarios.add(novoUsuario); // Adiciona o novo usuário à lista de usuário
                        usuariosRegistrados.add(novoUsuario.nome);
                        senhasRegistradas.add(novoUsuario.senha);
                        contadorUsuarios++; // Incrementa o contador para o próximo usuário
                        usuarioLogado = novoUsuario; // Define o novo usuário como o usuário logado
                        break;
                    case 3:
                        usuarioLogado=sair;
                        System.out.println("Saindo do sistema...");
                        return;
                    default:
                    System.out.println("Opção inválida. Por favor, selecione uma opção válida.");
                }
            }
            else if(usuarioLogado.nome!="sair"){
                if (usuarioLogado.nome=="admin") {
                    System.out.println("Bem vindo, "+ usuarioLogado.nome+ " Escolha uma opção.");
                    System.out.println("1. Cadastrar livro");
                    System.out.println("2. Cadastrar Usuario");
                    System.out.println("3. verificar disponibilidade de Livro");
                    System.out.println("4. Sair");
                    System.out.println("5. Deslogar");
                    opcao = scanner.nextInt();
                    switch (opcao) {

                        case 1:
                           Livro novolivro = criarLivro(contadorlivros);
                           livros.add(novolivro);
                            break;
                        case 2:
                            // Cadastro de novo usuário
                            Usuario novoUsuario = criarUsuario(contadorUsuarios); // Cria um novo usuário com o contador atual
                            usuarios.add(novoUsuario); // Adiciona o novo usuário à lista de usuário
                            usuariosRegistrados.add(novoUsuario.nome);
                            senhasRegistradas.add(novoUsuario.senha);
                            contadorUsuarios++; // Incrementa o contador para o próximo usuário
                        
                            break;
                        case 3:
                            Scanner ler = new Scanner(System.in);
                            String livroprocurado= ler.nextLine();
                            Livro livro= selecionarlivro(livroprocurado, livros);
                             if (livro.getQuantidadeLivre() > 0) {
                                System.out.println("O livro "+livro+" Têm "+livro.getQuantidadeLivre()+" Cópias disponíveis.");
                                
                             } else {
                                System.out.println("O livro "+livro+" Não têm mais cópias disponíveis.");
                             }
                          
                           
                            break;
                        case 4:
                            usuarioLogado=sair;
                            System.out.println("Saindo do sistema...");
                            return;
                        case 5:
                            usuarioLogado=null;
                            System.out.println("Deslogado...");
                            return;    
                        default:
                            System.out.println("Opção inválida. Por favor, selecione uma opção válida.");
                    }
                    
                } else {
                    System.out.println("Bem vindo, "+ usuarioLogado.nome+ " Escolha uma opção.");
                    System.out.println("1. verificar livros alugados");
                    System.out.println("2. verificar livros em espera para aluguel");
                    System.out.println("3. Alugar livro");
                    System.out.println("4. Devolver livro");
                    System.out.println("5. Sair");
                    System.out.println("6. Deslogar");
                    opcao = scanner.nextInt();
                switch (opcao) {

                    case 1:
                      System.out.println(usuarioLogado.nome+" Você têm os seguintes Livros alugados: " +usuarioLogado.livroPosse);
                        break;
                    case 2:
                    System.out.println(usuarioLogado.nome+" Você está na fila de espera dos seguintes livros: " +usuarioLogado.livrosesperando);
                        break;
                    case 3:
                      Scanner ler = new Scanner(System.in);
                      String livroprocurado= ler.nextLine();
                      Livro livro= selecionarlivro(livroprocurado, livros);
                      Aluguel novoAluguel = criarAluguel(usuarioLogado, livro, dataAtual, dataLimite, contadoralugueis); // Cria um novo usuário com o contador atual
                      alugueís.add(novoAluguel); // Adiciona o novo usuário à lista de usuário
                       
                        break;
                    case 4:
                        // Implemente o código para devolver livro
                        break;
                    case 5:
                        usuarioLogado=sair;
                        System.out.println("Saindo do sistema...");
                        return;
                    case 6:
                        usuarioLogado=null;
                        System.out.println("Deslogado...");
                        return;    
                    default:
                        System.out.println("Opção inválida. Por favor, selecione uma opção válida.");
                }
                    
                }
                

            }
            
        }
    }

    private static Livro selecionarlivro(String livroprocurado, ArrayList<Livro> livros) {
        Livro livroEncontrado = null;
        for (Livro livro : livros) {
            if (livro.getTitulo().equals(livroprocurado)) {
                livroEncontrado = livro;
                return livroEncontrado;
            }
        
        
        
    }
    return livroEncontrado;
}

    public static Usuario fazerLogin(Scanner scanner, ArrayList<String> usuariosRegistrados, ArrayList<String> senhasRegistradas, ArrayList<Usuario> usuarios) {
        System.out.println("Login:");
        System.out.print("Usuário: ");
        String usuario = scanner.next();
        System.out.print("Senha: ");
        String senha = scanner.next();
        Usuario usuarioEncontrado = null;
        for(Usuario u : usuarios){
            if (u.getNome()==usuario && u.getsenha()==senha) {
                System.out.println("Login bem-sucedido!");
                usuarioEncontrado=u;
                return usuarioEncontrado;
                
            }
            else{
                System.out.println("Usuário ou senha incorretos.");
                return null;
            }
        }
        System.out.println("fudeu");
        return null;
    }

    public static Usuario criarUsuario(int numeroUsuario) {
        Scanner scanner = new Scanner(System.in);
        Usuario novoUsuario = new Usuario();
        
        System.out.println("Cadastro de novo usuário:");

        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        novoUsuario.setNome(nome);

        System.out.print("Endereço: ");
        String endereco = scanner.nextLine();
        novoUsuario.setEndereco(endereco);

        System.out.print("senha: ");
        String senha = scanner.nextLine();
        novoUsuario.setsenha(senha);
        

        System.out.println("Usuário cadastrado com sucesso! Número de usuário: " + numeroUsuario);

        return novoUsuario;
    }
    public static Aluguel criarAluguel(Usuario usuario, Livro livro, Date dataaluguel, Date dataLimite,int contador) {
        Scanner scanner = new Scanner(System.in);
        Aluguel novoAluguel = new Aluguel(usuario,livro,dataaluguel,dataLimite);

        return novoAluguel;
    }
    public static Livro criarLivro(int numeroLivro) {
        Scanner scanner = new Scanner(System.in);
        Livro novoLivro = new Livro();
        
        System.out.println("Cadastro de novo Livro:");

        novoLivro.setIdLivro(numeroLivro);

        System.out.print("titulo: ");
        String nome = scanner.nextLine();
        novoLivro.setTitulo(nome);

        System.out.print("Autor: ");
        String autor = scanner.nextLine();
        novoLivro.setAutor(autor);

        System.out.print("Quantidade: ");
        int quantidade = scanner.nextInt();
        novoLivro.setQuantidadeTotal(quantidade);
        novoLivro.setQuantidadeLivre(quantidade);
        
        

        System.out.println("Livro cadastrado com sucesso! Número de Livro: " + numeroLivro);

        return novoLivro;
    }


        
 
}