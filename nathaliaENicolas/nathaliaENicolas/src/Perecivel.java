import java.time.LocalDate;

public class Perecivel extends Produto{

    private LocalDate validade;

    public Perecivel(String nome, int id, int quantidade, double preco, String validade) {
        super(nome, id, quantidade, preco);
        this.validade = LocalDate.parse(validade);
    }

    public LocalDate getValidade() {
        return validade;
    }

    public void setValidade(LocalDate validade) {
        this.validade = validade;
    }

    public boolean estaVencido(){
        LocalDate data = LocalDate.now();
        return data.isAfter(validade);
    }

    public double aplicaDesconto(double desconto){
        return super.getPreco() * (1-(desconto/100));
    }

    public String display() {
        return "Perecível{" +
                "validade: " + validade +
                ", id: " + super.getId() +
                ", nome: " + super.getNome() +
                ", quantidade: " + super.getQuantidade() +
                ", preco: " + super.getPreco() +
                '}';
    }
}
