package models.usuarios.funcionarios;

import java.util.ArrayList;

public class FuncionariosControl {
    private ArrayList<Funcionario> todosFuncionarios;

    public FuncionariosControl() {
        this.todosFuncionarios = new ArrayList<>();
    }

    public ArrayList<Funcionario> getTodosFuncionarios() {
        return this.todosFuncionarios;
    }

    public Funcionario addFuncionario(Funcionario f) {
        this.todosFuncionarios.add(f);
        return f;
    }
    
    public Funcionario removeFuncionario(Funcionario f) {
        Funcionario toRemove = null;
        for (Funcionario ff : todosFuncionarios) {
            if (f == ff) {
                toRemove = f;
                todosFuncionarios.remove(f);
            }
        }
        if (toRemove == null) throw new NullPointerException("Funcionario não encontrado");
        return toRemove; 

    }
}
