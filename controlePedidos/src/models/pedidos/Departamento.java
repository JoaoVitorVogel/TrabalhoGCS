package models.pedidos;

public class Departamento {
  private String nome;
  private Double valorMax;

  public Departamento(String n, Double valor) {
    this.nome = n;
    this.valorMax = valor;
  }

  public String getNome() {
     return this.nome;
  }

  public Double getValorMax() {
    return this.valorMax;
  }
}
