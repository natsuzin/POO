import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Bem vindo");
        ArrayList<Pedido> pedidos = new ArrayList<Pedido>();
        ArrayList<Cliente> clientes = new ArrayList<Cliente>();
        ArrayList<Produto> produtos = new ArrayList<Produto>();


        Scanner input = new Scanner(System.in);
        int resposta = 0;
        while(6 != resposta){
            System.out.println("\nO que voce deseja fazer? ");
            System.out.println("1) Fazer um pedido");
            System.out.println("2) Cadastrar Cliente");
            System.out.println("3) Listar Clientes");
            System.out.println("4) Cadastrar Produtos");
            System.out.println("5) Listar Produtos");
            System.out.println("6) Sair");

            resposta = input.nextInt();

            switch (resposta) {
                case 1 -> pedido(clientes, produtos, pedidos);
                case 2 -> cadastra_cliente(clientes, null, true);
                case 3 -> lista_cliente(clientes);
                case 4 -> cadastra_produto(produtos);
                case 5 -> lista_produto(produtos);
                default -> System.out.println("Entrada Invalida");
            }
        }
    }

    public static void pedido(ArrayList<Cliente> clientes, ArrayList<Produto> produtos, ArrayList<Pedido> pedidos){
        Scanner input = new Scanner(System.in);
        System.out.println("PEDIDO:");
        ArrayList<ItemPedido> itemPedidos = new ArrayList<ItemPedido>();

        char resposta = ' ';
        while(resposta != 'S' && resposta != 'N') {
            System.out.println("O pedido é para entrega? [S/N]");
            try {
                resposta = (char) System.in.read();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        boolean entrega;
        if(resposta == 'S') {
            entrega = true;
        } else{
            entrega = false;
        };
        input.nextLine();
        System.out.println("insira seu telefone: ");
        String telefone = input.nextLine();

        Cliente cliente = encontra_cliente(clientes, telefone, entrega);

        Pedido pedido = new Pedido(cliente,entrega);

        resposta = 'S';
        while(resposta == 'S') {
            lista_produto(produtos);
            System.out.println("\nInsira o codigo do produto que deseja comprar: ");

            int idProduto = input.nextInt();

            System.out.println("Quantos deseja comprar?");
            int quantidade = input.nextInt();

            Produto produto = null;

            for(Produto prod : produtos) {
                if(prod.getCodigo() == idProduto){
                    produto = prod;
                }
            }
            if(resposta == 'S'){
                pedido.adicionarItem(new ItemPedido(produto, quantidade));
                System.out.println("Item adicionado!");
            }
            System.out.println("Mais um produto? [S/N]");
            try {
                resposta = (char) System.in.read();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        double preco = 0;

        for (ItemPedido itemPedido : pedido.getProdutos() ){

            preco += itemPedido.getProduto().getPreco()* itemPedido.getQuantidade();
        }
        pedido.setValor(preco);

        System.out.println("VALOR DO PEDIDO: ");
        System.out.printf("PEDIDO:  %.2f\n", pedido.getValor());
        System.out.printf("ENTREGA:  %.2f\n", pedido.getTaxa_entrega());
        System.out.printf("TOTAL:  %.2f\n", pedido.obterPrecoTotal());

        int formaDePagamento = 0;
        while(formaDePagamento != 1 && formaDePagamento != 2) {
            System.out.println("FORMA DE PAGAMENTO: 1-DINHEIRO 2-CARTAO");
            formaDePagamento = input.nextInt();
        }
        double pagamento;
        if(formaDePagamento == 1){
            System.out.println("PRECISA DE TROCO PRA QUANTO");
            pagamento = input.nextDouble();
            pedido.setTroco(pagamento-pedido.obterPrecoTotal());
            System.out.printf("TROCO:  %.2f\n", pedido.getTroco());

        }
        pedidos.add(pedido);

        System.out.printf("PEDIDO REALIZADO EM %s!\n", pedido.getData().toString());
        System.out.println(pedido);

    }

    public static Cliente encontra_cliente(ArrayList<Cliente> clientes,String telefone, boolean entrega){
        Scanner input = new Scanner(System.in);
        for(Cliente cliente : clientes) {
            if(cliente.getTelefone().equals(telefone)){
                if (!(cliente.getEndereco() == null)){
                    return cliente; // cliente cadastrado COM endereco
                }
                System.out.println("Sem endereco cadastrado");
                System.out.println("insira seu endereco: ");
                String endereco = input.nextLine();

                cliente.setEndereco(endereco);
                return cliente; // cliente cadastrado SEM endereco
            }
        }
            return cadastra_cliente(clientes, telefone, entrega );
    }
    public static Cliente cadastra_cliente (ArrayList<Cliente> clientes, String telefone, boolean entrega){
        Scanner input = new Scanner(System.in);
        Cliente cliente;
        System.out.println("Nome: ");
        String nome = input.nextLine();

        if(telefone == null || telefone.length() == 0){
            System.out.println("telefone: ");
            telefone = input.nextLine();
        }
        if(entrega) {
            System.out.println("endereco: ");
            String endereco = input.nextLine();
            cliente = new Cliente(nome,endereco,telefone);
        } else{
            cliente = new Cliente(nome,telefone);
        }
        clientes.add(cliente);
        System.out.println("novo cliente cadastrado!");
        System.out.println(cliente);
        return cliente;
    }

    public static Produto cadastra_produto (ArrayList<Produto> produtos){
        Scanner input = new Scanner(System.in);

        System.out.println("Nome: ");
        String nome = input.nextLine();
        System.out.println("Codigo do produto: ");
        int id = input.nextInt();
        System.out.println("Preco: ");
        double preco = input.nextDouble();
        Produto produto = new Produto(id,nome,preco);
        produtos.add(produto);


        return produto;
    }

    public static void lista_cliente (ArrayList<Cliente> clientes){
        Scanner input = new Scanner(System.in);
        System.out.println("CLIENTES: ");
        for(Cliente cliente : clientes) {
            System.out.println(cliente.toString());
        }
    }
    public static void lista_produto (ArrayList<Produto> produtos){
        Scanner input = new Scanner(System.in);
        System.out.println("PRODUTOS: ");
        for(Produto produto : produtos) {
            System.out.println(produto.toString());
        }
    }
    }