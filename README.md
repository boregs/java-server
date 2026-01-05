# Servidor Local Java

Esse projeto implementa um servidor local simples em Java que consegue responder a requisições HTTP básicas. O Objetivo
desse projeto é entender e adiquirir uma base solida da linguagem e seus conceitos fundamentais, além de
preparar para a utilização de frameworks mais avançados no futuro como Spring Boot, Spring Data, Hibernate, entre outros.


## Funcionalidades
- Responde a requisições HTTP GET.
- Retorna uma mensagem simples como resposta.
- Suporte para múltiplas conexões simultâneas usando threads.
- Guarda logs e usuarios conectados.

## Requisitos
- Java Development Kit (JDK) 8 ou superior.
- IDE de sua preferencia

## Como Executar
1. Clone o repositório na sua maquina local:
   ```bash
   git clone https://github.com/boregs/java-server
    ```
   
2. Navegue até o diretório do projeto:
   ```bash
   cd java-server
   ```
   
3. Compile o código fonte:
   ```bash
   javac Main.java
   ```
   
ou, se estiiver com o repositorio em uma IDE, apenas rode o projeto.


## Teste de Estresse

Se você quiser testar o servidor com diversas conexões, o arquivo StressTest.java consegue te dar uma boa estimativa

Dentro do repositorio, rode o seguinte comando:

```bash
javac StressTest.java
java StressTest
```

Se você estiver em uma IDE, rode primeiro o Main.java (o servidor) e depois rode o StressTest.java
Confirme que quer rodar o teste e veja os resultados no console.

Se quiser trocar o numero de conexões simuladas, altere a variavel "numberSimClients" na linha 12 do StressTest.java
```bash
int numberSimClients = 1000; // altere esse numero para o valor desejado
   ```
Você também pode alterar o numero de threads e o backlog do servidor alterando as variaveis "backlog" na linha 11 e o atributo
na linha 17 do Main.java
```bash
// altere essas linhas
int backlog = 2000;
ExecutorService pool = Executors.newFixedThreadPool(100);
```
