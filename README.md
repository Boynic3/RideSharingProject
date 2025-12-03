# << Projeto de Orientação a Objetos desenvolvido em Java >>

**Desenvolvido por: Matheus Moretti Soares, Arthur Miguel Silva e Luis Felipe Albuquerque Fernandes**

# 🚗 Sistema de Ride Sharing (Simulador de Uber/99)

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![IntelliJ IDEA](https://img.shields.io/badge/IntelliJIDEA-000000.svg?style=for-the-badge&logo=intellij-idea&logoColor=white)
![Status](https://img.shields.io/badge/STATUS-CONCLUÍDO-brightgreen?style=for-the-badge)
![POO](https://img.shields.io/badge/Conceito-POO-blue?style=for-the-badge)

Este é um projeto desenvolvido em **Java** que simula o funcionamento do back-end de um aplicativo de transporte. O sistema opera via console e permite o gerenciamento de passageiros, motoristas, corridas e transações financeiras, aplicando conceitos sólidos de **Orientação a Objetos**.

## 📋 Funcionalidades

O sistema possui um menu interativo com as seguintes opções:

* **Cadastros:**
    * Passageiros e Motoristas (com herança de `UsuarioComum`).
    * Veículos associados aos motoristas.
    * Métodos de Pagamento (Dinheiro, Pix, Cartão de Crédito).
* **Gestão de Status:**
    * Motoristas podem ficar `ONLINE`, `OFFLINE` ou entrar automaticamente em `EM_CORRIDA`.
    * Validação para impedir mudança de status durante uma corrida ativa.
* **Fluxo da Corrida:**
    * **Solicitar:** Filtra apenas motoristas disponíveis e passageiros sem dívidas. Verifica se o passageiro já não está em outra corrida.
    * **Calcular Preço:** Utiliza polimorfismo e classes específicas (`CategoriaComum`, `CategoriaLuxo`) para calcular tarifas baseadas na quilometragem.
    * **Finalizar:** Filtra apenas corridas em andamento, libera o motorista e gera o débito para o passageiro.
* **Financeiro:**
    * **Processar Pagamento:** Baixa a dívida do passageiro usando a interface de pagamento.
    * **Recarregar Saldo:** Funcionalidade exclusiva para quem paga em Dinheiro (uso de `instanceof` e *casting*).
    * Validação de saldo insuficiente com **Exceptions personalizadas**.
* **Avaliação:**
    * Sistema de cálculo de média de notas para Passageiros e Motoristas.

## 🛠️ Tecnologias e Conceitos Aplicados

* **Linguagem:** Java (JDK 17+)
* **POO (Programação Orientada a Objetos):**
    * **Herança:** `Motorista` e `Passageiro` herdam de `UsuarioComum`. `CategoriaLuxo` e `CategoriaComum` herdam de `CategoriaCorrida`.
    * **Polimorfismo:** Implementação da interface `MetodoPagamento` e métodos de cálculo de preço.
    * **Encapsulamento:** Uso de getters, setters e modificadores de acesso (`private`/`protected`).
    * **Abstração:** Uso de classes abstratas e interfaces.
* **Tratamento de Exceções:** Criação de exceções personalizadas (`SaldoInsuficienteException`, `EstadoInvalidoDaCorridaException`, etc.).
* **Enums:** Para controle rígido de status (`StatusMotorista`, `StatusCorrida`).
* **Collections:** Uso de `ArrayList` para gerenciamento de dados em memória.

## 📂 Estrutura do Projeto

O projeto está organizado nos seguintes pacotes:

```text
src/
├── entidades/          # Classes de modelo (Passageiro, Motorista, Veiculo, Pagamentos)
├── enums/              # Constantes (StatusCorrida, StatusMotorista)
├── exceptions/         # Exceções personalizadas de regra de negócio
├── servicos/           # Lógica da Corrida e Classes de Categorias de Preço
└── ui/                 # Interface com o usuário (Menu Principal e Main) 
```
## 🚀 Como Executar

1.  **Pré-requisitos**: Certifique-se de ter o **Java (JDK)** instalado em sua máquina.
2.  **Clone o repositório**:
    ```bash
    git clone [https://github.com/Boynic3/RideSharingProject.git](https://github.com/Boynic3/RideSharingProject.git)
    ```
3.  **Importe o projeto**: Abra a pasta do projeto na sua IDE favorita (IntelliJ, Eclipse, VS Code).
4.  **Execute**: Localize e rode a classe `Principal.java` que está dentro do pacote `ui`.

## 💡Sinta-se à vontade para sugestões ou reports no código

## 🧪 Dados Iniciais (Mock)

Para facilitar os testes sem precisar cadastrar tudo do zero, o sistema carrega automaticamente os seguintes dados ao iniciar:

* **👤 Passageiro:** André
    * *Pagamento:* Dinheiro
    * *Saldo:* R$ 500.00
* **🚖 Motorista 1:** José
    * *Carro:* Toyota Corolla
    * *Status Inicial:* `ONLINE`
* **🚖 Motorista 2:** Creusa
    * *Carro:* Honda Civic
    * *Status Inicial:* `OFFLINE`

## 📝 Exemplo de Uso (Walkthrough)

Siga este roteiro para testar o fluxo principal do sistema:

1.  **Iniciar**: Rode o programa e aguarde o menu.
2.  **Solicitar Corrida**: Escolha a **opção 5**.
    * Selecione o passageiro "André".
    * Selecione o motorista "José".
    * Defina o local de partida, destino e a distância.
    * Escolha a categoria (1- Comum ou 2- Luxo).
    > *Neste momento, a corrida entra em `EM_ANDAMENTO` e o motorista muda o status para `EM_CORRIDA`.*
3.  **Finalizar Viagem**: Escolha a **opção 6**.
    * Selecione a corrida que está acontecendo.
    > *O sistema libera o motorista (volta a ser `ONLINE`) e gera um débito no saldo do passageiro.*
4.  **Pagar**: Escolha a **opção 8**.
    * O sistema identifica o passageiro devedor e processa o pagamento automaticamente.

---

*Desenvolvido para fins de estudo de Orientação a Objetos.*
