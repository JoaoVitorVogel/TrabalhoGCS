import menus.Menu;

public class App {
    public static void main(String[] args) throws Exception {
        Menu menu = new Menu();
        menu.clearConsole();
        menu.showLogo();
        menu.showOptions();
        menu.criarUsuarios();
        menu.criarDepartamentos();
        menu.showTodosFuncionarios();
    }
}
