import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Pedido {
    private Cliente cliente;
    private List<ItemPedido> produtos;
    private boolean entrega;
    private double taxa_entrega;
    private double valor;
    private int forma_pagamento;
    private double troco;
    private LocalDate data;

    public Pedido(Cliente cliente, boolean entrega) {
        this.cliente = cliente;
        this.entrega = entrega;
        this.taxa_entrega = 10D;
        this.produtos = new ArrayList<ItemPedido>();
        this.data = LocalDate.now();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<ItemPedido> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<ItemPedido> produtos) {
        this.produtos = produtos;
    }

    public boolean isEntrega() {
        return entrega;
    }

    public void setEntrega(boolean entrega) {
        this.entrega = entrega;
    }

    public double getTaxa_entrega() {
        return taxa_entrega;
    }

    public void setTaxa_entrega(double taxa_entrega) {
        this.taxa_entrega = taxa_entrega;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getForma_pagamento() {
        return forma_pagamento;
    }

    public void setForma_pagamento(int forma_pagamento) {
        this.forma_pagamento = forma_pagamento;
    }

    public double getTroco() {
        return troco;
    }

    public void setTroco(double troco) {
        this.troco = troco;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }


    public void adicionarItem(ItemPedido item){
        this.produtos.add(item);
    }
    public double obterPrecoTotal(){

        return this.getValor() + this.getTaxa_entrega();
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "cliente=" + cliente +
                ", produtos=" + produtos +
                ", entrega=" + entrega +
                ", taxa_entrega=" + taxa_entrega +
                ", valor=" + valor +
                ", forma_pagamento=" + forma_pagamento +
                ", troco=" + troco +
                ", data=" + data +
                '}';
    }
}
