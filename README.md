# Backend - Sistema de Agendamento de Transferências

## Estrutura Arquitetural

### O backend foi desenvolvido em Java 11 utilizando o Spring Boot 2.7.18, com banco de dados H2 em memória para facilitar os testes.
### A arquitetura segue princípios da Arquitetura Hexagonal (Ports and Adapters), separando responsabilidades em diferentes camadas:

- domain 
  - Contém as entidades de negócio e enums. É o coração da aplicação, isolado de frameworks e detalhes técnicos.

- usecase (application layer)
  - Implementa os casos de uso do sistema (regras de negócio). Essa camada orquestra as operações utilizando as entidades do domínio.

- infra (infrastructure layer)
  - Contém implementações técnicas como repositórios, integração com banco de dados (Spring Data JPA) e configurações.

- web (adapter layer)
  - Expõe a API REST utilizando Spring Web. Atua como a porta de entrada para comunicação externa.

Benefício: Essa separação facilita a manutenção, a testabilidade e permite trocar tecnologias (ex: mudar banco de dados ou framework web) sem impactar o domínio.

## Tecnologias utilizadas
- Java 11
- Spring Boot 2.7.18
- Banco de dados H2

## Pré-requisitos
- [Java 11](https://adoptium.net/) instalado
- Uma IDE de sua preferência (IntelliJ, Eclipse, VS Code com extensão Java)

## Como rodar o projeto
1. Clone este repositório:
   ```bash
   git clone https://github.com/Desafio-Agendamento-Trasnferencia/api-transfereicia.git
   ```
2. Acesse a pasta do backend:
   ```bash
   cd api-transfereicia
   ```
3. Abra o projeto em sua IDE e execute a classe principal da aplicação (`@SpringBootApplication`).

4. O backend será iniciado e estará disponível em:
   ```
   http://localhost:8080
   ```

## Banco de Dados
O banco utilizado é o **H2 em memória**.  
Já existem algumas contas pré-cadastradas para testes:

### Contas disponíveis
- Conta: **1000000001**
- Conta: **1000000002**
- Conta: **1000000003**
- Conta: **1000000004**
- Conta: **1000000005**
- Conta: **1000000006**
- Conta: **1000000007**
- Conta: **1000000008**
- Conta: **1000000009**
- Conta: **1000000010**
