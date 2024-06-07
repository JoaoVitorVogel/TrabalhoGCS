package menus;

import models.usuarios.funcionarios.Funcionario;
import models.usuarios.funcionarios.FuncionariosControl;

public class Menu {
    private FuncionariosControl funcionariado;
    public static void main(String[] args) {
        Menu teste = new Menu();
        // teste.clearConsole();
        // teste.showLogo();
        // teste.showOptions();
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
}