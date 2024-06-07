package menus;

import models.usuarios.funcionarios.Funcionario;
// import models.usuarios.funcionarios.FuncionariosControl;
import models.usuarios.administradores.Administrador;
import models.usuarios.UsuariosControl;
import models.usuarios.Usuario;

import java.io.*;
import java.util.Scanner;

public class Menu {
    // private FuncionariosControl funcionariado;
    private UsuariosControl usuarios;

    public Menu() {
        // funcionariado = new FuncionariosControl();
        usuarios = new UsuariosControl();
    }

    public void showTodosFuncionarios() {
        // Usuario testador = new Funcionario("testador", "almoxarifado");
        // Usuario adm = new Administrador("adm", "almoxarifado");

        // usuarios.addUsuario(adm);
        // usuarios.addUsuario(testador);

        System.out.println("Mostrando todos funcionaros:");
        int indexCount = 0;
        for (Usuario f : usuarios.getTodosUsuarios()) {
            StringBuilder builder = new StringBuilder("[");
            builder.append(indexCount);
            builder.append("] ");
            builder.append(f.toString());
            System.out.println(builder.toString());
            indexCount++;
        }

        System.out.println();
        System.out.println("Selecione um funcionario pelo numero ou digite 0 para sair: ");
        System.out.println();
    }

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

            // instancia usuarios com tokens como atributos;
            Usuario usuario = new Usuario(token1, token2);
            
            usuarios.addUsuario(usuario);
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
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }
}