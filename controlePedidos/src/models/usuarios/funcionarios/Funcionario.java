package models.usuarios.funcionarios;

// import java.util.ArrayList;

import models.usuarios.Usuario;

public class Funcionario extends Usuario {
    public Funcionario(String nome, String departamento) {
        super(nome, departamento);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Nome: ");
        builder.append(this.getNome());
        builder.append(" | Tipo: ");
        builder.append("Funcionario");
        builder.append(" | Departamento: ");
        builder.append(this.getDepartamento());
        return builder.toString();
    }
}
