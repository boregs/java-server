import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.concurrent.Executors;
/*
* cliente precisa conectar ao servidor
* cliente precisa enviar comandos
* servidor precisa processar comandos
* servidor precisa enviar respostas
* cliente precisa receber respostas
* servidor precisa lidar com multiplos clientes
* */

public class ClientHandler implements Runnable {
    private final Socket clientSocket;

    ClientHandler(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run(){
        // bufferedreader recebe os dados do cliente e os guarda em um buffer para serem processados
        try(BufferedReader input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))){
            // printwriter envia os dados processados de volta para o cliente
            PrintWriter output = new PrintWriter(clientSocket.getOutputStream(), true);

            String clientComand;

            // loop para ler os comandos do cliente
            while((clientComand = input.readLine()) != null){
                System.out.println("> Cliente: " + clientComand);
                String response = "Comando processado: " + clientComand.toUpperCase();
                output.println(response);
            }

        } catch (IOException clientConectErr){
            System.err.println("> Erro na conexao com o cliente: " + clientConectErr.getMessage());
            }
            //fecha a conexao com o cliente
            finally {
                try {
                    clientSocket.close();
                } catch (IOException e){
                    System.err.println("> Erro ao fechar a conexao com o cliente: " + e.getMessage());
                }
            }

    }
}
