import java.net.ServerSocket;
import java.net.Socket;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) throws IOException {
        int port = 8080;

        try (ServerSocket server = new ServerSocket(port)) {
            ExecutorService pool = Executors.newFixedThreadPool(1000);
            System.out.println("> Servidor Iniciado na porta: " + port);

        } catch (IOException err){
            System.out.println("> Erro ao iniciar o servidor: " + err.getMessage());
        }
    }
}

