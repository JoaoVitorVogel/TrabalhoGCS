package models.pedidos;

public class Item {
    private String descricao;
    private int quantidade;
    private double valor_un;
    private double valor_total;

    public Item(String descricao, int quantidade, double valor_un) {
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.valor_un = valor_un;
        atualizaValorTotal();
    }

    public String getDescricao() { return this.descricao; }

    public void setDescricao(String newDesc) { this.descricao = newDesc; }

    public int getQuantidade() { return this.quantidade; }

    public void setQuantidade(int newQuantidade) { 
        this.quantidade = newQuantidade; 
        atualizaValorTotal(); 
    }

    public void addQuantidade(int valorToAdd) {
        this.quantidade += valorToAdd;
        atualizaValorTotal();
     }

    public double getValorUn() { return this.valor_un; }

    public void setValorUn(double newValorUn) {
        this.valor_un = newValorUn;
        atualizaValorTotal();
    }

    public double getValorTotal() { return this.valor_total; }

    private void atualizaValorTotal() {
        this.valor_total = this.quantidade * this.valor_un;
    }
    
}
