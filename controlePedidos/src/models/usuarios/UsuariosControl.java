package models.usuarios;
import java.util.ArrayList;

public class UsuariosControl {

private ArrayList<Usuario> todosUsuarios;

    public UsuariosControl() {
        this.todosUsuarios = new ArrayList<>();
    }

    public ArrayList<Usuario> getTodosUsuarios() {
        return this.todosUsuarios;
    }
 
    public ArrayList<Usuario> getFuncionarios() {
        ArrayList<Usuario> funcionarios;
        funcionarios = new ArrayList<>();
        for( Usuario u : this.todosUsuarios ){
            if(!u.getDepartamento().equals("Administrador")){
                funcionarios.add(u);
            }
        }
        return funcionarios;
    }

    public ArrayList<Usuario> getAdministradores() {
        ArrayList<Usuario> administradores;
        administradores = new ArrayList<>();
        for( Usuario u : this.todosUsuarios ){
            if(u.getDepartamento().equals("Administrador")){
                administradores.add(u);
            }
        }
        return administradores;
    }

    public Usuario addUsuario(Usuario u) {
        this.todosUsuarios.add(u);
        return u;
    }
  
    public Usuario removeUsuario(Usuario u) {
        Usuario toRemove = null;
        for (Usuario uu : todosUsuarios) {
            if (u == uu) {
                toRemove = u;
                todosUsuarios.remove(u);
            }
        }
        if (toRemove == null) throw new NullPointerException("Usuario não encontrado");
        return toRemove; 
    } 
}
