package models.pedidos;


import java.util.Date;
import java.util.List;

public class EstatisticasPedidos {
    private long totalPedidos;
    private long pedidosAprovados;
    private long pedidosReprovados;
    private long pedidosUltimos30Dias;
    private double valorMedioUltimos30Dias;
    private double valorTotalUltimos30Dias;
    private Pedido pedidoMaiorValorAberto;

    public EstatisticasPedidos(List<Pedido> pedidos) {
        this.gerarEstatisticas(pedidos);
    }

    private void gerarEstatisticas(List<Pedido> pedidos) {
        this.totalPedidos = pedidos.size();
        this.pedidosAprovados = 0;
        this.pedidosReprovados = 0;
        this.pedidosUltimos30Dias = 0;
        this.valorTotalUltimos30Dias = 0;

        Date dataLimite = new Date(System.currentTimeMillis() - 30L * 24 * 60 * 60 * 1000);

        for (Pedido pedido : pedidos) {
            if (pedido.getStatus() == StatusPedido.APROVADO) {
                pedidosAprovados++;
            } else if (pedido.getStatus() == StatusPedido.REPROVADO) {
                pedidosReprovados++;
            }
            if (pedido.getDataPedido().after(dataLimite)) {
                pedidosUltimos30Dias++;
                valorTotalUltimos30Dias += pedido.getValorTotal();
            }
        }

        this.valorMedioUltimos30Dias = pedidosUltimos30Dias > 0 ? valorTotalUltimos30Dias / pedidosUltimos30Dias : 0;

        this.pedidoMaiorValorAberto = null;
        for (Pedido pedido : pedidos) {
            if (pedido.getStatus() == StatusPedido.ABERTO) {
                if (pedidoMaiorValorAberto == null || pedido.getValorTotal() > pedidoMaiorValorAberto.getValorTotal()) {
                    pedidoMaiorValorAberto = pedido;
                }
            }
        }
    }

    public long getTotalPedidos() {
        return totalPedidos;
    }

    public long getPedidosAprovados() {
        return pedidosAprovados;
    }

    public long getPedidosReprovados() {
        return pedidosReprovados;
    }

    public long getPedidosUltimos30Dias() {
        return pedidosUltimos30Dias;
    }

    public double getValorMedioUltimos30Dias() {
        return valorMedioUltimos30Dias;
    }

    public double getValorTotalUltimos30Dias() {
        return valorTotalUltimos30Dias;
    }

    public Pedido getPedidoMaiorValorAberto() {
        return pedidoMaiorValorAberto;
    }

    @Override
    public String toString() {
        return "EstatisticasPedidos{" +
                "totalPedidos=" + totalPedidos +
                ", pedidosAprovados=" + pedidosAprovados +
                ", pedidosReprovados=" + pedidosReprovados +
                ", pedidosUltimos30Dias=" + pedidosUltimos30Dias +
                ", valorMedioUltimos30Dias=" + valorMedioUltimos30Dias +
                ", valorTotalUltimos30Dias=" + valorTotalUltimos30Dias +
                ", pedidoMaiorValorAberto=" + pedidoMaiorValorAberto +
                '}';
    }
}