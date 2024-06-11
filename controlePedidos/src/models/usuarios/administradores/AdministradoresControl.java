package models.usuarios.administradores;

import java.util.ArrayList;

public class AdministradoresControl {
    private ArrayList<Administrador> todosAdministradores;

    public AdministradoresControl() {
        this.todosAdministradores = new ArrayList<>();
    }

    public ArrayList<Administrador> getTodosAdministradores() {
        return this.todosAdministradores;
    }

    public Administrador addFuncionario(Administrador a) {
        this.todosAdministradores.add(a);
        return a;
    }
    
    public Administrador removeFuncionario(Administrador a) {
      Administrador toRemove = null;
        for (Administrador aa : todosAdministradores) {
            if (a == aa) {
                toRemove = a;
                todosAdministradores.remove(a);
            }
        }
        if (toRemove == null) throw new NullPointerException("Funcionario não encontrado");
        return toRemove; 

    }
}
