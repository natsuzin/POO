import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Produto> produtos = new ArrayList<Produto>();
        ArrayList<Perecivel> pereciveis = new ArrayList<Perecivel>();

        // menu

        Scanner input = new Scanner(System.in);
        int resposta = 0;
        while(4 != resposta){
            System.out.println("\nO que voce deseja fazer? ");
            System.out.println("1) Incluir um produto");
            System.out.println("2) Vender um produto");
            System.out.println("3) Listar os produtos");
            System.out.println("4) Sair");
            resposta = input.nextInt();

            switch (resposta) {
                case 1 -> inclusao(produtos,pereciveis);
                case 2 -> venda(produtos,pereciveis);
                case 3 -> listagem(produtos,pereciveis);
                case 4 -> System.out.println("Saindo...");
                default -> System.out.println("Entrada Invalida");
            }
        }
    }


    public static void inclusao(ArrayList<Produto> produtos, ArrayList<Perecivel> pereciveis){
        Scanner input = new Scanner(System.in);
        System.out.println("INCLUSÃO DE PRODUTO");
        System.out.println("Nome: ");
        String nome = input.nextLine();
        System.out.println("id: ");
        int id = input.nextInt();
        System.out.println("Quantidade: ");
        int quantidade = input.nextInt();
        System.out.println("Preço de venda: R$");
        double preco = input.nextDouble();

        char resposta = ' ';
        while(resposta != 'S' && resposta != 'N') {
            System.out.println("É perecível? [S/N] ");
            try {
                resposta = (char) System.in.read();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            if (resposta == 'N') {
                Produto novoProduto = new Produto(nome,id,quantidade,preco);
                produtos.add(novoProduto);

            } else if (resposta == 'S'){
                System.out.println("Digite a validade do produto: ");
                System.out.println("Dia: ");
                int dia = input.nextInt();
                System.out.println("Mês: ");
                int mes = input.nextInt();
                System.out.println("Ano: ");
                int ano = input.nextInt();
                String validade = convertToDate(dia,mes,ano);
                Perecivel novoPerecivel = new Perecivel(nome,id,quantidade,preco,validade);
                pereciveis.add(novoPerecivel);
                System.out.println("Inclusão confirmada!");
            }
        }
    }

    public static void venda(ArrayList<Produto> produtos, ArrayList<Perecivel> pereciveis){
        Scanner input = new Scanner(System.in);
        System.out.println("VENDA DE PRODUTO");

        char resposta = ' ';
        while(resposta != 'S' && resposta != 'N') {
            System.out.println("É perecível? [S/N] ");

            try {
                resposta = (char) System.in.read();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("Id do produto:");
        int id = input.nextInt();
        if (resposta == 'N') {
            for (Produto produto : produtos) {
                if(produto.getId() == id){
                    System.out.println("Quantidade a ser vendida:");
                    int quantidade = input.nextInt();

                    if(quantidade > produto.getQuantidade()){
                        System.out.println("Quantidade superior ao estoque, venda cancelada.");
                        return;
                    }

                    System.out.println("Informações da venda: ");
                    System.out.printf("Quantidade vendida: %d \n", quantidade);
                    System.out.printf("Preço Unitario: %s \n", produto.getPreco());
                    System.out.printf("Preço total: %s \n", quantidade*produto.getPreco());

                    char confirma = ' ';
                    while(confirma != 'S' && confirma != 'N') {
                        System.out.println("Confirma Venda? [S/N]: ");
                        try {
                            confirma = (char) System.in.read();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    if(confirma == 'N'){
                        System.out.println("Venda cancelada.");
                        return;
                    } else {
                        produto.setQuantidade(produto.getQuantidade()-quantidade);
                        System.out.println("Venda realizada.");
                    }


                }
            }

        } else {
            for (Perecivel perecivel : pereciveis) {
                if(perecivel.getId() == id){
                    System.out.println("Quantidade a ser vendida:");
                    int quantidade = input.nextInt();

                    if(quantidade > perecivel.getQuantidade()){
                        System.out.println("Quantidade superior ao estoque, venda cancelada.");
                        return;
                    }
                    if(perecivel.estaVencido()){
                        System.out.println("Produto vencido, venda cancelada.");
                        return;
                    }
                    double preco = perecivel.getPreco();
                    if(perecivel.getValidade().minusDays(1).equals(LocalDate.now())){
                        System.out.println("Produto com desconto");
                        System.out.println("Insira a porcentagem: ");
                        double porcentagem = input.nextDouble();
                        preco = perecivel.aplicaDesconto(porcentagem);
                    }
                    System.out.println("Informações da venda: ");
                    System.out.printf("Quantidade vendida: %d \n", quantidade);
                    System.out.printf("Preço unitário: %s \n", preco);
                    System.out.printf("Preço total: %s \n", quantidade*preco);

                    char confirma = ' ';
                    while(confirma != 'S' && confirma != 'N') {
                        System.out.println("Confirma venda? [S/N]: ");
                        try {
                            confirma = (char) System.in.read();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    if(confirma == 'N'){
                        System.out.println("Venda cancelada.");
                        return;
                    } else {
                        perecivel.setQuantidade(perecivel.getQuantidade()-quantidade);
                        System.out.println("Venda realizada.");
                    }
                }
            }


        }
    }

    public static void listagem(ArrayList<Produto> produtos, ArrayList<Perecivel> pereciveis){
        System.out.printf("\nProdutos não perecíveis: [%d]\n", produtos.size());
        for (Produto produto : produtos) {
            System.out.println(produto.display());
        }
        System.out.printf("\nProdutos perecíveis: [%d]\n", pereciveis.size());
        for (Perecivel perecivel : pereciveis) {
            System.out.println(perecivel.display());
        }
    }
    public static String convertToDate(int dia, int mes, int ano){
        return ano + "-" + String.format("%02d", mes) + "-" + String.format("%02d", dia);
    }
}
