package ui;
import entidades.*;
import servicos.*;

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;


public class Principal {

    public static void main(String[] args) {

        int opcao = 1;

        System.out.println(" ==== Ride Sharing Iniciado ====");
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

            System.out.print("Elerolha uma opção: ");
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
                        cadastrarVeiculo(selecionarMotorista());
                        break;
                    case 4:
                        alterarStatus();
                        break;
                    case 5:
                        solicitarCorrida();
                        break;
                    case 6:
                        finalizarViagem();
                        break;
                    case 7:
                        cancelarViagem();
                        break;
                    case 8:
                        processarPagamento();
                        break;
                    case 9:
                        verCorridas();
                        break;
                    case 10:
                        listarMotoristas();
                        break;
                    case 11:
                        listarPassageiros();
                        break;
                    case 12:
                        avaliarMotorista();
                        break;
                    case 13:
                        avaliarPassageiro();
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

    private static List<Passageiro> passageiros = new ArrayList<>();
    private static List<Motorista> motoristas = new ArrayList<>();
    private static List<Corrida> corridas = new ArrayList<>();

    static Scanner ler = new Scanner(System.in);

    private static void cadastrarPassageiro() {
        System.out.println("\n=== Cadastro de Passageiro ===");
        System.out.print("Nome: ");
        String nome = ler.nextLine();
        System.out.print("CPF: ");
        String cpf = ler.nextLine();
        System.out.print("Email: ");
        String email = ler.nextLine();
        System.out.print("Senha: ");
        String senha = ler.nextLine();
        System.out.print("Telefone: ");
        String telefone = ler.nextLine();


        Passageiro p = new Passageiro(nome, cpf, email, telefone, senha);
        passageiros.add(p);
        cadastrarMetodoPagamentoPassageiro(p);

        System.out.println("Cadastro de passageiro realizado."); //Mudar isso dps
    }

    private static void cadastrarMetodoPagamentoPassageiro(Passageiro m) {
        System.out.println("\n=== Cadastro de Método de Pagamento para Passageiro ===");

        if (m == null) return;

        System.out.println("Escolha o método de pagamento:");
        System.out.println("1 - Cartão de Crédito");
        System.out.println("2 - Pix");
        System.out.println("3 - Dinheiro");
        int escolha = Integer.parseInt(ler.nextLine());

        switch (escolha) {
            case 1:
                System.out.println("Digite o número do cartão de crédito:");
                String numeroCartao = ler.nextLine();
                System.out.println("Digite a bandeira do cartão:");
                String bandeira = ler.nextLine();
                System.out.println("Digite a validade do cartão (MM/AA):");
                String validade = ler.nextLine();
                System.out.println("Digite o CVV do cartão:");
                String cvv = ler.nextLine();
                MetodoPagamento c = new CartaoCredito(numeroCartao, bandeira, cvv, validade);
                m.setPagamento(c);
                break;
            case 2:
                System.out.println("Digite a chave Pix:");
                String chavePix = ler.nextLine();
                MetodoPagamento p = new Pix(chavePix);
                m.setPagamento(p);
                break;
            case 3:
                System.out.println("Digite um valor saldo:");
                Double s = ler.nextDouble();
                MetodoPagamento d = new Dinheiro(s);
                m.setPagamento(d);
                break;
            default:
                if (escolha !=1 || escolha !=2 || escolha !=3 ) {
                    cadastrarMetodoPagamentoPassageiro(m);
            };
        }
        System.out.println("Método de pagamento adicionado ao passageiro!");
    }

    }

    private static void cadastrarMotorista() {
        System.out.println("\n=== Cadastro de Motorista ===");
        System.out.print("Nome: ");
        String nome = Principal.ler.nextLine();
        System.out.print("CPF: ");
        String cpf = Principal.ler.nextLine();
        System.out.print("Senha: ");
        String senha = Principal.ler.nextLine();
        System.out.print("Email: ");
        String email = Principal.ler.nextLine();
        System.out.print("Telefone: ");
        String telefone = Principal.ler.nextLine();
        System.out.print("CNH: ");
        String cnh = Principal.ler.nextLine();

        Motorista m = new Motorista(nome, cpf, senha, email, telefone, cnh);
        cadastrarVeiculo(m);

        Principal.motoristas.add(m);


        System.out.println("Cadastro de motorista realizado."); // Colocar codigo aq dps
    }

    private static void cadastrarVeiculo(Motorista m) {
        System.out.println("Digite o modelo do carro: ");
        String modelo = Principal.ler.nextLine();
        System.out.println("Digite a cor do carro: ");
        String cor = Principal.ler.nextLine();
        System.out.println("Digite a placa do carro: ");
        String placa = Principal.ler.nextLine();
        System.out.println("Digite o ano de fabricação do carro: ");
        int anoFab = Principal.ler.nextInt();
        System.out.println("Digite o ano do modelo do carro: ");
        int anoModelo =  Principal.ler.nextInt();
        Veiculo c = new Veiculo(modelo, cor, placa, anoFab, anoModelo);
        m.setCarro(c);

        System.out.println("Cadastro de veículo realizado.");
    }

    private static void alterarStatus() {

        System.out.println("Status alterado");
    }

    private static void solicitarCorrida() {
        int preco = 0;
        System.out.println("Digite o local de partida: ");
        String localPartida = Principal.ler.nextLine();
        System.out.println("Digite o local de chegada: ");
        String localFinal = Principal.ler.nextLine();
        System.out.println("Digite a distância da viagem (em Kms): ");
        Double kilometragem = Double.parseDouble(Principal.ler.nextLine());

        Corrida c = new Corrida(localPartida, localFinal, kilometragem);
        Principal.corridas.add(c);
        System.out.println("A sua corrida parte de " + localPartida + " até " + localFinal + " e tem " + kilometragem + "kms de distância");

        System.out.println("Categoria:");
        System.out.println("1. Comum");
        System.out.println("2. Luxo");
        int G = Integer.parseInt(Principal.ler.nextLine());
        CategoriaCorrida categoria = (c == 1 ? new CategoriaComum() : new CategoriaLuxo());

        if (G == 1){
            categoria.calcularPreco(5,1,kilometragem);
        }else if (G == 2){
            categoria.calcularPreco(9,2.20,kilometragem);
        }
        System.out.println("O preço da viagem é igual a " + categoria.getPreco());
        System.out.println("Corrida solicitada");
    }


    private static void finalizarViagem() {
        Corrida c = selecionarMotorista();
        if(c.isViagemIniciada() == true){
        c.finalizarViagem();}
    }

private static Motorista selecionarMotorista() {
    for (int i = 0; i < Principal.motoristas.size(); i++) {
        System.out.println(i + "_" + Principal.motoristas.get(i).toString());
    }
    System.out.println("Escolha um motorista: ");
    return Principal.motoristas.get(Integer.parseInt(Principal.ler.nextLine()));
}

private static Corrida selecionarViagem() {
    for (int i = 0; i < Principal.corridas.size(); i++) {
        System.out.println(i + "_" + Principal.corridas.get(i).toString());
    }
    System.out.println("Escolha uma  viagem: ");
    return Principal.corridas.get(Integer.parseInt(Principal.ler.nextLine()));
}

private static void cancelarViagem() {
        Corrida c = selecionarViagem();
        if(c.isViagemIniciada() == true){
            c.finalizarViagem();
        }
    }

    private static void processarPagamento() {

        System.out.println("Pagamento processado");
    }

    private static void verCorridas() {
        System.out.println("Corridas: ");
    for (Corrida c : Principal.corridas) {
        System.out.println("-------------------------");

        System.out.println("Inicio " + c.getLocalPartida());
        System.out.println("Fim " + c.getLocalFinal());
        System.out.println("Distância: " + c.getKilometragem());
        System.out.println("-------------------------");
    }

    }

    private static void listarMotoristas() {
        System.out.println("Motoristas: ");
        for (Motorista m : Principal.motoristas) {
            System.out.println("-------------------------");
            System.out.println("Nome: " + m.getNome());
            System.out.println("Carro " + m.getCarro());
            System.out.println("CNH: " + m.getCnh());
            System.out.println("Status atual: " + m.getStatusMotorista());
            System.out.println("-------------------------");
        }


    }

    private static void listarPassageiros() {
        System.out.println("Passageiros: ");
        for (Passageiro m : Principal.passageiros) {
            System.out.println("-------------------------");
            System.out.println("Nome: " + m.getNome());
            System.out.println("CPF: " + m.getCpf());
            System.out.println("Email " + m.getEmail());
            System.out.println("Saldo pendente?" + m.isSaldoPendente());
            System.out.println("-------------------------");
        }

    }

    private static void avaliarMotorista() {
        System.out.println("==Avaliar motoristas==");
        System.out.println("Qual motorista você quer avaliar: ");


    }

    private static void avaliarPassageiro() {
        System.out.println("==Avaliar passageiros==");
        System.out.println("Qual passageiro você quer avaliar: ");


    }
}