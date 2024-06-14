package models.pedidos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import models.usuarios.Usuario;

public class Pedido {
    private static int contadorId = 1;

    private int id;
    private Date data_pedido;
    private Date data_conclusao;
    private StatusPedido status;
    private double valor_total; 
    private Departamento departamento;
    private Usuario solicitante;
    private ArrayList<Item> itens;

    public Pedido(
        Date data_pedido, 
        Date data_conclusao, 
        StatusPedido status, 
        double valor_total,
        Departamento departamento,
        Usuario solicitante,
        ArrayList<Item> itens
        ) {
            this.id = contadorId++;
            this.data_pedido = data_pedido;
            this.data_conclusao = data_conclusao;
            this.status = status;
            this.valor_total = valor_total;
            this.departamento = departamento;
            this.solicitante = solicitante;
            this.itens = itens;
            
        }


    public int getId() { return id; }

    public Date getDataPedido() { return this.data_pedido; }

    public void setDataPedido(Date data_pedido) { this.data_pedido = data_pedido; }

    public Date getDataConclusao() { return this.data_conclusao; }

    public void setDataConclusao(Date data_conclusao) { this.data_conclusao = data_conclusao; }

    public StatusPedido getStatus() { return this.status; }

    public void setStatus(StatusPedido newStatus) { this.status = newStatus; }
    
    public Usuario getSolicitante() { return this.solicitante; }

    public void addItem(Item item) { itens.add(item); }

    private void atualizaValorTotal() {
        if (itens.size() == 0 || itens == null) {
            this.valor_total = 0;
        } else {
            for (Item item : itens) {
                valor_total += item.getValorTotal();
            }
        }

    }

    public List<Item> getItens() { return itens; }

    public double getValorTotal() {
        atualizaValorTotal();
        return this.valor_total;
    }

    public Departamento getDepartamento() { return departamento; }


    @Override
    public String toString() {
        return "Pedido [id=" + id + ", data_pedido=" + data_pedido + ", data_conclusao=" + data_conclusao + ", status="
                + status + ", valor_total=" + valor_total + ", departamento=" + departamento + ", solicitante="
                + solicitante + ", itens=" + itens.toString() + "]";
    }
    
}
