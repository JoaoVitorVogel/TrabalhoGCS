package models.usuarios.funcionarios;

import models.usuarios.TipoUsuario;

// import java.util.ArrayList;

import models.usuarios.Usuario;
import models.usuarios.TipoUsuario;

public class Funcionario extends Usuario {
    public Funcionario(String nome, String departamento) {
        super(nome, departamento, TipoUsuario.ADMINISTRADOR);
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
