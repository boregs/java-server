import java.net.ServerSocket;
import java.net.Socket;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) throws IOException {
        int port = 8080;
        int backlog = 2000;

        // damos o backlog como 2000 para permitir mais conexoes pendentes
        try (ServerSocket server = new ServerSocket(port, backlog)) {

            // iniciamos a pool com um numero pequeno para previnir sobrecarga do servidor
            ExecutorService pool = Executors.newFixedThreadPool(100);
            System.out.println("> Servidor Iniciado na porta: " + port);

            while (true) {
                Socket clientSocket = server.accept();
                System.out.println("> Cliente conectado: " + clientSocket.getInetAddress().getHostAddress());
                pool.execute(new ClientHandler(clientSocket));
            }

        } catch (IOException err){
            System.out.println("> Erro ao iniciar o servidor: " + err.getMessage());
        }
    }
}

