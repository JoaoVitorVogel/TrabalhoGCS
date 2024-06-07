package models.usuarios;

import java.util.ArrayList;

public class Usuario {
    private ArrayList<Usuario> usuarios_gerados;

    private String nome;
    public String getNome() {
        return this.nome;
    }
    public void setNome(String newNome) {
        this.nome = newNome;
    }

    private int id;
    private void setId() {
        if (usuarios_gerados == null) usuarios_gerados = new ArrayList<>();
        int newId = usuarios_gerados.size();
        this.id = newId;
        usuarios_gerados.add(this);
    }
    public int getId() {
        return this.id;
    }

    public Usuario(String nome) {
        setId();
        this.nome = nome;
    }

}


