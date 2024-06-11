package menus;

import models.pedidos.*;
import models.usuarios.*;
import models.usuarios.administradores.*;
import models.usuarios.funcionarios.*;
import java.io.*;
import java.util.Scanner;

public class Menu {
    private UsuariosControl usuarios;
    private DepartamentosControl departamentos;

    public Menu() {
        usuarios = new UsuariosControl();
        departamentos = new DepartamentosControl();

        this.criarUsuarios();
        this.criarDepartamentos();
    }

    public void showTodosUsuarios() {
        System.out.println("Mostrando todos usuarios:");
        int indexCount = 1;
        for (Usuario u : usuarios.getTodosUsuarios()) {
            StringBuilder builder = new StringBuilder("[");
            builder.append(indexCount);
            builder.append("] ");
            builder.append(u.toString());
            System.out.println(builder.toString());
            indexCount++;
        }

        System.out.println();
        System.out.println("Selecione um usuario ou digite 0 para sair: ");
        System.out.println();
    }

    public void showTodosAdministradores() {
        System.out.println("Mostrando todos administradores:");
        int indexCount = 0;
        for (Usuario a : usuarios.getAdministradores()) {
            StringBuilder builder = new StringBuilder("[");
            builder.append(indexCount);
            builder.append("] ");
            builder.append(a.toString());
            System.out.println(builder.toString());
            indexCount++;
        }

        System.out.println();
        System.out.println("Selecione um administrador ou digite 0 para sair: ");
        System.out.println();
    }

    public void showTodosFuncionarios() {
        System.out.println("Mostrando todos funcionarios:");
        int indexCount = 1;
        for (Usuario u : usuarios.getFuncionarios()) {
            StringBuilder builder = new StringBuilder("[");
            builder.append(indexCount);
            builder.append("] ");
            builder.append(u.toString());
            System.out.println(builder.toString());
            indexCount++;
        }

        System.out.println();
        System.out.println("Selecione um funcionario ou digite 0 para sair: ");
        System.out.println();
    }

    public void showDepartamentos() {
        System.out.println("Mostrando todos departamentos:");
        int indexCount = 1;
        for (Departamento d : departamentos.getTodosDepartamentos()) {
            StringBuilder builder = new StringBuilder("[");
            builder.append(indexCount);
            builder.append("] ");
            builder.append(d.toString());
            System.out.println(builder.toString());
            indexCount++;
        }
    }

    public void showPedidos() {

    }

    // le o arquivo CSV "funcionarios" e cria as instancias de usuarios
    public void criarUsuarios() {
        Scanner scanner;  
        File csvFile = new File("funcionarios.csv");
        try {
          scanner = new Scanner(csvFile);
        
          // leitura das linhas
          while (scanner.hasNextLine()) {

            String line = scanner.nextLine();
            String[] tokens = line.split(","); // nome , departamento

            String token1 = tokens[0]; //nome
            String token2 = tokens[1]; //departamento

            Usuario usuario;

            // instancia usuarios com tokens como atributos;
            if (token2.equals("Administrador")) {
                usuario = new Administrador(token1, token2);

            } else {
                usuario = new Funcionario(token1, token2);
            }

            usuarios.addUsuario(usuario);
         }
           scanner.close();
    
        } catch (FileNotFoundException e) {
          e.printStackTrace();
        }
    }

    public void criarDepartamentos() {
        Scanner scanner;  
        File csvFile = new File("departamentos.csv");
        try {
          scanner = new Scanner(csvFile);
        
          // leitura das linhas
          while (scanner.hasNextLine()) {

            String line = scanner.nextLine();
            String[] tokens = line.split(","); // nomeDep , valorMax

            String token1 = tokens[0]; //nome Departamento
            Double token2 = Double.valueOf(tokens[1]); //valorMax pedidos

            Departamento departamento = new Departamento(token1, token2);

            departamentos.addDepartamento(departamento);
         }
           scanner.close();
    
        } catch (FileNotFoundException e) {
          e.printStackTrace();
        }
    }

    public void showOptions() {
        System.out.println("\n[1] Mostrar todos funcionarios");
        System.out.println("[2] Mostrar todos administradores");
        System.out.println("[3] Mostrar todos usuarios");
        System.out.println("[4] Ver departamentos");
        System.out.println("[5] Ver pedidos");
        System.out.println();
        System.out.println("[0] Sair da aplicacao\n");
    }

    public void showLogo() {
        System.out.println("\r\n" + //
                        "░▒▓██████████████▓▒░░▒▓█▓▒░░▒▓█▓▒░░▒▓██████▓▒░░▒▓███████▓▒░░▒▓███████▓▒░  \r\n" + //
                        "░▒▓█▓▒░░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░ \r\n" + //
                        "░▒▓█▓▒░░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░ \r\n" + //
                        "░▒▓█▓▒░░▒▓█▓▒░░▒▓█▓▒░░▒▓██████▓▒░░▒▓████████▓▒░▒▓███████▓▒░░▒▓███████▓▒░  \r\n" + //
                        "░▒▓█▓▒░░▒▓█▓▒░░▒▓█▓▒░  ░▒▓█▓▒░   ░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░      ░▒▓█▓▒░        \r\n" + //
                        "░▒▓█▓▒░░▒▓█▓▒░░▒▓█▓▒░  ░▒▓█▓▒░   ░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░      ░▒▓█▓▒░        \r\n" + //
                        "░▒▓█▓▒░░▒▓█▓▒░░▒▓█▓▒░  ░▒▓█▓▒░   ░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░      ░▒▓█▓▒░        \r\n" + //
                        "                                                                          \r\n" + //
                        "                                                                          \r\n" + //
                        "");
    }

    public void clearConsole() {
        //System.out.print("\033[H\033[2J");  
        //System.out.flush();  
    }
}