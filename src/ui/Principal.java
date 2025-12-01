package ui;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        int opcao = 1;

        System.out.println("Ride Sharing Iniciado");
        do {
            System.out.println("1- Cadastrar Passageiro");
            System.out.println("2- Cadastrar Motorista");
            System.out.println("3- Cadastrar Veículo");
            System.out.println("4- Status Motorista");
            System.out.println("5- Solicitar Corrida");
            System.out.println("6- Iniciar Viagem");
            System.out.println("7- Finalizar Viagem");
            System.out.println("8- Cancelar Viagem");
            System.out.println("9- Processar Pagamento ");
            System.out.println("10- Corridas em andamento");
            System.out.println("11- Listar Motoristas");
            System.out.println("12- Listar Passageiros");
            System.out.println("13- Avaliar Motorista");
            System.out.println("14- Avaliar Passageiro");
            System.out.println("0- Sair");

            System.out.print("Escolha uma opção: ");
            try {
                opcao = Integer.parseInt(ler.nextLine());
                switch (opcao) {
                    case 0:
                        System.out.println("Saindo...");
                        break;
                    case 1:
                        cadastrarPassageiro();
                        break;
                    case 2:
                        cadastrarMotorista();
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                    case 5:
                        break;
                    case 6:
                        break;
                    case 7:
                        break;
                    case 8:
                        break;
                    case 9:
                        break;
                    case 10:
                        break;
                    case 11:
                        break;
                    case 12:
                        break;
                    case 13:
                        break;
                    case 14:
                        break;
                    default:
                        System.out.println("Opção INVÁLIDA. Tente novamente.");
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Opção INVÁLIDA. Digite um número.");
            }

            if (opcao != 0) {
                System.out.println("Pressione ENTER para continuar...");
                ler.nextLine();
            }

        } while (opcao != 0);
    }

    private static void cadastrarMotorista() {
        System.out.println("Cadastro de motorista realizado."); // Colocar codigo aq dps
    }

    private static void cadastrarPassageiro() {
        System.out.println("Cadastro de passageiro realizado."); //Mudar isso dps
    }
}