package ui;
import entidades.*;
import enums.StatusMotorista;
import enums.StatusCorrida;
import servicos.*;
import exceptions.*;
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
            System.out.println("14- Recarregar saldo em dinheiro");
            System.out.println("15- Ver Histórico dos Usuários");
            System.out.println("16- Ver Histórico Geral de Corridas");
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
                        processarPagamentoMain();
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
                    case 14:
                        recarregarSaldoPassageiro();
                        break;
                    case 15:
                        verHistoricoUsuario();
                        break;
                    case 16:
                        verHistoricoGeralSistema();
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
                double s = Double.parseDouble(ler.nextLine());
                MetodoPagamento d = new Dinheiro(s);
                m.setPagamento(d);
                break;
            default:
                cadastrarMetodoPagamentoPassageiro(m);
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
        int anoFab = Integer.parseInt(Principal.ler.nextLine());
        System.out.println("Digite o ano do modelo do carro: ");
        int anoModelo = Integer.parseInt(Principal.ler.nextLine());
        Veiculo c = new Veiculo(modelo, cor, placa, anoFab, anoModelo);
        m.setCarro(c);

        System.out.println("Cadastro de veículo realizado.\n");
    }

    private static void alterarStatus() {
        Motorista m = selecionarMotorista();
        if (m == null) return;
        if (m.getStatusMotorista() == StatusMotorista.EM_CORRIDA) {
            System.out.println("ERRO: O motorista " + m.getNome() + " está em corrida. Finalize a viagem (Opção 6) primeiro!");
            return;
        }
        System.out.println("Status atual: " + m.getStatusMotorista());
        System.out.println("Defina o novo status de " + m.getNome() + ": ");
        int statusEscolhido = lerOpcaoSegura("1- Online\n2- Offline", 1, 2);
        if (statusEscolhido == 1) {
            m.setStatusMotorista("ONLINE");
        } else {
            m.setStatusMotorista("OFFLINE");
        }
        System.out.println("Status alterado com sucesso para: " + m.getStatusMotorista());
    }

    private static void solicitarCorrida() {
        System.out.println("==Solicitar Corrida==");
        System.out.println("Qual é o passageiro?");
        Passageiro p = selecionarPassageiroDisponivel();

        if (p == null) {
            System.out.println("Passageiro inválido ou cancelado.");
            return;
        }
        System.out.println(p.getNome());

        try {
            p.verificarSePodeViajar();
        } catch (SaldoPendenteException e) {
            System.out.println("ERRO: " + e.getMessage());
            System.out.println("Vá para a opção 8 pagar a dívida antes.");
            return;
        }

        System.out.println("Escolha um Motorista disponível (ONLINE):");

        java.util.List<Motorista> disponiveis = new java.util.ArrayList<>();

        for (Motorista mot : Principal.motoristas) {
            if (mot.getStatusMotorista() == StatusMotorista.ONLINE) {
                disponiveis.add(mot);
            }
        }

        try {
            if (disponiveis.isEmpty()) {
                throw new NenhumMotoristaDisponivelException("Não há motoristas online no momento!");
            }
        } catch (NenhumMotoristaDisponivelException e) {
            System.out.println("ERRO: " + e.getMessage());
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
        double quilometragem = lerDoubleSeguro();

        Corrida c = new Corrida(localPartida, localFinal, quilometragem);
        c.setPassageiro(p);
        c.setMotorista(m);
        c.setStatus(StatusCorrida.EM_ANDAMENTO);
        m.setStatus(StatusMotorista.EM_CORRIDA);
        System.out.println("A sua corrida parte de " + localPartida + " até " + localFinal + " e tem " + quilometragem + "kms de distância");

        System.out.println("Categoria:");
        System.out.println("1. Comum");
        System.out.println("2. Luxo");
        int opcaoCat = Integer.parseInt(Principal.ler.nextLine());

        if (opcaoCat == 1) {
            c.setCategoria(new CategoriaComum());
        } else if (opcaoCat == 2) {
            c.setCategoria(new CategoriaLuxo());
        } else {
            System.out.println("Categoria inválida. Cancelando.");
            return;
        }

        c.calcularValorFinal();

        Principal.corridas.add(c);

        p.adicionarCorridaAoHistorico(c);
        m.adicionarCorridaAoHistorico(c);

        System.out.println("Corrida iniciada!");
        System.out.println("Valor calculado pela categoria: R$ " + String.format("%.2f", c.getValorCalculado()));
    }

    private static Passageiro selecionarPassageiro() {
        if (Principal.passageiros.isEmpty()) {
            System.out.println("Não há passageiros cadastrados.");
            return null;
        }
        for(int i = 0; i < Principal.passageiros.size(); i++){
            System.out.println((i + 1) + "- " + Principal.passageiros.get(i).getNome());
        }
        int escolha = lerOpcaoSegura("Escolha um passageiro (ou 0 para cancelar): ", 0, Principal.passageiros.size());
        if (escolha == 0) return null;
        return Principal.passageiros.get(escolha - 1);
    }
    private static Passageiro selecionarPassageiroDisponivel() {
        List<Passageiro> ocupados = new ArrayList<>();
        for (Corrida c : corridas) {
            if (c.getStatus() == StatusCorrida.EM_ANDAMENTO) {
                ocupados.add(c.getPassageiro());
            }
        }

        List<Passageiro> disponiveis = new ArrayList<>();
        for (Passageiro p : passageiros) {
            if (!ocupados.contains(p)) {
                disponiveis.add(p);
            }
        }

        if (disponiveis.isEmpty()) {
            System.out.println("Todos os passageiros estão em corridas no momento.");
            return null;
        }

        for (int i = 0; i < disponiveis.size(); i++) {
            System.out.println((i + 1) + "- " + disponiveis.get(i).getNome());
        }

        System.out.println("Escolha um passageiro: ");
        int escolha = Integer.parseInt(Principal.ler.nextLine());

        if (escolha < 1 || escolha > disponiveis.size()) {
            System.out.println("Opção inválida.");
            return null;
        }

        return disponiveis.get(escolha - 1);
    }

    private static void finalizarViagem() {
        System.out.println("== Finalizar Viagem ==");

        List<Corrida> emAndamento = new ArrayList<>();
        for(Corrida c : Principal.corridas) {
            if(c.getStatus() == StatusCorrida.EM_ANDAMENTO) {
                emAndamento.add(c);
            }
        }

        if(emAndamento.isEmpty()) {
            System.out.println("Nenhuma corrida em andamento para finalizar.");
            return;
        }

        for (int i = 0; i < emAndamento.size(); i++) {
            System.out.println((i + 1) + "- " + emAndamento.get(i).toString());
        }

        int escolha = Integer.parseInt(Principal.ler.nextLine());
        Corrida c = emAndamento.get(escolha - 1);
        try {
            c.finalizarViagem();

            if(c.getMotorista() != null) {
                c.getMotorista().setStatusMotorista("ONLINE");
            }
            if(c.getPassageiro() != null) {
                c.getPassageiro().setSaldoPendente(true);
                System.out.println("Viagem finalizada! Débito gerado.");
            }

        } catch (EstadoInvalidoDaCorridaException e) {
            System.out.println(e.getMessage());
        }
    }

    private static Motorista selecionarMotorista() {
        if (Principal.motoristas.isEmpty()) {
            System.out.println("Não há motoristas cadastrados.");
            return null;
        }

        System.out.println("--- Seleção de Motorista ---");
        for (int i = 0; i < Principal.motoristas.size(); i++) {
            Motorista m = Principal.motoristas.get(i);
            System.out.println((i + 1) + "- " + m.getNome() + " (" + m.getStatusMotorista() + ")");
        }
        int escolha = lerOpcaoSegura("Escolha um motorista (ou 0 para cancelar): ", 0, Principal.motoristas.size());

        if (escolha == 0) {
            System.out.println("Operação cancelada.");
            return null;
        }
        return Principal.motoristas.get(escolha - 1);
    }

    private static Corrida selecionarViagem() {
        System.out.println("Escolha uma viagem: ");
        for (int i = 0; i < Principal.corridas.size(); i++) {
            System.out.println((i + 1) + "- " + Principal.corridas.get(i).toString());
        }
        int escolha = Integer.parseInt(Principal.ler.nextLine());
        return Principal.corridas.get(escolha - 1);
    }

    private static void cancelarViagem() {
        System.out.println("== Cancelar Viagem ==");
        Corrida c = selecionarViagem();
        if (c == null) return;

        try {
            c.cancelarViagem();
            if (c.getMotorista() != null) {
                c.getMotorista().setStatusMotorista("ONLINE");
            }
            System.out.println("Viagem cancelada com sucesso.");

        } catch (EstadoInvalidoDaCorridaException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void processarPagamentoMain() {
        System.out.println("== Processar Pagamento ==");
        List<Passageiro> devedores = new ArrayList<>();
        for (Passageiro p : Principal.passageiros) {
            if (p.isSaldoPendente()) {
                devedores.add(p);
            }
        }

        if (devedores.isEmpty()) {
            System.out.println("Nenhum passageiro possui dívidas pendentes.");
            return;
        }

        System.out.println("Selecione o passageiro para pagar:");
        for (int i = 0; i < devedores.size(); i++) {
            System.out.println((i + 1) + "- " + devedores.get(i).getNome());
        }

        int escolha = Integer.parseInt(Principal.ler.nextLine());
        Passageiro pagador = devedores.get(escolha - 1);

        double valorAPagar = 0.0;

        for (int i = Principal.corridas.size() - 1; i >= 0; i--) {
            Corrida c = Principal.corridas.get(i);
            if (c.getPassageiro().equals(pagador) && c.getStatus() == StatusCorrida.FINALIZADA) {
                valorAPagar = c.getValorCalculado();
                break;
            }
        }

        if (valorAPagar == 0.0) {
            System.out.println("Erro: Não foi possível encontrar o valor da corrida.");
            return;
        }

        System.out.println("Valor pendente: R$ " + valorAPagar);
        System.out.println("Tentando pagar com " + pagador.getPagamento());

        try {
            pagador.getPagamento().processarPagamento(valorAPagar);

            pagador.setSaldoPendente(false);
            System.out.println("Dívida quitada com sucesso! Passageiro liberado para novas corridas.");


        } catch (SaldoInsuficienteException e) {
            System.out.println("FALHA NO PAGAMENTO: " + e.getMessage());
            System.out.println("O passageiro continua com a dívida e não pode solicitar novas corridas.");
            System.out.println("Utilize a opção 14 para recarregar seu saldo");
        }
    }

    private static void verCorridas() {
        System.out.println("=== Corridas em Andamento ===");
        boolean encontrouAlguma = false;

        if (Principal.corridas.isEmpty()) {
            System.out.println("Nenhuma corrida registrada no sistema.");
            return;
        }

        for (Corrida c : Principal.corridas) {
            if (c.getStatus() == StatusCorrida.EM_ANDAMENTO || c.getStatus() == StatusCorrida.SOLICITADA) {

                encontrouAlguma = true;
                System.out.println("-------------------------");
                String nomePassageiro = (c.getPassageiro() != null) ? c.getPassageiro().getNome() : "Desconhecido";
                String nomeMotorista = (c.getMotorista() != null) ? c.getMotorista().getNome() : "Aguardando...";

                System.out.println("Corrida de " + nomePassageiro);
                System.out.println("Motorista: " + nomeMotorista);
                System.out.println("Status: " + c.getStatus());
                System.out.println("De: " + c.getLocalPartida() + " -> Para: " + c.getLocalFinal());
                System.out.println("-------------------------");
            }
        }
        if (!encontrouAlguma) {
            System.out.println("Não há nenhuma corrida em andamento no momento.");
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
                System.out.println("Avaliação: " + m.calcularNota());
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
                if (!p.isSaldoPendente()){
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
                System.out.println("Método de pagamento: " + p.getPagamento());
                System.out.println(("Avaliação: " + p.calcularNota()));
                System.out.println("-------------------------");
            }

        }
    }

    private static void avaliarMotorista() {
        if (Principal.motoristas.isEmpty()) {
            System.out.println("Não há motoristas cadastrados.");
            return;
        }
        System.out.println("== Avaliar Motorista ==");
        Motorista m = selecionarMotorista();
        if (m == null) return;
        double valorNota = -1;

        while (valorNota < 0 || valorNota > 5) {
            System.out.println("Qual nota você quer dar (0 a 5)?");
            try {
                valorNota = Double.parseDouble(ler.nextLine());
                if (valorNota < 0 || valorNota > 5) {
                    System.out.println("Erro: A nota deve ser entre 0 e 5.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Erro: Digite um número válido (ex: 4.5).");
            }
        }

        System.out.println("Deseja deixar um comentário? (Digite o comentário ou aperte ENTER para pular):");
        String comentario = ler.nextLine();
        m.darNota(valorNota, comentario);
        System.out.println("Avaliação registrada com sucesso!");
        System.out.println("Nova média do motorista: " + String.format("%.2f", m.calcularNota()));
    }

    private static void avaliarPassageiro() {
        if (Principal.passageiros.isEmpty()) {
            System.out.println("Não há passageiros cadastrados.");
            return;
        }
        System.out.println("== Avaliar Passageiro ==");
        Passageiro p = selecionarPassageiro();
        if (p == null) return;
        double avaliacao = -1;

        while (avaliacao < 0 || avaliacao > 5) {
            System.out.println("Qual nota você quer dar a esse passageiro? (0 a 5): ");
            try {
                avaliacao = Double.parseDouble(Principal.ler.nextLine());
                if (avaliacao < 0 || avaliacao > 5) {
                    System.out.println("Erro: A nota deve ser entre 0 e 5.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Erro: Digite um número válido.");
            }
        }
        System.out.println("Deseja deixar um comentário? (Digite o texto ou aperte ENTER para pular):");
        String comentario = Principal.ler.nextLine();
        p.darNota(avaliacao, comentario);
        System.out.println("Nota adicionada com sucesso!");
        System.out.println("A nota atual desse Passageiro é: " + String.format("%.2f", p.calcularNota()));
    }

    private static void recarregarSaldoPassageiro() {
        System.out.println("\n=== Recarregar Saldo (Apenas Dinheiro) ===");

        Passageiro p = selecionarPassageiro();
        if (p == null) return;

        if (p.getPagamento() instanceof Dinheiro) {
            Dinheiro metodoDinheiro = (Dinheiro) p.getPagamento();
            System.out.println("Saldo Atual: " + p.getPagamento());
            System.out.println("Quanto deseja adicionar?");

            try {
                double valor = Double.parseDouble(ler.nextLine());
                metodoDinheiro.adicionarSaldo(valor);
                if (p.isSaldoPendente()) {
                    System.out.println("AVISO: Passageiro com débito pendente. Vá na opção 8 para pagar.");
                }

            } catch (NumberFormatException e) {
                System.out.println("Valor inválido.");
            }

        } else {
            System.out.println("ERRO: Este passageiro usa " + p.getPagamento().getMetodo());
            System.out.println("A recarga de saldo só está disponível para quem paga em Dinheiro.");
        }
    }

    private static void verHistoricoUsuario() {
        System.out.println("=== Ver Histórico de Usuários ===");
        System.out.println("1 - Histórico de Passageiro");
        System.out.println("2 - Histórico de Motorista");
        int tipo = Integer.parseInt(ler.nextLine());

        if (tipo == 1) {
            Passageiro p = selecionarPassageiro();
            if (p == null) return;

            System.out.println("Histórico de corridas de " + p.getNome() + ":");
            List<Corrida> historico = p.getHistoricoCorridas();

            if (historico.isEmpty()) {
                System.out.println("Nenhuma corrida realizada.");
            } else {
                for (Corrida c : historico) {
                    System.out.println(c.toString() + " - Status: " + c.getStatus());
                }
            }

        } else if (tipo == 2) {
            Motorista m = selecionarMotorista();
            if (m == null) return;

            System.out.println("Histórico de corridas de " + m.getNome() + ":");
            List<Corrida> historico = m.getHistoricoCorridas();
            if (historico.isEmpty()) {
                System.out.println("Nenhuma corrida realizada.");
            } else {
                for (Corrida c : historico) {
                    System.out.println(c.toString() + " - Status: " + c.getStatus());
                }
            }
        } else {
            System.out.println("Opção inválida.");
        }
    }

    private static void verHistoricoGeralSistema() {
        System.out.println("=== Histórico Geral do Sistema (Finalizadas e Canceladas) ===");

        if (Principal.corridas.isEmpty()) {
            System.out.println("Nenhuma corrida registrada no sistema.");
            return;
        }

        boolean encontrouAlgum = false;

        for (Corrida c : Principal.corridas) {
            if (c.getStatus() == StatusCorrida.FINALIZADA || c.getStatus() == StatusCorrida.CANCELADA) {
                encontrouAlgum = true;

                System.out.println("-------------------------");
                System.out.println("Data/ID: Corrida #" + (Principal.corridas.indexOf(c) + 1));
                System.out.println("Status: " + c.getStatus());

                String pNome = (c.getPassageiro() != null) ? c.getPassageiro().getNome() : "[Removido]";
                String mNome = (c.getMotorista() != null) ? c.getMotorista().getNome() : "[Sem motorista]";

                System.out.println("Passageiro: " + pNome);
                System.out.println("Motorista: " + mNome);
                System.out.println("Trajeto: " + c.getLocalPartida() + " -> " + c.getLocalFinal());
                if (c.getStatus() == StatusCorrida.FINALIZADA) {
                    System.out.println("Valor Final: R$ " + String.format("%.2f", c.getValorCalculado()));
                }
                System.out.println("-------------------------");
            }
        }
        if (!encontrouAlgum) {
            System.out.println("O histórico está vazio (apenas corridas em andamento ou solicitadas no momento).");
        }
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

    // pra evitar os crashes de antes
    private static int lerOpcaoSegura(String mensagem, int min, int max) {
        int opcao = -1;
        while (true) {
            System.out.println(mensagem);
            try {
                String entrada = ler.nextLine();
                opcao = Integer.parseInt(entrada);

                if (opcao >= min && opcao <= max) {
                    return opcao;
                } else {
                    System.out.println("Erro: Digite um número entre " + min + " e " + max + ".");
                }
            } catch (NumberFormatException e) {
                System.out.println("Erro: Entrada inválida. Por favor, digite apenas números.");
            }
        }
    }

    private static double lerDoubleSeguro() {
        while (true) {
            System.out.println("Digite a distância da viagem (em Km): ");
            try {
                String entrada = ler.nextLine();
                // Tenta converter. Se for texto inválido, vai para o catch.
                double valor = Double.parseDouble(entrada);

                if (valor < 0) {
                    System.out.println("Erro: O valor não pode ser negativo.");
                } else {
                    return valor;
                }
            } catch (NumberFormatException e) {
                System.out.println("Erro: Digite uma distância válida (use ponto para decimais, ex: 12.5).");
            }
        }
    }

}
