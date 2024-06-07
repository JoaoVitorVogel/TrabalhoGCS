package models.usuarios;

import java.util.ArrayList;

public class Usuario {
    private ArrayList<Usuario> usuarios_gerados;
    private int id;

    protected String nome;
    protected String departamento;

    public Usuario(String nome, String departamento) {
        setId();
        this.nome = nome;
        this.departamento = departamento;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String newNome) {
        this.nome = newNome;
    }

    public String getDepartamento() {
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
}


