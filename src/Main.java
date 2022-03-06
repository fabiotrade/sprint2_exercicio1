import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {

        Scanner scan = new Scanner(System.in);
        ProdutoDAO PD = new ProdutoDAO();
        int menu = 0;

        while (menu != 4){
            System.out.println("1 inserir");
            System.out.println("2 atualizar");
            System.out.println("3 excluir");
            System.out.println("4 sair");

            menu = scan.nextInt();
            switch (menu){
                case 1:
                    PD.insere();
                    break;

                case 2:
                PD.atualiza();
                break;

                case 3:
                    PD.exclui();
                    break;

                case 4:
                    System.out.println("Finalizando programa.");
                    break;

                default:
                    System.out.println("Opção inválida.");
                    break;

            }
        }


    }

}
