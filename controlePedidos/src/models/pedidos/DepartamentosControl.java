package models.pedidos;
import java.util.ArrayList;

public class DepartamentosControl {
  private ArrayList<Departamento> todosDepartamentos;

  public DepartamentosControl() {
      this.todosDepartamentos = new ArrayList<>();
  }

  public ArrayList<Departamento> getTodosDepartamentos() {
      return this.todosDepartamentos;
  }

  public Departamento addDepartamento(Departamento d) {
    this.todosDepartamentos.add(d);
    return d;
}
}
