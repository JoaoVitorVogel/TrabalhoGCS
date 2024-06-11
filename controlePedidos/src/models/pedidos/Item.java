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
        atualiza_valor_total();
    }

    public String getDescricao() { return this.descricao; }

    public void setDescricao(String newDesc) { this.descricao = newDesc; }

    public int getQuantidade() { return this.quantidade; }

    public void setQuantidade(int newQuantidade) { 
        this.quantidade = newQuantidade; 
        atualiza_valor_total(); 
    }

    public void addQuantidade(int valorToAdd) {
        this.quantidade += valorToAdd;
        atualiza_valor_total();
     }

    public double getValorUn() { return this.valor_un; }

    public void setValorUn(double newValorUn) {
        this.valor_un = newValorUn;
        atualiza_valor_total();
    }

    public double getValorTotal() { return this.valor_total; }

    private void atualiza_valor_total() {
        this.valor_total = this.quantidade * this.valor_un;
    }
    
}
