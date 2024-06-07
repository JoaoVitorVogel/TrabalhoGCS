package menus;

import models.usuarios.funcionarios.Funcionario;
import models.usuarios.funcionarios.FuncionariosControl;

public class Menu {
    private FuncionariosControl funcionariado;
    public static void main(String[] args) {
        Menu teste = new Menu();
        teste.clearConsole();
        teste.showLogo();
        teste.showOptions();
        teste.showTodosFuncionarios();
    }

    public Menu() {
        funcionariado = new FuncionariosControl();
    }

    public void showTodosFuncionarios() {
        Funcionario testador = new Funcionario("testador");
        funcionariado.addFuncionario(testador);
        System.out.println("Mostrando todos funcionaros:");
        int indexCount = 0;
        for (Funcionario f : funcionariado.getTodosFuncionarios()) {
            StringBuilder builder = new StringBuilder("[");
            builder.append(indexCount);
            builder.append("] ");
            builder.append(f.toString());
            System.out.println(builder.toString());
        }

        System.out.println();
        System.out.println("Selecione um funcionario pelo numero ou digite 0 para sair: ");
        System.out.println();

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