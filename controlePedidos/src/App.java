import java.util.Scanner;

import menus.Menu;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner leitorInput = new Scanner(System.in);

        Menu menu = new Menu();
        menu.clearConsole();
        menu.showLogo();
        menu.showOptions();
        // menu.showTodosFuncionarios();

        int opcaoSelecionada = leitorInput.nextInt();
        System.out.println("Você escolheu a opção: " + opcaoSelecionada);

        switch (opcaoSelecionada) {
            case 0:
            System.out.println("Programa encerrado.");
            break;
            case 1:
                menu.showTodosFuncionarios();
            case 2:
                menu.showTodosAdministradores();
            case 3:
                menu.showTodosUsuarios();
            case 4:
                menu.showDepartamentos();
            case 5:
                menu.showPedidos();
        }   
     }
}
