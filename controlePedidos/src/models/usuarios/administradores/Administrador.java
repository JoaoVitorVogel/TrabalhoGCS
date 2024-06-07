package models.usuarios.administradores;

import java.util.ArrayList;

import models.usuarios.Usuario;

public class Administrador extends Usuario {
    ArrayList<Administrador> administradores_gerados;
    
    public Administrador(String nome) {
        super(nome);
        if (administradores_gerados.size() <= 0) administradores_gerados = new ArrayList<>();
        administradores_gerados.add(this);
    }
}
