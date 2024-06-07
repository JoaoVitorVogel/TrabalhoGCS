import menus.Menu;

public class App {
    public static void main(String[] args) throws Exception {
        Menu teste = new Menu();
        teste.clearConsole();
        teste.showLogo();
        teste.showOptions();
        teste.showTodosFuncionarios();
    }
}
