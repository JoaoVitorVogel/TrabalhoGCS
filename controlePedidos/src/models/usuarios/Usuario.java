package models.usuarios;

import java.util.ArrayList;

import models.pedidos.Departamento;

public class Usuario {
    private ArrayList<Usuario> usuarios_gerados;
    private int id;

    protected String nome;
    protected Departamento departamento;
    private TipoUsuario tipo;


    public Usuario(String nome, Departamento departamento, TipoUsuario tipo) {
        setId();
        this.nome = nome;
        this.departamento = departamento;
        this.tipo = tipo;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String newNome) {
        this.nome = newNome;
    }

    public Departamento getDepartamento() {
        return this.departamento;
    }

    public int getId() {
        return this.id;
    }
    
    private void setId() {
        if (usuarios_gerados == null) usuarios_gerados = new ArrayList<>();
        int newId = usuarios_gerados.size();
        this.id = newId;
        usuarios_gerados.add(this);
    }

    public TipoUsuario getTipo() {
        return tipo;
    }
}


