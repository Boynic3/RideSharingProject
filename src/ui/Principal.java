package ui;
import entidades.*;
import enums.StatusMotorista;
import servicos.*;

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;


public class Principal {

    public static void main(String[] args) {

        int opcao = 1;
        testeInicializarDados();
        System.out.println(" ==== Ride Sharing Iniciado ====");
        do {
            System.out.println("1- Cadastrar Passageiro");
            System.out.println("2- Cadastrar Motorista");
            System.out.println("3- Cadastrar Veículo");
            System.out.println("4- Status Motorista");
            System.out.println("5- Solicitar Corrida");
            System.out.println("6- Finalizar Viagem");
            System.out.println("7- Cancelar Viagem");
            System.out.println("8- Processar Pagamento ");
            System.out.println("9- Corridas em andamento");
            System.out.println("10- Listar Motoristas");
            System.out.println("11- Listar Passageiros");
            System.out.println("12- Avaliar Motorista");
            System.out.println("13- Avaliar Passageiro");
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

        System.out.println("Cadastro de passageiro realizado.\n"); //Mudar isso dps
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
        System.out.println("Método de pagamento adicionado ao passageiro!\n");

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

        Motorista m = new Motorista(nome, cpf, senha, email, telefone, cnh, "OFFLINE");
        cadastrarVeiculo(m);

        Principal.motoristas.add(m);


        System.out.println("Cadastro de motorista realizado.\n"); // Colocar codigo aq dps
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

        System.out.println("Cadastro de veículo realizado.\n");
    }

    private static void alterarStatus() {
        if (Principal.motoristas.isEmpty()) {
            System.out.println("Não há motoristas cadastrados.");
            return;
        }
        System.out.println("==Alterar status do motorista==");
        Motorista m = selecionarMotorista();
        System.out.println("Status atual: " + m.getStatusMotorista());
        System.out.println("Defina o novo status de " + m.getNome() + ": ");
        System.out.println("1- Online\n2- Offline");
        int statusEscolhido = Integer.parseInt(Principal.ler.nextLine());
        if (statusEscolhido == 1) {
            m.setStatusMotorista("ONLINE");
        } else if (statusEscolhido == 2) {
            m.setStatusMotorista("OFFLINE");
        } else {
            System.out.println("Status inválido. Operação cancelada.");
            return;
        }
        System.out.println("Status alterado");
    }

    private static void solicitarCorrida() {
        int preco = 0;
        System.out.println("==Solicitar Corrida==");

        System.out.println("Qual é o passageiro?");
        Passageiro p = selecionarPassageiro();

        if (p == null) {
            System.out.println("Passageiro inválido ou cancelado.");
            return;
        }

        System.out.println("Escolha um Motorista disponível (ONLINE):");


        java.util.List<Motorista> disponiveis = new java.util.ArrayList<>();

        for (Motorista mot : Principal.motoristas) {
            if (mot.getStatusMotorista() == StatusMotorista.ONLINE) {
                disponiveis.add(mot);
            }
        }

        if (disponiveis.isEmpty()) {
            System.out.println("Nenhum motorista online no momento.");
            return;
        }

        for (int i = 0; i < disponiveis.size(); i++) {
            System.out.println((i + 1) + "- " + disponiveis.get(i).getNome());
        }

        int escolhaMot = Integer.parseInt(Principal.ler.nextLine());

        if (escolhaMot < 1 || escolhaMot > disponiveis.size()) {
            System.out.println("Opção inválida.");
            return;
        }

        Motorista m = disponiveis.get(escolhaMot - 1);
        System.out.println("Motorista " + m.getNome() + " selecionado.");


        System.out.println("Digite o local de partida: ");
        String localPartida = Principal.ler.nextLine();
        System.out.println("Digite o local de chegada: ");
        String localFinal = Principal.ler.nextLine();
        System.out.println("Digite a distância da viagem (em Km): ");
        Double kilometragem = Double.parseDouble(Principal.ler.nextLine());

        Corrida c = new Corrida(localPartida, localFinal, kilometragem);
        Principal.corridas.add(c);
        System.out.println("A sua corrida parte de " + localPartida + " até " + localFinal + " e tem " + kilometragem + "kms de distância");

        System.out.println("Categoria:");
        System.out.println("1. Comum");
        System.out.println("2. Luxo");
        int G = Integer.parseInt(Principal.ler.nextLine());

        double precoDouble;
        if (G == 1){
            precoDouble = 5.0 + 1.0 * kilometragem;
        } else if (G == 2){
            precoDouble = 9.0 + 2.20 * kilometragem;
        } else {
            System.out.println("Categoria inválida. Cancelando solicitação.");
            return;
        }

        System.out.println("O preço da viagem é  " + precoDouble);
        System.out.println("Corrida solicitada");
    }

    private static Passageiro selecionarPassageiro() {
        if (Principal.passageiros.isEmpty()) {
            System.out.println("Não há passageiros cadastrados.");
            return null;
        }
        for(int i = 0; i < Principal.passageiros.size(); i++){
            Passageiro p = Principal.passageiros.get(i);
            System.out.println((i + 1) + "- " + p.getNome());
        }
        System.out.println("Escolha um passageiro: ");
        int escolha = Integer.parseInt(Principal.ler.nextLine());
        return Principal.passageiros.get(escolha - 1);
    }


    private static void finalizarViagem() {              //Arruma esse metodo
        Corrida c = selecionarViagem();
        if(c != null && c.isViagemIniciada() == true){
            c.finalizarViagem();
        }
    }

    private static Motorista selecionarMotorista() {
        if (Principal.motoristas.isEmpty()) {
            System.out.println("Não há motoristas cadastrados.");
            return null;
        }
        for (int i = 0; i < Principal.motoristas.size(); i++) {
            Motorista m = Principal.motoristas.get(i);
            System.out.println((i + 1) + "- " + m.getNome() + "(" + m.getStatusMotorista() + ")");
        }
        System.out.println("Escolha um motorista: ");
        int escolha = Integer.parseInt(Principal.ler.nextLine());
        return Principal.motoristas.get(escolha - 1);
    }

    private static Corrida selecionarViagem() {
        for (int i = 0; i < Principal.corridas.size(); i++) {
            System.out.println(i + "_" + Principal.corridas.get(i).toString());
        }
        System.out.println("Escolha uma  viagem: ");
        return Principal.corridas.get(Integer.parseInt(Principal.ler.nextLine()));
    }

    private static void cancelarViagem() {        //Mesma coisa com esse aqui, ajeitar como expliquei
        Corrida c = selecionarViagem();
        if(c.isViagemIniciada() == true){
            c.finalizarViagem();
        }
    }

    private static void processarPagamento() {    //Implementa isso pra depois que a corrida seja finalizada,
                                                  //esse metodo seja chamado e pague a corrida
        System.out.println("Pagamento processado");
    }

    private static void verCorridas() {           //Ajeita o verCorridas depois de dar um jeito
        System.out.println("Corridas: ");         //de fazer a corrida ser iniciada e virar um objeto
        for (Corrida c : Principal.corridas) {
            System.out.println("-------------------------");

            System.out.println("Inicio " + c.getLocalPartida());
            System.out.println("Fim " + c.getLocalFinal());
            System.out.println("Distância: " + c.getKilometragem());
            System.out.println("-------------------------");
        }

    }

    private static void listarMotoristas() {
        if (Principal.motoristas.isEmpty()) {
            System.out.println("Não há motoristas cadastrados.");
        } else {
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
    }
    private static void listarPassageiros() {
        if (Principal.passageiros.isEmpty()) {
            System.out.println("Não há passageiros cadastrados.");
        } else {
            System.out.println("Passageiros: ");
            for (Passageiro p : Principal.passageiros) {
                String respostaSaldo =  "";
                if (p.isSaldoPendente() == false){
                    respostaSaldo = "Não. Tudo pago";
                } else {
                    respostaSaldo = "Sim. Pagamento pendente";
                }
                System.out.println("-------------------------");
                System.out.println("Nome: " + p.getNome());
                System.out.println("CPF: " + p.getCpf());
                System.out.println("Email " + p.getEmail());
                System.out.println("Telefone: " + p.getTelefone());
                System.out.println("Saldo pendente? " + respostaSaldo);
                System.out.println("Metodo de pagamento: " + p.getPagamento());
                System.out.println("-------------------------");
            }

        }
    }

    private static void avaliarMotorista() {
        if (Principal.motoristas.isEmpty()) {
            System.out.println("Não há motoristas cadastrados.");
            return;
        }
        System.out.println("==Avaliar motoristas==");
        System.out.println("Qual motorista você quer avaliar: ");


    }

    private static void avaliarPassageiro() {
        if (Principal.passageiros.isEmpty()) {
            System.out.println("Não há passageiros cadastrados.");
            return;
        }
        System.out.println("==Avaliar passageiros==");
        System.out.println("Qual passageiro você quer avaliar: ");


    }

    private static void testeInicializarDados() {
        // n esquecam de adicionar o passageiro/motorista nas listas

        Passageiro p = new Passageiro("André", "12345678900", "andreprofessor@gmail.com", "senhasecreta123", "61999999999");

        MetodoPagamento pagamentoDinheiro = new Dinheiro(500.0);
        p.setPagamento(pagamentoDinheiro);

        passageiros.add(p);

        Motorista m = new Motorista("José", "98765432100", "jose@gmail.com", "senhaMenosSecreta123", "61988888888", "00123456789", "ONLINE");
        motoristas.add(m);
        Veiculo v = new Veiculo("Toyota Corolla", "Prata", "ABC-1234", 2021, 2020);
        m.setCarro(v);

        Motorista m2 = new Motorista("Creusa", "11122233344", "creusauber@gmail.com", "senhaCreusa123", "61977777777", "00987654321", "OFFLINE");
        motoristas.add(m2);
        Veiculo v2 = new Veiculo("Honda Civic", "Preto", "XYZ-5678", 2020, 2020);
        m2.setCarro(v2);
    }
}
