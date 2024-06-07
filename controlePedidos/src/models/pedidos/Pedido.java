package models.pedidos;

import java.util.ArrayList;
import java.util.Date;

import models.usuarios.funcionarios.Funcionario;

public class Pedido {
    private Date data_pedido;
    private Date data_conclusao;
    private StatusPedido status;
    private double valor_total; 
    private Funcionario funcionario;
    private ArrayList<Item> itens;

    public Pedido(
        Date data_pedido, 
        Date data_conclusao, 
        StatusPedido status, 
        double valor_total,
        // departamento??
        Funcionario funcionario
        ) {
            this.data_pedido = data_pedido;
            this.data_conclusao = data_conclusao;
            this.status = status;
            this.valor_total = valor_total;
            this.funcionario = funcionario;
            this.itens = new ArrayList<Item>();
            // departamento
        }

    public Date getDataPedido() { return this.data_pedido; }

    public void setDataPedido(Date data_pedido) { this.data_pedido = data_pedido; }

    public Date getDataConclusao() { return this.data_conclusao; }

    public void setDataConclusao(Date data_conclusao) { this.data_conclusao = data_conclusao; }

    public StatusPedido getStatus() { return this.status; }

    public void setStatus(StatusPedido newStatus) { this.status = newStatus; }

    public Funcionario getFuncionario() { return this.funcionario; }

    public void addItem(Item item) { itens.add(item); }

    private void atualiza_valor_total() {
        if (itens.size() == 0 || itens == null) {
            this.valor_total = 0;
        } else {
            for (Item item : itens) {
                valor_total += item.getValorTotal();
            }
        }

    }

    public double getValorTotal() {
        atualiza_valor_total();
        return this.valor_total;
    }
}
