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
            System.out.println("[1] Mostrar todos usuarios\n");
            System.out.println("[0] Sair da aplicacao\n");

            opcaoSelecionada = leitorInput.nextInt();
            System.out.println("Você escolheu a opção: " + opcaoSelecionada);

            switch (opcaoSelecionada) {
                case 0:
                    System.out.println("Programa encerrado.");
                    break;
                case 1:
                    menu.showTodosUsuarios();
                    opcaoSelecionada = leitorInput.nextInt();
                    System.out.println("Você escolheu a opção: " + opcaoSelecionada);
                    if(opcaoSelecionada == 0){
                        break;
                    }
                    menu.selectUsuario(opcaoSelecionada);
                    break;
            } 
        }  
    }
}
