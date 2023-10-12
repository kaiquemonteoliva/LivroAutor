import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ArrayList<Livro> listaNovoL = new ArrayList<>();

        Livro novoLv = new Livro();
        Autor novoAt = new Autor();


        System.out.println("Bem vindo ao nosso sistema");

        Scanner scanner = new Scanner(System.in);

        int opcao;

        do {

            System.out.println("Escolha uma opcao: 1 Cadastrar livro, 2 Listar livro, 0 sair");
            opcao = scanner.nextInt();

            switch (opcao){

                case 1:
                    System.out.println("Digite o nome do autor: ");
                    novoAt.nome = scanner.next();

                    System.out.println("Digite o local de nascimento: ");
                    novoAt.localNasc = scanner.next();

                    novoLv.autor = novoAt;

                    System.out.println("Digite o Titulo do livro: ");
                    novoLv.titulo = scanner.next();

                    System.out.println("Digite o preco: ");
                    novoLv.preco = scanner.nextInt();

                    System.out.println("Digite a data de lancamento (dd/MM/yyyy): ");
//                    novoLv.dataLancamento = LocalDate.parse(scanner.next()).atStartOfDay();
                    LocalDate date = LocalDate.parse(scanner.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                    Period periodo = Period.between(date, LocalDate.now());

                    novoLv.dataLancamento = date.atStartOfDay();

                    if(periodo.getYears() >= 5){
                        System.out.println("O livro pode ser cadastrado");
                    }else {
                        System.out.println("O livro nao pode ser cadastrado");
                    }


                    listaNovoL.add(novoLv);
                    System.out.println("Cadastro realizado com sucesso!!!");



                    break;

                case 2:

                    if(listaNovoL.size() > 0){
                        for (Livro cadaLivro: listaNovoL) {
                            System.out.println();
                            System.out.println("Nome: " + cadaLivro.autor.nome);
                            System.out.println("Local de nascimento: " + cadaLivro.autor.localNasc);
                            System.out.println("Titulo:" + cadaLivro.titulo);
                            System.out.println("Preco: " + cadaLivro.preco);
                            System.out.println("Data de lancamento: " + cadaLivro.dataLancamento.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                            scanner.nextLine();
                        }

                        opcao = scanner.nextInt();
                    }else {
                        System.out.println("Lista Vazia!");
                    }
                    break;

                case 0:
                    System.out.println("Voce saiu");


            }



        }while (opcao != 0);

    }

}