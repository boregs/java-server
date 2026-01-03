import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.Scanner;

public class StressTest {
    public static void main(String[] args) throws InterruptedException{
<<<<<<< HEAD
        int numberSimClients = 1000; // numero de clientes na simulação
        ExecutorService service = Executors.newFixedThreadPool(numberSimClients);
        Scanner scan = new Scanner(System.in);
        // pega o horario de quando o programa começou a rodar
        long programStartTime = System.currentTimeMillis();

        System.out.println(">> Bem Vindo ao Teste de Estresse");
        System.out.print(">> Deseja iniciar? (s/n)  ");

        if (scan.nextLine().equalsIgnoreCase("n")){
            System.out.println(">> Encerrando o programa.");
            scan.close();
            return;
        }

        for (int i = 0; i < numberSimClients; i++){
            final int clientId = i;
            service.submit(() -> {
                try(Socket socket = new Socket("localhost", 8080)){
                    PrintWriter input = new PrintWriter(socket.getOutputStream(), true);
=======
        int numberSimClients = 100; // numero de clientes na simulação
        ExecutorService service = new Executors.newFixedThreadPool(numberSimClients);
        Scanner scan = new Scanner(System.in);

        System.out.println(">> Bem Vindo ao Teste de Estresse");
        System.out.println(">> Deseja iniciar? (s/n)");
        /*
        adicionar if else com o scanner aqui
        */


        // pega o horario de quando o programa começou a rodar
        long programStartTime = System.currentTimeMillis();

        for (int i = 0; i < numberSimClients; i++){
            final int clientId = i;
            executor.submit(() -> {
                try(Socket socket = new Socket("localhost", 8080)){
                    PrintWriter input = new PrintWriter(socket.getOutputStream, true);
>>>>>>> 09fca5cbb2a71608f7e2c2fa1f4556118aa77cc4
                } catch (IOException e){
                    System.err.println(">> Erro ao se conectar com o cliente: " + clientId);
                }
            });
        }
<<<<<<< HEAD
        service.shutdown();

        service.awaitTermination(1, TimeUnit.MINUTES);
=======
        executor.shutdown();
        
        executor.awaitTermination(1, TimeUnit.MINUTES);
>>>>>>> 09fca5cbb2a71608f7e2c2fa1f4556118aa77cc4

        long programEndTime = System.currentTimeMillis();
        System.out.println("O programa rodou por: " + (programEndTime - programStartTime) + "ms");
    }
<<<<<<< HEAD
}
=======
}
>>>>>>> 09fca5cbb2a71608f7e2c2fa1f4556118aa77cc4
