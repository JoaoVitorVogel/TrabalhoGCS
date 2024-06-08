package models.pedidos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import models.pedidos.Pedido;
import models.usuarios.Usuario;
import models.usuarios.funcionarios.Funcionario;

public class SistemaControlePedidos {
    private List<Pedido> pedidos;

    public SistemaControlePedidos() {
        this.pedidos = new ArrayList<>();
    }

    public void registrarPedido(
        Date data_pedido, 
        Date data_conclusao, 
        StatusPedido status, 
        double valor_total,
        Departamento departamento,
        Funcionario funcionario,
        Usuario solicitante, 
        ArrayList<Item> itens) {
        Pedido novoPedido = new Pedido(new Date(), new Date(), status, valor_total, departamento, funcionario, solicitante, itens);
        pedidos.add(novoPedido);
    }


    public List<Pedido> listarPedidosEntreDatas(Date dataInicial, Date dataFinal) {
        List<Pedido> pedidosEntreDatas = new ArrayList<>();
        for (Pedido pedido : pedidos) {
            Date dataPedido = pedido.getDataPedido();
            if (dataPedido.after(dataInicial) && dataPedido.before(dataFinal)) {
                pedidosEntreDatas.add(pedido);
            }
        }
        return pedidosEntreDatas;
    }

    public List<Pedido> buscarPedidosPorSolicitante(Usuario solicitante) {
        List<Pedido> pedidosDoSolicitante = new ArrayList<>();
        for (Pedido pedido : pedidos) {
            if (pedido.getSolicitante().equals(solicitante)) {
                pedidosDoSolicitante.add(pedido);
            }
        }
        return pedidosDoSolicitante;
    }
}
