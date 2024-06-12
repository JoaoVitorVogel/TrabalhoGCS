import java.util.Scanner;

import menus.Menu;

public class App {
    public static void main(String[] args) throws Exception {
        @SuppressWarnings("resource")
        Scanner leitorInput = new Scanner(System.in);

        Menu menu = new Menu();
        int opcaoSelecionada = 1;

        while (opcaoSelecionada != 0) {
                
            menu.showLogo();
            menu.showOptions();

            opcaoSelecionada = leitorInput.nextInt();
            System.out.println("Você escolheu a opção: " + opcaoSelecionada);

            switch (opcaoSelecionada) {
                case 0:
                    System.out.println("Programa encerrado.");
                    break;
                case 1:
                    menu.showTodosFuncionarios();
                    break;
                case 2:
                    menu.showTodosAdministradores();
                    break;
                case 3:
                    menu.showTodosUsuarios();
                    break;
                case 4:
                    menu.showDepartamentos();
                    break;
                case 5:
                    menu.showPedidos();
                    break;
            } 
        }  
    }
}
