package models.pedidos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import models.usuarios.*;
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
    public List<Pedido> buscarPedidosPorDescricaoItem(String descricao) {
        List<Pedido> pedidosComDescricao = new ArrayList<>();
        for (Pedido pedido : pedidos) {
            for (Item item : pedido.getItens()) {
                if (item.getDescricao().contains(descricao)) {
                    pedidosComDescricao.add(pedido);
                    break;
                }
            }
        }
        return pedidosComDescricao;
    }

    public Pedido buscarPedidoPorId(int id) {
        for (Pedido pedido : pedidos) {
            if (pedido.getId() == id) {
                return pedido;
            }
        }
        return null;
    }

    public void avaliarPedido(int id, StatusPedido novoStatus, Usuario administrador) {
        if (administrador.getTipo() != TipoUsuario.ADMINISTRADOR) {
            throw new IllegalArgumentException("Somente administradores podem avaliar pedidos.");
        }

        Pedido pedido = buscarPedidoPorId(id);
        if (pedido != null && pedido.getStatus() == StatusPedido.ABERTO) {
            pedido.setStatus(novoStatus);
            if (novoStatus == StatusPedido.APROVADO || novoStatus == StatusPedido.REPROVADO) {
                pedido.setDataConclusao(new Date());
            }
        } else {
            throw new IllegalArgumentException("Pedido não encontrado ou já avaliado.");
        }
    }

    public List<Pedido> listarPedidosAbertos() {
        List<Pedido> pedidosAbertos = new ArrayList<>();
        for (Pedido pedido : pedidos) {
            if (pedido.getStatus() == StatusPedido.ABERTO) {
                pedidosAbertos.add(pedido);
            }
        }
        return pedidosAbertos;
    }
    public EstatisticasPedidos gerarEstatisticas() {
        return new EstatisticasPedidos(pedidos);
    }

}
