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

    public Departamento getDepartamentoByName(String nome) {
        for(Departamento d : todosDepartamentos){
            if(d.getNome().equals(nome)){
                return d;
            }
        }
        return null;
    }

    

  public Departamento addDepartamento(Departamento d) {
    this.todosDepartamentos.add(d);
    return d;
}
}
