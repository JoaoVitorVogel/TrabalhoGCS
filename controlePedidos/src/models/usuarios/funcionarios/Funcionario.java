package models.usuarios.funcionarios;

import java.util.ArrayList;

import models.usuarios.Usuario;

public class Funcionario extends Usuario {
    public Funcionario(String nome) {
        super(nome);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Nome: ");
        builder.append(this.getNome());
        builder.append(" | Tipo: ");
        builder.append("Funcionario");
        return builder.toString();
    }
}
