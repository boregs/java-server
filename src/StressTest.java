import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.Scanner;

public class StressTest {
    public static void main(String[] args) throws InterruptedException{
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
                } catch (IOException e){
                    System.err.println(">> Erro ao se conectar com o cliente: " + clientId);
                }
            });
        }
        executor.shutdown();
        
        executor.awaitTermination(1, TimeUnit.MINUTES);

        long programEndTime = System.currentTimeMillis();
        System.out.println("O programa rodou por: " + (programEndTime - programStartTime) + "ms");
    }
}
