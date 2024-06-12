import java.util.Scanner;

import menus.Menu;
import models.pedidos.Item;
import java.util.ArrayList;

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

                    while (opcaoSelecionada != 9 && opcaoSelecionada != 0) {
                        
                        System.out.println("[1] Registrar novo pedido\n");
                        System.out.println("[2] Ver pedidos\n");
                        System.out.println("[9] Trocar de usuario\n");
                        System.out.println("[0] Sair da aplicacao\n");

                        opcaoSelecionada = leitorInput.nextInt(); 

                        switch (opcaoSelecionada) {
                            case 1:

                                ArrayList<Item> itens;
                                itens = new ArrayList<>();
                                double valor_total = 0;
                                String opcao = "s";

                                while (opcao.equals("s")) {

                                    System.out.println("Informe a descricao do item: ");
                                    String descricao = leitorInput.next();

                                    System.out.println("Informe a quantidade do item: ");
                                    int quantidade = leitorInput.nextInt();

                                    System.out.println("Informe o valor unitario do item: ");
                                    double valor_un = leitorInput.nextDouble();
                                
                                    Item item = new Item(descricao, quantidade, valor_un);
                                    itens.add(item);

                                    valor_total = valor_total + item.getValorTotal();

                                    System.out.println("Deseja adicionar mais itens? ('s' ou 'n')");
                                    opcao = leitorInput.next();
                                }
                                menu.cadastraPedido(valor_total, itens);
                                System.out.println("Pedido cadastrado");
                                break;
                            
                            case 2:
                                menu.showPedidos();
                                break;
                        
                            default:
                                break;
                        }
                    }
                    break;
            }
        }
    }
}
