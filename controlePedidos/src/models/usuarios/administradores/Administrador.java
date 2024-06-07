package models.usuarios.administradores;

// import java.util.ArrayList;

import models.usuarios.Usuario;

public class Administrador extends Usuario {
    // ArrayList<Administrador> administradores_gerados;
    
    public Administrador(String nome, String departamento) {
        super(nome, departamento);
        // if (administradores_gerados.size() <= 0) administradores_gerados = new ArrayList<>();
        // administradores_gerados.add(this);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Nome: ");
        builder.append(this.getNome());
        builder.append(" | Tipo: ");
        builder.append("Administrador");
        builder.append(" | Departamento: ");
        builder.append(this.getDepartamento());
        return builder.toString();
    }
}
